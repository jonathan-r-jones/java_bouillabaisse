package fileProcessor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

import org.faceless.pdf2.OutputProfile;
import org.faceless.pdf2.PDF;
import org.faceless.pdf2.PDFReader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class FileProcessor 
{

	public static final String WORKSPACE_PATH = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\NES\\Java Support\\";
	public static final String WORKSPACE_PATH_2 = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\NES\\Requirements\\";

	public Boolean fileExists(String fullFileName)
	{
		File file = new File(fullFileName);
		if(file.exists() && !file.isDirectory()) 
		{ 
			return true;
		}
		System.out.println("File not found.");
		return false;
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
	public Boolean xmlFileIsWellFormedAndValid(String xmlFilename, String xsdFilename)
	{
		if(!fileExists(xmlFilename))
		{
	    	System.out.println("\n **** XML file not found.");
			return false;
		}
		if(!fileExists(xsdFilename))
		{
	    	System.out.println("\n **** XSD file not found.");
			return false;
		}
	    try 
	    {
		    // Parse an XML document into a DOM tree.
	    	DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		    Document document = parser.parse(new File(xmlFilename));
		    // Create a SchemaFactory capable of understanding WXS schemas.
		    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		    // Load a WXS schema, represented by a Schema instance.
		    Source schemaFile = new StreamSource(new File(xsdFilename));
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
	public boolean isXfaForm(String pdfToTestFilename)
    {
		// Function Purpose: Determine which PDFs are XFA Forms. 
		// Creation Date: Sep-29-2016
        PDF pdf = null;
		try 
		{
            pdf = new PDF(new PDFReader(new File(pdfToTestFilename)));
        } 
		catch (Exception e) 
		{
			System.err.println(e.getClass()+"; "+e.getMessage());
		}
        return pdf.getBasicOutputProfile().isSet(OutputProfile.Feature.XFAForm);
    }
}
