/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_p1;

import java.sql.Timestamp;

/**
 *
 * @author captj_000
 */
public class BookingList {
    private Customer bookCustName;
    private Holiday bookHoliday;
    private Magician bookMagician;
    private Timestamp bookTimestamp;
    
    public BookingList() {
    }
    
    public BookingList(Customer custName, Holiday holiday, Magician magician, Timestamp timestamp) {
        setBookCustName(custName);
        setBookHoliday(holiday);
        setBookMagician(magician);
        setBookTimestamp(timestamp);
    }

    /**
     * @return the bookCustName
     */
    public Customer getBookCustName() {
        return bookCustName;
    }

    /**
     * @param bookCustName the bookCustName to set
     */
    public void setBookCustName(Customer bookCustName) {
        this.bookCustName = bookCustName;
    }

    /**
     * @return the bookHoliday
     */
    public Holiday getBookHoliday() {
        return bookHoliday;
    }

    /**
     * @param bookHoliday the bookHoliday to set
     */
    public void setBookHoliday(Holiday bookHoliday) {
        this.bookHoliday = bookHoliday;
    }

    /**
     * @return the bookMagician
     */
    public Magician getBookMagician() {
        return bookMagician;
    }

    /**
     * @param bookMagician the bookMagician to set
     */
    public void setBookMagician(Magician bookMagician) {
        this.bookMagician = bookMagician;
    }

    /**
     * @return the bookTimestamp
     */
    public Timestamp getBookTimestamp() {
        return bookTimestamp;
    }

    /**
     * @param bookTimestamp the bookTimestamp to set
     */
    public void setBookTimestamp(Timestamp bookTimestamp) {
        this.bookTimestamp = bookTimestamp;
    }
}
