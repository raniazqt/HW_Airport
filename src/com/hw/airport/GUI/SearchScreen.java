package com.hw.airport.GUI;

import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.service.CheckInSvc;
import com.hw.airport.service.CheckInSvcImpl;

public class SearchScreen extends javax.swing.JFrame {

	private CheckInSvc checkinSvc = new CheckInSvcImpl();
	private JTextField bookingRefFld;
	private JLabel bookingLbl;
	private JPanel contentPanel;
	private JTextField lastNameFld;
	private JLabel lastNameLbl;
	private JButton submitBtn;
	private JLabel titleLbl;

	public SearchScreen() {

		contentPanel = new javax.swing.JPanel();
		submitBtn = new javax.swing.JButton();
		lastNameLbl = new javax.swing.JLabel();
		bookingLbl = new javax.swing.JLabel();
		titleLbl = new javax.swing.JLabel();
		bookingRefFld = new javax.swing.JTextField();
		lastNameFld = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		contentPanel.setBackground(new java.awt.Color(240, 255, 255));
		contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Welcome to ScotiaAir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

		submitBtn.setText("Submit");

		lastNameLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lastNameLbl.setText("Last Name:");

		bookingLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		bookingLbl.setText("Booking Code:");

		titleLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		titleLbl.setText("Check In Here");

		submitBtn.setText("Search");
		submitBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				performSearchAction(evt);
			}
		});

		javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		contentPanelLayout.setHorizontalGroup(contentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup()
						.addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(contentPanelLayout.createSequentialGroup().addGap(171, 171, 171)
										.addGroup(contentPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lastNameLbl).addComponent(bookingLbl))
										.addGap(25, 25, 25)
										.addGroup(contentPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lastNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 241,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(bookingRefFld, javax.swing.GroupLayout.PREFERRED_SIZE,
														241, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(contentPanelLayout.createSequentialGroup().addGap(276, 276, 276)
										.addComponent(titleLbl)))
						.addContainerGap(172, Short.MAX_VALUE)));
		contentPanelLayout.setVerticalGroup(contentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(titleLbl)
						.addGap(54, 54, 54)
						.addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lastNameLbl).addComponent(lastNameFld,
										javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(85, 85, 85)
						.addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(bookingLbl).addComponent(bookingRefFld,
										javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(96, 96, 96).addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(157, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(contentPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void performSearchAction(ActionEvent evt) {

		if (lastNameFld.getText().isEmpty() || bookingRefFld.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Passenger Booking Details");
		} else {
			try {
				Booking booking = checkinSvc.retrieveBookingByCodeAndLastName(lastNameFld.getText(),
						bookingRefFld.getText());
				if (booking.isCheckedIn() == false) {

					BaggageInfoScreen obj = new BaggageInfoScreen(booking);
					obj.setVisible(true);

					this.setVisible(false);

				}

				else {
					JOptionPane.showMessageDialog(null,"You've already checked in!");
					
					WelcomeWindow obj = new WelcomeWindow();
					obj.setVisible(true);
					this.setVisible(false);
					
				}

			} catch (HWAirportException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}

		}

	}

}