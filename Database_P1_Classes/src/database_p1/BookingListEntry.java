/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_p1;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author captj_000
 */
public class BookingListEntry {
    private final String bookCustName;
    private final String bookHoliday;
    private final String bookMagName;
    private final Timestamp bookTimestamp;
    
    public BookingListEntry(String custName, String holName, String magName) {
        bookCustName = custName;
        bookHoliday = holName;
        bookMagName = magName;
        bookTimestamp = new Timestamp(new Date().getTime());
    }

    public static ArrayList<BookingListEntry> queryHolidays(String holiday) {
        return Connector.getWaitListByHoliday(holiday);
    }
    
    public static ArrayList<BookingListEntry> queryMagicians(String magician) {
        return Connector.getWaitListByMagician(magician);
    }
    
    /**
     * @return the bookCustName
     */
    public String getBookCustName() {
        return bookCustName;
    }

    /**
     * @return the bookMagName
     */
    public String getBookMagName() {
        return bookMagName;
    }

    /**
     * @return the bookHoliday
     */
    public String getBookHoliday() {
        return bookHoliday;
    }

    /**
     * @return the bookTimestamp
     */
    public Timestamp getBookTimestamp() {
        return bookTimestamp;
    }
}