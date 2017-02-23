package generalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import fileProcessor.FileProcessor;
import fileProcessor.PdfWriterPss;
import fileProcessor.XmlWriter;

public class GeneralTests
{
FileProcessor fileProcessor = new FileProcessor();
PdfWriterPss pdfWriterPss = new PdfWriterPss();
String wp = FileProcessor.WORKSPACE_PATH;
XmlWriter xmlWriter = new XmlWriter();

@Test
public void test1()
{
	System.out.println("1. ****");
	// assertEquals(true, fileProcessor.fileExists(wp + "a.txt"));
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	System.out.println(sdf.format(cal.getTime()));
}
@Test
public void test2()
{
	// fp: Get time.
	System.out.println("2. ****");
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm a");
	System.out.println(simpleDateFormat.format(calendar.getTime()));
}
@Test
public void test3()
{
	// fp: Get date.
	System.out.println("3. ****");
	DateFormat dateFormat = new SimpleDateFormat("MMM-d-yyyy HH:mm a");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
}
@Test
public void test4()
{
	// fp: Get Document Generation Timestamp:
	System.out.println("4. ****");
	DateFormat dateFormat = new SimpleDateFormat("MMM-d-yyyy h:mm a");
	Date date = new Date();
	String documentGenerationTimestamp = "Document Generation Timestamp: " + dateFormat.format(date);
	System.out.println(documentGenerationTimestamp);
}
@Test
public void test5()
{
	// fp: Get Document Generation Timestamp:
	System.out.println("5. ****");
	Date date = new Date();
	SimpleDateFormat simpDate;
	simpDate = new SimpleDateFormat("h:mm a");
	System.out.println(simpDate.format(date));
}

public enum PageAlignment
{
	UNDEFINED, CENTERED
}

@Test
public void test6()
{
	// fp: Get Document Generation Timestamp:
	System.out.println("6. ****");
	System.out.println(PageAlignment.CENTERED);
	System.out.println(PageAlignment.CENTERED.toString());
	System.out.println(PageAlignment.CENTERED.ordinal());
}
@Test
public void test11()
{
	// JRJ, Oct-17-2016 4:56 PM.
	System.out.println("15. ****");
	DateFormat dateFormat = new SimpleDateFormat("MMM-d-yyyy h:mm a");
	Date date = new Date();
	String documentGenerationTimestamp = dateFormat.format(date);
	documentGenerationTimestamp = documentGenerationTimestamp.replaceAll("\\s", "_");
	System.out.println(documentGenerationTimestamp);
}
@Test
public void test12()
{
	// Function Purpose: 2 assert calls where 1 is false and the other true.
	// Creation Date: Oct-24-2016
	assertEquals(2, 2);
	assertEquals(1, 1);
}
@Test
public void test13()
{
	// Function Purpose: Test inline conditional
	// Creation Date: Oct-24-2016
	// Outcome:
	// Conclusion:
	String test = "hw";
	String test2 = null;
	System.out.println("Test: " + ((test2 == null) ? "null" : test));

}
@Test
public void test14()
{
	// Function Purpose: Test List of strings.
	// Creation Date: Nov-3-2016
	List<String> supplierNames = new ArrayList<String>();
	supplierNames.add("sup1");
	supplierNames.add("sup2");
	supplierNames.add("sup3");
	System.out.println(supplierNames.get(1));
}
@Test
public void test15()
{
	// Function Purpose: Test List of strings.
	// Creation Date: Nov-3-2016
	List<String> supplierNames = new ArrayList<String>();
	;
	supplierNames.add("sup1");
	supplierNames.add("sup2");
	supplierNames.add("sup3");
	assertTrue(supplierNames.contains("sup3"));
}
@Test
public void test16()
{
	// Function Purpose: Test List of strings.
	// Creation Date: Nov-3-2016
	// Gotcha: Notice that it's whole strings only.
	List<String> supplierNames = new ArrayList<String>();
	;
	supplierNames.add("sup1");
	supplierNames.add("sup2");
	supplierNames.add("sup3");
	assertTrue(!supplierNames.contains("3"));
}
@Test
public void test17()
{
	// Function Purpose: Test case sensitivity.
	// Creation Date: Nov-3-2016
	// Gotcha: Notice that it IS CASE SENSITIVE.
	// This is the latest.
	List<String> supplierNames = new ArrayList<String>();
	supplierNames.add("sup1");
	supplierNames.add("sup2");
	supplierNames.add("sup3");
	assertTrue(!supplierNames.contains("SUP1"));
}
@Test
public void test18()
{
	// JRJ, Nov-22-2016
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String todaysDate = dateFormat.format(date);
	System.out.println(todaysDate);	
}
@Test
public void test19()
{
	// JRJ, Nov-25-2016
	General general = new General();
	System.out.println(general.getCurrentDate());
}
@Test
public void test20()
{
	// Fp: Output date in date format. 
	// Date: Dec-1-2015
	Date date = new Date();
	System.out.println(date.toString());
}
@Test
public void test21()
{
	// Fp: Output date in date format. 
	// Date: Dec-1-2015
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
	Date date = new Date();
	String todaysDate = dateFormat.format(date);
	System.out.println(todaysDate);
}
@Test
public void test22()
{
	// Fp: Output date existing crappy date. 
	// Date: Dec-1-2015
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
	Date date = new Date();
	String todaysDate = dateFormat.format(date).toString();
	System.out.println(todaysDate);
//	dateFormat.format(systemDate).toString() + "-" + sequenceNumberString;
}
@Test
public void test23()
{
	//fcd: Dec-5-2015
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
	Date date = new Date();
	String todaysDate = dateFormat.format(date).toString();
	System.out.println(todaysDate);
//	dateFormat.format(systemDate).toString() + "-" + sequenceNumberString;
}
@Test
public void test24()
{
	// JRJ, Jan-10-2017 3:59 PM.
	DateFormat dateFormat = new SimpleDateFormat("MMM-d-yyyy h:mm a");
	Date date = new Date();
	String documentGenerationTimestamp = dateFormat.format(date);
	documentGenerationTimestamp = documentGenerationTimestamp.replaceAll("\\s", "_");
	documentGenerationTimestamp = documentGenerationTimestamp.replaceAll(":", "_");
	System.out.println(documentGenerationTimestamp);
}
@Test
public void test25()
{
	// JRJ, Feb-22-2017
	System.out.println("Hello World Feb-23-2017.");
}
} // (!efget)