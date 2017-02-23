package fileProcessor;

import org.junit.Test;

public class ForMikeTests 
{
	public static final String WORKSPACE_PATH_3 = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Public\\BFO\\";
	String wp = WORKSPACE_PATH_3;
	ForMike  forMike = new ForMike();

	@Test
	public void test1() 
	{
		// Function Purpose: Test the merge. 
		//    Creation Date: Sep-30-2016
		//          Outcome: Even though Merged.pdf is 4 KB bigger than 123 Template.pdf, it's looks identical to it.
		String templatePDFFilename = wp + "123 Template.pdf"; 
		String xmlDataFilename = wp + "Simple Test Data.xml";
		String codeGeneratedPdfFilename = wp + "Merged.pdf";
		forMike.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
	@Test
	public void test2() 
	{
		// Function Purpose: Test the merge with data. 
		//    Creation Date: Sep-30-2016
		//          Outcome: Same as test1.
		String templatePDFFilename = wp + "123 Template.pdf"; 
		String xmlDataFilename = wp + "Lots of Test Data.xml";
		String codeGeneratedPdfFilename = wp + "Merged2.pdf";
		forMike.createPdf(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
	}
}
