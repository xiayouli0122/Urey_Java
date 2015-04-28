package com.urey.example.io;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	
	public static void main(String[] args) {
		long starttime = getStartTime();
		long endtime = getEndTime();
		System.out.println("dayStart:" + starttime);
		System.out.println("dayEnd:" + endtime);
		
		long nowTime = System.currentTimeMillis();
		System.out.println("now:" + nowTime);
		long monthStartTime = getMonthStartTime(nowTime);
		long monthEndTime = getMonthEndTime(nowTime);
		System.out.println("monthStart:" + monthStartTime);
		System.out.println("monthEnd:" + monthEndTime);
		
		Date startdate = new Date(starttime);
		Date endDate = new Date(endtime);
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		System.out.println("DayStart:" + format.format(startdate));
		System.out.println("DayEnd:" + format.format(endDate));
		System.out.println("monthStart:" + format.format(monthStartTime));
		System.out.println("monthEnd:" + format.format(monthEndTime));
		
		
		
		
		//test get 2014-10-24 time
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 9);
		calendar.set(Calendar.DAY_OF_MONTH, 24);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);  
		calendar.set(Calendar.SECOND, 0);  
		calendar.set(Calendar.MILLISECOND, 0); 
		
		System.out.println(calendar.getTimeInMillis());
		
		
	}
	
	private static Long getStartTime(){  
        Calendar todayStart = Calendar.getInstance();  
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime().getTime();  
    }  
      
    private static Long getEndTime(){  
        Calendar todayEnd = Calendar.getInstance();  
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);  
        todayEnd.set(Calendar.MINUTE, 59);  
        todayEnd.set(Calendar.SECOND, 59);  
        todayEnd.set(Calendar.MILLISECOND, 999);  
        return todayEnd.getTime().getTime();  
    }  
    
    private static Long getMonthStartTime(long mills){  
        Calendar monthStart = Calendar.getInstance();  
//        monthStart.setTime(new Date(mills));
//        monthStart.set(Calendar.DATE, 1);  
//        monthStart.roll(Calendar.DATE, -1);  
        monthStart.set(Calendar.DAY_OF_MONTH, 1);
        monthStart.set(Calendar.HOUR_OF_DAY, 0);  
        monthStart.set(Calendar.MINUTE, 0);  
        monthStart.set(Calendar.SECOND, 0);  
        monthStart.set(Calendar.MILLISECOND, 0);  
        return monthStart.getTime().getTime();  
    }  
      
    private static Long getMonthEndTime(long mills){  
        Calendar monthEnd = Calendar.getInstance();  
//        monthEnd.setTime(new Date(mills));
//        monthEnd.set(Calendar.DATE, 1);  
//        monthEnd.roll(Calendar.DATE, -1);  
        int day = monthEnd.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("day:" + day);
        monthEnd.set(Calendar.DAY_OF_MONTH, day);
        monthEnd.set(Calendar.HOUR_OF_DAY, 23);  
        monthEnd.set(Calendar.MINUTE, 59);  
        monthEnd.set(Calendar.SECOND, 59);  
        monthEnd.set(Calendar.MILLISECOND, 999);  
        return monthEnd.getTime().getTime();  
    }  


}
