package com.urey.story;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.urey.example.io.StroyInfo;

public class StoryMain {
	public static void main(String[] args) {
		
//		String bearpre = "小熊维尼晚安故事MP3-星期二-02-";
//		rename(bearpre, Constants.BEAR_PATH);
		
//		String pre = "成语故事MP3-";
//		rename(pre, Constants.CHENGYU_PATH);
		
//		String fsleeppre = "儿童故事mp3下载 知识 ";
//		rename(fsleeppre, Constants.SLEEP_PATH);
		
//		String childpre = "幼儿故事mp3-";
//		rename(childpre, childpath);
		
//		String fairpre = "世界著名童话MP3-";
////		rename(fairpre, fairypath);
		
//		String lishipre = "001";
//		rename(lishipre, Constants.HISTORY_PATH);
		
//		String goldcatpre = "";
////		rename(goldcatpre, goldcatpath);
			
//		String xiyoujipre = "";
////		rename(xiyoujipre, xiyoujipath);
		
//		String ergepre = "儿童歌曲大全-";
////		rename(ergepre, ergepath);
		
//		String historycnpre = "中国历史故事MP3-11";
//		rename(historycnpre, Constants.HISTORY_CN_PATH);
		
		writeStorInfoToExcel();
		formatRename();
		
//		removeFlag(Constants.HISTORY_PATH);
	}
	
