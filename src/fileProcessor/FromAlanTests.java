package fileProcessor;

import org.junit.Test;

public class FromAlanTests 
{

	String wp = FileProcessor.WORKSPACE_PATH;
	FromAlan fromAlan = new FromAlan();

	@Test
	public void test1() 
	{
		// Outcome: It works without error, but the Populated.pdf looks like no_data.pdf
		// and is not populated.
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "no_data.pdf"; 
		String xmlDataFilename = wp + "qdata.xml";
		String codeGeneratedPdfFilename = wp + "Populated.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test2() 
	{
		// fp: Pass in a random PDF to see what happens.
		// Outcome: Error Message:
		// class java.lang.IllegalStateException; Document does not contain an XFA form.
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "FormFill3.pdf"; 
		String xmlDataFilename = wp + "qdata.xml";
		String codeGeneratedPdfFilename = wp + "Populated.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test3() 
	{
		// fp: Reverse the order of the PDF files!
		// Outcome: No data still. 
		// Conclusion: What I do know is that the third parameter is the file that gets generated.
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "no_data.pdf"; 
		String xmlDataFilename = wp + "qdata.xml";
		String codeGeneratedPdfFilename = wp + "Populated.pdf";
		fromAlan.createPdf(codeGeneratedPdfFilename, xmlDataFilename, templatePDFFilename);
	}
	@Test
	public void test4() 
	{
		// fp: See if data.xml does anything.
		// and is not populated.
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "no_data.pdf"; 
		String xmlDataFilename = wp + "data.xml";
		String codeGeneratedPdfFilename = wp + "Populated3.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test5() 
	{
		// fp: Compare size of data to no data PDF.
		// Populated_with_No_Data.pdf size = 1,578 KB 
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "no_data.pdf"; 
		String xmlDataFilename = wp + "no data.xml";
		String codeGeneratedPdfFilename = wp + "Populated_with_No_Data.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test6() 
	{
		// fp: Compare size of data to no data PDF.
		// Populated_with_Data.pdf size = 1,578 KB
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "no_data.pdf"; 
		String xmlDataFilename = wp + "data.xml";
		String codeGeneratedPdfFilename = wp + "Populated_with_Data.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test7() 
	{
		// fp: Pass in a random XML file to see what happens.
		// Conclusion: The function does nothing but copy and renames the PDF.
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "no_data.pdf"; 
		String xmlDataFilename = wp + "random.xml";
		String codeGeneratedPdfFilename = wp + "Populated_with_random_xml.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test8() 
	{
		// fp: Minimally edited XML file from Alan.
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "alan.pdf"; 
		String xmlDataFilename = wp + "alan1.xml";
		String codeGeneratedPdfFilename = wp + "alan_output.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test9() 
	{
		// fp: Run Alan's code against pristine versions of backbone1.xml and template.pdf.
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "no data.pdf"; 
		String xmlDataFilename = wp + "backbone1.xml";
		String codeGeneratedPdfFilename = wp + "backbone1.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test10() 
	{
		// fp: Run Alan's code against 123.pdf with backbone1.xml.
		// Outcome: backbone2.pdf looks identical to 123data.pdf, so it's if all Alan's code did was
		// make a copy of the pdf, and nothing was done with the xml data.
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "123data.pdf"; 
		String xmlDataFilename = wp + "backbone1.xml";
		String codeGeneratedPdfFilename = wp + "backbone10.pdf";
		fromAlan.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test11() 
	{
		// fp: Run Alan's minimally changed code against 123.pdf with backbone1.xml.
		// Outcome: Same as test10.
		FromAlan fromAlan = new FromAlan();
		fromAlan.createPdfOriginalMinimallyChanged();
	}
	@Test
	public void test12() 
	{
		// Function Purpose: Get baby backbone to populate the PDF.  
		//    Creation Date: Sep-28-2016
		//          Outcome: class java.lang.IllegalStateException; Document does not contain an XFA form
		FromAlan fromAlan = new FromAlan();
		String templatePDFFilename = wp + "Interactive Form Version 2.pdf"; 
		String xmlDataFilename = wp + "babybackbone.xml";
		String codeGeneratedPdfFilename = wp + "babybackbone.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test13() 
	{
		// Function Purpose: Using my latest code, Compare PDF file sizes when I pass in qdata.xml as opposed to data.xml.   
		//    Creation Date: Sep-29-2016
		String templatePDFFilename = wp + "no data.pdf"; 
		String xmlDataFilename = wp + "qdata.xml";
		String codeGeneratedPdfFilename = wp + "q is merged 3.pdf"; // File size: 1,569 KB
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test14() 
	{
		// Function Purpose: Using my latest code, Compare PDF file sizes when I pass in qdata.xml as opposed to data.xml.   
		//    Creation Date: Sep-29-2016
		//       Conclusion: The file sizes are the same so it appears that nothing happened.
		String templatePDFFilename = wp + "no data.pdf"; 
		String xmlDataFilename = wp + "data.xml";
		String codeGeneratedPdfFilename = wp + "q is merged 4.pdf"; // File size: 1,569 KB
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test15() 
	{
		// fp: Run Alan's code against 123.pdf with qdata.xml.
		String templatePDFFilename = wp + "123data.pdf"; 
		String xmlDataFilename = wp + "qdata.xml";
		String codeGeneratedPdfFilename = wp + "123 plus qdata 4.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test16() 
	{
		// fp: Look at the stream.
		String templatePDFFilename = wp + "123data.pdf"; 
		String xmlDataFilename = wp + "qdata.xml";
		String codeGeneratedPdfFilename = wp + "qmerge_Oct_14.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test17() 
	{
		// Function Purpose: Test the merge cat4. 
		//    Creation Date: Sep-30-2016
		//          Outcome: Same as test1.
		String templatePDFFilename = wp + "cat4.pdf"; 
		String xmlDataFilename = wp + "cat4.xml";
		String codeGeneratedPdfFilename = wp + "Merged cat4-2.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test18() 
	{
		// Function Purpose: Test the BFO merge BEFORE I wrap the data document. 
		//    Creation Date: Oct-14-2016 11:10 AM
		//          Outcome: No error and no merge, just like before. 
		String templatePDFFilename = wp + "1234_data.pdf"; 
		String xmlDataFilename = wp + "567_data.xml";
		String codeGeneratedPdfFilename = wp + "1234_567_Merge.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test19() 
	{
		// Function Purpose: Test the BFO merge AFTER I wrap the data document. 
		//    Creation Date: Oct-14-2016 11:21 AM
		//          Outcome: It works! The merge worked! 
		String templatePDFFilename = wp + "1234_data.pdf"; 
		String xmlDataFilename = wp + "888_wrapped_data.xml";
		String codeGeneratedPdfFilename = wp + "1234_888_Merge.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test20() 
	{
		// Function Purpose: Test the BFO merge with data.xml. 
		//    Creation Date: Oct-14-2016 11:43 AM
		//          Outcome: Doesn't work.
		String templatePDFFilename = wp + "1234_data.pdf"; 
		String xmlDataFilename = wp + "data.xml";
		String codeGeneratedPdfFilename = wp + "1234_data_Merge.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test21() 
	{
		// Function Purpose: Test the BFO merge with data tweaked.xml. 
		//    Creation Date: Oct-14-2016 11:43 AM
		//          Outcome: Doesn't work.
		String templatePDFFilename = wp + "1234_data.pdf"; 
		String xmlDataFilename = wp + "data tweaked.xml";
		String codeGeneratedPdfFilename = wp + "1234_data_tweaked_Merge.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test22() 
	{
		// Function Purpose: Test the BFO merge with a little more data.xml. 
		//    Creation Date: Oct-14-2016
		//          Outcome: Worked.
		// This is the latest.
		String templatePDFFilename = wp + "1234_data.pdf"; 
		String xmlDataFilename = wp + "a little more data 2.xml";
		String codeGeneratedPdfFilename = wp + "1234_a_little_more_data_2_Merge.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test25()
	{
		// Function Purpose: Test the BFO merge with a little more data.xml.
		// Creation Date: Nov-14-2016
		// Outcome: Worked.
		// This is the latest.
		String templatePDFFilename = wp + "boilerplate.pdf";
		String xmlDataFilename = wp + "boilerplate.xml";
		String codeGeneratedPdfFilename = wp + "boilerplate merge equals 1.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test26()
	{
		// Function Purpose: Test cumulative merge.
		// Creation Date: Nov-18-2016
		// This is the latest.
		String templatePDFFilename = wp + "boilerplate merge equals 1.pdf";;
		String xmlDataFilename = wp + "boilerplate.xml";
		String codeGeneratedPdfFilename = wp + "boilerplate merge equals 2.pdf";
		fromAlan.createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
}
