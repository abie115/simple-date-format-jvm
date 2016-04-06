package com.abiewska.jvm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class notThreadSafeSDF {

	ExecutorService executorService = Executors.newFixedThreadPool(5);

	final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	List<Future<Date>> results = new ArrayList<Future<Date>>();

	public Date convert(String date) throws ParseException {
		return simpleDateFormat.parse(date);
	}

	public void test() {
		System.out
				.println("\n**********Not thread safe simple date format**********");
		for (int i = 0; i < 40; i++) {

			results.add(executorService.submit(new Callable<Date>(){

				@Override
				public Date call() throws Exception {
					return convert("2016-11-11");
				}
				
			}));
			
		}
		executorService.shutdown();
		
		for (Future<Date> result : results) {
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