	public static void writeStorInfoToExcel(){
		List<StroyInfo> infos = null;
//		infos = getInfos(Constants.BEAR_PATH, Constants.PRE_BEAR, Constants.TYPE_BEAR);
//		infos = getInfos(Constants.CHENGYU_PATH, Constants.PRE_CHENGYU, Constants.TYPE_CHENGYU);
//		infos = getInfos(Constants.SLEEP_PATH, Constants.PRE_SLEEP, Constants.TYPE_SLEEP);
//		infos = getInfos(Constants.CHILD_PATH, Constants.PRE_CHILD, Constants.TYPE_CHILD);
//		infos = getInfos(Constants.FAIRY_TALE_PATH, Constants.PRE_FAIRY_TALE, Constants.TYPE_FAIRY_TALE);
//		infos = getInfos(Constants.HISTORY_WORLD_PATH, Constants.PRE_HISTORY_WORLD, Constants.TYPE_HISTORY_WORLD);
//		infos = getInfos(Constants.GOLDCAT_PATH, Constants.PRE_GOLDCAT, Constants.TYPE_GOLDCAT);
//		infos = getInfos(Constants.XIYOUJI_PATH, Constants.PRE_XIYOUJI, Constants.TYPE_XIYOUJI);
//		infos= getInfos(Constants.CHILD_SONG_PATH, Constants.PRE_CHILD_SONG, Constants.TYPE_CHILD_SONG);
//		infos= getInfos(Constants.HISTORY_CN_PATH, Constants.PRE_HISTORY_CN, Constants.TYPE_HISTORY_CN);
		
		File file = new File("D:\\Dev\\github_floder\\ChengYuDaHui\\ChengYu\\res\\story\\story.xlsx");
		try {
			if (infos == null) {
				return;
			}
			writeExcel(file, infos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void formatRename(){
//		formatRename(Constants.BEAR_PATH, Constants.PRE_BEAR);
//		formatRename(Constants.CHENGYU_PATH, Constants.PRE_CHENGYU);
//		formatRename(Constants.SLEEP_PATH, Constants.PRE_SLEEP);
//		formatRename(Constants.CHILD_PATH, Constants.PRE_CHILD);
//		formatRename(Constants.FAIRY_TALE_PATH, Constants.PRE_FAIRY_TALE);
//		formatRename(Constants.HISTORY_WORLD_PATH, Constants.PRE_HISTORY_WORLD);
//		formatRename(Constants.GOLDCAT_PATH, Constants.PRE_GOLDCAT);
//		formatRename(Constants.XIYOUJI_PATH, Constants.PRE_XIYOUJI);
//		formatRename(Constants.CHILD_SONG_PATH, Constants.PRE_CHILD_SONG);
//		formatRename(Constants.HISTORY_CN_PATH, Constants.PRE_HISTORY_CN);
	}
	
	public static void rename(String pre, String path){
//		String ex = "mp3(www.goodkejian.com).mp3";
//		String ex = "---(www.goodkejian.com).mp3";
		String ex = "(www.goodkejian.com).mp3";

		File rootDir = new File(path);
		if (!rootDir.exists()) {
			return;
		}

		File[] files = rootDir.listFiles();
		String name = "";
		String newName = "";
		int start = pre.length();
		int end = 0;
		
		File newFile = null;
		for (File file : files) {
			name = file.getName();
			if (name.contains(pre)) {
				end = name.length() - ex.length();
				newName = name.substring(start, end) + ".mp3";
//				name = name.substring(start, end);
				newFile = new File(path + "\\" + newName);
//				System.out.println(newFile.getAbsolutePath());
				boolean ret = file.renameTo(newFile);
				if (!ret) {
					newName = name.substring(start, end) + "(2)" + ".mp3";
					newFile = new File(path + "\\" + newName);
					System.out.println(newFile.getAbsolutePath());
					file.renameTo(newFile);
				}
			}
		}
	}
	
	public static List<StroyInfo> getInfos(String path, String namepre, int type) {
		List<StroyInfo> list = new ArrayList<>();
		File rootDir = new File(path);
		if (!rootDir.exists()) {
			return null;
		}

		File[] files = rootDir.listFiles();
		CompartorList compartorList = new CompartorList();
		Arrays.sort(files, compartorList);

		List<File> fileList = new ArrayList<>();
		for (File file : files) {
			if (!file.getName().equals("size.txt")) {
				fileList.add(file);
			}
		}

		int id;
		String title;
		String oldFileName;
		String newFileName;
		long size;

		File file = null;
		StroyInfo info = null;
		for (int i = 0; i < fileList.size(); i++) {
			file = fileList.get(i);
			size = file.length();
			oldFileName = file.getName();
			
			newFileName = namepre + (i + 1) + ".mp3";
			
			id = i + 1;
			title = oldFileName.substring(0, oldFileName.length() - 4);
			info = new StroyInfo();
			info.setId(id);
			info.setType(type);
			info.setTitle(title);
			info.setFileName(newFileName);
			info.setSize(size);

			list.add(info);
		}

		return list;
	}
	
	public static void formatRename(String path, String namepre){
		File rootDir = new File(path);
		if (!rootDir.exists()) {
			return;
		}

		File[] files = rootDir.listFiles();
		CompartorList compartorList = new CompartorList();
		Arrays.sort(files, compartorList);

		List<File> fileList = new ArrayList<>();
		for (File file : files) {
			fileList.add(file);
		}

		String oldFileName;
		String newFileName;

		File file = null;
		File newFile = null;
		for (int i = 0; i < fileList.size(); i++) {
			file = fileList.get(i);
			oldFileName = file.getName();
			
			newFileName = namepre + (i + 1) + ".mp3";
			System.out.println("before:" + oldFileName);
			System.out.println("after:" + newFileName);
			newFile = new File(path + "\\" + newFileName);
			file.renameTo(newFile);
		}
	}

	public static void writeExcel(File file, List<StroyInfo> mList)
			throws IOException {
		String fileName = file.getName();
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName
				.substring(fileName.lastIndexOf(".") + 1);
		// 判断文件类型
		if ("xls".equals(extension)) {
			write2003Excel(file.getPath(), mList);
		} else if ("xlsx".equals(extension)) {
			write2007Excel(file.getPath(), mList);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}
	
	public static void write2007Excel(String filePath, List<StroyInfo> list) {
		int type = list.get(0).getType();
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));
			XSSFSheet sheet = wb.getSheetAt(type);//写入到指定的sheet表中
			XSSFRow row = sheet.getRow(0);//创建行
			int rownum = 0;
			StroyInfo info = null;
			for (int i = 0; i < list.size(); i++) {
				rownum += 1;
				info = list.get(i);
				row=sheet.createRow(rownum);  //从第二行开始，第一行是标题不修改
				//一共要创建5列，分别是id，type，title，filename
				row.createCell(0).setCellValue(info.getId());
				row.createCell(1).setCellValue(info.getType());
				row.createCell(2).setCellValue(info.getTitle());
				row.createCell(3).setCellValue(info.getFileName());
				row.createCell(4).setCellValue(info.getSize());
			}
			FileOutputStream out = new FileOutputStream(filePath);
			out.flush();
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void write2003Excel(String filePath, List<StroyInfo> list) {
		try {
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
			HSSFSheet sheet = wb.getSheetAt(list.get(0).getType());//写入到指定的sheet表中
			HSSFRow row = sheet.getRow(0);//创建行
			int rownum = 0;
			StroyInfo info = null;
			for (int i = 0; i < list.size(); i++) {
				rownum += 1;
				info = list.get(i);
				row=sheet.createRow(rownum);  //从第二行开始，第一行是标题不修改
				//一共要创建5列，分别是id，type，title，filename
				row.createCell(0).setCellValue(info.getId());
				row.createCell(1).setCellValue(info.getType());
				row.createCell(2).setCellValue(info.getTitle());
				row.createCell(3).setCellValue(info.getFileName());
				row.createCell(4).setCellValue(info.getSize());
			}
			FileOutputStream out = new FileOutputStream(filePath);
			out.flush();
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//去除《》
	public static void removeFlag(String path){
		File dirFile =new File(path);
		
		File[] files = dirFile.listFiles();
		String fileName = "";
		String newName = "";
		int start;
		int end;
		for (File file : files) {
			fileName = file.getName();
			String firstletter = fileName.substring(0, 1);
			if (firstletter.contains("“")) {
				System.out.println(fileName);
				fileName = fileName.replace("《", "");
//				System.out.println(fileName);
				fileName = fileName.replace("》", "");
				fileName = fileName.replace("“", "");
				fileName = fileName.replace("”", "");
//				start = fileName.indexOf("《");
//				end = fileName.indexOf("》");
//				newName = fileName.substring(start + 1, end) + ".mp3";
//				System.out.println(fileName);
				boolean ret = file.renameTo(new File(path + "\\" + fileName));
				if (!ret) {
					System.out.println(newName);
				}
			}
		}
	}
}
