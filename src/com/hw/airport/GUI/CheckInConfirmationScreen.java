
package com.hw.airport.GUI;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;


/**
 *
 * @author Bruce 
 */

public class CheckInConfirmationScreen extends javax.swing.JFrame {


    private JLabel bookingCdLbl;
    private JLabel bookingRefFld;
    private JButton doneBtn;
    private JLabel feeLbl;
    private JLabel feesFld;
    private JLabel flightCdLbl;
    private JLabel flightCdFld;
    private JPanel jPanel1;
    private JLabel nameFld;
    private JLabel nameLbl;
    private JLabel titleLbl;


    public CheckInConfirmationScreen(Booking booking, BookingCharge bookingChrgObj) {
   
    
        jPanel1 = new JPanel();
        nameLbl = new JLabel();
        nameFld = new JLabel();
        flightCdLbl = new JLabel();
        flightCdFld = new JLabel();
        bookingCdLbl = new JLabel();
        feeLbl = new JLabel();
        bookingRefFld = new JLabel();
        feesFld = new JLabel();
        doneBtn = new JButton();
        titleLbl = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 255, 255));
        jPanel1.setBorder(BorderFactory.createTitledBorder("Your check-in details"));

        nameLbl.setText("Passenger Name:");

        nameFld.setText(booking.getFullName());

        flightCdLbl.setText("Flight Code:");

        flightCdFld.setText(booking.getFlightCode());

        bookingCdLbl.setText("Booking Code:");

        feeLbl.setText("Fee Paid:");

        bookingRefFld.setText(booking.getRefCode());

        feesFld.setText(String.valueOf(bookingChrgObj.getTotalChg()));

        doneBtn.setText("Confirm");
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bookingCdLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nameLbl, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(nameFld)
                    .addComponent(bookingRefFld))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(flightCdLbl)
                    .addComponent(feeLbl))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(flightCdFld, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feesFld, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(doneBtn)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameFld)
                    .addComponent(flightCdLbl)
                    .addComponent(flightCdFld))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bookingCdLbl)
                    .addComponent(bookingRefFld)
                    .addComponent(feeLbl)
                    .addComponent(feesFld))
                .addGap(30, 30, 30)
                .addComponent(doneBtn)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        titleLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleLbl.setText("Check-In Confirmation ");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLbl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titleLbl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
      
		WelcomeWindow obj = new WelcomeWindow();
		obj.setVisible(true);
		this.setVisible(false);
	
    }



}
