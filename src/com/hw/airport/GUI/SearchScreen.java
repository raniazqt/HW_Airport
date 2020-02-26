package com.hw.airport.GUI;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.service.CheckInSvc;
import com.hw.airport.service.CheckInSvcImpl;


public class SearchScreen extends javax.swing.JFrame {
	
	private CheckInSvc checkinSvc = new CheckInSvcImpl();
	private javax.swing.JTextField bookingRefFld;
	private javax.swing.JLabel bookingLbl;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField lastNameFld;
	private javax.swing.JLabel lastNameLbl;
	private javax.swing.JButton submitBtn;
	private javax.swing.JLabel titleLbl;

	public SearchScreen() {

		jPanel1 = new javax.swing.JPanel();
		lastNameLbl = new javax.swing.JLabel();
		submitBtn = new javax.swing.JButton();
		lastNameFld = new javax.swing.JTextField();
		bookingLbl = new javax.swing.JLabel();
		bookingRefFld = new javax.swing.JTextField();
		titleLbl = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(240, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Check In Here"));

		lastNameLbl.setText("Last Name:");

		submitBtn.setText("Search");
		submitBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				performSearchAction(evt);
			}
		});


		bookingLbl.setText("Booking Code:");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE)
						.addComponent(lastNameLbl).addGap(18, 18, 18)
						.addComponent(lastNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34).addComponent(bookingLbl).addGap(18, 18, 18)
						.addComponent(bookingRefFld, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(170, 170, 170).addComponent(submitBtn)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lastNameLbl)
						.addComponent(lastNameFld, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(bookingLbl).addComponent(bookingRefFld, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(submitBtn).addContainerGap(20, Short.MAX_VALUE)));

		titleLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); 
		titleLbl.setText("Welcome to ScotiaAir");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(titleLbl).addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(18, 18, 18).addComponent(titleLbl)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	private void performSearchAction(ActionEvent evt) {
		if (lastNameFld.getText().isEmpty() || bookingRefFld.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Passenger Booking Details");
		} else {
			try {
				Booking booking = checkinSvc.retrieveBookingByCodeAndLastName(lastNameFld.getText(),
						bookingRefFld.getText());
				BaggageInfoScreen obj = new BaggageInfoScreen(booking);
				obj.setVisible(true);

				this.setVisible(false);

			} catch (HWAirportException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}

		}
	}

}