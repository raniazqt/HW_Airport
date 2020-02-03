package com.hw.airport.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class ScreenTemplate extends JFrame  implements ActionListener{
	
@Override
  public Dimension getPreferredSize() {
    return new Dimension(800, 600);
  }


	public void createGUITemplate(JPanel contentPanel){

		//set up window title
		setTitle("HW Airport");

		setLayout(null);
       // setLayout(new GridLayout(3, 1));
       setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
       
		//disable standard close button
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		ImageIcon header = new ImageIcon("./resources/images/header.png");
		JLabel imageLabel = new JLabel(header); 
	//	imageLabel.setLocation(10, 10);

//		add(imageLabel);

		JPanel headerPanel = new JPanel(new FlowLayout(SwingConstants.LEADING));
		headerPanel.setBorder(new LineBorder(Color.RED, 4));
		headerPanel.setSize(200, 200);
		headerPanel.add(imageLabel);
		add(headerPanel,gbc);
		//label1.setBounds(20,20,100,20);

		// to provide a 20 x 20 offset, an empty border will do nicely.
		// imageLabel.setBorder(new EmptyBorder(10, 10, 0, 0));

		// Did you actually check the Java Docs for these methods? 
		// They do not do what you seem to think they do.
		//label1.SetAlignmentX(20);
		//label1.SetAlignmentY(20);
		headerPanel.add(imageLabel);
		  gbc.anchor = GridBagConstraints.CENTER;
		add(contentPanel, gbc);
		JPanel footerPanel = new JPanel(new FlowLayout(SwingConstants.BOTTOM));
		add(footerPanel);
		footerPanel.setBorder(new LineBorder(Color.blue, 4));
		
		  gbc.anchor = GridBagConstraints.SOUTHWEST;
		JLabel footerLabel = new JLabel("FOOTER");
		footerPanel.add(footerLabel,gbc);
		

		//	imageLabel.setVisible(true);

		//	setupSouthPanel();
		//setupNorthPanel();
		//setupCenterPanel();

		//pack and set visible
		pack();
		setVisible(true);

		/* gobf = new GridOfButtonsFrame(staffList);
        gobf.pack(); 
        gobf.setVisible(true);*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


}
