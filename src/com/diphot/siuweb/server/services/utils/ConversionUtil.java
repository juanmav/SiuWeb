package com.diphot.siuweb.server.services.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConversionUtil {

	@SuppressWarnings("deprecation")
	public static String getSimpleDate(String stringDate){
		Date date = null;
		String result;
		try {
			date = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",Locale.US).parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dia = date.getDate() <= 9 ? "0" +(date.getDate()) : "" + (date.getDate());
		String mes = date.getMonth() <= 9 ? "0" +(date.getMonth() + 1) : "" + (date.getMonth() + 1);
		String a�o = ("" + (date.getYear() + 1900));
		
		result = (dia+ "/" + mes + "/"+ a�o);
		return result;
	}

}
