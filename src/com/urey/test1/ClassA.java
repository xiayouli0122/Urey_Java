package com.urey.test1;

import java.util.Random;

public class ClassA {
	
	int var1;
	
	public static void main(String[] args) {
		ClassB classB = new ClassA.ClassB();
		classB.fucntion();
		
		long time;
		
		String teString = "";
		for (int i = 0; i < 20; i++) {
			time = System.currentTimeMillis();
			System.out.println(time);
			long random  = new Random().nextInt(10000);
			System.out.println(random);
			teString = Long.toHexString(time + random);
			System.out.println(teString);
		}
	}

	public static void test(){
		System.out.println("CLassA.test");
	};
	
	static class ClassB extends ClassC{
		
		public void fucntion(){
			test();
			ClassA.test();
			test();
			super.test();
		}
	}
}
