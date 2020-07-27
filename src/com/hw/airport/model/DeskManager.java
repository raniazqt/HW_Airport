package com.hw.airport.model;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.service.DeskSvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DeskManager extends Observable implements Observer{
	//	LOG = LoggerManager.
	private volatile List<Desk> openedDeskList = new ArrayList<Desk>();
	private AirportSimulator sim = AirportSimulator.getInstnce();
	private DeskSvc deskSvc = AppContainer.getDeskSvc();
	private ThreadPoolExecutor executor;
	private List<DeskThread> deskThreadList = new ArrayList<DeskThread>();



	public DeskManager() {
		super();
		this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();//newFixedThreadPool((int) sim.getMaxOpndCheckinDesk());
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		int passToDeskRatio = sim.getPassToDeskRatio();
		int maxOpnDsk = (int) sim.getMaxOpndCheckinDesk();
		int openedDeskCnt = openedDeskList.size();

		PassengerQueue queue = PassengerQueue.getInstance();
		if ((queue.getQueueSize() > 0 && openedDeskCnt == 0) ||
				(queue.getQueueSize() > passToDeskRatio * openedDeskCnt && openedDeskCnt < maxOpnDsk)){
			Desk desk = this.openAndRunDesk();
			openedDeskList.add(desk);
			System.out.println("Desk opened");
			System.out.println("DESK ID: " + desk.getId());
			setChanged();
			notifyObservers(desk);
			
		}
	}

	private Desk openAndRunDesk() {
		
		int opndDskSz = this.openedDeskList.size()+1;
		String threadName = "DESK_" + opndDskSz + "_THREAD";

		System.out.println("Opening Desk # " + opndDskSz + " and run it on thread " + threadName);
		Desk desk = deskSvc.openDesk();
		System.out.println("OPENED DESK ID: " + desk.getId());

		desk.setThreadName(threadName);
		DeskThread deskThread = new DeskThread(desk, threadName );
		deskThreadList.add(deskThread);
		executor.execute(deskThread);
		
		return desk;
	}

	public int getOpenedDeskCount() {
		return openedDeskList.size();
		
	}
	public List<Desk> getOpenedDeskList() {
		return openedDeskList;
	}

	public void setOpenedDeskList(List<Desk> openedDeskList) {
		this.openedDeskList = openedDeskList;
	}

	public void closeDesk(DeskThread deskThread) {
		deskSvc.closeDesk(deskThread.getDesk());
		deskThread.stop();
		System.out.println("Thread stopped");
		
	}	


}
