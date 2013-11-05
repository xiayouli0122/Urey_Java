package com.urey.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) {
		try {
			System.out.println("-->" + BufferReaderDemo("E:\\pw.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String BufferReaderDemo(String path) throws IOException{
		File file = new File(path);
		
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();//∂¡“ª––
		
		while(temp != null){
			sb.append(temp+"\n");
			temp = br.readLine();
		}
		
		fr.close();
		br.close();
		
		return sb.toString();
	}
}
