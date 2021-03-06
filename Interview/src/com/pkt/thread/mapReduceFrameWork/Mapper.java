package com.pkt.thread.mapReduceFrameWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Mapper extends Thread {
	private String fileName;
	private static BlockingQueue<Map<String, Integer>> bq;
	

	public Mapper(String fileName, BlockingQueue<Map<String, Integer>> bq) {
		this.fileName = fileName;
		this.bq = bq;

	}

	public void run() {
		try {
			map(this.fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Map<String, Integer> map(String fileName) throws IOException {

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		Map<String, Integer> mapper = new HashMap<>();
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
		bq.offer(mapper);

		return mapper;

	}

	public static void mapV2(String fileName) throws IOException, ParseException {

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line;
		Map<String, Map<String, Integer>> map = new HashMap<>();
		while ((line = br.readLine()) != null) {
			String[] line_break = line.split(" ");
			String key = putInRange(line_break[0]).toString();

			if (map.containsKey(key)) {
				Map<String, Integer> m = map.get(key);
				int val = m.get(line_break[1]) + 1;
				m.put(line_break[1], val);
				map.put(key, m);
			} else {
				Map<String, Integer> m = new HashMap<>();
				m.put(line_break[1], 1);
				map.put(key, m);
			}

			// System.out.println(line);
		}
		br.close();
		// bq.offer(map);

		return;

	}

	public static Date putInRange(String time) throws ParseException {
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		Date six = parser.parse("06:00");
		Date seven = parser.parse("07:00");
		Date eight = parser.parse("08:00");
		Date nine = parser.parse("09:00");
		Date ten = parser.parse("10:00");
		Date eleven = parser.parse("11:00");
		Date twelve = parser.parse("12:00");
		Date thirteen = parser.parse("13:00");
		Date fourteen = parser.parse("14:00");
		Date fifteen = parser.parse("15:00");
		Date eighteen = parser.parse("18:00");
		try {
			Date userDate = parser.parse(time);
			if (userDate.after(six) && userDate.before(seven)) {
				return six;
			} else if (userDate.after(seven) && userDate.before(eight)) {
				return seven;
			} else if (userDate.after(eight) && userDate.before(nine)) {
				return eight;
			} else if (userDate.after(nine) && userDate.before(ten)) {
				return nine;
			} else if (userDate.after(ten) && userDate.before(eleven)) {
				return ten;
			} else if (userDate.after(eleven) && userDate.before(twelve)) {
				return eleven;
			} else if (userDate.after(twelve) && userDate.before(thirteen)) {
				return twelve;
			} else if (userDate.after(thirteen) && userDate.before(fourteen)) {
				return thirteen;
			} else if (userDate.after(fourteen) && userDate.before(fifteen)) {
				return fourteen;
			} else if (userDate.after(fifteen) && userDate.before(eighteen)) {
				return fifteen;
			} else if (userDate.after(eighteen) && userDate.before(six)) {
				return eighteen;
			}

		} catch (ParseException e) {
			e.printStackTrace();

		}
		return null;

	}

}
