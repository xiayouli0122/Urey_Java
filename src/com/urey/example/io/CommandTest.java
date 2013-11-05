package com.urey.example.io;

import java.io.IOException;
import java.util.Scanner;

public class CommandTest {
	private static final String ADB = "D:\\DE\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb.exe";
	private static final String CMD1 = " shell input text";
	public static void main(String[] args) {
		Process process;
		try {
			process = Runtime.getRuntime().exec(ADB + CMD1 + " www.cctv.com");
			System.out.println("===========");
			process.waitFor();
			
			Scanner scanner = new Scanner(process.getErrorStream());
			if (scanner.hasNext()) {
				System.out.println("" + scanner.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
