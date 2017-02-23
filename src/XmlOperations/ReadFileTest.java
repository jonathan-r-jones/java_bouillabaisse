package XmlOperations;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

public class ReadFileTest 
{
	ReadFile fileInQuestion = new ReadFile();
	@Test
	public void test() 
	{
		assertEquals(4, "Hell".length());
	}
	@Test
	public void test1() 
	{
		// Empty test methods evaluate as true.
	}
	@Test
	public void test2() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals("A", readFile.ReturnA());
	}
	@Test
	public void test3() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals(true, readFile.doesFileExistOld2());
	}
	@Test
	public void test4() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals(true, readFile.doesFileExistOld("c:\\!\\test"));
	}
	@Test
	public void test5() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals(false, readFile.fileExists("c:\\!\\test"));
	}
	@Test
	public void test6() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals(false, readFile.fileExists("c:\\!\\Helo World.txt"));
	}
	@Test
	public void test7() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals("H", readFile.getFirstCharacterInFile());
	}
	@Test
	public void test8() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals("H", readFile.getFirstCharacterInFileOld("c:\\!\\Helo World.txt"));
	}
	@Test
	public void doesFileExist() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals(true, readFile.fileExists("c:\\!\\Hello World - Copy.txt"));
	}
	@Test
	public void doesFileExist2() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals(true, readFile.fileExists("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\a.txt"));
	}
	@Test
	public void doesFileExist3() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals(true, readFile.fileExists("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\z.txt"));
	}
	@Test
	public void firstCharacterIsZ() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals("z", readFile.getFirstCharacterInFile2("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\z.txt"));
	}
	@Test
	public void firstCharacterIsZ2() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals("z", readFile.readFile2("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\z.txt"));
	}
	@Test
	public void firstCharacterIsA() 
	{
		ReadFile readFile = new ReadFile();
		assertEquals("a", readFile.readFile2("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\a.txt"));
	}
	@Test
	public void readFirstCharacterInFile() 
	{
		assertEquals("z", fileInQuestion.getFirstCharatcerInFile("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\z.txt"));
	}
	@Test
	public void readFirstCharacterInFile2() 
	{
		assertEquals("<", fileInQuestion.getFirstCharatcerInFile("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\menu.xml"));
	}
	@Test
	public void test17() throws ParserConfigurationException, SAXException, IOException 
	{
		//fileInQuestion.validateXmlFile();
	}
	@Test
	public void test18() throws ParserConfigurationException, SAXException, IOException 
	{
		fileInQuestion.validateXmlFile2();
	}
	@Test
	public void test19() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd"; 
		fileInQuestion.validateXmlFile3(fullXmlFilename, fullXsdFilename);
	}
	@Test
	public void test20() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy.xsd"; 
		fileInQuestion.validateXmlFile3(fullXmlFilename, fullXsdFilename);
	}
	@Test
	public void test21() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (2).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy.xsd"; 
		fileInQuestion.validateXmlFile3(fullXmlFilename, fullXsdFilename);
	}
	@Test
	public void test22() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (3).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy.xsd"; 
		fileInQuestion.validateXmlFile3(fullXmlFilename, fullXsdFilename);
	}
	@Test
	public void test23() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (3).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test24() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test25() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (4).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void xmlFileIsWellFormedAndValid() throws ParserConfigurationException, SAXException, IOException 
	{
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test28() throws ParserConfigurationException, SAXException, IOException 
	{
		//[Fatal Error] note%20-%20Copy%20(5).xml:1:20: A pseudo attribute name is expected. 
//		String fp = "<?xml version=1.0 encoding=UTF-8?> test";
//		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (5).xml"; 
//		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
//		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test29() throws ParserConfigurationException, SAXException, IOException 
	{
		String fp = "Rename note.xml test.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (6).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test30() throws ParserConfigurationException, SAXException, IOException 
	{
		String fp = "<?xml version=1.0 encoding=UTF-8?> test";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (7).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test31() throws ParserConfigurationException, SAXException, IOException 
	{
		String fp = "XML file not found test.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (x7).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test32() throws ParserConfigurationException, SAXException, IOException 
	{
		String fp = "XSD file not found test.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note - Copy (7).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\notex.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test33() throws ParserConfigurationException, SAXException, IOException 
	{
		String fp = "Reverse engineer.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data - Copy (2).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data - Copy (2).xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test34() throws ParserConfigurationException, SAXException, IOException 
	{
		String fp = "Reverse engineer 3.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 3.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 3.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test35() throws ParserConfigurationException, SAXException, IOException 
	{
		String fp = "Reverse engineer 4.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 4.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 4.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test36() 
	{
		String fp = "Get trace into console window.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 5.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 5.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test37() 
	{
		String fp = "RE6.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 6.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 6.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test38() 
	{
		String fp = "Missing XML content.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 7.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 7.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test39() 
	{
		String fp = "RE8. Working readguard action.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 8.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 8.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test40() 
	{
		String fp = "Look forward test.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 8.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test41() 
	{
		String fp = "Invalid XSD.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 9.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 9.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test42() 
	{
		String fp = "Failed RE10.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 10.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 10.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test43() 
	{
		String fp = "RE11.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 11.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 11.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test44() 
	{
		String fp = "RE12.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 12.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 12.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test45() 
	{
		String fp = "Look ahead 2.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 12.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test46() 
	{
		String fp = "Look ahead 2 data.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 12.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test47() 
	{
		String fp = "RE13.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 13.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 13.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test48() 
	{
		String fp = "RE14.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 14.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 14.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test49() 
	{
		String fp = "RE15.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 15.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 15.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test50() 
	{
		String fp = "RE16.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 16.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 16.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test51() 
	{
		String fp = "RE17. Successfully last lineage item of original thread.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 17.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 17.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test52() 
	{
		String fp = "Look ahead 1.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 17.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test53() 
	{
		String fp = "Look ahead 2 data.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data 17.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test54()
	{
		String fp = "Test simple data format.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\data 18.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\18.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test55()
	{
		String fp = "19. The moment you add a second serial list, schema validation will fail.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\data 19.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\18.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test56()
	{
		String fp = "20. Misnomer accommodation fail.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\20 data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\20.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test57()
	{
		String fp = "21. Persons reboot.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\21.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\21.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test58()
	{
		String fp = "22. Multiple serials.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\22.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\22.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test59()
	{
		String fp = "23. Rename.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\23.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\23.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test60()
	{
		String fp = "24. Add Government tag.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\24.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\24.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test61()
	{
		String fp = "25. Add doc tag.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\25.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\25.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test62()
	{
		String fp = "26. Add lists tag to partial data document.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\26 data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\25.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test63()
	{
		String fp = "27. Add lists tag to bigger partial data document.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\0 - modified data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\25.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test64()
	{
//		String fp = "29. Use small data file.";
//		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\29.xml"; 
//		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\29.xsd";
//		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test65()
	{
		String fp = "29. Incomplete data message.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\29.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\29.xsd";
		assertEquals(false, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test66()
	{
		String fp = "30. Get nos working.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\30.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\30.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test67()
	{
		String fp = "31. Get multiple nos working. maxOccurs=\"unbounded\" works! (and is necessary." ;
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\31.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\31.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test68()
	{
		String fp = "32. Do a complete document.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\32.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\32.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test69()
	{
		String fp = "33. Look ahead to a complete document.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\33.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\33.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test70()
	{
		String fp = "34. Are outer lists necessary now that I know to use unbounded.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\34.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test71()
	{
		String fp = "35. Verify no data.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\34.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test72()
	{
		String fp = "36. Works with no data.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\works with data and no data xml files.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test73()
	{
		String fp = "36. Works with data.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\data.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\works with data and no data xml files.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test74()
	{
		String fp = "Validate disposable xml file.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data - Copy (3).xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\works with data and no data xml files.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test75()
	{
		String fp = "Validate qdata xml file.";
		String fullXmlFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\qdata.xml"; 
		String fullXsdFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\works with data and no data xml files.xsd";
		assertEquals(true, fileInQuestion.xmlFileIsWellFormedAndValid(fullXmlFilename, fullXsdFilename));
	}
	@Test
	public void test76()
	{
		// fp = "Verify existence of disposable PDF file.";
		String fullPdfFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data - Copy.pdf"; 
		assertEquals(true, fileInQuestion.fileExists(fullPdfFilename));
	}
	@Test
	public void test78()
	{
		// fp = "Test fail.";
		//fail("Hey");
	}
	@Test
	@Ignore
	public void test77()
	{
		// fp = "Run merge and see if a new file is created.";
		String xmlDataFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\qdata.xml"; 
		String pdfTemplateFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data - Copy.pdf";
		MergeFile mergeFile = new MergeFile();
		mergeFile.createPdf(pdfTemplateFilename, xmlDataFilename);
	}
	@Test
	@Ignore
	public void test79()
	{
		// fp = "Run merge and see if a new file is created.";
		String pdfTemplateFilename = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\no data - Copy.pdf";
		MergeFile mergeFile = new MergeFile();
		mergeFile.createPdf(pdfTemplateFilename);
	}
}
