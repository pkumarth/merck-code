package com.phonepe.mapper.driver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import com.phonepe.mapper.map.Mapper;
import com.phonepe.mapper.reducer.Reducer;

public class Driver {
	public static void main(String[] args) throws Exception {
		int noOfMapper = 3;
		int noOfReducer = 2;
		int noOfFile = 6;

		// String file = "/Users/pthakur/Documents/phonepe/2.txt";
		List<Map<String, Integer>> mappedList = new LinkedList<>();

		for (int i = 0; i < 6; i++) {
			String dir = "/Users/pthakur/Documents/phonepe";
			String file = dir + "/" + (i + 1) + ".txt";
			System.out.println(file);
			Map<String, Integer> mapper = Mapper.map(file);
			mappedList.add(mapper);
		}
		Map<String, Integer> resultMap = Reducer.reduce(mappedList);

		for (Map.Entry<String, Integer> m : resultMap.entrySet()) {
			System.out.println(m.getKey() + " - " + m.getValue());

		}
		BlockingQueue<Map<String, Integer>> bq = new LinkedBlockingQueue<>();
		ExecutorService mapExecutor = Executors.newFixedThreadPool(noOfMapper);
		mapExecutor.submit(() -> {
			for (int i = 0; i < noOfFile; i++) {
				String dir = "/Users/pthakur/Documents/phonepe";
				String file = dir + "/" + (i + 1) + ".txt";
				System.out.println(file);
				Map<String, Integer> mapper;
				try {
					mapper = Mapper.map(file);
					bq.put(mapper);
					mappedList.add(mapper); // later on remove it
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		mapExecutor.shutdown();

		// Job Estimation for reducer

		int size = mappedList.size();
		int jobPerReducer = size / noOfReducer;
		int remaining = size % noOfReducer;
		AtomicInteger at = new AtomicInteger(0);

		ExecutorService reduceExecutor = Executors.newFixedThreadPool(noOfReducer);
		reduceExecutor.submit(() -> {
			Reducer.merge(mappedList.get(0), mappedList.get(at.incrementAndGet()));
		});
		reduceExecutor.shutdown();

	}
}
