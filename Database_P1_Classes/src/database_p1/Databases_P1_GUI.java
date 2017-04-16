/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is a scenario that you can use to test your final project. It is not an exhaustive test, but tests almost all of the conditions your program should handle.

When you submit your final project, all the tables in the database should be empty. This scenario assumes that is the case.

The holidays are going to be 1 and 2, the magicians are going to be m, n and o and the customers are going to be a, b, c, d, and e.

add hol 1
add hol 2 
add mag m 
add mag n
book a 1, should get assigned magician m 
book b 1, should get assigned magician n 
book c 1, should go to waitlist 
book d, 2 should be magician m 
book e 1, should go to waitlist after c 
add mag o, should get booked with c 1 from waitlist 
drop mag o, c booking should go back onto waitlist ahead of e 
cancel a 1, booking should get canceled and c 1 should get booked with magician m 
cancel e 1, cancels from waitlist

If your program does all of that, it should be in pretty good shape.
 */

package database_p1;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author rwm5592
 */
public class Databases_P1_GUI extends JFrame {
    
    private String customer;
    private Magician magician;
    private Holiday holiday;
    private WaitListEntry waitlist;
    private BookingList bookinglist;
    private ArrayList<Magician> resultsMag;
    private ArrayList<Holiday> resultsHol;
    private ArrayList<WaitListEntry> resultsWait;
    private ArrayList<BookingList> resultsBook;
    private ArrayList<String> resultsCust; 
    private ArrayList<Timestamp> resultsTS;

