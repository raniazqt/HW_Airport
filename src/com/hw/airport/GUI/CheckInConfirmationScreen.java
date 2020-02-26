
package com.hw.airport.GUI;

import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;



public class CheckInConfirmationScreen extends javax.swing.JFrame {


    private javax.swing.JLabel bookingCdLbl;
    private javax.swing.JLabel bookingRefFld;
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel feeLbl;
    private javax.swing.JLabel feesFld;
    private javax.swing.JLabel flightCdLbl;
    private javax.swing.JLabel flightCdFld;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameFld;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel titleLbl;


    public CheckInConfirmationScreen(Booking booking, BookingCharge bookingChrgObj) {
   
    
        jPanel1 = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        nameFld = new javax.swing.JLabel();
        flightCdLbl = new javax.swing.JLabel();
        flightCdFld = new javax.swing.JLabel();
        bookingCdLbl = new javax.swing.JLabel();
        feeLbl = new javax.swing.JLabel();
        bookingRefFld = new javax.swing.JLabel();
        feesFld = new javax.swing.JLabel();
        doneBtn = new javax.swing.JButton();
        titleLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Your check-in details"));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bookingCdLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameFld)
                    .addComponent(bookingRefFld))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(flightCdLbl)
                    .addComponent(feeLbl))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(flightCdFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(feesFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(doneBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameFld)
                    .addComponent(flightCdLbl)
                    .addComponent(flightCdFld))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookingCdLbl)
                    .addComponent(bookingRefFld)
                    .addComponent(feeLbl)
                    .addComponent(feesFld))
                .addGap(30, 30, 30)
                .addComponent(doneBtn)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        titleLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        titleLbl.setText("Check-In Confirmation ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLbl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {
      
		WelcomeWindow obj = new WelcomeWindow();
		obj.setVisible(true);
		this.setVisible(false);
	
    }



}
