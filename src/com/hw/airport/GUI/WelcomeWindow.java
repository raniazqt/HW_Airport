package com.hw.airport.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

public class WelcomeWindow extends JFrame {

	private JButton psngrBtn = new JButton();
	
	private JButton rptBtn = new JButton();
	
	private JLabel imgLbl;

	private JPanel contentPanel;

	public WelcomeWindow() {

		 contentPanel = new JPanel();
	        imgLbl = new JLabel();
	        psngrBtn = new JButton();

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        contentPanel.setBackground(new java.awt.Color(240, 255, 255));
	        contentPanel.setBorder(BorderFactory.createTitledBorder(null, "Welcome to the Check In", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); 

	        imgLbl.setIcon(new ImageIcon("resources\\images\\airport_pic.png")); 

	        psngrBtn.setText("Check In");
	    	psngrBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent evt) {
	    			psngrBtnActionPerformed(evt);
	    		}
	    	});

	    	  rptBtn.setText("Close");

	          GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
	          contentPanel.setLayout(contentPanelLayout);
	          contentPanelLayout.setHorizontalGroup(
	              contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	              .addGroup(contentPanelLayout.createSequentialGroup()
	                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                  .addComponent(psngrBtn)
	                  .addGap(185, 185, 185)
	                  .addComponent(rptBtn)
	                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	              .addGroup(contentPanelLayout.createSequentialGroup()
	                  .addGap(18, 18, 18)
	                  .addComponent(imgLbl)
	                  .addContainerGap(20, Short.MAX_VALUE))
	          );
	          contentPanelLayout.setVerticalGroup(
	              contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	              .addGroup(contentPanelLayout.createSequentialGroup()
	                  .addGap(31, 31, 31)
	                  .addComponent(imgLbl)
	                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
	                  .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                      .addComponent(psngrBtn)
	                      .addComponent(rptBtn))
	                  .addContainerGap())
	          );

	          GroupLayout layout = new GroupLayout(getContentPane());
	          getContentPane().setLayout(layout);
	          layout.setHorizontalGroup(
	              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	              .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	          );
	          layout.setVerticalGroup(
	              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	              .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	          );

	          pack();
	}
	
	private void psngrBtnActionPerformed(ActionEvent evt) {

		SearchScreen obj = new SearchScreen();
		obj.setVisible(true);
		this.setVisible(false);
	}

}
