package com.pkt.thread.mapReduceFrameWork;

import java.util.Map;
import java.util.Map.Entry;

public class ReducerV2 {

	public static void reduce(Map<String, Map<String, Integer>> resultMap, Map<String, Map<String, Integer>> map) {
		System.out.println("====New ========");
		for (Entry<String, Map<String, Integer>> m : map.entrySet()) {
			System.out.println(m.getKey());
			if (resultMap.containsKey(m.getKey())) {
				Map<String, Integer> rm = resultMap.get(m.getKey());

				for (Map.Entry<String, Integer> cm : m.getValue().entrySet()) {
					if (rm.containsKey(cm.getKey())) {
						int val = rm.get(cm.getKey()) + cm.getValue();
						rm.put(cm.getKey(), val);
					} else {
						rm.put(cm.getKey(), cm.getValue());

					}
				}
				resultMap.put(m.getKey(), rm);
			} else {
				resultMap.put(m.getKey(), m.getValue());

			}

		}

	}

}
