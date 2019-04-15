package com.pkt.thread.mapReduceFrameWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class DriverV2 {
	public static void main(String[] args) throws Exception {
		int noOfMapper = 6;
		int noOfFile = 6;
		BlockingQueue<String> fileBq = new LinkedBlockingQueue<>();
		for (int i = 0; i < 6; i++) {
			String dir = "/Users/pthakur/Documents/data/healofy";
			String file = dir + "/" + (i + 1) + ".txt";
			System.out.println(file);
			fileBq.offer(file);
		}
		ExecutorService mapExecutor = Executors.newFixedThreadPool(noOfMapper);
		BlockingQueue<Map<String, Map<String, Integer>>> mappedBq = new LinkedBlockingQueue<>();
		for (int i = 0; i < noOfFile; i++) {
			if (!fileBq.isEmpty()) {
				Runnable worker = new MapperV2(fileBq.take(), mappedBq);
				mapExecutor.execute(worker);
			}
		}
		mapExecutor.shutdown();
		while (!mapExecutor.isTerminated()) {

			// Thread.sleep(5000);
		}
		System.out.println("Finished all Mapper threads");

		// reduce to single result
		Map<String, Map<String, Integer>> resultMap = new HashMap<>();
		while (!mappedBq.isEmpty()) {
			ReducerV2.reduce(resultMap, mappedBq.take());
		}

		for (Entry<String, Map<String, Integer>> m : resultMap.entrySet()) {
			System.out.println("======"+m.getKey() +" =====");
			for (Map.Entry<String, Integer> cm : m.getValue().entrySet()) {
				System.out.println(  cm.getKey() + "    -    " + cm.getValue());
			}
		}

	}
}
