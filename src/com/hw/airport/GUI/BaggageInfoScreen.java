package com.hw.airport.GUI;												

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
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
import com.hw.airport.model.BookingCharge;
import com.hw.airport.service.CheckInSvc;
import com.hw.airport.service.CheckInSvcImpl;
/**
 *
 * @author Simon Grange, Safa Al Ameri, 
 */
/**
 * DisplayBaggageInfoScreen collects the necessary Baggage Check In Information for 
 * calculation of excess weight or size and so incurring excess charges.
 */
public class BaggageInfoScreen extends JFrame {
	private CheckInSvc checkInSvc = new CheckInSvcImpl();
	private Booking booking;
	private JTextField widthFld;
	private JTextField heightFld;
	private JTextField feesFld;
	private JTextField depthFld;
	private JTextField weightFld;
	private JTextField lastNameFld;
	private JTextField bookingRefFld ;
	private JTextField flightCdFld;
	private JTextField nameFld;
	

	private JButton cancelBtn;
	private JButton submitBtn;

	JLabel nameLbl;
	JLabel flightCdLbl;
	private JLabel jLabel1;
	private JLabel titleLbl;
	private JLabel heightLbl;
	private JLabel weightLbl;
	private JLabel depthLbl;
	private JLabel feeLbl;
	private JLabel widthLbl;
	private JLabel bookingCdLbl;

	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel baggagePanel;

	BookingCharge bookingChg;
	/**
	 * Creates new form Registration for baggage check in
	 * @param booking 
	 */
	
	public BaggageInfoScreen(Booking bookingObj) {
		this.booking = bookingObj;
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		baggagePanel = new JPanel();

		nameLbl = new JLabel("Name");
		flightCdLbl = new JLabel("Flight Code");
		depthLbl = new JLabel();
		weightLbl = new JLabel();
		widthLbl = new JLabel();
		feeLbl = new JLabel();
		heightLbl = new JLabel();
		bookingCdLbl = new JLabel();
		jLabel1 = new JLabel();
		titleLbl = new JLabel();

		submitBtn = new JButton();
		cancelBtn = new JButton();

		depthFld = new JTextField();
		bookingRefFld = new JTextField(booking.getRefCode());
		heightFld = new JTextField();
		widthFld = new JTextField();
		feesFld = new JTextField();;
		weightFld = new JTextField();
		lastNameFld = new JTextField(booking.getLastName());
		nameFld = new JTextField(booking.getFirstName() + " " + booking.getLastName());
		flightCdFld = new JTextField(booking.getFlightCode());
		
		flightCdFld.setEditable(false);
		nameFld.setEditable(false);
		

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setLayout(null);

		jPanel2.setLayout(null);

		// Main panel pale blue background
		baggagePanel.setBackground(new java.awt.Color(240, 255, 255));
		baggagePanel.setBorder(BorderFactory.createTitledBorder(null, "Please complete the information about your baggage", 0, 0, new java.awt.Font("Helvetica", 1, 14))); 

		depthLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); 
		depthLbl.setText("Depth");

		weightLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); 
		weightLbl.setText("Weight");

		heightLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); 
		heightLbl.setText("Height");

		feeLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); 
		feeLbl.setText("Fees To Pay (GBP) ");

		widthLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); 
		widthLbl.setText("Width");

		depthFld.setFont(new java.awt.Font("Helvetica", 0, 14)); 


		submitBtn.setText("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		cancelBtn.setText("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CancelActionPerformed(evt);
			}
		});


		bookingCdLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); 
		bookingCdLbl.setText("Passenger Booking Number");

		bookingRefFld.setEditable(false);
		bookingRefFld.setFont(new java.awt.Font("Helvetica", 0, 14)); 


		heightFld.setFont(new java.awt.Font("Helvetica", 0, 14)); 
		widthFld.setFont(new java.awt.Font("Helvetica", 0, 14)); 

		GroupLayout bagPanelLayout = new GroupLayout(baggagePanel);
		baggagePanel.setLayout(bagPanelLayout);


		bagPanelLayout.setHorizontalGroup( 
				bagPanelLayout.createSequentialGroup()
				.addContainerGap(20,50)
				.addGroup(bagPanelLayout.createSequentialGroup())
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING )
						.addGap(20)
						.addComponent(bookingCdLbl)
						.addComponent(nameLbl)
						.addComponent(flightCdLbl)
						.addComponent(weightLbl )
						.addComponent(heightLbl )
						.addComponent( widthLbl )
						.addComponent( depthLbl ) )
				.addGap(10)
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING )
						.addComponent(bookingRefFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(flightCdFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(weightFld, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE) 
						.addComponent(heightFld , GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent( widthFld , GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent( depthFld , GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGroup(bagPanelLayout.createSequentialGroup()
						.addContainerGap(50,50)
						.addComponent(cancelBtn )
						.addGap(100)
						.addComponent(submitBtn))
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
						.addComponent( weightLbl )
						.addComponent( weightFld ) )
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( heightLbl )
						.addComponent( heightFld ) )
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( widthLbl )
						.addComponent( widthFld ) )
				.addGroup( bagPanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE )
						.addComponent( depthLbl )
						.addComponent( depthFld ) )
				.addGroup(bagPanelLayout.createSequentialGroup()
						.addGroup(bagPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						//	.addGap(20,20)
								.addComponent(cancelBtn )
								.addComponent(submitBtn)))
				);






		/*
		 * bagPanelLayout.setHorizontalGroup(
		 * bagPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(bagPanelLayout.createSequentialGroup() .addGap(191, 191, 191)
		 * .addComponent(bookingCdLbl) .addGap(62, 62, 62) .addComponent(bookingRefFld,
		 * GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE) .addGap(0, 0,
		 * Short.MAX_VALUE)) .addGroup(bagPanelLayout.createSequentialGroup()
		 * .addContainerGap()
		 * .addGroup(bagPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(bagPanelLayout.createSequentialGroup()
		 * .addGroup(bagPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING,
		 * false) .addGroup(bagPanelLayout.createSequentialGroup() .addComponent(feeLbl)
		 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
		 * GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) .addComponent(feesFld,
		 * GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
		 * .addGroup(bagPanelLayout.createSequentialGroup() .addComponent(cancelBtn,
		 * GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE) .addGap(173, 173,
		 * 173)) .addGroup(bagPanelLayout.createSequentialGroup()
		 * .addComponent(widthLbl, GroupLayout.PREFERRED_SIZE, 49,
		 * GroupLayout.PREFERRED_SIZE) .addGap(59, 59, 59) .addComponent(widthFld,
		 * GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)) .addGap(106,
		 * 106, 106) // .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43,
		 * Short.MAX_VALUE)
		 * .addGroup(bagPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addComponent(heightLbl) .addComponent(heightFld,
		 * GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 200,
		 * GroupLayout.PREFERRED_SIZE) .addComponent(depthLbl) .addComponent(depthFld,
		 * GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 200,
		 * GroupLayout.PREFERRED_SIZE))) .addGroup(GroupLayout.Alignment.TRAILING,
		 * bagPanelLayout.createSequentialGroup()
		 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
		 * GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) .addComponent(submitBtn,
		 * GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE) .addGap(52, 52,
		 * 52))) .addGroup(bagPanelLayout.createSequentialGroup()
		 * .addComponent(depthLbl) .addGap(63, 63, 63) .addComponent(depthFld,
		 * GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE) .addGap(106,
		 * 106, 106)
		 * .addGroup(bagPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(bagPanelLayout.createSequentialGroup() .addComponent(depthLbl)
		 * .addGap(0, 0, Short.MAX_VALUE))
		 * .addGroup(bagPanelLayout.createSequentialGroup() .addComponent(weightLbl)
		 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
		 * GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) ))))) .addContainerGap()) );
		 * bagPanelLayout.setVerticalGroup(
		 * bagPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addComponent(bookingCdLbl) .addComponent(bookingRefFld)
		 * .addComponent(depthLbl) .addComponent(depthFld) .addComponent(heightFld)
		 * .addComponent(cancelBtn) .addComponent(submitBtn) .addComponent(feeLbl)
		 * .addComponent(feesFld) .addComponent(heightLbl) .addComponent(heightFld)
		 * .addComponent(widthLbl) .addComponent(widthFld) .addComponent(weightLbl)
		 * .addComponent(weightFld) );
		 * 
		 * 
		 */				/*
		 * jPanel3Layout.setVerticalGroup(
		 * jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(jPanel3Layout.createSequentialGroup()
		 * .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(jPanel3Layout.createSequentialGroup() .addComponent(bookingCdLbl)
		 * .addGap(23, 23, 23)) .addComponent(bookingRefFld,
		 * GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 32,
		 * GroupLayout.PREFERRED_SIZE))
		 * .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		 * .addGroup(jPanel3Layout.createSequentialGroup() .addGap(0, 0,
		 * Short.MAX_VALUE)
		 * .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		 * .addComponent(feeLbl) .addComponent(feesFld, GroupLayout.PREFERRED_SIZE, 30,
		 * GroupLayout.PREFERRED_SIZE)) .addGap(81, 81, 81))
		 * .addGroup(jPanel3Layout.createSequentialGroup()
		 * .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		 * .addComponent(depthLbl) .addComponent(depthFld, GroupLayout.PREFERRED_SIZE,
		 * 32, GroupLayout.PREFERRED_SIZE) .addComponent(weightLbl) )
		 * .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		 * .addGroup(jPanel3Layout.createSequentialGroup() .addGap(31, 31, 31)
		 * .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		 * .addComponent(widthLbl) .addComponent(widthFld, GroupLayout.PREFERRED_SIZE,
		 * 32, GroupLayout.PREFERRED_SIZE)))
		 * .addGroup(jPanel3Layout.createSequentialGroup() .addGap(20, 20, 20)
		 * .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		 * .addComponent(heightLbl) .addComponent(heightFld, GroupLayout.PREFERRED_SIZE,
		 * 32, GroupLayout.PREFERRED_SIZE))))
		 * .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 144,
		 * Short.MAX_VALUE)))
		 * .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		 * .addComponent(submitBtn, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
		 * .addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
		 * .addContainerGap()) );
		 */ 
		jPanel2.add(baggagePanel);
		baggagePanel.setBounds(30, 80, 760, 360);

		titleLbl.setBackground(new java.awt.Color(240, 255, 255));
		titleLbl.setFont(new java.awt.Font("Helvetica", 3, 16)); 
		titleLbl.setText("Baggage Check In Information");
		jPanel2.add(titleLbl);
		titleLbl.setBounds(0, 10, 360, 60);
		jPanel2.add(jLabel1);
		jLabel1.setBounds(0, 0, 600, 0);

		jPanel1.add(jPanel2);
		jPanel2.setBounds(0, 0, 810, 500);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
				);

		pack();
		this.setVisible(true);
	}

	private void submitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
		if(depthFld.getText().isEmpty() || depthFld.getText().charAt(0) == ' '){
			JOptionPane.showMessageDialog(null,"Please Enter Baggage Length (cm) ");
		}else if(heightFld.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please Enter Baggage Height (cm) ");
		}else if(widthFld.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Please Enter Baggage Weight (Kg) ");                
		}else{
			//Calculate xtra fees if any
			bookingChg = 
					new BookingCharge(bookingRefFld.getText(), lastNameFld.getText(), 1, Double.valueOf(heightFld.getText()), Double.valueOf(widthFld.getText()), Double.valueOf(depthFld.getText()), Double.valueOf(weightFld.getText()));
			try {
				bookingChg = checkInSvc.calculateXtraChargeForPasngr(bookingChg);
				//TODO: Display the results
				JOptionPane.showMessageDialog(null,
						"Volume Charge" + bookingChg.getVolumeCharge()+" "+
						"Weight Charge" + bookingChg.getWeightCharge());
				if (bookingChg.getVolumeCharge() <= 0 && bookingChg.getWeightCharge() <=0) {
					boolean status = checkInSvc.confirmCheckin(booking);
					if (status) {
						CheckInConfirmationScreen confirmationScrn = new CheckInConfirmationScreen(booking, bookingChg);
					}else {
						JOptionPane.showMessageDialog(null,"Failed to check in. Please try again");
					}
				}else {
					PaymentWindow paymentScrn = new PaymentWindow(booking,bookingChg);
					this.setVisible(false);
				}
			} catch (HWAirportException e) {
				e.printStackTrace();
			}
		}				
	}

	private void CancelActionPerformed(ActionEvent evt) {
		WelcomeWindow obj = new WelcomeWindow();
		obj.setVisible(true);
		this.setVisible(false);
	}

	public static void main(String[] args) {
		BaggageInfoScreen bagScreen = new BaggageInfoScreen(new Booking("","","ABC","",false));

	}


}
