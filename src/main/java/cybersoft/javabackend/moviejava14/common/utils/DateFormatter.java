package cybersoft.javabackend.moviejava14.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateFormatter {
	
	public static Timestamp convertStringToDate(String strDate) {
		if(strDate == null) {
			return null;
		}
		
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			// you can change format of date
			Date date = formatter.parse(strDate);
			Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;
		} catch (ParseException e) {
			log.error("Can not parse date: {}", e.getMessage());
			return null;
		}
	}
	
	public static Timestamp convertStringToDateAndTime(String strDate) {
		if(strDate == null) {
			return null;
		}
		
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			// you can change format of date
			Date date = formatter.parse(strDate);
			Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;
		} catch (ParseException e) {
			log.error("Can not parse date: {}", e.getMessage());
			return null;
		}
	}
	
	public static String getDate(Timestamp date) {
        return date.toString().substring(0, 10);
    }
	
	public static String getTime(Timestamp date) {
        return date.toString().substring(11, 16);
    }

}
