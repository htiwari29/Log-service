package com.htiwari29.logservice.common.util;

import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(com.fasterxml.jackson.core.JsonParser jsonParser,
			com.fasterxml.jackson.databind.DeserializationContext deserializationContext) throws IOException {
		String date = jsonParser.getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		try {
			return dateFormat.parse(date);
		}
		catch (ParseException ex) {
			throw new IOException("Error in parsing date", ex);
		}
	}

}
