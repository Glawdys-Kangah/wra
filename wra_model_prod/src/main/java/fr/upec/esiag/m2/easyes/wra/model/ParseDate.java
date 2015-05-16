package fr.upec.esiag.m2.easyes.wra.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * Class parse date to manipulate dates
 * @author Glawdys
 *
 */
public class ParseDate {
/**
 * get a the french format for the dates
 * @param date
 * @return
 */
	public Date parseDateToDDMMYYY(Date date){

		SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/yyyy");
		formatter.format(date);
		return date;
	}
/**
 * get the hyphen separated format for the dates
 * @param dateToParse
 * @return
 */
	public Date parseFormatDateWithHyphen(String dateToParse){
		SimpleDateFormat simpleDateFormat =
				new SimpleDateFormat("yyyy-MM-dd", Locale.UK);

		Date date = null;
		try {
			date = simpleDateFormat.parse(dateToParse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return date;
	}

}
