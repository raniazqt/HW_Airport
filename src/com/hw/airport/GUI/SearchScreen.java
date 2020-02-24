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
	private JTextField bookingRefFld;
	private JTextField lastNameFld;
	private JButton submitBtn;
	JLabel lastNameLbl;

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

	/**
	 * Creates new form ShortDetails
	 */
	public SearchScreen() {

		/*
		 * JPanel footer = GUIUtil.getFooterPanel(); JPanel header =
		 * GUIUtil.getHeader();
		 */
		lastNameLbl = new JLabel();
		lastNameFld = new JTextField(20);
		submitBtn = new JButton();
		bookingRefLabel = new JLabel();
		bookingRefFld = new JTextField(10);

		// Search fields last name & booking reference with a submit button
		lastNameLbl.setFont(new Font("Helvetica", 1, 12));
		lastNameLbl.setText("Last Name");

		lastNameFld.setEditable(true);
		lastNameFld.setFont(new Font("Helvetica", 0, 12));


		bookingRefLabel.setFont(new Font("Helvetica", 1, 12));
		bookingRefLabel.setText("Booking Reference");

		bookingRefFld.setFont(new Font("Helvetica", 0, 12));
		bookingRefFld.setEditable(true);
		bookingRefFld.setFont(new Font("Helvetica", 0, 14));

		submitBtn.setText("Next");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				performSearchAction(evt);
			}
		});

		//Search result panel components 
		flightNmbrLbl.setFont(new Font("Helvetica", 1, 12));
		flightNmbrLbl.setText("Flight Number");
		flightNmbrFld.setFont(new Font("Helvetica", 1, 12));
		flightNmbrFld.setEditable(false);


		searchRsltPnl.setBackground(new Color(240, 255, 255));
		GroupLayout searchPanelLayout = new GroupLayout(searchRsltPnl);
		searchRsltPnl.setLayout(searchPanelLayout);
		searchPanelLayout.setHorizontalGroup(buildSearchResultHorizontalLayout(searchPanelLayout));
		searchPanelLayout.setVerticalGroup(buildSearchResultVerticalLayout(searchPanelLayout));


		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(240, 255, 255));
		formPanel
		.setBorder(BorderFactory.createTitledBorder(null, "Check In Here", 0, 0, new Font("Helvetica", 1, 14))); // NOI18N

		GroupLayout formPanelLayout = new GroupLayout(formPanel);
		formPanel.setLayout(formPanelLayout);
		formPanelLayout.setHorizontalGroup(buildFormHorizontalLayout(formPanelLayout));
		formPanelLayout.setVerticalGroup(buildFormVerticalLayout(formPanelLayout));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 830, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 810, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(searchRsltPnl, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(searchRsltPnl, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				);


		pack();
		setVisible(true);
	}

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

	private ParallelGroup buildFormHorizontalLayout(GroupLayout formPanelLayout) {
		return formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(formPanelLayout.createSequentialGroup().addGroup(formPanelLayout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(formPanelLayout.createSequentialGroup().addGap(115, 115, 115))
						.addGroup(formPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(lastNameLbl)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
								.addComponent(lastNameFld, GroupLayout.PREFERRED_SIZE, 200,GroupLayout.PREFERRED_SIZE)))
						.addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(formPanelLayout.createSequentialGroup().addGap(62, 62, 62)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
										.addGap(20, 20, 20))
								.addGroup(formPanelLayout.createSequentialGroup().addGap(85, 85, 85)
										.addComponent(bookingRefLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
										.addComponent(bookingRefFld, GroupLayout.PREFERRED_SIZE, 200,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())))
				.addGroup(GroupLayout.Alignment.TRAILING,
						formPanelLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(submitBtn, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addGap(329, 329, 329));
	}

	/*************************************************************/
	private ParallelGroup buildSearchResultHorizontalLayout(GroupLayout panelLayout) {
		return panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelLayout.createSequentialGroup().addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(panelLayout.createSequentialGroup().addGap(115, 115, 115))
						.addGroup(panelLayout.createSequentialGroup().addContainerGap()
								.addComponent(nameLbl)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
								.addComponent(nameFld, GroupLayout.PREFERRED_SIZE, 800,GroupLayout.PREFERRED_SIZE)))
						.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panelLayout.createSequentialGroup().addGap(62, 62, 62)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
										.addGap(20, 20, 20))
								.addGroup(panelLayout.createSequentialGroup().addGap(85, 85, 85)
										.addComponent(bookingLbl)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
										.addComponent(bookingFld, GroupLayout.PREFERRED_SIZE, 200,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())));
						
	}

	private ParallelGroup buildSearchResultVerticalLayout(GroupLayout formPanelLayout) {
		return formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(formPanelLayout.createSequentialGroup()
						.addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false))
						.addGap(68, 68, 68)
						.addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameFld)
								.addComponent(bookingLbl)
								.addComponent(bookingFld, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38)
						
						);
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
