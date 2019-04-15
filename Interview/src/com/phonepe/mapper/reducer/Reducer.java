package com.phonepe.mapper.reducer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Reducer {
//	public static void main(String[] args) throws Exception {
//
//		String f = "/Users/pthakur/Documents/phonepe/1.txt";
//		Map<String, Integer> mapper = reduce(f);
//		for (Map.Entry<String, Integer> m : mapper.entrySet()) {
//			System.out.println(m.getKey() + " - " + m.getValue());
//
//		}
//
//		List<Map<String, Integer>> reducerList = new LinkedList<>();
//
//	}

	public static Map<String, Integer> reduce(List<Map<String, Integer>> reducerList) throws IOException {

		Map<String, Integer> resultMap = reducerList.get(0);

		for (int i = 1; i < reducerList.size(); i++) {
			merge(resultMap, reducerList.get(1));

		}
		return resultMap;

	}

	public static void merge(Map<String, Integer> resultMap, Map<String, Integer> map) {

		for (Map.Entry<String, Integer> m : map.entrySet()) {
			if (resultMap.containsKey(m.getKey())) {
				resultMap.put(m.getKey(), resultMap.get(m.getKey()) + m.getValue());
			} else {
				resultMap.put(m.getKey(), m.getValue());
			}

		}

	}

}
