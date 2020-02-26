/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw.airport.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;
import com.hw.airport.service.CheckInSvc;
import com.hw.airport.service.CheckInSvcImpl;

/**
 *
 * @author Bruce
 */
public class PaymentWindow extends javax.swing.JFrame {

	private CheckInSvc checkInSvc = new CheckInSvcImpl();
	private Booking booking;
	BookingCharge bookingChg;

	private javax.swing.JLabel bookingCdLbl;
	private javax.swing.JLabel bookingRefFld;
	private javax.swing.JTextField expiryFld;
	private javax.swing.JLabel expiryLbl;
	private javax.swing.JLabel flightCdFld;
	private javax.swing.JLabel flightCdLbl;
	private javax.swing.JTextField cvvFld;
	private javax.swing.JLabel cvvLbl;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel nameFld;
	private javax.swing.JLabel nameLbl;
	private javax.swing.JButton submitBtn;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JTextField cardFld;
	private javax.swing.JLabel cardLbl;
	

	public PaymentWindow(Booking bookingObj, BookingCharge bookingChgObj) {

		this.booking = bookingObj;
		this.bookingChg = bookingChgObj;
		
		jPanel1 = new javax.swing.JPanel();
		nameLbl = new javax.swing.JLabel();
		bookingCdLbl = new javax.swing.JLabel();
		nameFld = new javax.swing.JLabel();
		flightCdLbl = new javax.swing.JLabel();
		flightCdFld = new javax.swing.JLabel();
		bookingRefFld = new javax.swing.JLabel();
		cardLbl = new javax.swing.JLabel();
		expiryLbl = new javax.swing.JLabel();
		cardFld = new javax.swing.JTextField();
		expiryFld = new javax.swing.JTextField();
		cvvLbl = new javax.swing.JLabel();
	
		cvvFld = new javax.swing.JTextField();
		
		submitBtn = new javax.swing.JButton();
		titleLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(240, 255, 255));
		jPanel1.setBorder(
				javax.swing.BorderFactory.createTitledBorder("Please complete the Payment information below"));

		nameLbl.setText("Passenger Name:");

		bookingCdLbl.setText("Booking Code:");

		cardLbl.setText("Card Number:");

		expiryLbl.setText("Expiry:");

		cvvLbl.setText("CVV:");



		flightCdLbl.setText("Flight Code:");
		
		nameFld.setText(booking.getFirstName() + " " + booking.getLastName());

		flightCdFld.setText(booking.getFlightCode());

		bookingRefFld.setText(booking.getRefCode());

		submitBtn.setText("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(
												javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout
														.createSequentialGroup().addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(expiryLbl).addComponent(cardLbl))
														.addGap(11, 11, 11)
														.addGroup(jPanel1Layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING).addComponent(
																		cardFld,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(expiryFld,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel1Layout.createSequentialGroup().addComponent(nameLbl)
														.addGap(16, 16, 16).addComponent(nameFld)))
										.addGap(64, 64, 64)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														jPanel1Layout.createSequentialGroup().addComponent(flightCdLbl)
																.addGap(30, 30, 30).addComponent(flightCdFld))
												.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(cvvLbl))
														.addGap(18, 18, 18)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(cvvFld,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																))))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(bookingCdLbl)
										.addGap(31, 31, 31).addComponent(bookingRefFld))))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(157, 157, 157).addComponent(submitBtn)))
						.addGap(0, 29, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21)
						.addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(nameLbl)
								.addComponent(nameFld).addComponent(flightCdLbl).addComponent(flightCdFld))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(bookingCdLbl).addComponent(bookingRefFld))
						.addGap(26, 26, 26)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cardLbl)
								.addComponent(cardFld, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cvvLbl).addComponent(cvvFld, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(expiryFld, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(expiryLbl))
						.addGap(35, 35, 35).addComponent(submitBtn)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		titleLabel.setText("Fees Payment");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								layout.createSequentialGroup().addComponent(titleLabel).addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(9, 9, 9).addComponent(titleLabel)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGap(18, 18, 18)));

		pack();
	}

	private void submitActionPerformed(ActionEvent evt) {
		CheckInConfirmationScreen obj = new CheckInConfirmationScreen(booking, bookingChg);
		obj.setVisible(true);
		this.setVisible(false);
			}
		
	}

