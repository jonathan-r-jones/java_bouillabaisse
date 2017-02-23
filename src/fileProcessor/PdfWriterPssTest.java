package fileProcessor;

import org.junit.Test;

public class PdfWriterPssTest implements Outcome 
{
	PdfWriterPss pdfWriterPss = new PdfWriterPss();
	FileProcessor fileProcessor = new FileProcessor();
	String wp = FileProcessor.WORKSPACE_PATH;

	@Test
	public void test1() 
	{
		String pdfFilename = wp + "java generated pdf file - version 1.pdf";
		pdfWriterPss.writePDF1(pdfFilename);
	}
	@Test
	public void test2() 
	{
		String pdfFilename = wp + "java generated pdf file - version 2.pdf";
		pdfWriterPss.writePDF2(pdfFilename);
	}
	@Test
	public void test3() 
	{
		String pdfFilename = wp + "java generated pdf file - version 3.pdf";
		pdfWriterPss.writePDF3(pdfFilename);
	}
	@Test
	public void test4() 
	{
		String pdfFilename = wp + "java generated pdf file - version 4.pdf";
		pdfWriterPss.writePDF4(pdfFilename);
	}
	@Test
	public void test5() 
	{
		String pdfFilename = wp + "java generated pdf file - version 5.pdf";
		pdfWriterPss.writePDF5(pdfFilename);
	}
	@Test
	public void test6() 
	{
		String pdfFilename = wp + "java generated pdf file - version 5.pdf";
		pdfWriterPss.pdfFieldReader(pdfFilename);
	}
	@Test
	public void test7() 
	{
		String pdfFilename = wp + "java generated pdf file - version 1.pdf";
		pdfWriterPss.pdfFieldReader(pdfFilename);
	}
	@Test
	public void test8() 
	{
		String pdfFilename = wp + "no data.pdf";
		pdfWriterPss.pdfFieldReader(pdfFilename);
	}
	@Test
	public void test9() 
	{
		String pdfFilename = wp + "no data.pdf";
		pdfWriterPss.pdfFieldReader2(pdfFilename);
	}
	@Test
	public void test10() 
	{
		// This is the place in the code where I can see that the resultset is zero. The code I have is not properly reading the 
		// PDF. 
		// JRJ, Sep-29-2016 4:56 PM, WK-1.
		// This is the latest.
		String pdfFilename = wp + "data.pdf";
		pdfWriterPss.pdfFieldReader2(pdfFilename);
	}
}
