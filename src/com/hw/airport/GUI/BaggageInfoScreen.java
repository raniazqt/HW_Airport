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
 * @author Bruce-Inspiron
 */
public class BaggageInfoScreen extends javax.swing.JFrame {

	private CheckInSvc checkInSvc = new CheckInSvcImpl();
	private Booking booking;
	BookingCharge bookingChg;

	private javax.swing.JLabel bookingCdLbl;
	private javax.swing.JLabel bookingRefFld;
	private javax.swing.JTextField depthFld;
	private javax.swing.JLabel depthLbl;
	private javax.swing.JLabel flightCdFld;
	private javax.swing.JLabel flightCdLbl;
	private javax.swing.JTextField heightFld;
	private javax.swing.JLabel heightLbl;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel nameFld;
	private javax.swing.JLabel nameLbl;
	private javax.swing.JButton submitBtn;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JTextField weightFld;
	private javax.swing.JLabel weightLbl;
	private javax.swing.JTextField widthFld;
	private javax.swing.JLabel widthLbl;

	public BaggageInfoScreen(Booking bookingObj) {

		this.booking = bookingObj;
		jPanel1 = new javax.swing.JPanel();
		nameLbl = new javax.swing.JLabel();
		bookingCdLbl = new javax.swing.JLabel();
		nameFld = new javax.swing.JLabel();
		flightCdLbl = new javax.swing.JLabel();
		flightCdFld = new javax.swing.JLabel();
		bookingRefFld = new javax.swing.JLabel();
		weightLbl = new javax.swing.JLabel();
		depthLbl = new javax.swing.JLabel();
		weightFld = new javax.swing.JTextField();
		depthFld = new javax.swing.JTextField();
		heightLbl = new javax.swing.JLabel();
		widthLbl = new javax.swing.JLabel();
		heightFld = new javax.swing.JTextField();
		widthFld = new javax.swing.JTextField();
		submitBtn = new javax.swing.JButton();
		titleLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(240, 255, 255));
		jPanel1.setBorder(
				javax.swing.BorderFactory.createTitledBorder("Please complete the information about your baggage"));

		nameLbl.setText("Passenger Name:");

		bookingCdLbl.setText("Booking Code:");

		weightLbl.setText("Weight");

		depthLbl.setText("Length");

		heightLbl.setText("Height");

		widthLbl.setText("Width");

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
																.addComponent(depthLbl).addComponent(weightLbl))
														.addGap(11, 11, 11)
														.addGroup(jPanel1Layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING).addComponent(
																		weightFld,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(depthFld,
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
														.addComponent(heightLbl).addComponent(widthLbl))
														.addGap(18, 18, 18)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(heightFld,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(widthFld,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 69,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
								.addComponent(weightLbl)
								.addComponent(weightFld, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(heightLbl).addComponent(heightFld, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(depthFld, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(depthLbl).addComponent(widthLbl).addComponent(widthFld,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(35, 35, 35).addComponent(submitBtn)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		titleLabel.setText("Check in Baggage Information");

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

	private void submitActionPerformed(ActionEvent evt) {// GEN-FIRST:event_SubmitActionPerformed
		if (depthFld.getText().isEmpty() || depthFld.getText().charAt(0) == ' ') {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Length (cm) ");
		} else if (heightFld.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Height (cm) ");
		} else if (widthFld.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Weight (Kg) ");
		} else {
			// Calculate xtra fees if any
			bookingChg = new BookingCharge(bookingRefFld.getText(), booking.getLastName(), 1,
					Double.valueOf(heightFld.getText()), Double.valueOf(widthFld.getText()),
					Double.valueOf(depthFld.getText()), Double.valueOf(weightFld.getText()));
			try {
				bookingChg = checkInSvc.calculateXtraChargeForPasngr(bookingChg);
				// TODO: Display the results
				JOptionPane.showMessageDialog(null, "Volume Charge" + bookingChg.getVolumeCharge() + " "
						+ "Weight Charge" + bookingChg.getWeightCharge());
				if (bookingChg.getVolumeCharge() <= 0 && bookingChg.getWeightCharge() <= 0) {
					boolean status = checkInSvc.confirmCheckin(booking);
					if (status) {
						this.setVisible(false);
						CheckInConfirmationScreen confirmationScrn = new CheckInConfirmationScreen(booking, bookingChg);

					} else {
						JOptionPane.showMessageDialog(null, "Failed to check in. Please try again");
					}
				} else {
					this.setVisible(false);
					PaymentWindow paymentScrn = new PaymentWindow(booking, bookingChg);
				}
			} catch (HWAirportException e) {
				e.printStackTrace();
			}
		}
	}

}
