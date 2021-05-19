//Loryn Duncombe(ld3dx) Homework 6
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class PrintQueue {
	private Queue<String> queue;// creating a queue full of strings 
	private java.util.concurrent.locks.Lock documentChangeLock;
	private Condition hasPrintTask;
	private boolean isOn;
	int currentSize = 0;
	
	//methods
	public PrintQueue() {
		this.queue = new LinkedList<>();
		if (documentChangeLock == null) {
			documentChangeLock = new ReentrantLock();
			
		}
		hasPrintTask = documentChangeLock.newCondition();
		isOn = true;
	}
	
	public String dequeue() {
		documentChangeLock.lock();
		try {
			return queue.poll();//removing it from the queue
		}
		finally {
			documentChangeLock.unlock(); // must unlock at the end of each method
		}
	}
	public void enqueue (String greeting) {
		documentChangeLock.lock();
		try {
			queue.add(greeting); // adds greeting to the queue
			currentSize ++; //increases the size by 1 
		}
		finally {
			documentChangeLock.unlock(); // must unlock at the end of each method
		}
	}
	public void turnOff() {
		documentChangeLock.lock();
		try {
			isOn = false; //turns it off
			hasPrintTask.signalAll(); 
			
		}
		catch (IllegalMonitorStateException e) {
			
		}
		finally {
			documentChangeLock.unlock();// must unlock at the end of each method
		}
		}
	
public boolean isOn() {
	return isOn; // turns it on 
}
}
