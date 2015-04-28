package com.urey.example.io;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestJava5 {
	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getPercentInstance();
		DecimalFormat df = new DecimalFormat("0.00");
//		String str = df.format((float)6/14);
//		System.out.println(str);
//		System.out.println(nf.format((long)3/14));
		float prev = 0;
		
		for (int i = 0; i < 22; i++) {
			float percent = (float)i / 22;
			if (prev != percent * 100) {
//				mProgressBar.setProgress((int)(percent * 100));
//				mPercentView.setText(nf.format(percent));
				System.out.println(">" + nf.format(percent));
//				mNumberView.setText(dProgressStr + "/" + dMaxStr);
				prev = percent * 100;
				System.out.println("prev=" + prev);
			}
		}
		
	}
}
