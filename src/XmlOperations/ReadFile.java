package XmlOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ReadFile 
{
	public String ReturnA()
	{
		return "A";
	}
	public Boolean doesFileExistOld2()
	{
		return true;
	}
	public Boolean doesFileExistOld(String fileName)
	{
		return true;
	}
	public Boolean fileExists(String fullFileName)
	{
		File file = new File(fullFileName);
		if(file.exists() && !file.isDirectory()) 
		{ 
			return true;
		}
		return false;
	}
	private List<String> readFile(String filename)
	{
	  List<String> records = new ArrayList<String>();
	  try
	  {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	      records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	public String getFirstCharacterInFile()
	{
		return "H";
	}
	public String getFirstCharacterInFileOld(String fullFileName)
	{
		return "H";
	}
	public String getFirstCharacterInFile2(String fullFileName)
	{
		return "z";
	}
	public String getFirstCharacterInFile3(String fullFileName)
	{
		if(!fileExists(fullFileName))
		{
			return "File not foound.";
		}
		return "z";
	}
	public void ReadFile3() throws Exception
	{
	    // Declare variables corresponding to names of i/o files
	    String oldFilename = "";
	    String newFilename = "";

	    // Console input of i/o filenames
	    BufferedReader bufferedReader;
	    bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	    System.out.println("What is the input text? Include path and .txt extension) ");
	    oldFilename = bufferedReader.readLine();
	    System.out.print(oldFilename);

	    System.out.println("What is the output text? Include path and .txt extension) ");
	    newFilename = bufferedReader.readLine();
	    System.out.print(newFilename);

	    bufferedReader.close();

	    // Read text from old file,     
	    BufferedReader fin;
	    fin = new BufferedReader(new FileReader(oldFilename));

	    while (fin.ready())
	    {
	      String lineFromFile;
	      lineFromFile = fin.readLine();
	      System.out.println(lineFromFile);

	      if (lineFromFile.charAt(0) != '>' || lineFromFile.charAt(0) != '+')
	      {
	        PrintWriter fout;
	        fout = new PrintWriter(new FileWriter(newFilename));
	        fout.println('#' + lineFromFile);
	        fout.close();
	      }
	    } // while
	    fin.close();
	    System.out.print("Text processing complete.");
	}
	String readFile2(String filename)
	{
	  String record = new String();
	  try
	  {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    line = reader.readLine();
	    reader.close();
	    return line;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	public String getFirstCharatcerInFile(String filename)
	{
	  try
	  {
	    BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
	    String line;
	    line = bufferedReader.readLine();
	    bufferedReader.close();
	    return line.substring(0, 1);
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	public void validateXmlFile() throws ParserConfigurationException, SAXException, IOException
	{
	    // parse an XML document into a DOM tree
	    DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    Document document = parser.parse(new File("instance.xml"));

	    // create a SchemaFactory capable of understanding WXS schemas
	    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	    // load a WXS schema, represented by a Schema instance
	    Source schemaFile = new StreamSource(new File("mySchema.xsd"));
	    Schema schema = factory.newSchema(schemaFile);

	    // create a Validator instance, which can be used to validate an instance document
	    Validator validator = schema.newValidator();

	    // validate the DOM tree
	    try 
	    {
	        validator.validate(new DOMSource(document));
	    }
	    catch (SAXException e) 
	    {
	        // instance document is invalid!
	    }
	}
	public void validateXmlFile2() throws ParserConfigurationException, SAXException, IOException
	{
	    // parse an XML document into a DOM tree
	    DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    Document document = parser.parse(new File("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xml"));

	    // create a SchemaFactory capable of understanding WXS schemas
	    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	    // load a WXS schema, represented by a Schema instance
	    Source schemaFile = new StreamSource(new File("C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\Java\\note.xsd"));
	    Schema schema = factory.newSchema(schemaFile);

	    // create a Validator instance, which can be used to validate an instance document
	    Validator validator = schema.newValidator();

	    // validate the DOM tree
	    try 
	    {
	        validator.validate(new DOMSource(document));
	    }
	    catch (SAXException e) 
	    {
	        // instance document is invalid!
	    }
	}
	public void validateXmlFile3(String fulXmlFilename, String fulXsdFilename) throws ParserConfigurationException, SAXException, IOException
	{
	    // parse an XML document into a DOM tree
	    DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    Document document = parser.parse(new File(fulXmlFilename));

	    // create a SchemaFactory capable of understanding WXS schemas
	    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	    // load a WXS schema, represented by a Schema instance
	    Source schemaFile = new StreamSource(new File(fulXsdFilename));
	    Schema schema = factory.newSchema(schemaFile);

	    // create a Validator instance, which can be used to validate an instance document
	    Validator validator = schema.newValidator();

	    // validate the DOM tree
	    try 
	    {
	        validator.validate(new DOMSource(document));
	    }
	    catch (SAXException saxException) 
	    {
	        // instance document is invalid!
	    }
	}
	public Boolean xmlFileIsWellFormedAndValid(String fullXmlFilename, String fullXsdFilename)
	{
		if(!fileExists(fullXmlFilename))
		{
	    	System.out.println("\n **** XML file not found.");
			return false;
		}
		if(!fileExists(fullXsdFilename))
		{
	    	System.out.println("\n **** XSD file not found.");
			return false;
		}
	    try 
	    {
		    // Parse an XML document into a DOM tree.
	    	DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    Document document = parser.parse(new File(fullXmlFilename));
		    // Create a SchemaFactory capable of understanding WXS schemas.
		    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		    // Load a WXS schema, represented by a Schema instance.
		    Source schemaFile = new StreamSource(new File(fullXsdFilename));
		    Schema schema = factory.newSchema(schemaFile);
		    // Create a Validator instance, which can be used to validate an instance document.
		    Validator validator = schema.newValidator();
		    // Validate the DOM tree.
	        validator.validate(new DOMSource(document));
	    }
	    catch (ParserConfigurationException exception) 
	    {
	    	System.out.println("\n **** The XML document is invalid (ParserConfigurationException).");
	    	System.out.println(exception.getMessage());
			return false;
	    }
	    catch (IOException exception) 
	    {
	    	System.out.println("\n **** The XML document is invalid (IOException).");
	    	System.out.println(exception.getMessage());
			return false;
	    }
	    catch (SAXParseException saxParseException) 
	    {
	    	System.out.println("\n **** The XML document is invalid (SAXParseException).");
	    	System.out.println(saxParseException.getMessage());
			return false;
	    }
	    catch (SAXException saxException) 
	    {
	    	System.out.println("\n **** An (XSD?) document is invalid. (SAXException)");
	    	System.out.println(saxException.getMessage());
			return false;
	    }
		return true;
	}
}
