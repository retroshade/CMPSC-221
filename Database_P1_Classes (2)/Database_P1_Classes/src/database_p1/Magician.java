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
public class Magician {
    private static String magicianName;
    private static Connection connectionMag;
    private static PreparedStatement selectMagByName;
    
    public Magician() {
    }
    
    public Magician(String magicianName) {
        setMagicianName(magicianName);
    }

    /**
     * @return the holidayName
     */
    public String getMagicianName() {
        return magicianName;
    }

    /**
     * @param holidayName the holidayName to set
     */
    public void setMagicianName(String magicianName) {
        this.magicianName = magicianName;
    }
    
        
    public static ArrayList<String> getMagicianByName(String nameMag) {
        ArrayList<String> results = new ArrayList<>();
        ResultSet resultSet = null;
        
        try
        {
            selectMagByName.setString(1, nameMag);
            resultSet = selectMagByName.executeQuery();
            results = new ArrayList<String>();
            
            while (resultSet.next())
            {
                results.add(resultSet.getString("magicianName"));
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
    
    public static ArrayList<String> getAllMagicians() {
        ArrayList<String> results = new ArrayList<String>();
        ResultSet resultSet = null;
        
        try
        {
            resultSet = Connector.getConnection().prepareStatement("SELECT * FROM MAGICIANS").executeQuery();
            results = new ArrayList<String>();
            
            while (resultSet.next())
            {
                results.add(resultSet.getString("MagicianName"));
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
    
    public int addMagician(String name) {
        int result = 0;
        
        try
        {   
            PreparedStatement insertNewMagician = Connector.getConnection().prepareStatement("INSERT INTO Magicians (magicianname) VALUES (?)");
            insertNewMagician.setString(1, name);
            result = insertNewMagician.executeUpdate();
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
            connectionMag.close();
        }
        catch (SQLException sqlException4)
        {
            sqlException4.printStackTrace();
        }
    }
    
    public void deleteMagician(String name) {
        Connector.removeMagician(name);
    }
    
    public void listRemovalMag(String name) {
        Connector.removeMagList(name);
    }
}
