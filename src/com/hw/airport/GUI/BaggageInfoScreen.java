
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


public class BaggageInfoScreen extends javax.swing.JFrame {

	private CheckInSvc checkInSvc = new CheckInSvcImpl();
	private Booking booking;
	BookingCharge bookingChg;

	private JLabel bookingCdLbl;
	private JLabel bookingRefFld;
	private JTextField depthFld;
	private JLabel depthLbl;
	private JLabel flightCdFld;
	private JLabel flightCdLbl;
	private JTextField heightFld;
	private JLabel heightLbl;
	private JPanel contentPanel;
	private JLabel nameFld;
	private JLabel nameLbl;
	private JButton submitBtn;
	private JLabel titleLbl;
	private JTextField weightFld;
	private JLabel weightLbl;
	private JTextField widthFld;
	private JLabel widthLbl;

	public BaggageInfoScreen(Booking bookingObj) {

		this.booking = bookingObj;

		contentPanel = new javax.swing.JPanel();
		submitBtn = new javax.swing.JButton();
		nameLbl = new javax.swing.JLabel();
		bookingCdLbl = new javax.swing.JLabel();
		titleLbl = new javax.swing.JLabel();
		flightCdLbl = new javax.swing.JLabel();
		bookingRefFld = new javax.swing.JLabel();
		nameFld = new javax.swing.JLabel();
		weightLbl = new javax.swing.JLabel();
		flightCdFld = new javax.swing.JLabel();
		weightFld = new javax.swing.JTextField();
		heightLbl = new javax.swing.JLabel();
		depthLbl = new javax.swing.JLabel();
		widthLbl = new javax.swing.JLabel();
		depthFld = new javax.swing.JTextField();
		heightFld = new javax.swing.JTextField();
		widthFld = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		contentPanel.setBackground(new java.awt.Color(240, 255, 255));
		contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Enter your baggage information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

		submitBtn.setText("Submit");

		nameLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		nameLbl.setText("Full Name:");

		bookingCdLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		bookingCdLbl.setText("Booking Code:");

		titleLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		titleLbl.setText("Baggage Details");

		flightCdLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		flightCdLbl.setText("Flight Code:");

		bookingRefFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		bookingRefFld.setText("Code");

		nameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

		flightCdFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

		nameFld.setText(booking.getFirstName() + " " + booking.getLastName());

		flightCdFld.setText(booking.getFlightCode());

		bookingRefFld.setText(booking.getRefCode());

		submitBtn.setText("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		heightLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		heightLbl.setText("Height:");

		depthLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		depthLbl.setText("Length:");

		widthLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		widthLbl.setText("Width:");

		weightLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		weightLbl.setText("Weight:");

		javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		contentPanelLayout.setHorizontalGroup(contentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addGroup(contentPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(contentPanelLayout.createSequentialGroup().addGap(98, 98, 98)
								.addGroup(contentPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(contentPanelLayout.createSequentialGroup()
												.addGroup(contentPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(bookingCdLbl).addComponent(nameLbl).addComponent(
																weightLbl))
												.addGap(35, 35, 35)
												.addGroup(contentPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(bookingRefFld).addComponent(nameFld)))
										.addComponent(depthLbl)
										.addGroup(contentPanelLayout.createSequentialGroup().addGap(90, 90, 90)
												.addGroup(contentPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(weightFld, javax.swing.GroupLayout.PREFERRED_SIZE,
																104, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(depthFld, javax.swing.GroupLayout.PREFERRED_SIZE,
																104, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(161, 161, 161)
												.addGroup(contentPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(contentPanelLayout.createSequentialGroup()
																.addComponent(flightCdLbl).addGap(33, 33, 33)
																.addComponent(flightCdFld))
														.addGroup(contentPanelLayout.createSequentialGroup()
																.addGroup(contentPanelLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(widthLbl).addComponent(heightLbl))
																.addGap(18, 18, 18)
																.addGroup(contentPanelLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(heightFld,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				104,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(widthFld,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				104,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))))))
						.addGroup(contentPanelLayout.createSequentialGroup().addGap(276, 276, 276)
								.addGroup(contentPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(titleLbl))))
						.addContainerGap(134, Short.MAX_VALUE)));
		contentPanelLayout.setVerticalGroup(contentPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(contentPanelLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(titleLbl)
						.addGap(33, 33, 33)
						.addGroup(contentPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(nameLbl)
								.addComponent(flightCdLbl).addComponent(nameFld).addComponent(flightCdFld))
						.addGap(43, 43, 43)
						.addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(bookingCdLbl).addComponent(bookingRefFld))
						.addGap(57, 57, 57)
						.addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(weightLbl)
								.addComponent(weightFld, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(heightLbl).addComponent(heightFld, javax.swing.GroupLayout.PREFERRED_SIZE,
										28, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(40, 40, 40)
						.addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(depthLbl).addComponent(widthLbl)
								.addComponent(depthFld, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(widthFld, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(155, 155, 155)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				contentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(contentPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void submitActionPerformed(ActionEvent evt) {// GEN-FIRST:event_SubmitActionPerformed
		if (depthFld.getText().isEmpty() || depthFld.getText().charAt(0) == ' ') {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Length (cm) ");
		} else if (heightFld.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Height (cm) ");
		} else if (widthFld.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Weight (Kg) ");
		} else {
			// Calculate xtra fees if any
			bookingChg = new BookingCharge(bookingRefFld.getText(), booking.getLastName(), 1,
					Double.valueOf(heightFld.getText()), Double.valueOf(widthFld.getText()),
					Double.valueOf(depthFld.getText()), Double.valueOf(weightFld.getText()));
			try {
				bookingChg = checkInSvc.calculateXtraChargeForPasngr(bookingChg);
				// TODO: Display the results
				//JOptionPane.showMessageDialog(null, "Volume Charge: " + bookingChg.getVolumeCharge() + " "
						//+ "Weight Charge: " + bookingChg.getWeightCharge());
				if (bookingChg.getVolumeCharge() <= 0 && bookingChg.getWeightCharge() <= 0) {
					boolean status = checkInSvc.confirmCheckin(booking);
					if (status) {
						this.setVisible(false);
						CheckInConfirmationScreen confirmationScrn = new CheckInConfirmationScreen(booking, bookingChg);
						confirmationScrn.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Failed to check in. Please try again");
					}
				} else {
					this.setVisible(false);

					PaymentWindow paymentScrn = new PaymentWindow(booking, bookingChg);
					paymentScrn.setVisible(true);
				}
			} catch (HWAirportException e) {
				e.printStackTrace();
			}
		}
	}

}
