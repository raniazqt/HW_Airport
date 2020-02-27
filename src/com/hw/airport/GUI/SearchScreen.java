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
	private JPanel jPanel1;
	private JTextField lastNameFld;
	private JLabel lastNameLbl;
	private JButton submitBtn;
	private JLabel titleLbl;

	public SearchScreen() {

		jPanel1 = new JPanel();
		lastNameLbl = new JLabel();
		submitBtn = new JButton();
		lastNameFld = new JTextField();
		bookingLbl = new JLabel();
		bookingRefFld = new JTextField();
		titleLbl = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(240, 255, 255));
		jPanel1.setBorder(BorderFactory.createTitledBorder("Check In Here"));

		lastNameLbl.setText("Last Name:");

		submitBtn.setText("Search");
		submitBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				performSearchAction(evt);
			}
		});


		bookingLbl.setText("Booking Code:");

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(17, Short.MAX_VALUE)
						.addComponent(lastNameLbl).addGap(18, 18, 18)
						.addComponent(lastNameFld, GroupLayout.PREFERRED_SIZE, 90,
								GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34).addComponent(bookingLbl).addGap(18, 18, 18)
						.addComponent(bookingRefFld, GroupLayout.PREFERRED_SIZE, 90,
								GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(170, 170, 170).addComponent(submitBtn)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lastNameLbl)
						.addComponent(lastNameFld, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookingLbl).addComponent(bookingRefFld, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(submitBtn).addContainerGap(20, Short.MAX_VALUE)));

		titleLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); 
		titleLbl.setText("Welcome to ScotiaAir");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(titleLbl).addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(18, 18, 18).addComponent(titleLbl)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));


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