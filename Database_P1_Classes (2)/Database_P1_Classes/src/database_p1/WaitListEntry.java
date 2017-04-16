/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_p1;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author captj_000
 */
public class WaitListEntry {
    private final String waitCustName;
    private final String waitHoliday;
    private final Timestamp waitTimestamp;
    
    public WaitListEntry(String custName, String holName, Timestamp timestamp) {
        waitCustName = custName;
        waitHoliday = holName;
        waitTimestamp = timestamp;
    }
    
    public String submit() {
        return Connector.newRequest(this);
    }
    
    public static ArrayList<WaitListEntry> queryAll() {
        return Connector.getAllEntries();
    }
    
    public static void waitClear() {
        Connector.waitlistClear();
    }
    
    /**
     * @return the custName
     */
    public String getWaitCustName() {
        return waitCustName;
    }


    /**
     * @return the holiday
     */
    public String getWaitHoliday() {
        return waitHoliday;
    }


    /**
     * @return the timestamp
     */
    public Timestamp getWaitTimestamp() {
        return waitTimestamp;
    }

}
