package com.urey.example.io;

import java.text.Collator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

public class TestJava3 {
	public static void main(String[] args) {
		String oldName = "abcs()dfdsf(23e)";
		String newName = "";
		newName = rename(oldName);
		System.out.println(newName);
	}
	
	private static final String kuohu1 = ")";
	private static final String kuohu2 = "(";
	public static String rename(String oldName){
		String newName = "";
		String tempName = "";
		String extensionName = "";
		int index = oldName.lastIndexOf(".");
		if (index == -1) {
			tempName = oldName;
		}else {
			//得到除去扩展名的文件名，如：abc
			tempName = oldName.substring(0, oldName.lastIndexOf("."));
			extensionName =  oldName.substring(index);
		}
		
		System.out.println("name=" + tempName + "   name.len=" + tempName.length());
		//判断一下最后一个是否是括弧2
		System.out.println("" + tempName.substring(tempName.length() - 1, tempName.length()));
		//得到倒数第一个括弧的位置
		int kuohuoIndex1 = tempName.lastIndexOf(kuohu1);
		System.out.println("kuohuoIndex1=" + kuohuoIndex1);
		//得到倒数第二个括弧的位置
		int kuohuoIndex2 = tempName.lastIndexOf(kuohu2);
		System.out.println("kuohuoIndex2=" + kuohuoIndex2);
		if (kuohuoIndex1 != tempName.length() - 1) {
			newName = tempName + "(2)" + extensionName;
		}else {
			//得到括弧里面的String
			String str = tempName.substring(kuohuoIndex2 + 1, kuohuoIndex1);
			System.out.println("str=" + str);
			try {
				int num = Integer.parseInt(str);
				
				newName =  tempName.substring(0, kuohuoIndex2) + "(" + (num + 1) + ")"+ extensionName;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				newName = tempName + "(2)" + extensionName;
				System.out.println(e.toString());
			}
		}
		return newName;
	}
}
