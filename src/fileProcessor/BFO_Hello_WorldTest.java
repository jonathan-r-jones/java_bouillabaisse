package fileProcessor;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class BFO_Hello_WorldTest 
{
	
	FileProcessor fileProcessor = new FileProcessor();
	PdfWriterPss pdfWriterPss = new PdfWriterPss();
	String wp = FileProcessor.WORKSPACE_PATH;
	XmlWriter xmlWriter = new XmlWriter();
	
	@Test
	public void test1()  
	{
		BFO_Hello_World.test1();
	}
	@Test
	public void validateFileExists() 
	{
		assertEquals(true, fileProcessor.fileExists(wp + "a.txt"));
	}
	@Test
	public void validateFileExists2() 
	{
		assertEquals(true, fileProcessor.fileExists(wp + "HelloWorld.xml"));
	}
	@Test
	public void test3() 
	{
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "HelloWorld3.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
	@Test
	public void test4() 
	{
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "Colors.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
	@Test
	public void test5() 
	{
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "FormFill2.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
	@Test
	public void test6() 
	{
		// fp = "Try to fill out my form in a crude way.";
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "form_fill_no_data.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
	@Test
	public void test7() 
	{
		// fp = "Use HelloWorld3 as the background PDF.";
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "FormFill3.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
	@Test
	public void test8() 
	{
		// fp = "Try no_data.pdf as a background.";
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "FormFill8.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
	@Test
	public void test9() 
	{
		// fp = "Try no_data.pdf as a background.";
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "FormFill9.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
	@Test
	public void test10() 
	{
		// Function Purpose: Try to create an XFA form. 
		//	  Creation Date: Sep-28-2016
		//	        Outcome:
		//	  	 Conclusion:
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "FormFill9.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
	@Test
	public void test11() 
	{
		// Function Purpose: Validate that HelloWorld.pdf is NOT an XFA form. 
		//	  Creation Date: Sep-29-2016
		//	        Outcome:
		//	  	 Conclusion:
		try 
		{
			BFO_Hello_World.mainDuplicate(wp + "HelloWorld11.xml");
		} 
		catch (SAXException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ - " + e);
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println("JRJ2 - " + e);
			e.printStackTrace();
		}
	}
}
