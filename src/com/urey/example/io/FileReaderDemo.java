package com.urey.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class FileReaderDemo {
	public static void main(String[] args) {
		try {
//			System.out.println("-->" + BufferReaderDemo("D:\\word.txt"));
			TreeSet<String> words = BufferReaderDemo("D:\\word.txt");
			System.out.println("wors.dize=" + words.size());
			for (String string : words) {
				FileWrite.fileWriteDemo("bbb", string);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static TreeSet<String> BufferReaderDemo(String path) throws IOException{
		//java中，TreeSet集合能自动识别添加的是否重复 , 重复的将不会添加 , 很方便
		TreeSet<String> noRepeast = new TreeSet<>() ;
		File file = new File(path);
		
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String temp = null;
//		StringBuffer sb = new StringBuffer();
		temp = br.readLine();
		while(temp != null){
//			sb.append(temp);
			if (temp == null || temp.equals("")) {
				
			} else {
				if (temp.equals("，")) {
					System.out.println("it is a ，");
				} else {
					System.out.println("temp:" + temp);
					noRepeast.add(temp);
				}
			}
			temp = br.readLine();
		}
		
		fr.close();
		br.close();
		
		return noRepeast;
	}
}
