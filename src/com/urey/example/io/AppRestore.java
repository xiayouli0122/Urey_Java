package com.urey.example.io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.naming.InitialContext;

public class AppRestore {
	private static final String ADB = "D:\\Dev\\adt-bundle-windows\\sdk\\platform-tools\\adb.exe";
	private static final String CMD1 = " shell input text";
	private static final String INSTALL = " install ";
	private static final String INSTALL_R = " install -r ";
	private static final String APKPATH = "D:\\astro.apk";
	private static final String DEVICE_NEXUS = " -s 0149C6F10B01B017 ";
	public static void main(String[] args) {
		String path = "D:\\install";
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("file is not exist");
			return;
		}
		
		File[] files = file.listFiles();
		if (null == files || files.length == 0) {
			System.out.println("There is no file");
			return;
		}
		
		for (int i = 0; i < files.length; i++) {
			System.out.println((i+1) + "/" + files.length);
			installApk(files[i].getAbsolutePath());
		}
		System.out.println("install success");
//		
		//auto rename multi files
//		for (int i = 0; i < files.length; i++) {
//			rename(files[i], path, i);
//		}
//		System.out.println("rename success");
	}
	
	public static void installApk(String apkpath){
		System.out.println("installing...:" + apkpath);
		Process process;
		try {
			process = Runtime.getRuntime().exec(ADB + INSTALL + apkpath);
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
	
	public static void rename(File file, String despath, int i){
		File desfile = new File(despath + File.separator + "abc" + i + ".apk");
		file.renameTo(desfile);
	}
}
