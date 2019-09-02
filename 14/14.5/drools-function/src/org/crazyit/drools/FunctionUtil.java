package org.crazyit.drools;

import java.util.Calendar;
import java.util.Date;

public class FunctionUtil {

	public static Date plusDay(Date d, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DAY_OF_MONTH, amount);
		return c.getTime();
	}
}
