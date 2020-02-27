
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
	private JPanel jPanel1;
	private JLabel nameFld;
	private JLabel nameLbl;
	private JButton submitBtn;
	private JLabel titleLabel;
	private JTextField cardFld;
	private JLabel cardLbl;
	

	public PaymentWindow(Booking bookingObj, BookingCharge bookingChgObj) {

		this.booking = bookingObj;
		this.bookingChg = bookingChgObj;
		
		jPanel1 = new JPanel();
		nameLbl = new JLabel();
		bookingCdLbl = new JLabel();
		nameFld = new JLabel();
		flightCdLbl = new JLabel();
		flightCdFld = new JLabel();
		bookingRefFld = new JLabel();
		cardLbl = new JLabel();
		expiryLbl = new JLabel();
		cardFld = new JTextField();
		expiryFld = new JTextField();
		cvvLbl = new JLabel();
	
		cvvFld = new JTextField();
		
		submitBtn = new JButton();
		titleLabel = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(240, 255, 255));
		jPanel1.setBorder(
				BorderFactory.createTitledBorder("Please complete the Payment information below"));

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

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel1Layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(
												GroupLayout.Alignment.LEADING, jPanel1Layout
														.createSequentialGroup().addGroup(jPanel1Layout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING)
																.addComponent(expiryLbl).addComponent(cardLbl))
														.addGap(11, 11, 11)
														.addGroup(jPanel1Layout.createParallelGroup(
																GroupLayout.Alignment.LEADING).addComponent(
																		cardFld,
																		GroupLayout.PREFERRED_SIZE, 69,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(expiryFld,
																		GroupLayout.PREFERRED_SIZE, 69,
																		GroupLayout.PREFERRED_SIZE)))
										.addGroup(GroupLayout.Alignment.LEADING,
												jPanel1Layout.createSequentialGroup().addComponent(nameLbl)
														.addGap(16, 16, 16).addComponent(nameFld)))
										.addGap(64, 64, 64)
										.addGroup(jPanel1Layout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(
														jPanel1Layout.createSequentialGroup().addComponent(flightCdLbl)
																.addGap(30, 30, 30).addComponent(flightCdFld))
												.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(cvvLbl))
														.addGap(18, 18, 18)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING)
																.addComponent(cvvFld,
																		GroupLayout.PREFERRED_SIZE, 69,
																		GroupLayout.PREFERRED_SIZE)
																))))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(bookingCdLbl)
										.addGap(31, 31, 31).addComponent(bookingRefFld))))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(157, 157, 157).addComponent(submitBtn)))
						.addGap(0, 29, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21)
						.addGroup(jPanel1Layout
								.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nameLbl)
								.addComponent(nameFld).addComponent(flightCdLbl).addComponent(flightCdFld))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(bookingCdLbl).addComponent(bookingRefFld))
						.addGap(26, 26, 26)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(cardLbl)
								.addComponent(cardFld, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cvvLbl).addComponent(cvvFld, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(expiryFld, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(expiryLbl))
						.addGap(35, 35, 35).addComponent(submitBtn)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); 
		titleLabel.setText("Fees Payment");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								layout.createSequentialGroup().addComponent(titleLabel).addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(9, 9, 9).addComponent(titleLabel)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanel1,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGap(18, 18, 18)));

		pack();
	}

	private void submitActionPerformed(ActionEvent evt) {
		CheckInConfirmationScreen obj = new CheckInConfirmationScreen(booking, bookingChg);
		obj.setVisible(true);
		this.setVisible(false);
			}
		
	}

