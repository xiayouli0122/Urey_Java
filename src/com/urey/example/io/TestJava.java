package com.urey.example.io;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		long date = 1383794250;
		System.out.println(getFormatDate(date));
//		if (red) {
//			
//		}
	}
	
	/**get app install date*/
	public static String getFormatDate(long date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(new Date(date));
		return dateString;
	}
}
