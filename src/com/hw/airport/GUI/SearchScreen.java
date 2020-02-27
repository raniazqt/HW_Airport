package com.hw.airport.GUI;

import java.awt.Color;
import java.awt.Font;
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

		contentPanel = new JPanel();
		submitBtn = new JButton();
		lastNameLbl = new JLabel();
		bookingLbl = new JLabel();
		titleLbl = new JLabel();
		bookingRefFld = new JTextField();
		lastNameFld = new JTextField();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createBevelBorder(BevelBorder.RAISED),
				"Welcome to ScotiaAir", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 16))); // NOI18N

		submitBtn.setText("Submit");

		lastNameLbl.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		lastNameLbl.setText("Last Name:");

		bookingLbl.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		bookingLbl.setText("Booking Code:");

		titleLbl.setFont(new Font("Tahoma", 0, 24)); // NOI18N
		titleLbl.setText("Check In Here");

		submitBtn.setText("Search");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				performSearchAction(evt);
			}
		});

		GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		contentPanelLayout.setHorizontalGroup(contentPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup()
						.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(contentPanelLayout.createSequentialGroup().addGap(171, 171, 171)
										.addGroup(contentPanelLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lastNameLbl).addComponent(bookingLbl))
										.addGap(25, 25, 25)
										.addGroup(contentPanelLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lastNameFld, GroupLayout.PREFERRED_SIZE, 241,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(bookingRefFld, GroupLayout.PREFERRED_SIZE,
														241, GroupLayout.PREFERRED_SIZE)
												.addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 92,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(contentPanelLayout.createSequentialGroup().addGap(276, 276, 276)
										.addComponent(titleLbl)))
						.addContainerGap(172, Short.MAX_VALUE)));
		contentPanelLayout.setVerticalGroup(contentPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(titleLbl)
						.addGap(54, 54, 54)
						.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lastNameLbl).addComponent(lastNameFld,
										GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE))
						.addGap(85, 85, 85)
						.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(bookingLbl).addComponent(bookingRefFld,
										GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE))
						.addGap(96, 96, 96).addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 40,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(157, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(contentPanel,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

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