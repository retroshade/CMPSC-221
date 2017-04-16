/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author captj_000
 */
public class Holiday {
    private static String holidayName;
    private static Connection connectionHol;
    private static PreparedStatement selectHolByName;
    
    public Holiday() {
    }
    
    public Holiday(String holidayName) {
        setHolidayName(holidayName);
        
    }

    /**
     * @return the holidayName
     */
    public String getHolidayName() {
        return holidayName;
    }

    /**
     * @param holidayName the holidayName to set
     */
    public void setHolidayName(String holName) {
        this.holidayName = holName;
    }
    
    
    public static ArrayList<String> getHolidayByName(String nameHol) {
        ArrayList<String> results = new ArrayList<String>();
        ResultSet resultSet = null;
        
        try
        {
            selectHolByName.setString(1, nameHol);
            resultSet = selectHolByName.executeQuery();
            results = new ArrayList<String>();
            
            while (resultSet.next())
            {
                results.add(resultSet.getString("holidayName"));
            }
        }
        catch (SQLException sqlE)
        {
            sqlE.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlE)
            {
                sqlE.printStackTrace();
                close();
            }
        }
        
        return results;
    }
        
    public static ArrayList<String> getAllHolidays() {
        connectionHol = Connector.getConnection();
        
        ArrayList<String> results = new ArrayList<String>();
        ResultSet resultSet = null;
        
        try
        {
            resultSet = Connector.getConnection().prepareStatement("SELECT * FROM Holiday").executeQuery();
            results = new ArrayList<String>();
            
            while (resultSet.next())
            {
                results.add(resultSet.getString("HolidayName"));
            }
        }
        catch (SQLException sqlException1)
        {
            sqlException1.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException sqlException2)
            {
                sqlException2.printStackTrace();
                close();
            }
        }
        
        return results;
    }
    
    public int addHoliday(String name) {
        int result = 0;
        
        try
        {
            PreparedStatement insertNewHoliday = Connector.getConnection().prepareStatement("INSERT INTO Holiday (holidayname) VALUES (?)");
            insertNewHoliday.setString(1, name);
            result = insertNewHoliday.executeUpdate();
        }
        catch (SQLException sqlException3)
        {
            sqlException3.printStackTrace();
            close();
        }
        
        return result;
    }
    
    public static void close() {
        try
        {
            connectionHol.close();
        }
        catch (SQLException sqlException4)
        {
            sqlException4.printStackTrace();
        }
    }
    
    public void deleteHoliday(String name) {
        Connector.removeHoliday(name);
    }
    
    public void listRemovalHol(String name) {
        Connector.removeHolList(name);
    }
}
