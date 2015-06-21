package by.zhukova.busstop.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class BusStop {

	static Logger logger = Logger.getLogger(BusStop.class);

	private int busStopNum;
	private int busesNum;
	private final int MAX_NUM = 3;
	private Semaphore semaphore;
	private Lock lock = new ReentrantLock();

	public BusStop() {
	}

	public BusStop(int num) {
		this.setBusStopNum(num);
		this.busesNum = 0;
		semaphore = getSemaphore();
	}

	public boolean isFull() {
		if (busesNum == MAX_NUM) {
			return true;
		} else {
			return false;
		}
	}

	public void busOnBusStop(Bus bus) {
		try {
			semaphore.acquire();
			comingBus(bus);
			Thread.sleep(1000);
			leavingBus(bus);
		} catch (InterruptedException e) {
			logger.error(e);
		} finally {
			semaphore.release();
		}
	}

	private void comingBus(Bus bus) throws InterruptedException {
		lock.lock();
		System.out.println("Автобус " + bus.getBusNumber()
				+ " прибыл на остановку " + busStopNum);
		busesNum += 1;
		System.out.println("Количество автобусов на остановке  " + busStopNum
				+ " - " + busesNum);
		lock.unlock();
	}

	private void leavingBus(Bus bus) throws InterruptedException {
		lock.lock();
		System.out.println("Автобус " + bus.getBusNumber()
				+ " покинул остановку " + busStopNum);
		busesNum -= 1;
		System.out.println("Количество автобусов на остановке " + busStopNum
				+ " - " + busesNum);
		lock.unlock();
	}

	public int getBusStopNum() {
		return busStopNum;
	}

	public void setBusStopNum(int busStopNum) {
		this.busStopNum = busStopNum;
	}

	public int getBusesNum() {
		return busesNum;
	}

	public void setBusesNum(int num) {
		this.busesNum = num;
	}

	public Semaphore getSemaphore() {
		semaphore = new Semaphore(MAX_NUM);
		return semaphore;
	}

}
