package com.urey.example.io;

import java.text.DecimalFormat;

public class FileSizeUtil {
	public static void main(String[] args) {
		System.out.println("" + getFormatFileSize(35100060));
	}
	
	public static String getFormatFileSize(double filesize){
		System.out.println(filesize);
		if (filesize > 1024 * 1024) {
			Double dsize = (double) (filesize / (1024 * 1024));
			return new DecimalFormat("#.00").format(dsize) + "MB";
		}else if (filesize > 1024) {
			Double dsize = (double)filesize / (1024);
			return new DecimalFormat("#.00").format(dsize) + "KB";
		}else {
			return String.valueOf((int)filesize) + " Bytes";
		}
	}
}
