package com.diphot.siu.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class ParseTest {

	@Test
	public void parseTest(){
		Date date = null;
		try {
			date = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",Locale.US).parse("Wed Sep 04 17:10:45 ART 2013");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( (date.getDay() +1 )+ "/" + (date.getMonth() +1 ) + "/"+ (date.getYear()+ 1900));
	}

	@Test
	public void parseTest2(){
		Date date = null;
		
		try {
			date = new SimpleDateFormat("dd/MM/yyyy",Locale.US).parse("12/12/2013");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(date.toString());
	}

}


