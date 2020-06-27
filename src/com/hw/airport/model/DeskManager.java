package com.hw.airport.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.service.DeskSvc;

public class DeskManager implements Observer{
	private List<Desk> openedDeskList = new ArrayList<Desk>();
	private AirportSimulator sim = AirportSimulator.getInstnce();
	private DeskSvc deskSvc = AppContainer.getDeskSvc();
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		int passToDeskRatio = sim.getPassToDeskRatio();
		int maxOpnDsk = sim.getMaxOpndCheckinDesk();
		int openedDeskCnt = openedDeskList.size();
		
		PassengerQueue queue = PassengerQueue.getInstance();
		if (queue.getQueueSize() > 0 && openedDeskCnt == 0) {
			Desk desk = this.createAndOpenDesk();
			openedDeskList.add(desk);
			System.out.println("Desk opened");
		}else {
			if (queue.getQueueSize() > passToDeskRatio * openedDeskCnt && openedDeskCnt < maxOpnDsk) {
				Desk desk = deskSvc.openDesk();
				openedDeskList.add(desk);
				System.out.println("Desk opened");
			}
		}
		
	}

	private Desk createAndOpenDesk() {
		int opndDskSz = this.openedDeskList.size();
		Thread thread = new Thread(()->{
			Desk desk = deskSvc.openDesk();
			deskSvc.processPassengersQueue(desk);
		
		}, "DESK_" + opndDskSz + 1 + "_THREAD"); 
		
		
		
		return null;
	}
	

}
