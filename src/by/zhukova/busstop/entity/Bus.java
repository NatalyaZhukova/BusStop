package by.zhukova.busstop.entity;

import java.util.List;
import org.apache.log4j.Logger;

public class Bus extends Thread {

	static Logger logger = Logger.getLogger(Bus.class);

	private int busNumber;
	private BusStop busStop;
	private List<BusStop> list;

	public Bus(int num) {
		this.setBusNumber(num);
	}

	public void run() {
		for (int i = 0; i < list.size(); i++) {

			busStop = list.get(i);
			busStop.busOnBusStop(this);

		}

	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public BusStop getBusStop() {
		return busStop;
	}

	public void setBusStop(BusStop busStop) {
		this.busStop = busStop;
	}

	public void setList(List<BusStop> list) {
		this.list = list;
	}

}
