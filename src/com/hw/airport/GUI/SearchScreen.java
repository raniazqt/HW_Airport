package com.hw.airport.GUI;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

	private javax.swing.JPanel outPnl;
	private javax.swing.JPanel inPnl;

	private javax.swing.JLabel titleLbl;
	private javax.swing.JLabel lastNameLbl;
	private javax.swing.JLabel bookingLbl;

	private javax.swing.JTextField lastNameFld;
	private javax.swing.JTextField bookingRefFld;

	private javax.swing.JButton submitBtn;

	public SearchScreen() {
		outPnl = new javax.swing.JPanel();
		inPnl = new javax.swing.JPanel();
		titleLbl = new javax.swing.JLabel();
		lastNameLbl = new javax.swing.JLabel();
		bookingLbl = new javax.swing.JLabel();
		lastNameFld = new javax.swing.JTextField();
		bookingRefFld = new javax.swing.JTextField();
		submitBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		outPnl.setLayout(null);

		inPnl.setBackground(new java.awt.Color(240, 255, 255));
		inPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Check In Here", 0, 0,
				new java.awt.Font("Helvetica", 1, 14))); // NOI18N

		lastNameLbl.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
		lastNameLbl.setText("Last Name");

		bookingLbl.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
		bookingLbl.setText("Booking Number");

		lastNameFld.setEditable(true);
		lastNameFld.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N

		bookingRefFld.setEditable(true);
		bookingRefFld.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N

		/*
		 * SHould point to the DisplayBaggageInfoScreen ? make actionPerformed PRIVATE
		 * as this class only
		 */
		submitBtn.setText("Next");
		submitBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				performSearchAction(evt);
			}
		});

		javax.swing.GroupLayout inPnlLayout = new javax.swing.GroupLayout(inPnl);
		inPnl.setLayout(inPnlLayout);
		inPnlLayout.setHorizontalGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(inPnlLayout.createSequentialGroup().addGroup(inPnlLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(inPnlLayout.createSequentialGroup().addGap(115, 115, 115))
						.addGroup(inPnlLayout.createSequentialGroup().addContainerGap().addComponent(lastNameLbl)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60,
										Short.MAX_VALUE)
								.addComponent(lastNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(inPnlLayout.createSequentialGroup().addGap(62, 62, 62)

										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59,
												Short.MAX_VALUE)

										.addGap(20, 20, 20))
								.addGroup(inPnlLayout.createSequentialGroup().addGap(85, 85, 85)
										.addComponent(bookingLbl)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33,
												Short.MAX_VALUE)
										.addComponent(bookingRefFld, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inPnlLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(submitBtn,
								javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(329, 329, 329)));
		inPnlLayout.setVerticalGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(inPnlLayout.createSequentialGroup()
						.addGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)

						).addGap(68, 68, 68)
						.addGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lastNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lastNameLbl).addComponent(bookingLbl).addComponent(bookingRefFld,
										javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38).addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE)));

		outPnl.add(inPnl);
		inPnl.setBounds(30, 80, 780, 280);

		titleLbl.setBackground(new java.awt.Color(240, 255, 255));
		titleLbl.setFont(new java.awt.Font("Helvetica", 3, 36));
		// titleLbl.setFont(new java.awt.Color(0, 139, 139); // NOI18N
		titleLbl.setText("Welcome to Scotia Air");
		outPnl.add(titleLbl);
		titleLbl.setBounds(200, 10, 400, 60);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 830, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(outPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 810,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 440, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(outPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 418,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

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

				DisplayBaggageInfoScreen obj2 = new DisplayBaggageInfoScreen();
				obj2.setVisible(true);

				this.setVisible(false);

			} catch (HWAirportException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}

		}
	}

}
