package com.hw.airport.model;

import java.util.Observable;
import java.util.Observer;

public class DeskManager implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		System.out.println("Queue size has changed");
		
	}
	

}
