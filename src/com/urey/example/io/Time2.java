package com.urey.example.io;

public class Time2 {
	public static void main(String[] args) {
		int h = 0,m = 0,s = 0;
		int w1 = Math.round((h * 60 * 60 + m * 60 + s) /3600 *6);
		int w2 = Math.round((m * 60 +s) / 60 * 6);
		int w3 = s * 6;
		
		int count = 0;
		System.out.println(Math.round(3661 /3600 * 6));
		
		for (int t = 0; t < 60 * 60 * 12 * 2; t++) {
			//时钟的角度
			int w11 = Math.round(t % 3600 * 6);
			
			//分钟的角度
			int w22 = Math.round(t % 60 * 6);
			
			//秒针的角度
			int w33 = Math.round(t * 6);
		}
		
//		for (s = 0; s < 60; s++) {
//			for (m = 0; m < 60; m++) {
//				for (h = 0; h < 24; h++) {
//					System.out.println("w1=" + w1 + " w2=" + w2 + " w3=" + w3);
//					if (w1 == w2 && w2 == w3) {
//						count ++ ;
//						System.out.println(h + ":" + m + ":" + s);
//					}
//				}
//			}
//		}
		
//		for (h = 0; h < 24; h++) {
//			for (m = 0; m < 60; m++) {
//				for (s = 0; s < 60; s++) {
//					int w1111 = Math.round((h * 60 * 60 + m * 60 + s) /3600 *6);
//					int w2222 = Math.round((m * 60 +s) / 60 * 6);
//					int w3333 = s * 6;
//					if (w1111 == w2222 && w2222 == w3333) {
//						count ++ ;
//						System.out.println(h + ":" + m + ":" + s);
//					}
//				}
//			}
//		}
		
		System.out.println(count);
	}
}
