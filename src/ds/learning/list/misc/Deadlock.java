package ds.learning.list.misc;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

//http://stackoverflow.com/questions/217113/deadlock-in-java
class A {
	synchronized void foo(B b) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered X.foo");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("X Interrupted");
		}
		System.out.println(name + " trying to call Y.last()");
		b.last();
	}

	synchronized void last() {
		System.out.println("Inside X.last");
	}
}

class B {
	synchronized void bar(A a) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered Y.bar");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Y Interrupted");
		}
		System.out.println(name + " trying to call Y.last()");
		a.last();
	}

	synchronized void last() {
		System.out.println("Inside X.last");
	}
}

class Deadlock implements Runnable {
	A a = new A();
	B b = new B();

	Deadlock() {
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this, "RacingThread");
		t.start();
		new DeadLockDetectionThread().start();
		a.foo(b); // get lock on X in this thread.
		System.out.println("Back in main thread");
	}

	public void run() {
		b.bar(a); // get lock on Y in other thread.
		System.out.println("Back in other thread");
	}

	public static void main(String args[]) {
		new Deadlock();
	}
	
}

//http://stackoverflow.com/questions/217113/deadlock-in-java
class DeadLockDetectionThread extends Thread {
	
	public void run() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
			  long[] ids = tmx.findDeadlockedThreads();
			  if (ids != null) {
			     ThreadInfo[] infos = tmx.getThreadInfo(ids, true, true);
			     System.out.println("The following threads are deadlocked:");
			     for (ThreadInfo ti : infos) {
			        System.out.println("ThreadInfo##"+ti);
			     }
		}
		
	}
}
