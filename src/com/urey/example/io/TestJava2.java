package com.urey.example.io;

import java.util.ArrayList;

public class TestJava2 {
	public static void main(String[] args) {
		long time = 7930474;
		long hour = time / (60 * 60 * 1000);
		long min = time % (60 * 60 * 1000) / (60 * 1000);
		long sec = time % (60 * 60 * 1000) % (60 * 1000);
		System.out.println(hour + ":" + min + ":" + sec);
	}
}
