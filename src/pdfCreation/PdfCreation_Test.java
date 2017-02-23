package pdfCreation;

import org.junit.Test;

import XmlOperations.ReadFile;

public class PdfCreation_Test 
{
	ReadFile fileInQuestion = new ReadFile();
	PdfCreation pdfCreation = new PdfCreation();
	@Test
	public void test1() 
	{
		String pdfFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\java generated pdf file - version 1.pdf";
		pdfCreation.CreatePDF1(pdfFilename);
	}
}
