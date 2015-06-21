package by.zhukova.busstop.run;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.zhukova.busstop.entity.Bus;
import by.zhukova.busstop.entity.BusStop;

public class Runner {

	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	static Logger logger = Logger.getLogger(Runner.class);

	public static void main(String[] args) {

		ArrayList<BusStop> route = new ArrayList<BusStop>();
		for (int i = 0; i < 5; i++) {
			BusStop stop = new BusStop(i + 1);
			route.add(stop);
		}

		Bus bus1 = new Bus(1);
		bus1.setList(route);
		bus1.start();
		Bus bus2 = new Bus(2);
		bus2.setList(route);
		bus2.start();
		Bus bus3 = new Bus(3);
		bus3.setList(route);
		bus3.start();
		Bus bus4 = new Bus(4);
		bus4.setList(route);
		bus4.start();
		Bus bus5 = new Bus(5);
		bus5.setList(route);
		bus5.start();
		Bus bus6 = new Bus(6);
		bus6.setList(route);
		bus6.start();
		Bus bus7 = new Bus(7);
		bus7.setList(route);
		bus7.start();
		Bus bus8 = new Bus(8);
		bus8.setList(route);
		bus8.start();
	}

}