    /**
     * Creates new form Databases_P1_GUI
     */
    public Databases_P1_GUI() {
        super("Magician Booking and Search");        
        initComponents();
        HolidayBookComboBox.setModel(new DefaultComboBoxModel(Holiday.getAllHolidays().toArray()));
        MagicianStatusComboBox.setModel(new DefaultComboBoxModel(Magician.getAllMagicians().toArray()));
        HolidayStatusComboBox.setModel(new DefaultComboBoxModel(Holiday.getAllHolidays().toArray()));
        DropHolCB.setModel(new DefaultComboBoxModel(Holiday.getAllHolidays().toArray()));
        DropMagCB.setModel(new DefaultComboBoxModel(Magician.getAllMagicians().toArray()));
        magician = new Magician();
        holiday = new Holiday();
        bookinglist = new BookingList();
        customer = new String();
        
        ArrayList<String> hol = Holiday.getAllHolidays();
        ArrayList<String> mag = Magician.getAllMagicians();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        ADMaglPanel = new javax.swing.JTabbedPane();
        BookTabPanel = new javax.swing.JPanel();
        CustomerBookLabel = new javax.swing.JLabel();
        CustomerBookTextField = new javax.swing.JTextField();
        HolidayBookLabel = new javax.swing.JLabel();
        HolidayBookComboBox = new javax.swing.JComboBox();
        BookButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BookingStatusTextField = new javax.swing.JTextArea();
        StatusTabPanel = new javax.swing.JPanel();
        HolidayListingButton = new javax.swing.JButton();
        MagicianListingButton = new javax.swing.JButton();
        WaitlistListingButton = new javax.swing.JButton();
        HolidayStatusComboBox = new javax.swing.JComboBox<>();
        MagicianStatusComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListingStatusTextField = new javax.swing.JTextArea();
        ADHolPanel = new javax.swing.JPanel();
        AddHolButton = new javax.swing.JButton();
        DropApptButton = new javax.swing.JButton();
        DropHolCB = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        ADHolTA = new javax.swing.JTextArea();
        AddHolTF = new javax.swing.JTextField();
        DropCustTF = new javax.swing.JTextField();
        ADMagPanel = new javax.swing.JPanel();
        AddMagButton = new javax.swing.JButton();
        DropMagButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ADMagTA = new javax.swing.JTextArea();
        DropMagCB = new javax.swing.JComboBox<>();
        AddMagTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TitleLabel.setText("Magician Agent Booking");

        ADMaglPanel.setName("Tab"); // NOI18N

        CustomerBookLabel.setText("Customer Name: ");

        CustomerBookTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerBookTextFieldActionPerformed(evt);
            }
        });

        HolidayBookLabel.setText("Holiday");

        BookButton.setText("Book");
        BookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonActionPerformed(evt);
            }
        });

        BookingStatusTextField.setColumns(20);
        BookingStatusTextField.setRows(5);
        jScrollPane2.setViewportView(BookingStatusTextField);

        javax.swing.GroupLayout BookTabPanelLayout = new javax.swing.GroupLayout(BookTabPanel);
        BookTabPanel.setLayout(BookTabPanelLayout);
        BookTabPanelLayout.setHorizontalGroup(
            BookTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BookTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BookTabPanelLayout.createSequentialGroup()
                        .addGroup(BookTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustomerBookLabel)
                            .addComponent(HolidayBookLabel))
                        .addGap(18, 18, 18)
                        .addGroup(BookTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HolidayBookComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CustomerBookTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(BookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        BookTabPanelLayout.setVerticalGroup(
            BookTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BookTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookTabPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(BookTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerBookLabel)
                            .addComponent(CustomerBookTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BookTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HolidayBookLabel)
                            .addComponent(HolidayBookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        ADMaglPanel.addTab("Book", BookTabPanel);

        HolidayListingButton.setText("Holiday Listing");
        HolidayListingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HolidayListingButtonActionPerformed(evt);
            }
        });

        MagicianListingButton.setText("Magician Listing");
        MagicianListingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MagicianListingButtonActionPerformed(evt);
            }
        });

        WaitlistListingButton.setText("Waitlist Listing");
        WaitlistListingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WaitlistListingButtonActionPerformed(evt);
            }
        });

        ListingStatusTextField.setColumns(20);
        ListingStatusTextField.setRows(5);
        jScrollPane1.setViewportView(ListingStatusTextField);

        javax.swing.GroupLayout StatusTabPanelLayout = new javax.swing.GroupLayout(StatusTabPanel);
        StatusTabPanel.setLayout(StatusTabPanelLayout);
        StatusTabPanelLayout.setHorizontalGroup(
            StatusTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StatusTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(StatusTabPanelLayout.createSequentialGroup()
                        .addGroup(StatusTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HolidayListingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HolidayStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(StatusTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MagicianListingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MagicianStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(WaitlistListingButton)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        StatusTabPanelLayout.setVerticalGroup(
            StatusTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StatusTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(StatusTabPanelLayout.createSequentialGroup()
                        .addGroup(StatusTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HolidayStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MagicianStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(StatusTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HolidayListingButton)
                            .addComponent(MagicianListingButton)))
                    .addComponent(WaitlistListingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ADMaglPanel.addTab("Status", StatusTabPanel);

        AddHolButton.setText("Add Holiday");
        AddHolButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddHolButtonActionPerformed(evt);
            }
        });

        DropApptButton.setText("Drop Appt.");
        DropApptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DropApptButtonActionPerformed(evt);
            }
        });

        ADHolTA.setColumns(20);
        ADHolTA.setRows(5);
        jScrollPane5.setViewportView(ADHolTA);

        javax.swing.GroupLayout ADHolPanelLayout = new javax.swing.GroupLayout(ADHolPanel);
        ADHolPanel.setLayout(ADHolPanelLayout);
        ADHolPanelLayout.setHorizontalGroup(
            ADHolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADHolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ADHolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddHolButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddHolTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ADHolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ADHolPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DropApptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ADHolPanelLayout.createSequentialGroup()
                        .addComponent(DropHolCB, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADHolPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DropCustTF, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ADHolPanelLayout.setVerticalGroup(
            ADHolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADHolPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(ADHolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddHolButton)
                    .addComponent(DropApptButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ADHolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DropCustTF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddHolTF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(DropHolCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADHolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        ADMaglPanel.addTab("Add/Drop Holiday", ADHolPanel);

        AddMagButton.setText("Add Magician");
        AddMagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMagButtonActionPerformed(evt);
            }
        });

        DropMagButton.setText("Drop Magician");
        DropMagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DropMagButtonActionPerformed(evt);
            }
        });

        ADMagTA.setColumns(20);
        ADMagTA.setRows(5);
        jScrollPane4.setViewportView(ADMagTA);

        javax.swing.GroupLayout ADMagPanelLayout = new javax.swing.GroupLayout(ADMagPanel);
        ADMagPanel.setLayout(ADMagPanelLayout);
        ADMagPanelLayout.setHorizontalGroup(
            ADMagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADMagPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ADMagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddMagTF, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddMagButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ADMagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ADMagPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(DropMagButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(ADMagPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DropMagCB, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ADMagPanelLayout.setVerticalGroup(
            ADMagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADMagPanelLayout.createSequentialGroup()
                .addGroup(ADMagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ADMagPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(ADMagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddMagButton)
                            .addComponent(DropMagButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ADMagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddMagTF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DropMagCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADMagPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );

        ADMaglPanel.addTab("Add/Drop Magician", ADMagPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADMaglPanel, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(TitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADMaglPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomerBookTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerBookTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerBookTextFieldActionPerformed

    private void BookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookButtonActionPerformed
        // TODO add your handling code here:
        String memo;
        Timestamp bookStamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        if (CustomerBookTextField.getText().equals("")) 
        {
            memo = "ERROR: Please enter customer name";
            BookingStatusTextField.setText(memo);
            //System.out.print("ERROR");
        }
        else
        {
            String client = CustomerBookTextField.getText();
            WaitListEntry request = new WaitListEntry(client, HolidayBookComboBox.getSelectedItem().toString(), bookStamp);
            String mag = request.submit();
            if (mag.equals("waitlisted")) {
                memo = "No magicians available. \nYou have been added to the waitlist.";
            }
            else { 
                memo = "You booked " + mag + " for " + request.getWaitHoliday();
            }

            BookingStatusTextField.setText(memo);
        }
    }//GEN-LAST:event_BookButtonActionPerformed

    private void HolidayListingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HolidayListingButtonActionPerformed
        // TODO add your handling code here:
        String memo = "Customer \tMagician";
        ArrayList<BookingListEntry> holList = BookingListEntry.queryHolidays(HolidayStatusComboBox.getSelectedItem().toString());

        for (BookingListEntry b: holList) {
            memo += "\n" + b.getBookCustName() + "\t" + b.getBookMagName();
        }
        
        ListingStatusTextField.setText(memo);
    }//GEN-LAST:event_HolidayListingButtonActionPerformed

    private void WaitlistListingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WaitlistListingButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<WaitListEntry> waitlist = WaitListEntry.queryAll();
        String memo = "Customer \tHoliday";
        
        for(WaitListEntry w: waitlist) {
            memo += "\n" + w.getWaitCustName() + "\t" + w.getWaitHoliday();
        }
        
        ListingStatusTextField.setText(memo);
    }//GEN-LAST:event_WaitlistListingButtonActionPerformed

    private void MagicianListingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MagicianListingButtonActionPerformed
        // TODO add your handling code here:
        String memo = "Customer \tHoliday";
        ArrayList<BookingListEntry> magList = BookingListEntry.queryMagicians(MagicianStatusComboBox.getSelectedItem().toString());

        for (BookingListEntry m: magList) {
            memo += "\n" + m.getBookCustName() + "\t" + m.getBookHoliday();
        }
        
        ListingStatusTextField.setText(memo);
        //magician booked status
        //delete magician
        //delete that magicians bookings
        //rebook maglist (like in add magician) 
    }//GEN-LAST:event_MagicianListingButtonActionPerformed

    private void AddHolButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddHolButtonActionPerformed
        // TODO add your handling code here:
        String memo;
        if (AddHolTF.getText().equals("")) 
        {
            memo = "ERROR: Please enter magician name";
            ADHolTA.setText(memo);
        }
        else
        {
            String holA = AddHolTF.getText();
            Holiday request = new Holiday(holA);
            int magB = request.addHoliday(holA);
            ArrayList<WaitListEntry> wl = new ArrayList<>();            
            
            memo = holA + " has been added to \navailable holidays.";// as\nmagician number " + magB +".";
            //System.out.printf("%s has been added to available magicians", magA);
            ADHolTA.setText(memo);
            
            HolidayBookComboBox.setModel(new DefaultComboBoxModel(Holiday.getAllHolidays().toArray()));
            HolidayStatusComboBox.setModel(new DefaultComboBoxModel(Holiday.getAllHolidays().toArray()));
            DropHolCB.setModel(new DefaultComboBoxModel(Holiday.getAllHolidays().toArray()));  
        }
    }//GEN-LAST:event_AddHolButtonActionPerformed

    private void DropApptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DropApptButtonActionPerformed
        // TODO add your handling code here:
        //remove from booking, if possible
            //book that magician to waitlist
        //or delete from waitlist
        
        String customer = DropCustTF.getText();
        String holChoice = DropHolCB.getSelectedItem().toString();
        WaitListEntry wle;// = new WaitListEntry(customer, holChoice, wle.getWaitTimestamp());
        
        Connector.removeAppt(customer, holChoice);        
        String memo = customer + "'s appointment for " + holChoice+ " has been cancelled.";
        ADHolTA.setText(memo);
    }//GEN-LAST:event_DropApptButtonActionPerformed

    private void AddMagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMagButtonActionPerformed
        // TODO add your handling code here:
        String memo;
        if (AddMagTF.getText().equals("")) 
        {
            memo = "ERROR: Please enter magician name";
            ADMagTA.setText(memo);
        }
        else
        {
            String magA = AddMagTF.getText();
            Magician requestMag = new Magician(magA);
            int magB = requestMag.addMagician(magA);
            
            memo = magA + " has been added to \navailable magicians.\n\n";// as\nmagician number.";// + magB +".";
            ADMagTA.setText(memo);
            
            MagicianStatusComboBox.setModel(new DefaultComboBoxModel(Magician.getAllMagicians().toArray()));
            DropMagCB.setModel(new DefaultComboBoxModel(Magician.getAllMagicians().toArray()));
            //get all entries
            //delete waitlist
            //loop booking method
            ArrayList<WaitListEntry> waitlist = WaitListEntry.queryAll();
            Connector.waitlistClear();
            
            for (WaitListEntry wle : waitlist) {
                    String client = AddMagTF.getText();
                    String mag = wle.submit();
                    
                    memo += wle.getWaitCustName() + " booked " + mag + " for " + wle.getWaitHoliday() + "\n";

                    ADMagTA.setText(memo);
            }
        }
    }//GEN-LAST:event_AddMagButtonActionPerformed

    private void DropMagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DropMagButtonActionPerformed
        // TODO add your handling code here:
        Magician magDropped = new Magician();
        String magChoice = DropMagCB.getSelectedItem().toString();
        
        String memo = "";
        ArrayList<BookingListEntry> magList = BookingListEntry.queryMagicians(magChoice);
        ArrayList<WaitListEntry> waitList = WaitListEntry.queryAll();
        
        magDropped.deleteMagician(magChoice);        
        magDropped.listRemovalMag(magChoice);
        //WaitListEntry.waitClear();
                
        for (BookingListEntry ble : magList) {
            WaitListEntry request = new WaitListEntry(ble.getBookCustName(), ble.getBookHoliday(), ble.getBookTimestamp());
            //WaitListEntry request2 = new WaitListEntry(waitList.)
            String mag = request.submit();
            
            memo += ble.getBookCustName() + " booked " + mag + " for " + request.getWaitHoliday() + "\n";
            ADMagTA.setText(memo);
        }
        
        //magician booked status
        //delete magician
        //delete that magicians bookings
        //rebook maglist (like in add magician) 
        
        MagicianStatusComboBox.setModel(new DefaultComboBoxModel(Magician.getAllMagicians().toArray()));
        DropMagCB.setModel(new DefaultComboBoxModel(Magician.getAllMagicians().toArray()));
        
        String memo1 = magChoice + " was removed from the list of available holidays.";
        ADHolTA.setText(memo1);
    }//GEN-LAST:event_DropMagButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Databases_P1_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Databases_P1_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Databases_P1_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Databases_P1_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Databases_P1_GUI().setSize(400, 400);
                new Databases_P1_GUI().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADHolPanel;
    private javax.swing.JTextArea ADHolTA;
    private javax.swing.JPanel ADMagPanel;
    private javax.swing.JTextArea ADMagTA;
    private javax.swing.JTabbedPane ADMaglPanel;
    private javax.swing.JButton AddHolButton;
    private javax.swing.JTextField AddHolTF;
    private javax.swing.JButton AddMagButton;
    private javax.swing.JTextField AddMagTF;
    private javax.swing.JButton BookButton;
    private javax.swing.JPanel BookTabPanel;
    private javax.swing.JTextArea BookingStatusTextField;
    private javax.swing.JLabel CustomerBookLabel;
    private javax.swing.JTextField CustomerBookTextField;
    private javax.swing.JButton DropApptButton;
    private javax.swing.JTextField DropCustTF;
    private javax.swing.JComboBox<String> DropHolCB;
    private javax.swing.JButton DropMagButton;
    private javax.swing.JComboBox<String> DropMagCB;
    private javax.swing.JComboBox HolidayBookComboBox;
    private javax.swing.JLabel HolidayBookLabel;
    private javax.swing.JButton HolidayListingButton;
    private javax.swing.JComboBox<String> HolidayStatusComboBox;
    private javax.swing.JTextArea ListingStatusTextField;
    private javax.swing.JButton MagicianListingButton;
    private javax.swing.JComboBox<String> MagicianStatusComboBox;
    private javax.swing.JPanel StatusTabPanel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton WaitlistListingButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
