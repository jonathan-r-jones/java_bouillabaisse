package generalTests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class General 
{
public String getCurrentDate()
{
	// JRJ, Nov-25-2016
	DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
	Date date = new Date();
	String currentDate = dateFormat.format(date);
	return currentDate;
}
}
