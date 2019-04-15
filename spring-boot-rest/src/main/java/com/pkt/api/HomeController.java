package com.pkt.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	private static List<Employee> dataList = new ArrayList<>();

	@CrossOrigin(origins="*")
	@GetMapping("/")
	public List<Employee> getData() {
		return dataList;

	}

	@CrossOrigin(origins="*")
	@PostMapping("/")
	public void postData(@RequestBody Employee emp) {
		dataList.add(emp);

	}

}
