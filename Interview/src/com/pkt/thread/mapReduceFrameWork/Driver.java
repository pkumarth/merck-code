package com.pkt.thread.mapReduceFrameWork;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;



public class Driver {
	public static void main(String[] args) throws Exception {
		int noOfMapper = 4;
		int noOfReducer = 2;
		int noOfFile = 6;
		BlockingQueue<String> fileBq = new LinkedBlockingQueue<>();
		for (int i = 0; i < 6; i++) {
			String dir = "/Users/pthakur/Documents/data";
			String file = dir + "/" + (i + 1) + ".txt";
			System.out.println(file);
			fileBq.offer(file);
		}
		ExecutorService mapExecutor = Executors.newFixedThreadPool(noOfMapper);
		BlockingQueue<Map<String, Integer>> mappedBq = new LinkedBlockingQueue<>();
		for (int i = 0; i < noOfFile; i++) {
			if (!fileBq.isEmpty()) {
				Runnable worker = new Mapper(fileBq.take(), mappedBq);
				mapExecutor.execute(worker);
			}
		}
		mapExecutor.shutdown();
		while (!mapExecutor.isTerminated()) {

			Thread.sleep(5000);
		}
		System.out.println("Finished all Mapper threads");

		// reduce to single result
		Map<String, Integer> resultMap = new HashMap<>();
		while (!mappedBq.isEmpty()) {
			Reducer.merge(resultMap, mappedBq.take());
		}

		for (Map.Entry<String, Integer> m : resultMap.entrySet()) {
			System.out.println(m.getKey() + " - " + m.getValue());

		}

	}
}
