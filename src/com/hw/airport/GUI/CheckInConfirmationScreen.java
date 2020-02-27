
package com.hw.airport.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;

public class CheckInConfirmationScreen extends javax.swing.JFrame {

	private JLabel bookingCdLbl;
	private JLabel bookingRefFld;
	private JButton submitBtn;
	private JLabel feeLbl;
	private JLabel feeFld;
	private JLabel flightCdLbl;
	private JLabel flightCdFld;
	private JPanel contentPanel;
	private JLabel nameFld;
	private JLabel nameLbl;
	private JLabel titleLbl;

	public CheckInConfirmationScreen(Booking booking, BookingCharge bookingChrgObj) {

		contentPanel = new JPanel();
		submitBtn = new JButton();
		nameLbl = new JLabel();
		bookingCdLbl = new JLabel();
		titleLbl = new JLabel();
		flightCdLbl = new JLabel();
		bookingRefFld = new JLabel();
		nameFld = new JLabel();
		flightCdFld = new JLabel();
		feeFld = new JLabel();
		feeLbl = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
				"Please review your details", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				new Font("Tahoma", 0, 16)));

		submitBtn.setText("Submit");

		nameLbl.setFont(new Font("Tahoma", 0, 18));
		nameLbl.setText("Full Name:");

		bookingCdLbl.setFont(new Font("Tahoma", 0, 18));
		bookingCdLbl.setText("Booking Code:");

		titleLbl.setFont(new Font("Tahoma", 0, 24));
		titleLbl.setText("           Check in");

		flightCdLbl.setFont(new Font("Tahoma", 0, 18));
		flightCdLbl.setText("Flight Code:");

		bookingRefFld.setFont(new Font("Tahoma", 0, 18));

		nameFld.setFont(new Font("Tahoma", 0, 18));

		flightCdFld.setFont(new Font("Tahoma", 0, 18));

		feeFld.setFont(new Font("Tahoma", 0, 18));
		feeFld.setText(String.valueOf(bookingChrgObj.getTotalChg()));

		feeLbl.setFont(new Font("Tahoma", 0, 18));
		feeLbl.setText("Fee:");

		nameFld.setText(booking.getFirstName() + " " + booking.getLastName());

		flightCdFld.setText(booking.getFlightCode());

		bookingRefFld.setText(booking.getRefCode());

		submitBtn.setText("Confirm");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				submitBtnActionPerformed(evt);
			}
		});

		GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		contentPanelLayout.setHorizontalGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addGroup(contentPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(contentPanelLayout.createSequentialGroup().addGap(329, 329, 329)
								.addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPanelLayout.createSequentialGroup().addGap(98, 98, 98)
								.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(contentPanelLayout.createSequentialGroup().addComponent(bookingCdLbl)
												.addGap(35, 35, 35).addComponent(bookingRefFld).addGap(182, 182, 182)
												.addComponent(feeLbl).addGap(49, 49, 49).addComponent(feeFld))
										.addGroup(contentPanelLayout.createSequentialGroup().addComponent(nameLbl)
												.addGap(62, 62, 62)
												.addGroup(contentPanelLayout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(contentPanelLayout.createSequentialGroup()
																.addGap(222, 222, 222).addComponent(flightCdLbl))
														.addComponent(nameFld).addComponent(titleLbl))
												.addGap(29, 29, 29).addComponent(flightCdFld)))))
						.addContainerGap(120, Short.MAX_VALUE)));
		contentPanelLayout.setVerticalGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(titleLbl)
						.addGap(66, 66, 66)
						.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nameLbl).addComponent(nameFld).addComponent(flightCdLbl)
								.addComponent(flightCdFld))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
						.addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(feeLbl).addComponent(feeFld).addComponent(bookingCdLbl)
								.addComponent(bookingRefFld))
						.addGap(87, 87, 87)
						.addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(135, 135, 135)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(contentPanel,
				GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
				GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(contentPanel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();

	}

	private void submitBtnActionPerformed(ActionEvent evt) {

		WelcomeWindow obj = new WelcomeWindow();
		obj.setVisible(true);
		this.setVisible(false);

	}

}
