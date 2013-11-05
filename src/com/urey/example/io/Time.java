package com.urey.example.io;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {
	public static void main(String[] args) {
		int count = 0;
		//����һ��GregorianCalendar�����ҽ�������ʱ���붼��Ϊ0���õ�һ������ʱ��ֵ����ȷ�����룩
		long base = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime().getTime();
		//ʱ���ʽ�������ں�������
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		//һ����60*60*12*2�룬��0�뿪ʼ���������ӣ��жϸ�ʱ���Ƿ�������ص���
		//��ʱ������ֳ�60���ж�ʱ�롢���롢�����Ƿ���ͬһ������
		for (int t = 0; t < 60 * 60 * 12 * 2; t++) {
			 //����ʱ�����ڸ��ӣ���60*60*12�����ǽ���ǰ������ӳ�䵽����ķ�Χ�У�ʱ���ں������ǰ�����λ�ñ䶯һ������
			//Ȼ�����60�õ���������Ȼ�����ڷ�����˵һ������һ���ӣ�����ʱ����˵������ʮ����֮һ���ӣ�ʱ��60������5�����ӣ���
			//�������ٳ���12�õ�ʱ�����ڵĸ���
			int locHourHand = Math.round((t % (60 * 60 * 12)) / (60 * 12));
			// ��60*60����õ��֡���ε����ݣ�����60�õ����з�������Ҳ��Ӧ�ڷ�������ˡ�
			int locMinuteHand = Math.round((t % (60 * 60)) / 60);
			// ��60����õ�������ݣ����������ڸ���
			int locSecondHand = t % 60;
			//��������ͬ���ʾ�ص�
			if (locHourHand == locMinuteHand && locHourHand == locSecondHand) {
				count ++;
				//��ʱ����ָ�Ϊһ��������Date����Date����ȷ�����룩
				//����֮ǰ�Ļ���ʱ��ֵ���ټ��ϵ����ʱ��
				Date date = new Date(base + t * 1000);
				System.out.println(df.format(date));
			}
		}
		System.out.println("count=" + count);
	}
}
