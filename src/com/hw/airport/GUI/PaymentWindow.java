package com.hw.airport.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.hw.airport.model.Booking;
import com.hw.airport.model.BookingCharge;

public class PaymentWindow extends JFrame {
	private JPanel mainPnl;
	private JPanel scndPnl;
	private JPanel payPnl;

	private JLabel feesFld;
	private JLabel bookingRefFld ;
	private JLabel flightCdFld;
	private JLabel nameFld;

	private JButton payBtn;

	private JLabel jLabel1;
	private JLabel nameLbl;
	private JLabel flightCdLbl;
	private JLabel feeLbl;
	private JLabel bookingCdLbl;
	private JLabel titleLbl;

	//Credit card info
	private JTextField ccNmbrFld;
	private JTextField ccNameFld;
	private JTextField ccExpDtFld;

	private JLabel ccNmbrLbl;
	private JLabel ccNameLbl;
	private JLabel ccExpDtLbl;
	private Booking booking;
	private BookingCharge bookingChg;

	public PaymentWindow(Booking bookingObj, BookingCharge bookingChgObj) {
		this.booking = bookingObj;
		this.bookingChg = bookingChgObj;
		mainPnl = new JPanel();
		scndPnl = new JPanel();
		payPnl = new JPanel();

		mainPnl.setLayout(null);
		scndPnl.setLayout(null);
		payPnl.setLayout(null);

		nameLbl = new JLabel("Name");
		bookingCdLbl = new JLabel("Booking Reference");
		flightCdLbl = new JLabel("Flight Code");
		feeLbl = new JLabel("Fees");
		titleLbl = new JLabel();
		jLabel1 = new JLabel("label1");

		ccNmbrFld = new JTextField(200);
		ccNameFld = new JTextField(200);
		ccExpDtFld = new JTextField(200);

		ccNmbrLbl= new JLabel("Credit Card Number");
		ccNameLbl = new JLabel("Name on Card");
		ccExpDtLbl= new JLabel("Card Expiry Card");

		feesFld = new JLabel();
		bookingRefFld = new JLabel(bookingChg.getRefCode());
		flightCdFld= new JLabel(booking.getFlightCode());;
		nameFld = new JLabel(booking.getFullName());

		payBtn = new JButton("PAY");

		//frame configuration
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(null);

		// Main panel pale blue background
		payPnl.setBackground(new Color(240, 255, 255));
		payPnl.setBorder(BorderFactory.createTitledBorder(null, "Please complete the Payment information below", 0, 0, new Font("Helvetica", 1, 14))); 

		payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				payActionPerformed(evt);
			}
		});

		GroupLayout bagPanelLayout = new GroupLayout(payPnl);
		payPnl.setLayout(bagPanelLayout);

		bagPanelLayout.setHorizontalGroup( 
				bagPanelLayout.createSequentialGroup()
				.addContainerGap(20,50)
				.addGroup(bagPanelLayout.createSequentialGroup())
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING )
						.addGap(20)
						.addComponent(bookingCdLbl)
						.addComponent(nameLbl)
						.addComponent(flightCdLbl)
						.addComponent(feeLbl)
						.addComponent(ccNmbrLbl)
						.addComponent(ccNameLbl)
						.addComponent(ccExpDtLbl)
						)
				.addGap(10)
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING )
						.addComponent(bookingRefFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(flightCdFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(feesFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(ccNmbrFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(ccNameFld,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(ccExpDtFld,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGroup(bagPanelLayout.createSequentialGroup()
						.addContainerGap(50,50)
						.addComponent(payBtn ))
				);


		// Vertically, we want to align each label with its textfield
		// on the baseline of the components
		bagPanelLayout.setVerticalGroup( 
				bagPanelLayout.createSequentialGroup()
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( bookingCdLbl )
						.addComponent( bookingRefFld ))
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( nameLbl )
						.addComponent( nameFld ) )
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( flightCdLbl )
						.addComponent( flightCdFld ) )
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( feeLbl )
						.addComponent( feesFld ) )
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( ccNmbrLbl )
						.addComponent( ccNmbrFld))
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( ccNameLbl)
						.addComponent( ccNameFld))
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( ccExpDtLbl)
						.addComponent( ccExpDtFld))
				.addGroup(bagPanelLayout.createSequentialGroup()
						.addGroup(bagPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								//	.addGap(20,20)
								.addComponent(payBtn)
								))
				);

		scndPnl.add(payPnl);
		payPnl.setBounds(30, 80, 760, 360);

		titleLbl .setBackground(new Color(240, 255, 255));
		titleLbl.setFont(new java.awt.Font("Helvetica", 3, 16));
		titleLbl.setText("Fees Payment");
		scndPnl.add(titleLbl);
		titleLbl.setBounds(0, 10, 360, 60); 
		scndPnl.add(jLabel1);
		jLabel1.setBounds(0, 0, 600, 0);

		mainPnl.add(scndPnl);
		scndPnl.setBounds(0, 0, 810, 500);



		mainPnl.setBackground(new java.awt.Color(240, 255, 255));

		jLabel1 = new JLabel("Payment");

		GroupLayout jPanel2Layout = new GroupLayout(scndPnl);
		scndPnl.setLayout(jPanel2Layout);

		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(237, 237, 237)
						.addComponent(jLabel1)
						.addContainerGap(236, Short.MAX_VALUE))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		mainPnl.add(scndPnl);
		scndPnl.setBounds(0, 0, 810, 500);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(mainPnl, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(mainPnl, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
				);
		pack();
		this.setVisible(true);
	}

	private void payActionPerformed(ActionEvent evt) {
		CheckInConfirmationScreen obj = new CheckInConfirmationScreen(booking, bookingChg);
		obj.setVisible(true);
		this.setVisible(false);
	}

}
