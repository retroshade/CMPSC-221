/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author captj_000
 */
public class Connector {
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/Magician Booking";
    private static Connection connection;
    private static final String username = "java";
    private static final String password = "java";
    
    private static PreparedStatement allHolidays;
    private static PreparedStatement allMagicians;
    private static PreparedStatement freeMagician;
    private static PreparedStatement addWaitList;
    private static PreparedStatement allEntries;
    private static PreparedStatement addBookList;
    private static PreparedStatement waitClear;
    private static PreparedStatement removeHoliday;
    private static PreparedStatement removeMagician;
    private static PreparedStatement removeMagFromList;
    private static PreparedStatement removeHolFromList;
    private static PreparedStatement removeApptBook;
    private static PreparedStatement removeApptWait;
    private static PreparedStatement bookingSelect;
    private static PreparedStatement returnWaitListEntry;
    
    public static void setPreparedStatements() throws SQLException {
        allHolidays = connection.prepareStatement("SELECT customer, magician FROM bookinglist WHERE holiday = ? ORDER BY customer ASC");
        allMagicians = connection.prepareStatement("SELECT customer, holiday FROM bookinglist WHERE magician = ? ORDER BY customer ASC");
        freeMagician = connection.prepareStatement("SELECT magicianname FROM magicians WHERE magicianname NOT IN (SELECT magician FROM bookinglist WHERE bookinglist.holiday = ?) ORDER BY magicianname ASC");
        addWaitList = connection.prepareStatement("INSERT INTO waitlist (timestamp, holiday, customer) VALUES (?, ?, ?)");
        addBookList = connection.prepareStatement("INSERT INTO bookinglist (magician, holiday, customer) VALUES (?, ?, ?)");
        allEntries = connection.prepareStatement("SELECT customer, holiday, timestamp FROM waitlist ORDER BY customer ASC");
        waitClear = connection.prepareStatement("DELETE FROM waitlist");
        removeHoliday = connection.prepareStatement("DELETE FROM holiday WHERE holidayname = ?");
        removeHolFromList = connection.prepareStatement("DELETE FROM bookinglist WHERE holiday = ?");
        removeMagician = connection.prepareStatement("DELETE FROM magicians WHERE magicianname = ?");
        removeMagFromList = connection.prepareStatement("DELETE FROM bookinglist WHERE magician = ?");
        removeApptBook = connection.prepareStatement("DELETE FROM bookinglist WHERE customer = ? AND holiday = ?");
        removeApptWait = connection.prepareStatement("DELETE FROM waitlist WHERE customer = ? AND holiday = ?");
        bookingSelect = connection.prepareStatement("SELECT magician FROM bookinglist WHERE customer = ? AND holiday = ?");
        returnWaitListEntry = connection.prepareStatement("SELECT * FROM waitlist WHERE customer = ? AND holiday = ?");
    }
    
    public static void removeAppt(String custName, String holName) {
        try
        {
            getConnection();
            setPreparedStatements();
            bookingSelect.setString(1, custName);
            bookingSelect.setString(2, holName);
            ResultSet resultSet = bookingSelect.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                i++;
            }
            
            bookingSelect.setString(1, custName);
            bookingSelect.setString(2, holName);
            ResultSet rs1 = bookingSelect.executeQuery();
            
            if (i > 0) {
                while (rs1.next()) {
                    String magicianname = rs1.getString("magician");
                    removeApptBook.setString(1, custName);
                    removeApptBook.setString(2, holName);
                    removeApptBook.executeUpdate();
                    
                    returnWaitListEntry.setString(1, custName);
                    returnWaitListEntry.setString(2, holName);
                    ResultSet rs = returnWaitListEntry.executeQuery();
                    int numColWait = rs.getMetaData().getColumnCount();
                    if (numColWait == 1) {
                        removeApptWait.setString(1, custName);
                        removeApptWait.setString(2, holName);
                        removeApptWait.executeUpdate();
                        
                        addBookList.setString(1, magicianname);
                        addBookList.setString(2, holName);
                        addBookList.setString(3, custName);
                        addBookList.executeUpdate();
                    } 
                    i--;
                }
            }
            else {
                removeApptWait.setString(1, custName);
                removeApptWait.setString(2, holName);
                removeApptWait.executeUpdate();
            }
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
    }
    
