package com.pkt.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class Task implements Runnable {
	public int num;
	private final LinkedBlockingQueue<String> queue;

	public Task(int num, LinkedBlockingQueue<String> queue) {
		this.num = num;
		this.queue = queue;

	}

	@Override
	public void run() {
		System.out.println("Task " + num + " is running.");
		String str = "Task " + num + " is running.";
		queue.offer(str);

	}

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(7);
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
		Task1 task1 = new Task1(0, queue);
		pool.execute(task1);

		for (int i = 1; i < 5; i++) {
			Task task = new Task(i, queue);
			pool.execute(task);
		}
	}

}
