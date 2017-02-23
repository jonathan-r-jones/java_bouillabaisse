package fileProcessor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.lowagie.tools.arguments.FileArgument;
import com.lowagie.tools.arguments.StringArgument;
import com.lowagie.tools.plugins.*;

import com.lowagie.text.DocumentException;

public class PdfProcessorTests 
{

	PdfProcessor pdfProcessor = new PdfProcessor();
	FileProcessor fileProcessor = new FileProcessor();
	String wp = FileProcessor.WORKSPACE_PATH;

	@Test
	public void test1() 
	{
		//   Function Purpose: Point the PDF reader at a few different PDFs. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: Size = 0.
		String pdfFilename = wp + "data.pdf";
		pdfProcessor.pdfFieldReader3(pdfFilename);
	}
	@Test
	public void test1b() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "data.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test3() 
	{
		//   Function Purpose: Point the PDF creator at one of my homegrown PDFs. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: Size = 1!, which is surprising to me.
		String pdfFilename = wp + "Interactive Form Version 2.pdf";
		pdfProcessor.pdfFieldReader3(pdfFilename);
	}
	@Test
	public void test3b() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "Interactive Form Version 2.pdf";
		assertEquals(1, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test4() 
	{
		//   Function Purpose: Point the PDF creator at one of my homegrown PDFs that has 2 fields. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: Size = 2!
		String pdfFilename = wp + "Interactive Form Version 3.pdf";
		pdfProcessor.pdfFieldReader3(pdfFilename);
	}
	@Test
	public void test4b() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "Interactive Form Version 3.pdf";
		assertEquals(2, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test5() 
	{
		//   Function Purpose: Point the PDF creator at one of my homegrown PDFs that has 2 fields. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: Size = 3!
		String pdfFilename = wp + "Interactive Form Version 4.pdf";
		pdfProcessor.pdfFieldReader3(pdfFilename);
	}
	@Test
	public void test8() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "no data.pdf";
		assertEquals(true, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test8b() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "no data.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test9() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "data.pdf";
		assertEquals(true, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test9b() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "data.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test10() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "Interactive Form Version 4.pdf";
		assertEquals(false, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test10b() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "Interactive Form Version 4.pdf";
		assertEquals(3, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test11() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "-SF_1424.pdf";
		assertEquals(false, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test11b() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "-SF_1424.pdf";
		assertEquals(98, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test12() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: This is true!?
		String pdfFilename = wp + "-SF_1423_test.pdf";
		assertEquals(true, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test12b() throws IOException, DocumentException 
	{
		//	          Outcome: This is an XFA PDF that has fields I can see. Totally amazing. **** Category 4 PDF!
		String pdfFilename = wp + "-SF_1423_test.pdf";
		assertEquals(78, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test13() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: Category 4 PDF.
		String pdfFilename = wp + "-SF_1423.pdf";
		assertEquals(true, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test13b() throws IOException, DocumentException 
	{
		//	          Outcome: This is an XFA PDF that has fields I can see. Totally amazing. **** Category 4 PDF!
		String pdfFilename = wp + "-SF_1423.pdf";
		assertEquals(78, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test14() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: Category 2 PDF.
		String pdfFilename = wp + "-DD_1348_1A.pdf";
		assertEquals(false, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test14b() throws IOException, DocumentException 
	{
		//	          Outcome: Category 2 PDF
		String pdfFilename = wp + "-DD_1348_1A.pdf";
		assertEquals(51, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test15() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "-DD_1637.pdf";
		assertEquals(false, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test15b() throws IOException, DocumentException 
	{
		//	          Outcome: Category 2 PDF.
		String pdfFilename = wp + "-DD_1637.pdf";
		assertEquals(39, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test16() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "-DD_1640.pdf";
		assertEquals(false, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test16b() throws IOException, DocumentException 
	{
		//	          Outcome: Category 2 PDF.
		String pdfFilename = wp + "-DD_1640.pdf";
		assertEquals(38, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test17() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "-DD_1641.pdf";
		assertEquals(false, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test17b() throws IOException, DocumentException 
	{
		//	          Outcome: Category 2 PDF.
		String pdfFilename = wp + "-DD_1641.pdf";
		assertEquals(49, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test18() 
	{
		//   Function Purpose: Test 8 PCARSS forms to see if they are XFA forms. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "nodata5.pdf";
		assertEquals(true, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test18b() throws IOException, DocumentException 
	{
		//	          Outcome: Category 2 PDF.
		String pdfFilename = wp + "nodata5.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test19() throws IOException, DocumentException 
	{
		//   Function Purpose: Show the fields of a category 4 form! 
		//	    Creation Date: Sep-30-2016
		String pdfFilename = wp + "-SF_1423_test.pdf";
		pdfProcessor.pdfFieldReader4(pdfFilename);
	}
	@Test
	public void test20() 
	{
		//   Function Purpose: Let's see some values next to the keys. 
		//	    Creation Date: Sep-30-2016
		String pdfFilename = wp + "Interactive Form Version 4.pdf";
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test21() 
	{
		//   Function Purpose: Let's see some values for the big guy. 
		//	    Creation Date: Sep-30-2016
		String pdfFilename = wp + "-SF_1423_test.pdf";
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test22() 
	{
		//   Function Purpose: Test 123 form. 
		//	    Creation Date: Sep-30-2016
		//	          Outcome: 
		String pdfFilename = wp + "123data.pdf";
		assertEquals(true, pdfProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test22b() throws IOException, DocumentException 
	{
		//	          Outcome: Category 2 PDF.
		String pdfFilename = wp + "123data.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test22c() 
	{
		//   Function Purpose: Let's see some values for the big guy. 
		//	    Creation Date: Sep-30-2016
		String pdfFilename = wp + "123data.pdf";
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test30a() 
	{
		// Example of a Category 1 pdf.
		String pdfilename = wp + "HelloWorld11.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test30b() 
	{
		String pdfFilename = wp + "HelloWorld11.pdf";
		pdfProcessor.pdfFieldReader3(pdfFilename);
	}
	@Test
	public void test30c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "HelloWorld11.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test30d() 
	{
		// fp: Inspect PDF.
		// fcd: Oct-11-2016
		String pdfFilename = wp + "HelloWorld11.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}	
	@Test
	public void test31a() 
	{
		// Example of a Category 1 pdf.
		String pdfilename = wp + "Access Google's Web Service.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test31b() 
	{
		String pdfFilename = wp + "Access Google's Web Service.pdf";
		pdfProcessor.pdfFieldReader3(pdfFilename);
	}
	@Test
	public void test31c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "Access Google's Web Service.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test31d() 
	{
		// fp: Inspect PDF.
		// fcd: Oct-11-2016
		String pdfFilename = wp + "Access Google's Web Service.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	@Test
	public void test32a() 
	{
		// Example of a Category 2 pdf.
		String pdfilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test32b() 
	{
		String pdfFilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf";
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test32c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf";
		assertEquals(3, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test32d() 
	{
		// fp: Inspect PDF.
		// fcd: Oct-11-2016
		String pdfFilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	@Test
	public void test33a() 
	{
		// Example of a Category 3 pdf.
		String pdfFilename = wp + "nodata5.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfFilename));
	}
		@Test
	public void test33b() 
	{
		String pdfFilename = wp + "nodata5.pdf";
		pdfProcessor.pdfFieldReader3(pdfFilename);
	}
	@Test
	public void test33c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "nodata5.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test33d() 
	{
		// fp: Inspect PDF.
		// fcd: Oct-11-2016
		String pdfFilename = wp + "nodata5.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	@Test
	public void test34a() 
	{
		// Example of a Category 4 pdf.
		String pdfilename = wp + "-SF_1423_test.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test34b() 
	{
		//	          Outcome: This is an XFA PDF that has fields I can see. Totally amazing. **** Category 4 PDF!
		String pdfFilename = wp + "-SF_1423_test.pdf";
		pdfProcessor.pdfFieldReader5(pdfFilename);
		// JRJ, Oct-12-2016 11:20 AM, WK-1. 
	}
	@Test
	public void test34c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "-SF_1423_test.pdf";
		assertEquals(78, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test34d() 
	{
		// fp: Inspect PDF.
		// fcd: Oct-11-2016
		String pdfFilename = wp + "-SF_1423_test.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	@Test
	public void test35a() 
	{
		// fp: Proof that Alan's no data pdf file is category 3 pdf.
		String pdfilename = wp + "no data.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test35b() 
	{
		String pdfFilename = wp + "no data.pdf";
		pdfProcessor.pdfFieldReader3(pdfFilename);
	}
	@Test
	public void test35c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "no data.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test35d() 
	{
		// fp: Inspect PDF.
		// fcd: Oct-11-2016
		String pdfFilename = wp + "no data.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	@Test
	public void test36a() 
	{
		String pdfilename = wp + "data.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfilename));
	}
	@Test
	public void test36b() 
	{
		// fp: Proof that Alan's data pdf file is category 3 pdf.
		String pdfFilename = wp + "data.pdf";
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test36c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "data.pdf";
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test36d() 
	{
		// fp: Inspect PDF.
		// fcd: Oct-11-2016
		String pdfFilename = wp + "data.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}	
	@Test
	public void test37a() 
	{
		String pdfFilename = wp + "K2 Training Form.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test37b() 
	{
		String pdfFilename = wp + "K2 Training Form.pdf"; 
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test37c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "K2 Training Form.pdf"; 
		assertEquals(22, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test37d() 
	{
		// fp: Inspect PDF.
		// fcd: Oct-11-2016
		String pdfFilename = wp + "K2 Training Form.pdf"; 
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}	
	@Test
	public void test38a() 
	{
		String pdfFilename = wp + "old.pdf"; 
		assertEquals(false, fileProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test38b() 
	{
		String pdfFilename = wp + "old.pdf"; 
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test38c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "old.pdf"; 
		assertEquals(1, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test38d() 
	{
		// fp: Inspect PDF.
		// fcd: Nov-18-2016
		String pdfFilename = wp + "old.pdf"; 
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}	
	@Test
	public void test38() 
	{
		// fp: Test method pdfFieldReader6.
		String pdfFilename = wp + "no data.pdf";
		pdfProcessor.pdfReader6(pdfFilename);
	}
	@Test
	public void test39() 
	{
		// fp: Test method pdfFieldReader7.
		String pdfFilename = wp + "no data.pdf";
		pdfProcessor.pdfReader7(pdfFilename);
	}
	@Test
	public void test40() 
	{
		// fp: Verify anew/again (double validation) that I can't read Alan's pdf file with iText2. Test count of pdfReader7.
		String pdfFilename = wp + "no data.pdf";
		assertEquals(1610406, pdfProcessor.pdfReader7(pdfFilename));
	}
	@Test
	public void test41() 
	{
		// fp: Test a file that should have records.
		String pdfFilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf";
		assertEquals(15235, pdfProcessor.pdfReader7(pdfFilename));
	}
	@Test
	public void test42() 
	{
		// fp: Test toolbox.
		// Outcome: "You need to choose a sourcefile.".
		String pdfFilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		inspectPDF.execute();
	}
	@Test
	public void test43() throws InstantiationException 
	{
		// fp: Test a file that should have records.
		// Outcome: "You need to choose a sourcefile.".
		String pdfFilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf";
		//FileArgument fileArgument = new FileArgument(null, pdfFilename, pdfFilename, false);
		InspectPDF inspectPDF = new InspectPDF();
		//ArrayList<String> elements = new ArrayList<>();
		//String stringArgument = new StringArgument(null, "test", pdfFilename, pdfFilename);
		//elements.add(pdfFilename);
		//elements.add(null);
		//StringArgument stringArgument = new StringArgument();
		//StringArgument stringArgument = (StringArgument) password;
		//stringArgument = "";
		//elements.add(stringArgument.toString());
		//inspectPDF.setArguments(elements); 
		//inspectPDF.getValue(pdfFilename);
		inspectPDF.execute();
		//assertEquals(15235, pdfProcessor.pdfReader7(pdfFilename));
	}
	@Test
	public void test44() throws InstantiationException 
	{
		// fp: Get inspectPdf to work.
		// Outcome: "You need to choose a sourcefile.".
		String pdfFilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		inspectPDF.getValue(pdfFilename);
		inspectPDF.execute();
	}
	@Test
	public void test45() throws InstantiationException 
	{
		// fp: Get inspectPdf to work.
		// Outcome: This works!
		String pdfFilename = wp + "Interactive Form Version 4 - Edited and Saved.pdf";
		FileArgument fileArgument = new FileArgument(null, pdfFilename, pdfFilename, false);
		InspectPDF inspectPDF = new InspectPDF();
		String[] toppings = new String[2];
		toppings[0] = pdfFilename;
		inspectPDF.setMainArguments(toppings);
		inspectPDF.execute();
	}
	@Test
	public void test46() 
	{
		// JRJ, Oct-14-2016 10:41 AM, WK-1. 
		// This is the latest.
		// fp: Refactor inspectPdf.
		// Outcome: It works!
		String pdfFilename = wp + "HelloWorld11.pdf";
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	@Test
	public void test47a() 
	{
		String pdfFilename = wp + "boilerplate.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test47b() 
	{
		String pdfFilename = wp + "boilerplate.pdf"; 
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test47c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "boilerplate.pdf"; 
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test47d() 
	{
		// fp: Inspect PDF.
		// fcd: Nov-18-2016
		String pdfFilename = wp + "boilerplate.pdf"; 
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	@Test
	public void test48a() 
	{
		String pdfFilename = wp + "boilerplate merge equals 1.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test48b() 
	{
		String pdfFilename = wp + "boilerplate merge equals 1.pdf"; 
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test48c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "boilerplate merge equals 1.pdf"; 
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test48d() 
	{
		// fp: Inspect PDF.
		// fcd: Nov-18-2016
		String pdfFilename = wp + "boilerplate merge equals 1.pdf"; 
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	@Test
	public void test49a() 
	{
		String pdfFilename = wp + "boilerplate merge equals 2.pdf"; 
		assertEquals(true, fileProcessor.isXfaForm(pdfFilename));
	}
	@Test
	public void test49b() 
	{
		String pdfFilename = wp + "boilerplate merge equals 2.pdf"; 
		pdfProcessor.pdfFieldReader5(pdfFilename);
	}
	@Test
	public void test49c() throws IOException, DocumentException 
	{
		String pdfFilename = wp + "boilerplate merge equals 2.pdf"; 
		assertEquals(0, pdfProcessor.countFields(pdfFilename));
	}
	@Test
	public void test49d() 
	{
		// fp: Inspect PDF.
		// fcd: Nov-18-2016
		String pdfFilename = wp + "boilerplate merge equals 2.pdf"; 
		InspectPDF inspectPDF = new InspectPDF();
		String[] args = new String[1];
		args[0] = pdfFilename;
		inspectPDF.setMainArguments(args);
		inspectPDF.execute();
	}
	

}