    public static void removeApptBook(String custName, String holName) {
        try
        {
            getConnection();
            setPreparedStatements();
            removeApptBook.setString(1, custName);
            removeApptBook.setString(2, holName);
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
    }
    
    public static void removeApptWait(String custName, String holName) {
        try
        {
            getConnection();
            setPreparedStatements();
            removeApptWait.setString(1, custName);
            removeApptWait.setString(2, holName);
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
    }
    
    public static void removeHoliday(String hol) {
        try
        {
            getConnection();
            setPreparedStatements();
            removeHoliday.setString(1, hol);
            removeHoliday.executeUpdate();
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
    }
    
    public static void removeHolList(String hol) {
        try
        {
            getConnection();
            setPreparedStatements();
            removeHolFromList.setString(1, hol);
            removeHolFromList.executeUpdate();
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
    }
    
    public static void removeMagList(String mag) {
        try
        {
            getConnection();
            setPreparedStatements();
            removeMagFromList.setString(1, mag);
            removeMagFromList.executeUpdate();
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
    }
    
    public static void removeMagician(String mag) {
        try
        {
            getConnection();
            setPreparedStatements();
            removeMagician.setString(1, mag);
            removeMagician.executeUpdate();
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
    }
    
    public static String newRequest(WaitListEntry wle) {
        String magician = "waitlisted";
        
        try 
        {
            getConnection();
            setPreparedStatements();
            freeMagician.setString(1, wle.getWaitHoliday());
            ResultSet resultSet = freeMagician.executeQuery();
            if(resultSet.next()){
                magician = resultSet.getString("magicianname");
                addBookList.setString(1, magician);
                addBookList.setString(2, wle.getWaitHoliday());
                addBookList.setString(3, wle.getWaitCustName());
                addBookList.executeUpdate();
            }
            else{
                addWaitList.setString(1, wle.getWaitTimestamp().toString());
                addWaitList.setString(2, wle.getWaitHoliday());
                addWaitList.setString(3, wle.getWaitCustName());
                addWaitList.executeUpdate();
                
            }
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
        
        return magician;
    }

    public static void waitlistClear() {
        try
        {
            getConnection();
            setPreparedStatements();
            waitClear.executeUpdate();
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
    }
    
    public static ArrayList<WaitListEntry> getAllEntries() {
        ArrayList<WaitListEntry> list = new ArrayList<>();
        
        try
        {
            getConnection();
            setPreparedStatements();
            ResultSet resultSet = allEntries.executeQuery();
            while (resultSet.next()) {
                list.add(new WaitListEntry(resultSet.getString("customer"), resultSet.getString("holiday"), resultSet.getTimestamp("timestamp")));
            }
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
        finally
        {
            return list;
        }
    }
    
    public static ArrayList<BookingListEntry> getWaitListByHoliday(String holiday) {
        ArrayList<BookingListEntry> holidayList = new ArrayList<>();
        
        try 
        {
            getConnection();
            setPreparedStatements();
            allHolidays.setString(1, holiday);
            ResultSet resultSet = allHolidays.executeQuery();   
            while (resultSet.next()){
                holidayList.add(new BookingListEntry(resultSet.getString("customer"), holiday, resultSet.getString("magician")));
            }
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
        finally
        {
            return holidayList;
        }
    }
    
    public static ArrayList<BookingListEntry> getWaitListByMagician(String magician) {
        ArrayList<BookingListEntry> magicianList = new ArrayList<>();
        
        try 
        {
            getConnection();
            setPreparedStatements();
            allMagicians.setString(1, magician);
            ResultSet resultSet = allMagicians.executeQuery();
            while (resultSet.next()) {
                magicianList.add(new BookingListEntry(resultSet.getString("customer"), resultSet.getString("holiday"), magician));
            }
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
            close();
        }
        finally
        {
            return magicianList;
        }
    }
    
    public static Connection getConnection() {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection(DATABASE_URL, username, password);
            }
            catch (SQLException sqlException2)
            {
                sqlException2.printStackTrace();
                System.exit(1);
            }
            
            return connection;
        }
        else
            return connection;
    }
    
    public static void close() {
        try
        {
            connection.close();
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
        }
    }
}