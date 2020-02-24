package com.hw.airport.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
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

/**
 *
 * @author simon grange
 */
public class SearchScreen extends JFrame {
	private CheckInSvc checkinSvc = new CheckInSvcImpl();

	private JPanel mainPnl;
	private JPanel scndPnl;
	private JPanel searchPnl;

	private JTextField bookingRefFld;
	private JTextField lastNameFld;
	private JButton submitBtn;
	
	private JLabel lastNameLbl;
	private JLabel titleLbl;
	private JLabel jLabel1;
	// Search results section
	JPanel searchRsltPnl = new JPanel();
	JTextField flightNmbrFld = new JTextField();
	JTextField nameFld = new JTextField();
	JLabel nameLbl = new JLabel("Passenger Name");
	JLabel bookingLbl = new JLabel("Booking Reference");
	JTextField bookingFld = new JTextField();
	JLabel flightNmbrLbl = new JLabel("Flight Number");
	JButton checkinBtn = new JButton("Check in");
	JButton cancel = new JButton("Cancel");

	private JLabel bookingRefLabel;
	public SearchScreen() {

		searchPnl = new JPanel();
		mainPnl = new JPanel();
		scndPnl = new JPanel();
		

		mainPnl.setLayout(null);
		scndPnl.setLayout(null);
		searchPnl.setLayout(null);


		// Search fields last name & booking reference with a submit button		
		lastNameLbl = new JLabel("Last Name");
		lastNameFld = new JTextField(20);
		submitBtn = new JButton("Submit");
		bookingRefLabel = new JLabel("Booking Reference");
		bookingRefFld = new JTextField(10);

		titleLbl = new JLabel();
		jLabel1 = new JLabel("label1");

		//Main frame setup
		this.setFont(new Font("Helvetica", 1, 12));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(null);


		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				performSearchAction(evt);
			}
		});

		//Search result panel components 
		flightNmbrLbl.setText("Flight Number");
		flightNmbrFld.setEditable(false);

		/*
		 * searchRsltPnl.setBackground(new Color(240, 255, 255)); GroupLayout
		 * searchPanelLayout = new GroupLayout(searchRsltPnl);
		 * searchRsltPnl.setLayout(searchPanelLayout);
		 * searchPanelLayout.setHorizontalGroup(buildSearchResultHorizontalLayout(
		 * searchPanelLayout));
		 * searchPanelLayout.setVerticalGroup(buildSearchResultVerticalLayout(
		 * searchPanelLayout));
		 */
		/************ Search Form***************/
		GroupLayout searchLayout = new GroupLayout(searchPnl);
		searchPnl.setLayout(searchLayout);

		searchLayout.setHorizontalGroup( 
				searchLayout.createSequentialGroup()
				.addContainerGap(20,50)
				.addGroup(searchLayout.createSequentialGroup())
				.addGroup( searchLayout.createParallelGroup( GroupLayout.Alignment.LEADING )
						.addGap(20)
						.addComponent(bookingRefLabel)
						.addComponent(lastNameLbl))
				.addGap(10)
				.addGroup( searchLayout.createParallelGroup( GroupLayout.Alignment.LEADING )
						.addComponent(bookingRefFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastNameFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGroup(searchLayout.createSequentialGroup()
						.addContainerGap(50,50)
						.addComponent(submitBtn ))
				);

		// Vertically, we want to align each label with its textfield
		// on the baseline of the components
		searchLayout.setVerticalGroup( 
				searchLayout.createSequentialGroup()
				.addGroup( searchLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( bookingRefLabel )
						.addComponent( bookingRefFld ))
				.addGroup( searchLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( lastNameLbl )
						.addComponent( lastNameFld) )
				.addGroup(searchLayout.createSequentialGroup()
						.addGroup(searchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								//	.addGap(20,20)
								.addComponent(submitBtn)
								))
				);

		scndPnl.add(searchPnl);
		searchPnl.setBackground(new Color(240, 255, 255));
		searchPnl.setBounds(30, 80, 760, 360);

		titleLbl .setBackground(new Color(240, 255, 255));
		titleLbl.setFont(new Font("Helvetica", 3, 16));
		titleLbl.setText("Find Booking");
		scndPnl.add(titleLbl);
		titleLbl.setBounds(0, 10, 360, 60); 
		scndPnl.add(jLabel1);
		jLabel1.setBounds(0, 0, 600, 0);

		
		mainPnl.add(scndPnl);
		scndPnl.setBounds(0, 0, 810, 500);
		mainPnl.setBackground(new java.awt.Color(240, 255, 255));

		jLabel1 = new JLabel("Confirmation");

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

		/*
		 * 
		 * JPanel formPanel = new JPanel(); formPanel.setBackground(new Color(240, 255,
		 * 255)); formPanel .setBorder(BorderFactory.createTitledBorder(null,
		 * "Check In Here", 0, 0, new Font("Helvetica", 1, 14))); // NOI18N
		 * 
		 * GroupLayout formPanelLayout = new GroupLayout(formPanel);
		 * formPanel.setLayout(formPanelLayout);
		 * formPanelLayout.setHorizontalGroup(buildFormHorizontalLayout(formPanelLayout)
		 * );
		 * formPanelLayout.setVerticalGroup(buildFormVerticalLayout(formPanelLayout));
		 * 
		 * GroupLayout layout = new GroupLayout(getContentPane());
		 * getContentPane().setLayout(layout);
		 * layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.
		 * LEADING) .addGap(0, 830, Short.MAX_VALUE)
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
		 * GroupLayout.Alignment.TRAILING,
		 * layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE,
		 * Short.MAX_VALUE) .addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 810,
		 * GroupLayout.PREFERRED_SIZE) .addContainerGap(GroupLayout.DEFAULT_SIZE,
		 * Short.MAX_VALUE)))
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
		 * GroupLayout.Alignment.TRAILING,
		 * layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE,
		 * Short.MAX_VALUE) .addComponent(searchRsltPnl, GroupLayout.PREFERRED_SIZE,
		 * 210, GroupLayout.PREFERRED_SIZE) .addContainerGap(GroupLayout.DEFAULT_SIZE,
		 * Short.MAX_VALUE))));
		 * 
		 * layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.
		 * LEADING) .addGap(0, 440, Short.MAX_VALUE)
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
		 * GroupLayout.Alignment.TRAILING,
		 * layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE,
		 * Short.MAX_VALUE) .addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 380,
		 * GroupLayout.PREFERRED_SIZE) .addContainerGap(GroupLayout.DEFAULT_SIZE,
		 * Short.MAX_VALUE)))
		 * .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
		 * GroupLayout.Alignment.TRAILING,
		 * layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE,
		 * Short.MAX_VALUE) .addComponent(searchRsltPnl, GroupLayout.PREFERRED_SIZE,
		 * 380, GroupLayout.PREFERRED_SIZE) .addContainerGap(GroupLayout.DEFAULT_SIZE,
		 * Short.MAX_VALUE))) );
		 * 
		 * 
		 * pack(); setVisible(true);
		 */	}

	private ParallelGroup buildFormVerticalLayout(GroupLayout formPanelLayout) {
		return formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(formPanelLayout.createSequentialGroup()
						.addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false))
						.addGap(68, 68, 68)
						.addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lastNameFld, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastNameLbl).addComponent(bookingRefLabel)
								.addComponent(bookingRefFld, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38)
						.addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE));
	}


	private void performSearchAction(ActionEvent evt) {
		StringBuffer msg = new StringBuffer();
		boolean error = false;
		if (lastNameFld.getText().isEmpty()) {
			error = true;
			msg.append("Last name can not be empty");
			msg.append("\n");
		}
		if (bookingRefFld.getText().isEmpty()) {
			error = true;
			msg.append("Booking reference can not be empty");
		} 
		if (error) {
			JOptionPane.showMessageDialog(this,msg);
		}else {
			try {
				Booking booking = checkinSvc.retrieveBookingByCodeAndLastName(lastNameFld.getText(), bookingRefFld.getText());
				bookingFld.setText(booking.getRefCode());
				nameFld.setText(booking.getFirstName().concat(" ").concat(booking.getLastName()));
				flightNmbrFld.setText(booking.getFlightCode());
				BaggageInfoScreen obj = new BaggageInfoScreen(booking);
				obj.setVisible(true);
				this.setVisible(false);

			} catch (HWAirportException e) {
				JOptionPane.showMessageDialog(this,e.getMessage());
			}

		}
	}

}
