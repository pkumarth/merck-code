package com.pkt.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class Task1 implements Runnable {
	public int num;
	private final LinkedBlockingQueue<String> queue;

	public Task1(int num, LinkedBlockingQueue<String> queue) {
		this.num = num;
		this.queue = queue;

	}

	@Override
	public void run() {
		System.out.println("Task " + num + " is running.");
		try {
			while (true) {
				System.out.println(queue.take());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
