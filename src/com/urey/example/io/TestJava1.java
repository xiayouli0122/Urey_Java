package com.urey.example.io;

import java.util.ArrayList;

public class TestJava1 {
	public static void main(String[] args) {
		
		int[][] a = {
				{1,2,3},
				{2,3,4},
				{3,3},
				{4,3},
				{3,5,6}
		};
		
		int[] b = a[0];

//		for (int i = 0; i < b.length; i++) {
//			System.out.println("b[" + i + "]=" + b[i]);
//		}
		System.out.println("==>" + a[0][2] );
		System.out.println("a.len=" + a.length);
		for (int i = 0; i < a.length; i++) {
			
		}
		
		String msg1 = "LS@abcsdfsdf" + "\n"
		+ "aaaaaaaaaaaaa" + "\n"
				+ "bbbbbbbbbbbbbbb" + "\n"
		+ "ccccccccccccccccc" + "\n"
				+ "dddddddddddddddddd" + "\n";
		
		String msg[] = msg1.split("\n");
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < msg.length; i++) {
			System.out.println("msg[" + i + "]=" + msg[i]);
		}
		String a1 = ".android";
		System.out.println(a1.indexOf("."));
		
	}
}
