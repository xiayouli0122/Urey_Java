package com.urey.example.io;

import java.text.DecimalFormat;

public class TestJava4 {
	public static void main(String[] args) {
		long size = 3955228672l;
		long size1 = 1024 * 1024;
		System.out.println(getFormatSize(size));
		System.out.println(getFormatSize(size1));
		long size2 = 356123123;
		System.out.println(getFormatSize(size2));
	}
	
	public static String getFormatSize(double size){
		if( size >= 1024 * 1024 * 1024){
			Double dsize = (double)(size / (1024 * 1024 * 1024));
			return new DecimalFormat("#.00").format(dsize) + "G";
		}
		else if (size >= 1024 * 1024) {
			Double dsize = (double) (size / (1024 * 1024));
			return new DecimalFormat("#.00").format(dsize) + "MB";
		}else if (size > 1024) {
			Double dsize = (double)size / (1024);
			return new DecimalFormat("#.00").format(dsize) + "KB";
		}else {
			return String.valueOf((int)size) + " Bytes";
		}
	}
}
