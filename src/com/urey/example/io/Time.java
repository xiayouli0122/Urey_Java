package com.urey.example.io;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {
	public static void main(String[] args) {
		int count = 0;
		//构造一个GregorianCalendar，并且将年月日时分秒都定为0，得到一个基础时间值（精确到毫秒）
		long base = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime().getTime();
		//时间格式化，用于后面的输出
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		//一天有60*60*12*2秒，从0秒开始，逐秒增加，判断该时刻是否发生针的重叠。
		//把时钟盘面分成60格，判断时针、分针、秒针是否在同一格子上
		for (int t = 0; t < 60 * 60 * 12 * 2; t++) {
			 //计算时针所在格子，对60*60*12求余是将当前总秒数映射到半天的范围中（时针在后半天与前半天的位置变动一样），
			//然后除以60得到分钟数，然而对于分针来说一分钟走一格子，对于时针来说则是走十二分之一格子（时针60分钟走5个格子），
			//于是又再除以12得到时针所在的格子
			int locHourHand = Math.round((t % (60 * 60 * 12)) / (60 * 12));
			// 对60*60求余得到分、秒段的数据，除以60得到其中分钟数，也对应于分针格子了。
			int locMinuteHand = Math.round((t % (60 * 60)) / 60);
			// 对60求余得到秒段数据，即秒针所在格子
			int locSecondHand = t % 60;
			//若三者相同则表示重叠
			if (locHourHand == locMinuteHand && locHourHand == locSecondHand) {
				count ++;
				//此时将其恢复为一个正常的Date对象（Date对象精确到毫秒）
				//加上之前的基础时间值，再加上当天的时间
				Date date = new Date(base + t * 1000);
				System.out.println(df.format(date));
			}
		}
		System.out.println("count=" + count);
	}
}
