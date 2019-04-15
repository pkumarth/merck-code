package com.phonepe.mapper.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Mapper implements Runnable{
//	public static void main(String[] args) throws Exception {
//
//		String f = "/Users/pthakur/Documents/phonepe/2.txt";
//		Map<String, Integer> mapper = map(f);
//		for (Map.Entry<String, Integer> m : mapper.entrySet()) {
//			System.out.println(m.getKey() + " - " + m.getValue());
//			writeToFile((m.getKey() + " - " + m.getValue()), "/Users/pthakur/Documents/phonepe/mapper.txt");
//
//		}
//
//	}
	public void run() {
		
	}

	public static Map<String, Integer> map(String fileName) throws IOException {

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		Map<String, Integer> mapper = new HashMap<>();
		System.out.println("Read text file using InputStreamReader");
		while ((line = br.readLine()) != null) {
			String[] line_break = line.split(" ");
			if (mapper.containsKey(line_break[0])) {
				mapper.put(line_break[0], mapper.get(line_break[0]) + Integer.parseInt(line_break[1]));
			} else {
				mapper.put(line_break[0], Integer.parseInt(line_break[1]));
			}

			// System.out.println(line);
		}
		br.close();
		return mapper;

	}

//	private static void writeToFile(String text, String fileName) {
//		try {
//			Process p = Runtime.getRuntime().exec("git log");
//
//			try (BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//					BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//
//				String line = null;
//				while ((line = in.readLine()) != null) {
//					writer.write(line);
//					writer.newLine();
//					System.out.println(line);
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//
//		}
//	}

}
