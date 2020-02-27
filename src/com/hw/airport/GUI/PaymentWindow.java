
package com.hw.airport.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.service.CheckInSvc;
import com.hw.airport.service.CheckInSvcImpl;


public class PaymentWindow extends javax.swing.JFrame {

	private CheckInSvc checkInSvc = new CheckInSvcImpl();
	private Booking booking;
	BookingCharge bookingChg;

	private JLabel bookingCdLbl;
	private JLabel bookingRefFld;
	private JTextField expiryFld;
	private JLabel expiryLbl;
	private JLabel flightCdFld;
	private JLabel flightCdLbl;
	private JTextField cvvFld;
	private JLabel cvvLbl;
	private JPanel contentPanel;
	private JLabel nameFld;
	private JLabel nameLbl;
	private JButton submitBtn;
	private JLabel titleLbl;
	private JTextField cardFld;
	private JLabel cardLbl;
	

	public PaymentWindow(Booking bookingObj, BookingCharge bookingChgObj) {

		this.booking = bookingObj;
		this.bookingChg = bookingChgObj;
		
		    contentPanel = new JPanel();
	        submitBtn = new JButton();
	        nameLbl = new JLabel();
	        bookingCdLbl = new JLabel();
	        titleLbl = new JLabel();
	        flightCdLbl = new JLabel();
	        bookingRefFld = new JLabel();
	        nameFld = new JLabel();
	        cardLbl = new JLabel();
	        flightCdFld = new JLabel();
	        cardFld = new JTextField();
	        cvvLbl = new JLabel();
	        expiryLbl = new JLabel();
	        expiryFld = new JTextField();
	        cvvFld = new JTextField();

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        contentPanel.setBackground(new java.awt.Color(240, 255, 255));
	        contentPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Enter your Credit card details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); 

	        submitBtn.setText("Submit");

	        nameLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); 
	        nameLbl.setText("Full Name:");

	        bookingCdLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); 
	        bookingCdLbl.setText("Booking Code:");

	        titleLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); 
	        titleLbl.setText("Excess Baggage Payment");

	        flightCdLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); 
	        flightCdLbl.setText("Flight Code:");

	        bookingRefFld.setFont(new java.awt.Font("Tahoma", 0, 18)); 
	        

	        nameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); 
	       

	        cardLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); 
	        cardLbl.setText("Card Number:");

	        flightCdFld.setFont(new java.awt.Font("Tahoma", 0, 18)); 


			nameFld.setText(booking.getFirstName() + " " + booking.getLastName());

			flightCdFld.setText(booking.getFlightCode());

			bookingRefFld.setText(booking.getRefCode());

			submitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					submitActionPerformed(evt);
				}
			});

	        cvvLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); 
	        cvvLbl.setText("CVV");

	        expiryLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); 
	        expiryLbl.setText("Expiry Date:");

	        GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
	        contentPanel.setLayout(contentPanelLayout);
	        contentPanelLayout.setHorizontalGroup(
	            contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(contentPanelLayout.createSequentialGroup()
	                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(contentPanelLayout.createSequentialGroup()
	                        .addGap(98, 98, 98)
	                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(contentPanelLayout.createSequentialGroup()
	                                .addGap(355, 355, 355)
	                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                    .addGroup(contentPanelLayout.createSequentialGroup()
	                                        .addComponent(flightCdLbl)
	                                        .addGap(33, 33, 33)
	                                        .addComponent(flightCdFld))
	                                    .addGroup(contentPanelLayout.createSequentialGroup()
	                                        .addComponent(cvvLbl)
	                                        .addGap(18, 18, 18)
	                                        .addComponent(cvvFld, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))))
	                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
	                                .addGroup(contentPanelLayout.createSequentialGroup()
	                                    .addComponent(expiryLbl)
	                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(expiryFld, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
	                                .addGroup(contentPanelLayout.createSequentialGroup()
	                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addComponent(bookingCdLbl)
	                                        .addComponent(nameLbl)
	                                        .addComponent(cardLbl))
	                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                        .addGroup(contentPanelLayout.createSequentialGroup()
	                                            .addGap(35, 35, 35)
	                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                                .addComponent(bookingRefFld)
	                                                .addComponent(nameFld)))
	                                        .addGroup(contentPanelLayout.createSequentialGroup()
	                                            .addGap(18, 18, 18)
	                                            .addComponent(cardFld, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))))))
	                    .addGroup(contentPanelLayout.createSequentialGroup()
	                        .addGap(276, 276, 276)
	                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(titleLbl)
	                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
	                                .addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
	                                .addGap(101, 101, 101)))))
	                .addContainerGap(134, Short.MAX_VALUE))
	        );
	        contentPanelLayout.setVerticalGroup(
	            contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(contentPanelLayout.createSequentialGroup()
	                .addGap(32, 32, 32)
	                .addComponent(titleLbl)
	                .addGap(33, 33, 33)
	                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(nameLbl)
	                    .addComponent(flightCdLbl)
	                    .addComponent(nameFld)
	                    .addComponent(flightCdFld))
	                .addGap(43, 43, 43)
	                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(bookingCdLbl)
	                    .addComponent(bookingRefFld))
	                .addGap(57, 57, 57)
	                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(cardLbl)
	                    .addComponent(cardFld, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(cvvLbl)
	                    .addComponent(cvvFld, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
	                .addGap(40, 40, 40)
	                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(expiryLbl)
	                    .addComponent(expiryFld, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
	                .addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
	                .addGap(153, 153, 153))
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(contentPanel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	}

	private void submitActionPerformed(ActionEvent evt) {
		boolean status = checkInSvc.confirmCheckin(booking, bookingChg);
		CheckInConfirmationScreen obj = new CheckInConfirmationScreen(booking, bookingChg);
		obj.setVisible(true);
		this.setVisible(false);
	}
		
}

