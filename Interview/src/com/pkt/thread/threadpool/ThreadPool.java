package com.pkt.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	private class PoolWorker extends Thread {
		public void run() {
			Runnable task;
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							System.out.println("An error occurred while queue is waiting: " + e.getMessage());
						}
					}
					task = queue.poll();
				}
				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				}
			}
		}
	}

	private final int nThreads;
	private final LinkedBlockingQueue<Runnable> queue;
	private final PoolWorker[] threads;

	public ThreadPool(int nThreads) {
		super();
		this.nThreads = nThreads;
		this.queue = new LinkedBlockingQueue<>();

		this.threads = new PoolWorker[nThreads];
		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notifyAll();
		}
	}

}
