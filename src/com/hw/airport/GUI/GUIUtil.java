package com.hw.airport.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUIUtil{
	
	public static JPanel getHeader() {

		JPanel headerPnl = new JPanel();
		JLabel headerTxt = new JLabel();
		
		
		headerTxt.setFont(new Font("Helvetica", 1, 18));
		headerTxt.setText("HW Airport");
		headerTxt.setLocation(120,20);
		headerTxt.setBounds(0, 0, 20, 22);
		headerPnl.add(headerTxt);

		return headerPnl;

	}
	
	public static JPanel getFooterPanel() {
		JPanel footerPnl = new JPanel();
		JLabel footerTxt = new JLabel();

		footerTxt.setText("Have a safe trip");
		footerTxt.setLocation(120,20);
		footerTxt.setBounds(0, 0, 20, 22);
		footerPnl.add(footerTxt);

		return footerPnl;
	}
	
	public static JPanel getContentPanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setLayout(null);

		return contentPanel;
	}
	public static JFrame getAppFrame() {
		//Configure the main container - JFrame
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		return frame;
	}
}
