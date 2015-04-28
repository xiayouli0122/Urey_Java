package com.urey.example.io;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJava6 {

	public static void main(String[] args) {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��");
//		long date = 1391911965;
//		String str = format.format(new Date(date));
//		System.out.println("str=" + str);
		
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(700, 400);//移动鼠标到(10,20)点
			robot.mouseWheel(-50);

//		    robot.mousePress(InputEvent.BUTTON1_MASK);//按下左键
//
//		    robot.mouseRelease(InputEvent.BUTTON1_MASK);//释放左键
//
//		    robot.delay(100);//停顿100毫秒,即0.1秒
//
//		    robot.mousePress(InputEvent.BUTTON1_MASK);//按下左键
//
//		    robot.mouseRelease(InputEvent.BUTTON1_MASK);//释放左键
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
