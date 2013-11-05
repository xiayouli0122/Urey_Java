package com.urey.example.io;

import java.util.ArrayList;

public class TestJava {
	public static void main(String[] args) {
		int color = 0xff00ffff;
		int alpha = (color >> 24) & 0xff;
		int red = (color >> 16) & 0xff;
		int green = (color >> 8) & 0xff;
		int blue = color & 0xff;
		System.out.println("aplpha=" + alpha + "\n"
				+ "red=" + red + "\n"
				+ "green=" + green + "\n"
				+ "blue=" + blue);
		
//		if (red) {
//			
//		}
	}
}
