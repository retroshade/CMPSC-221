/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_p1;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author captj_000
 */
public class WaitList {
    
    public static void addToWaitList(String customer, String holiday, Timestamp timestamp) {
        String status;
        
        try
        {
            PreparedStatement setList = Connector.getConnection().prepareStatement("INSERT INTO WaitList (Customer, Holiday, Timestamp) VALUES (?, ?, ?)");
            setList.setString(1, customer);
            setList.setString(2, holiday);
            setList.setTimestamp(3, timestamp);
            
            setList.executeUpdate();
            
            status = String.format("%s has been added to the waitlist for %s", customer, holiday);
            //Database_P1_GUI.setScehduleTextArea(status);
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(0);
        }
    }
/**   
    public static ArrayList<Holiday> getWaitListByHoliday(String holiday) {
        
        ArrayList<WaitListEntry> waitlist = new ArrayList<>();
        
        return waitlist;
    }
*/
}
