package com.urey.example.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	public static void main(String[] args) {
		fileWriteDemo("test", "This is test");
	}
	
	/**将备份的内容先写入文件*/
	public static File fileWriteDemo(String title,String content){
		//default path
		File file = new File("E:\\");
		if (! file.exists()) {
			file.mkdirs();
		}
		
		String filePath = "E:\\" + title + ".txt";
		File tempFile = new File(filePath);
		if (! tempFile.exists()) {
			try {
				tempFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(tempFile);
			bw = new BufferedWriter(fw);
//			bw.newLine();
			bw.write(content);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally{
			fw = null;
			bw = null;
		}
		
		return tempFile;
	}
}
