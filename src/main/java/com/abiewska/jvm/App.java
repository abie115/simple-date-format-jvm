package com.abiewska.jvm;


public class App {
	public static void main(String[] args){

		threadSafeSDF threadSafeSDF = new threadSafeSDF();
		threadSafeSDF.test();
		
		notThreadSafeSDF notThreadSafeSDF = new notThreadSafeSDF();
		notThreadSafeSDF.test();
		
	}
}
