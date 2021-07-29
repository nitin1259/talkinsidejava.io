package com.java.freelance.julianne.Calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelCalculator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("input number>>");
		int len = scanner.nextInt(); // input 'k'
		
		// int [] inputArray = {34, 26, 100, 0, 4};
		// int len = inputArray.length;
		int sum = 0;
		
		// Make threads number of 'len'. Here we use List instead of array because there
		// is such contract in ExecutorService
		List<SecretCalcthread> calulator = new ArrayList<>(len);
		
		// Create thread pool with fixed number of threads
		ExecutorService service = Executors.newFixedThreadPool(8);
		
		// Add all Callable task in one collection
		for (int i = 0; i < len; i++) {
			calulator.add(new SecretCalcthread(i));
		}
		try {
			// Invoke all Callable task and get List with results
			List<Future<Integer>> results = service.invokeAll(calulator);
			
			// Future::get is blocking method. It waits result.
			for (Future<Integer> result : results) {
				sum += result.get();
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Something went unexpected");
			e.printStackTrace();
		}

		System.out.println("Result: " + sum);
		// We need to shutdown our service
		service.shutdown();

	}

}

class SecretCalcthread implements Callable<Integer> {

	private int input = 0;

	public SecretCalcthread(int num) {
		this.input = num;
	}

	@Override
	public Integer call() {
		StringBuilder result = new StringBuilder();
		String urlToRead =  "https://pic20a-api-server.vercel.app/api?key=" + this.input;
		
		try {
			URL url = new URL(urlToRead);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// System.out.println(ZonedDateTime.now() +" : "+this.input + " : "+result.toString());
		System.out.println(this.input + " : "+result.toString());
		
		return Integer.parseInt(result.toString());
	}
}