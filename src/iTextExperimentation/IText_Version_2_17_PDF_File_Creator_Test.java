package iTextExperimentation;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import XmlOperations.ReadFile;

public class IText_Version_2_17_PDF_File_Creator_Test 
{
	IText_Version_2_17_PDF_File_Creator pdfFileInQuestion = new IText_Version_2_17_PDF_File_Creator();
	ReadFile readFile = new ReadFile();
	@Test
	public void test1()
	{
		// fp = "Validate that the backbone XML file exists.";
		String backboneXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data - Copy (3).xml"; 
		assertEquals(true, readFile.fileExists(backboneXmlFilename));
	}
	@Test
	@Ignore
	public void pdfFileExists() 
	{
		// fp = "Validate that the PDF file exists after we try to create it..";
		FileInputStream fileInputStream;
		try 
		{
			String backboneXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data - Copy (3).xml"; 
			fileInputStream = new FileInputStream(backboneXmlFilename);
			pdfFileInQuestion.createPdfOriginal(fileInputStream);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Write assert PDF file exists.
		//assertEquals(true, readFile.fileExists("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\a.txt"));
	}
}
