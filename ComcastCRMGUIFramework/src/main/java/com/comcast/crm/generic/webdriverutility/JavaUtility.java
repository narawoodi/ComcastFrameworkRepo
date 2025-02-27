package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	
	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}
	
	public String getRequiredDateYYYYDDMM(int days) {
		//Date date=new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		//String newDate = sim.format(date);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requiredDate = sim.format(cal.getTime());
		return requiredDate;
	}
}