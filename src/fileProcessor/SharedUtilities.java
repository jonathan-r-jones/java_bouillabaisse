package fileProcessor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedUtilities 
{
	public String GetTimestamp()
	{
		DateFormat dateFormat = new SimpleDateFormat("MMM-d-yyyy h:mm a");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
