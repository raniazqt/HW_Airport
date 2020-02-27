package com.hw.airport.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.Font;

public class WelcomeWindow extends JFrame {

	private JButton psngrBtn = new JButton();
	
	private JLabel imgLbl;

	private JPanel contentPanel;

	public WelcomeWindow() {

		 contentPanel = new javax.swing.JPanel();
	        imgLbl = new javax.swing.JLabel();
	        psngrBtn = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        contentPanel.setBackground(new java.awt.Color(240, 255, 255));
	        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome to the Check In", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

	        imgLbl.setIcon(new javax.swing.ImageIcon("C:\\Users\\Bruce-Inspiron\\Documents\\MS\\SEM2\\AS\\F21AS_CW\\airport_pic.png")); // NOI18N

	        psngrBtn.setText("Check In");
	    	psngrBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent evt) {
	    			psngrBtnActionPerformed(evt);
	    		}
	    	});

	        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
	        contentPanel.setLayout(contentPanelLayout);
	        contentPanelLayout.setHorizontalGroup(
	            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(contentPanelLayout.createSequentialGroup()
	                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(contentPanelLayout.createSequentialGroup()
	                        .addGap(37, 37, 37)
	                        .addComponent(imgLbl))
	                    .addGroup(contentPanelLayout.createSequentialGroup()
	                        .addGap(292, 292, 292)
	                        .addComponent(psngrBtn)))
	                .addContainerGap(42, Short.MAX_VALUE))
	        );
	        contentPanelLayout.setVerticalGroup(
	            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(contentPanelLayout.createSequentialGroup()
	                .addGap(31, 31, 31)
	                .addComponent(imgLbl)
	                .addGap(18, 18, 18)
	                .addComponent(psngrBtn)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	}
	
	private void psngrBtnActionPerformed(ActionEvent evt) {

		SearchScreen obj = new SearchScreen();
		obj.setVisible(true);
		this.setVisible(false);
	}

}
