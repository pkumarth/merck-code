package com.phonepe.mapper.driver;

import java.util.ArrayList;
import java.util.List;

public class ABC {
	public static void main(String[] args) throws Exception {
		int threshold = 4;
		List<Integer> happy = new ArrayList<>();
		happy.add(1);
		happy.add(2);
		happy.add(3);
		happy.add(4);
		happy.add(5);

		int n = happy.size();
		int resFIndex = 0;
		int resIIndex = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (happy.get(j) - happy.get(i) >= threshold) {
					resFIndex = j;
					resIIndex = i;
				}
			}
		}
		if (resFIndex > 0) {
			int rem = resFIndex % 2;
			int qut = resFIndex / 2;
			if (rem > 0) {
				System.out.println(qut + 1);
			}

		}
		System.out.println(n);  
	}

}
