package com.urey.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Location {
	private static final String haoma = "E:\\Pro_Src\\号码归属地\\haoma.txt";
	public static void main(String[] args) {
		try {
			BufferReaderDemo(haoma);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  //从文件中读取数据
    public static String BufferReaderDemo(String path) throws IOException{
		File file = new File(path);
		
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();//按行读取
		
		System.out.println("temp=" + temp);
//		while(temp != null){
////			sb.append(temp+"\n");
//			temp = br.readLine();
//		}
		
		fr.close();
		br.close();
		
		return sb.toString();
	}
}
