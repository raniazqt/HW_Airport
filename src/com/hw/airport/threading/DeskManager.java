package com.hw.airport.threading;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.model.Desk;
import com.hw.airport.model.PassengerQueue;
import com.hw.airport.observer.Observer;
import com.hw.airport.observer.SynchronizedObservable;
import com.hw.airport.service.DeskSvc;
import com.hw.airport.service.ReportSvc;
import com.hw.airport.service.ReportSvcImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeskManager extends SynchronizedObservable implements Observer {
	Logger LOG = LogManager.getLogger(DeskManager.class);
	
	ReportSvc reportSvc = new ReportSvcImpl();
	
	private volatile List<Desk> openedDeskList = new ArrayList<Desk>();
	private AirportSimulator sim = AirportSimulator.getInstnce();
	private DeskSvc deskSvc = AppContainer.getDeskSvc();
	private ThreadPoolExecutor executor;
	private List<DeskThread> deskThreadList = new ArrayList<DeskThread>();

	public DeskManager() {
		super();
		this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();//newFixedThreadPool((int) sim.getMaxOpndCheckinDesk());
	}

	private Desk openAndRunDesk() {

		int opndDskSz = this.openedDeskList.size()+1;
		String threadName = "DESK_" + opndDskSz + "_THREAD";

		LOG.debug("Opening Desk # {} and run it on thread {} ", opndDskSz, threadName);
		Desk desk = deskSvc.openDesk();
		LOG.debug("OPENED DESK ID: {} ", desk.getId());

		desk.setThreadName(threadName);
		DeskThread deskThread = new DeskThread(desk, threadName );
		deskThreadList.add(deskThread);
		executor.execute(deskThread);

		return desk;
	}

	@Override
	public void onNotify(Object args) {

		int passToDeskRatio = sim.getPassToDeskRatio();
		int maxOpnDsk =  sim.getMaxOpndCheckinDesk();
		int openedDeskCnt = openedDeskList.size();

		//the notification is coming from the simulator timer to notify that time has elapsed. End simulation!
		if (args instanceof String && "TIME ELAPSED".equalsIgnoreCase((String)args)) {
			
			reportSvc.getFlightReport();
			
			executor.shutdownNow();
			setChanged();
			notifyObservers("DESKS_CLOSED");
			
		}else {
			PassengerQueue queue = PassengerQueue.getInstance();
			if ((queue.getQueueSize() > 0 && openedDeskCnt == 0) ||
					(queue.getQueueSize() > passToDeskRatio * openedDeskCnt && openedDeskCnt < maxOpnDsk)){
				Desk desk = this.openAndRunDesk();
				openedDeskList.add(desk);
				LOG.debug("Desk ID {} opened ", desk.getId());
				setChanged();
				notifyObservers(desk);
			}
		}
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
		openedDeskList.remove(deskThread.getDesk());
		setChanged();
		notifyObservers(deskThread.getDesk());
	}

	/*this method is called when trying to get a passenger from the queue and it is empty.
	 * In this case we check if all passengers were processed, then the simulator has ended
	 * and we need to notify the UI to close the simulator screen
	 * If there are still more passengers available in the master list, then the queue is temporary empty
	 * because of the populating rate being slower than the desk processing passengers rate. Leave the simulator running
	 *  
	 */
	public void checkOtherDesksStatus() {
		// TODO Auto-generated method stub
		
	}
}
