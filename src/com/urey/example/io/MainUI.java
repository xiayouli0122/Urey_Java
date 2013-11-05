package com.urey.example.io;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import org.xml.sax.HandlerBase;

public class MainUI extends JFrame{
	JFrame jframe = new JFrame();// 创建对象
	JMenuBar jmb = new JMenuBar();// 创建菜单条对象
	JMenu jMenu_File, jMenu_Edit, jMenu_About;// 菜单
	JMenuItem menu_send, menu_save, menu_exit, jmi4;// 菜单项
	
	
	JTextArea jTextArea;

	//构造　初始化
	public MainUI(String title){
		//设置标题
		jframe.setTitle(title);
		//定义窗口大小
		jframe.setSize(new Dimension(800,480));
	}
	
	//定义方法,添加菜单条和其他控件
	void setMyMenuBar(){
		//定义菜单
		jMenu_File = new JMenu("文件");
		jMenu_Edit = new JMenu("编辑");
		jMenu_About = new JMenu("帮助");
		
		//添加到菜单栏
		jmb.add(jMenu_File);
		jmb.add(jMenu_Edit);
		jmb.add(jMenu_About);
		
		//添加菜单项
		menu_send = new JMenuItem("Send");
		menu_send.addActionListener(new Handle());
		jMenu_File.add(menu_send);
		
		menu_save = new JMenuItem("保存");
		menu_save.addActionListener(new Handle());
		jMenu_File.add(menu_save);
		
		menu_exit = new JMenuItem("Exit");
		menu_exit.addActionListener(new Handle());
		jMenu_File.add(menu_exit);
		
		jMenu_Edit.add(new JMenuItem("复制"));
		
		jframe.setJMenuBar(jmb);
		jframe.pack();
		jframe.setVisible(true);
		
	}
	
	void setTextArea(){
		jTextArea = new JTextArea();
		jTextArea.setEditable(true);
		
		jframe.add(jTextArea);
	}
	
	private static final String ADB = "D:\\DE\\adt-bundle-windows-x86\\sdk\\platform-tools\\adb.exe";
	private static final String CMD1 = " shell input text ";
	public static void main(String[] args) {
		MainUI myWindow = new MainUI("MyWindow");
		myWindow.setMyMenuBar();
		myWindow.setTextArea();
	}
	
	class Handle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem jMenuItem = (JMenuItem) arg0.getSource();
			if (jMenuItem == menu_send) {
				System.out.println("111111");
				Process process;
				try {
					process = Runtime.getRuntime().exec(ADB + CMD1 + jTextArea.getText());
					System.out.println("===========");
					process.waitFor();
					
					Scanner scanner = new Scanner(process.getErrorStream());
					if (scanner.hasNext()) {
						System.out.println("" + scanner.next());
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else if (jMenuItem == menu_save) {
				System.out.println("22222222");
			}else if (jMenuItem == menu_exit) {
				System.exit(0);
			}
		}
		
	}
	
}
