package com.hw.airport.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ScreenTemplate extends JFrame  implements ActionListener{

	public void createGUITemplate(){

		//set up window title
		setTitle("HW Airport");

		setSize(800, 600);
		//disable standard close button
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		ImageIcon header = new ImageIcon("./resources/images/header.png");
		JLabel imageLabel = new JLabel(header); 
		imageLabel.setLocation(10, 10);

		add(imageLabel);

		JPanel headerPanel = new JPanel(new FlowLayout(SwingConstants.LEADING));
		headerPanel.setBorder(new LineBorder(Color.RED, 4));
		//  panel1.setSize(400, 200);
		add(headerPanel);
		//label1.setBounds(20,20,100,20);

		// to provide a 20 x 20 offset, an empty border will do nicely.
		// imageLabel.setBorder(new EmptyBorder(10, 10, 0, 0));

		// Did you actually check the Java Docs for these methods? 
		// They do not do what you seem to think they do.
		//label1.SetAlignmentX(20);
		//label1.SetAlignmentY(20);
		headerPanel.add(imageLabel);

		JPanel footerPanel = new JPanel(new FlowLayout(SwingConstants.BOTTOM));
		footerPanel.setBorder(new LineBorder(Color.blue, 4));
		add(footerPanel);
		JLabel footerLabel = new JLabel("FOOTER");
		footerPanel.add(footerLabel);


		//	imageLabel.setVisible(true);

		//	setupSouthPanel();
		//setupNorthPanel();
		//setupCenterPanel();

		//pack and set visible
		//pack();
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
