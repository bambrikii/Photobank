package org.bambrikii.kbParser.sync.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SyntTest1 {
	@Test
	public void test1() throws InterruptedException {
		final List<String> sync1 = new ArrayList<String>();
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				synchronized (sync1) {
					sync1.add("a1\n");
					System.out.printf("added a1");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				synchronized (sync1) {
					sync1.add("b1");
					System.out.printf("added b1");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		// Thread.sleep(10000);
	}
}
