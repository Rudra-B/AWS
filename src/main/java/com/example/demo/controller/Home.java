package com.example.demo.controller;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.management.OperatingSystemMXBean;

@RestController
public class Home {

	@GetMapping("/home")
	public String home() throws Exception {

		return "This is AWS service from instance    " + InetAddress.getLocalHost().getHostName();
	}

	@GetMapping("/loadcpu")
	public String loadCPU() throws Exception {

		Integer count = Runtime.getRuntime().availableProcessors();

		for (int i = 0; i < count; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (true)
						;
				}
			}).start();
		}
		return count.toString() + "   " + InetAddress.getLocalHost().getHostName();
	}

	@GetMapping("/getcpu")
	public String getCPU() throws Exception {
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

		Double cpu = osBean.getSystemCpuLoad();

		Double totalCpu = cpu * 100;

		return totalCpu + "    " + InetAddress.getLocalHost().getHostName().toString();
	}

}
