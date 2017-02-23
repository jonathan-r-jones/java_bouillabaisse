package pdfAndXmlMerger;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.faceless.pdf2.PDF;
import org.faceless.pdf2.PDFReader;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import xmlOperations2.WriteXMLFile;

public class PdfAndXmlMerger
{

String data_path = "C:\\Users\\jonathan.r.jones\\Documents\\Dropbox\\NES\\Eclipse Workspace\\$UnderDevelopment\\src\\pdfAndXmlMerger\\Test Data\\";

public void createPdf3(String templatePDFFilename, String xmlDataFilename, String codeGeneratedPdfFilename)
{
	// Function Purpose: Refactor Alan's method to use my standards and for my understanding.
	// Creation Date: Sep-29-2016
	PDF pdf = null;
	BufferedReader bufferedReader = null;
	try
	{
		pdf = new PDF(new PDFReader(new File(templatePDFFilename)));
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xmlDataFilename))));
		StringBuffer stringBuffer = new StringBuffer();
		String xmlFileString = null;
		while ((xmlFileString = bufferedReader.readLine()) != null)
		{
			stringBuffer.append(xmlFileString);
		}
		bufferedReader.close();
		System.out.println(stringBuffer.toString());

		pdf.getForm().setXFADatasets(stringBuffer.toString());

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		pdf.render(byteArrayOutputStream);
		byteArrayOutputStream.flush();
		pdf.render(new FileOutputStream(new File(codeGeneratedPdfFilename)));
	}
	catch(Exception exception)
	{
		System.err.println(exception.getClass() + ": " + exception.getMessage());
	}
}
public void createPdf4(String templatePDFFilename, String xmlDataFilename, String codeGeneratedPdfFilename)
{
	// Function Purpose: Uses createPdf3 but also adds the XFA tags if necessary.  
	// Creation Date: Nov-22-2016
	addXfaTags2(xmlDataFilename);
	createPdf3(templatePDFFilename, xmlDataFilename, codeGeneratedPdfFilename);
}
public static void addXfaTags2(String xmlFilename)
{
	Path path = Paths.get(xmlFilename);
	Charset charset = StandardCharsets.UTF_8;

	String content = null;
	try
	{
		content = new String(Files.readAllBytes(path), charset);
	}
	catch(IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// Disallow a repeat operation.
	if (!content.contains("xfa:datasets"))
	{
		String oldString = "<GovernmentProperty>";
		String newString = "\n<xfa:datasets xmlns:xfa=\"http://www.xfa.org/schema/xfa-data/1.0/\">";
		newString += "\n<xfa:data>";
		newString += "\n<GovernmentProperty>";
		content = content.replaceAll(oldString, newString);

		oldString = "</GovernmentProperty>";
		newString = "\n</GovernmentProperty>";
		newString += "\n</xfa:data>";
		newString += "\n</xfa:datasets>";
		content = content.replaceAll(oldString, newString);
	}

	try
	{
		Files.write(path, content.getBytes(charset));
	}
	catch(IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void writeFullyPopulatedValidateableXMLFile(String xmlDataFilename)
{
	try
	{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document document = docBuilder.newDocument();

		// This section is for the validateable document.
		Element governmentPropertyElement = document.createElement("GovernmentProperty");
		document.appendChild(governmentPropertyElement);

		Element documentInformationElement = document.createElement("DocumentInformation");
		governmentPropertyElement.appendChild(documentInformationElement);

		String xmlValue = "";
		String databaseValue = "";

		Element element1 = document.createElement("AttachmentNumber");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "99999";
		}
		documentInformationElement.appendChild(element1);
		element1.appendChild(document.createTextNode(xmlValue));

		Element element2 = document.createElement("AttachmentFileNumber");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		documentInformationElement.appendChild(element2);
		element2.appendChild(document.createTextNode(xmlValue));

		Element element3 = document.createElement("AttachmentFileTotalNumber");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		documentInformationElement.appendChild(element3);
		element3.appendChild(document.createTextNode(xmlValue));

		Element element4 = document.createElement("AttachmentDate");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String todaysDate = dateFormat.format(date);
		documentInformationElement.appendChild(element4);
		element4.appendChild(document.createTextNode(todaysDate));

		Element contractingOfficerNameElement = document.createElement("ContractingOfficerName");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter name.";
		}
		documentInformationElement.appendChild(contractingOfficerNameElement);
		contractingOfficerNameElement.appendChild(document.createTextNode(xmlValue));

		Element element5 = document.createElement("ContractingOfficerEmailAddress");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter@email.address";
		}
		documentInformationElement.appendChild(element5);
		element5.appendChild(document.createTextNode(xmlValue));

		Element element6 = document.createElement("ContractingOfficerTelephoneNumber");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter phone number.";
		}
		documentInformationElement.appendChild(element6);
		element6.appendChild(document.createTextNode(xmlValue));

		Element element7 = document.createElement("ProcurementInstrument");
		documentInformationElement.appendChild(element7);

		Element element10 = document.createElement("DocumentDescription");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Document description.";
		}
		element7.appendChild(element10);
		element10.appendChild(document.createTextNode(xmlValue));

		Element element11 = document.createElement("ProcurementInstrumentModificationNumber6");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "99999";
		}
		element7.appendChild(element11);
		element11.appendChild(document.createTextNode(xmlValue));

		Element element12 = document.createElement("AmendmentNumber");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "9999";
		}
		element7.appendChild(element12);
		element12.appendChild(document.createTextNode(xmlValue));

		Element element13 = document.createElement("ReferenceProcurementInstrument");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter reference procurement instrument.";
		}
		element7.appendChild(element13);
		element13.appendChild(document.createTextNode(xmlValue));

		Element element14 = document.createElement("ProcurementInstrumentNumber");
		documentInformationElement.appendChild(element14);

		Element element15 = document.createElement("ActivityAddressCode");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "999999";
		}
		element14.appendChild(element15);
		element15.appendChild(document.createTextNode(xmlValue));

		Element element16 = document.createElement("Year");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "14";
		}
		element14.appendChild(element16);
		element16.appendChild(document.createTextNode(xmlValue));

		Element element17 = document.createElement("ProcurementInstrumentTypeCode");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "V";
		}
		element14.appendChild(element17);
		element17.appendChild(document.createTextNode(xmlValue));

		Element element18 = document.createElement("SerializedIdentifier");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "9999";
		}
		element14.appendChild(element18);
		element18.appendChild(document.createTextNode(xmlValue));

		Element element19 = document.createElement("ProcurementInstrumentOrderNumber");
		documentInformationElement.appendChild(element19);

		Element element20 = document.createElement("OrderNumber13");
		element19.appendChild(element20);

		Element element21 = document.createElement("ActivityAddressCode");
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "999999";
		}
		element20.appendChild(element21);
		element21.appendChild(document.createTextNode(xmlValue));

		Element element22 = document.createElement("Year");
		element20.appendChild(element22);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "17";
		}
		element22.appendChild(document.createTextNode(xmlValue));

		Element element23 = document.createElement("ProcurementInstrumentTypeCode");
		element20.appendChild(element23);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "V";
		}
		element23.appendChild(document.createTextNode(xmlValue));

		Element element24 = document.createElement("SerializedIdentifier");
		element20.appendChild(element24);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "9999";
		}
		element24.appendChild(document.createTextNode(xmlValue));

		Element element25 = document.createElement("OrderNumber4");
		documentInformationElement.appendChild(element25);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "9999";
		}
		element25.appendChild(document.createTextNode(xmlValue));

		// ******************* Begin Large Section
		Element element26 = document.createElement("SeriallyManagedItemsList");
		governmentPropertyElement.appendChild(element26);

		Element element27 = document.createElement("LineNumber");
		element26.appendChild(element27);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element27.appendChild(document.createTextNode(xmlValue));

		Element element28 = document.createElement("ItemName");
		element26.appendChild(element28);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter item name.";
		}
		element28.appendChild(document.createTextNode(xmlValue));

		Element element29 = document.createElement("ItemDescription");
		element26.appendChild(element29);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter item description.";
		}
		element29.appendChild(document.createTextNode(xmlValue));

		Element element30 = document.createElement("NationalStockNumber");
		element26.appendChild(element30);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1234567890123";
		}
		element30.appendChild(document.createTextNode(xmlValue));

		Element element31 = document.createElement("ManufacturerCAGE");
		element26.appendChild(element31);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "CAGE1";
		}
		element31.appendChild(document.createTextNode(xmlValue));

		Element element32 = document.createElement("PartNumber");
		element26.appendChild(element32);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter part number.";
		}
		element32.appendChild(document.createTextNode(xmlValue));

		Element element33 = document.createElement("ModelNumber");
		element26.appendChild(element33);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter model number.";
		}
		element33.appendChild(document.createTextNode(xmlValue));

		Element element34 = document.createElement("SerialNumber");
		element26.appendChild(element34);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter serial number.";
		}
		element34.appendChild(document.createTextNode(xmlValue));

		Element element35 = document.createElement("UniqueItemIdentifier");
		element26.appendChild(element35);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter uid.";
		}
		element35.appendChild(document.createTextNode(xmlValue));

		Element element36 = document.createElement("Quantity");
		element26.appendChild(element36);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element36.appendChild(document.createTextNode(xmlValue));

		Element element37 = document.createElement("UnitOfMeasure");
		element26.appendChild(element37);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "10 Kilogram Drum";
		}
		element37.appendChild(document.createTextNode(xmlValue));

		Element element38 = document.createElement("UnitAcquisitionCost");
		element26.appendChild(element38);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element38.appendChild(document.createTextNode(xmlValue));

		Element element39 = document.createElement("UseAsIs");
		element26.appendChild(element39);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "True";
		}
		element39.appendChild(document.createTextNode(xmlValue));

		Element element40 = document.createElement("OnOrBeforeDate");
		element26.appendChild(element40);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = todaysDate;
		}
		element40.appendChild(document.createTextNode(xmlValue));

		Element element41 = document.createElement("Duration");
		element26.appendChild(element41);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element41.appendChild(document.createTextNode(xmlValue));

		Element element42 = document.createElement("TimeUnit");
		element26.appendChild(element42);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Months";
		}
		element42.appendChild(document.createTextNode(xmlValue));

		Element element43 = document.createElement("DeliveryEvent");
		element26.appendChild(element43);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Award Date";
		}
		element43.appendChild(document.createTextNode(xmlValue));

		Element element44 = document.createElement("Notes");
		element26.appendChild(element44);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter notes here.";
		}
		element44.appendChild(document.createTextNode(xmlValue));

		// ******************* Begin Large Section - This should be a for loop.
		Element element45 = document.createElement("NonSeriallyManagedItemsList");
		governmentPropertyElement.appendChild(element45);

		Element element46 = document.createElement("LineNumber");
		element45.appendChild(element46);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element46.appendChild(document.createTextNode(xmlValue));

		Element element47 = document.createElement("ItemName");
		element45.appendChild(element47);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter item name.";
		}
		element47.appendChild(document.createTextNode(xmlValue));

		Element element48 = document.createElement("ItemDescription");
		element45.appendChild(element48);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter item description.";
		}
		element48.appendChild(document.createTextNode(xmlValue));

		Element element49 = document.createElement("NationalStockNumber");
		element45.appendChild(element49);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1234567890123";
		}
		element49.appendChild(document.createTextNode(xmlValue));

		Element element50 = document.createElement("ManufacturerCAGE");
		element45.appendChild(element50);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "CAGE1";
		}
		element50.appendChild(document.createTextNode(xmlValue));

		Element element51 = document.createElement("PartNumber");
		element45.appendChild(element51);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter part number.";
		}
		element51.appendChild(document.createTextNode(xmlValue));

		Element element52 = document.createElement("ModelNumber");
		element45.appendChild(element52);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter model number.";
		}
		element52.appendChild(document.createTextNode(xmlValue));

		Element element55 = document.createElement("Quantity");
		element45.appendChild(element55);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element55.appendChild(document.createTextNode(xmlValue));

		Element element56 = document.createElement("UnitOfMeasure");
		element45.appendChild(element56);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "100 Lineal Yards";
		}
		element56.appendChild(document.createTextNode(xmlValue));

		Element element57 = document.createElement("UnitAcquisitionCost");
		element45.appendChild(element57);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element57.appendChild(document.createTextNode(xmlValue));

		Element element58 = document.createElement("UseAsIs");
		element45.appendChild(element58);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "True";
		}
		element58.appendChild(document.createTextNode(xmlValue));

		Element element59 = document.createElement("OnOrBeforeDate");
		element45.appendChild(element59);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = todaysDate;
		}
		element59.appendChild(document.createTextNode(xmlValue));

		Element element60 = document.createElement("Duration");
		element45.appendChild(element60);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element60.appendChild(document.createTextNode(xmlValue));

		Element element61 = document.createElement("TimeUnit");
		element45.appendChild(element61);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Months";
		}
		element61.appendChild(document.createTextNode(xmlValue));

		Element element62 = document.createElement("DeliveryEvent");
		element45.appendChild(element62);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Award Date";
		}
		element62.appendChild(document.createTextNode(xmlValue));

		Element element63 = document.createElement("Notes");
		element45.appendChild(element63);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter notes here.";
		}
		element63.appendChild(document.createTextNode(xmlValue));

		// ******************* Begin Large Section
		Element element64 = document.createElement("RequisitionableList");
		governmentPropertyElement.appendChild(element64);

		Element element65 = document.createElement("RequisitionableItem");
		element64.appendChild(element65);

		Element element66 = document.createElement("LineNumber");
		element65.appendChild(element66);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element66.appendChild(document.createTextNode(xmlValue));

		Element element67 = document.createElement("ItemName");
		element65.appendChild(element67);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter item name.";
		}
		element67.appendChild(document.createTextNode(xmlValue));

		Element element68 = document.createElement("ItemDescription");
		element65.appendChild(element68);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter item description.";
		}
		element68.appendChild(document.createTextNode(xmlValue));

		Element element69 = document.createElement("NationalStockNumber");
		element65.appendChild(element69);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1234567890123";
		}
		element69.appendChild(document.createTextNode(xmlValue));

		Element element70 = document.createElement("ManufacturerCAGE");
		element65.appendChild(element70);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "CAGE1";
		}
		element70.appendChild(document.createTextNode(xmlValue));

		Element element71 = document.createElement("PartNumber");
		element65.appendChild(element71);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "Enter part number.";
		}
		element71.appendChild(document.createTextNode(xmlValue));

		Element element72 = document.createElement("Quantity");
		element65.appendChild(element72);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element72.appendChild(document.createTextNode(xmlValue));

		Element element73 = document.createElement("UnitOfMeasure");
		element65.appendChild(element73);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "100 Lineal Yards";
		}
		element73.appendChild(document.createTextNode(xmlValue));

		Element element74 = document.createElement("UnitAcquisitionCost");
		element65.appendChild(element74);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "1";
		}
		element74.appendChild(document.createTextNode(xmlValue));

		Element element75 = document.createElement("UseAsIs");
		element65.appendChild(element75);
		databaseValue = "";
		xmlValue = databaseValue;
		if (xmlValue == "")
		{
			xmlValue = "True";
		}
		element75.appendChild(document.createTextNode(xmlValue));

		// **** End XML generation.

		// Write the content into XML file.
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(xmlDataFilename));
		// Output to console for testing.
		// StreamResult result = new StreamResult(System.out);
		transformer.transform(source, result);
		System.out.println("File saved!");
	}
	catch(ParserConfigurationException pce)
	{
		pce.printStackTrace();
	}
	catch(TransformerException tfe)
	{
		tfe.printStackTrace();
	}
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
}}
