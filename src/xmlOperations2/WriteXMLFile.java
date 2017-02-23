package xmlOperations2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile
{
public static void writeXMLFileDemo()
{
	try
	{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("company");
		doc.appendChild(rootElement);
		// staff elements
		Element staff = doc.createElement("Staff");
		rootElement.appendChild(staff);
		// set attribute to staff element
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		staff.setAttributeNode(attr);
		// shorten way
		// staff.setAttribute("id", "1");
		// first name elements
		Element firstname = doc.createElement("firstname");
		firstname.appendChild(doc.createTextNode("yong"));
		staff.appendChild(firstname);
		// last name elements
		Element lastname = doc.createElement("lastname");
		lastname.appendChild(doc.createTextNode("mook kim"));
		staff.appendChild(lastname);
		// nickname elements
		Element nickname = doc.createElement("nickname");
		nickname.appendChild(doc.createTextNode("mkyong"));
		staff.appendChild(nickname);
		// salary elements
		Element salary = doc.createElement("salary");
		salary.appendChild(doc.createTextNode("100000"));
		staff.appendChild(salary);
		// write the content into XML file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\!\\file.xml"));
		// Output to console for testing
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
	/*
	 * 
	 * A new XML file is created in “C:\\file.xml“, with default UTF-8 encoded.
	 * Note:: For debugging, you can change the StreamResult to output the XML
	 * content to your console. StreamResult result = new
	 * StreamResult(System.out); transformer.transform(source, result);
	 * 
	 */
}
public static void writeXMLFile2(String xmlDataFilename)
{
	try
	{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("company");
		doc.appendChild(rootElement);
		// staff elements
		Element staff = doc.createElement("Staff");
		rootElement.appendChild(staff);
		// set attribute to staff element
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		staff.setAttributeNode(attr);
		// shorten way
		// staff.setAttribute("id", "1");
		// first name elements
		Element firstname = doc.createElement("firstname");
		firstname.appendChild(doc.createTextNode("yong"));
		staff.appendChild(firstname);
		// last name elements
		Element lastname = doc.createElement("lastname");
		lastname.appendChild(doc.createTextNode("mook kim"));
		staff.appendChild(lastname);
		// nickname elements
		Element nickname = doc.createElement("nickname");
		nickname.appendChild(doc.createTextNode("mkyong"));
		staff.appendChild(nickname);
		// salary elements
		Element salary = doc.createElement("salary");
		salary.appendChild(doc.createTextNode("100000"));
		staff.appendChild(salary);
		// write the content into XML file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(xmlDataFilename));
		// Output to console for testing
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
public static void writeXMLFile3(String xmlDataFilename)
{
	try
	{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("GovernmentProperty");
		doc.appendChild(rootElement);

		Element documentInformationElement = doc.createElement("DocumentInformation");
		rootElement.appendChild(documentInformationElement);

		Element contractingOfficerNameElement = doc.createElement("ContractingOfficerName");
		documentInformationElement.appendChild(contractingOfficerNameElement);

		contractingOfficerNameElement.appendChild(doc.createTextNode("q"));

		// contractingOfficerNameElement.setNodeValue("q");

		// Attr attr = doc.createAttribute("ContractingOfficerName");
		// attr.setValue("q");
		// documentInformationElement.setAttributeNode(attr);
		// shorten way
		// staff.setAttribute("id", "1");
		// first name elements
		// Element firstname = doc.createElement("firstname");
		// firstname.appendChild(doc.createTextNode("yong"));
		// staff.appendChild(firstname);
		// // last name elements
		// Element lastname = doc.createElement("lastname");
		// lastname.appendChild(doc.createTextNode("mook kim"));
		// staff.appendChild(lastname);
		// // nickname elements
		// Element nickname = doc.createElement("nickname");
		// nickname.appendChild(doc.createTextNode("mkyong"));
		// staff.appendChild(nickname);
		// // salary elements
		// Element salary = doc.createElement("salary");
		// salary.appendChild(doc.createTextNode("100000"));
		// staff.appendChild(salary);
		// write the content into XML file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(xmlDataFilename));
		// Output to console for testing
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
public static void writeXMLFile(String xmlDataFilename)
{
	try
	{
		String xmlValue = "y";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document ddocument = docBuilder.newDocument();
		Element rootElement = ddocument.createElement("GovernmentProperty");
		ddocument.appendChild(rootElement);

		Element documentInformationElement = ddocument.createElement("DocumentInformation");
		rootElement.appendChild(documentInformationElement);

		Element element1 = ddocument.createElement("AttachmentNumber");
		documentInformationElement.appendChild(element1);
		element1.appendChild(ddocument.createTextNode(xmlValue));

		Element element2 = ddocument.createElement("AttachmentFileNumber");
		documentInformationElement.appendChild(element2);
		element2.appendChild(ddocument.createTextNode(xmlValue));

		Element element3 = ddocument.createElement("AttachmentFileTotalNumber");
		documentInformationElement.appendChild(element3);
		element3.appendChild(ddocument.createTextNode(xmlValue));

		Element element4 = ddocument.createElement("AttachmentDate");
		documentInformationElement.appendChild(element4);
		element4.appendChild(ddocument.createTextNode(xmlValue));

		Element contractingOfficerNameElement = ddocument.createElement("ContractingOfficerName");
		documentInformationElement.appendChild(contractingOfficerNameElement);
		contractingOfficerNameElement.appendChild(ddocument.createTextNode(xmlValue));

		Element element5 = ddocument.createElement("ContractingOfficerEmailAddress");
		documentInformationElement.appendChild(element5);
		element5.appendChild(ddocument.createTextNode(xmlValue));

		Element element6 = ddocument.createElement("ContractingOfficerTelephoneNumber");
		documentInformationElement.appendChild(element6);
		element6.appendChild(ddocument.createTextNode(xmlValue));

		Element element7 = ddocument.createElement("ProcurementInstrument");
		documentInformationElement.appendChild(element7);

		Element element10 = ddocument.createElement("DocumentDescription");
		element7.appendChild(element10);
		element10.appendChild(ddocument.createTextNode(xmlValue));

		Element element11 = ddocument.createElement("ProcurementInstrumentModificationNumber6");
		element7.appendChild(element11);
		element11.appendChild(ddocument.createTextNode(xmlValue));

		Element element12 = ddocument.createElement("AmendmentNumber");
		element7.appendChild(element12);
		element12.appendChild(ddocument.createTextNode(xmlValue));

		Element element13 = ddocument.createElement("ReferenceProcurementInstrument");
		element7.appendChild(element13);
		element13.appendChild(ddocument.createTextNode(xmlValue));

		Element element14 = ddocument.createElement("ProcurementInstrumentNumber");
		documentInformationElement.appendChild(element14);

		Element element15 = ddocument.createElement("ActivityAddressCode");
		element14.appendChild(element15);
		element15.appendChild(ddocument.createTextNode(xmlValue));

		Element element16 = ddocument.createElement("Year");
		element14.appendChild(element16);
		element16.appendChild(ddocument.createTextNode(xmlValue));

		Element element17 = ddocument.createElement("ProcurementInstrumentTypeCode");
		element14.appendChild(element17);
		element17.appendChild(ddocument.createTextNode(xmlValue));

		Element element18 = ddocument.createElement("SerializedIdentifier");
		element14.appendChild(element18);
		element18.appendChild(ddocument.createTextNode(xmlValue));

		Element element19 = ddocument.createElement("ProcurementInstrumentOrderNumber");
		documentInformationElement.appendChild(element19);

		Element element20 = ddocument.createElement("OrderNumber13");
		element19.appendChild(element20);

		Element element21 = ddocument.createElement("ActivityAddressCode");
		element20.appendChild(element21);
		element21.appendChild(ddocument.createTextNode(xmlValue));

		Element element22 = ddocument.createElement("Year");
		element20.appendChild(element22);
		element22.appendChild(ddocument.createTextNode(xmlValue));

		Element element23 = ddocument.createElement("ProcurementInstrumentTypeCode");
		element20.appendChild(element23);
		element23.appendChild(ddocument.createTextNode(xmlValue));

		Element element24 = ddocument.createElement("SerializedIdentifier");
		element20.appendChild(element24);
		element24.appendChild(ddocument.createTextNode(xmlValue));

		Element element25 = ddocument.createElement("OrderNumber4");
		documentInformationElement.appendChild(element25);
		element25.appendChild(ddocument.createTextNode(xmlValue));

		// ******************* Begin Large Section
		Element element26 = ddocument.createElement("SeriallyManagedItemsList");
		rootElement.appendChild(element26);

		Element element27 = ddocument.createElement("LineNumber");
		element26.appendChild(element27);
		element27.appendChild(ddocument.createTextNode(xmlValue));

		Element element28 = ddocument.createElement("ItemName");
		element26.appendChild(element28);
		element28.appendChild(ddocument.createTextNode(xmlValue));

		Element element29 = ddocument.createElement("ItemDescription");
		element26.appendChild(element29);
		element29.appendChild(ddocument.createTextNode(xmlValue));

		Element element30 = ddocument.createElement("NationalStockNumber");
		element26.appendChild(element30);
		element30.appendChild(ddocument.createTextNode(xmlValue));

		Element element31 = ddocument.createElement("ManufacturerCAGE");
		element26.appendChild(element31);
		element31.appendChild(ddocument.createTextNode(xmlValue));

		Element element32 = ddocument.createElement("PartNumber");
		element26.appendChild(element32);
		element32.appendChild(ddocument.createTextNode(xmlValue));

		Element element33 = ddocument.createElement("ModelNumber");
		element26.appendChild(element33);
		element33.appendChild(ddocument.createTextNode(xmlValue));

		Element element34 = ddocument.createElement("SerialNumber");
		element26.appendChild(element34);
		element34.appendChild(ddocument.createTextNode(xmlValue));

		Element element35 = ddocument.createElement("UniqueItemIdentifier");
		element26.appendChild(element35);
		element35.appendChild(ddocument.createTextNode(xmlValue));

		Element element36 = ddocument.createElement("Quantity");
		element26.appendChild(element36);
		element36.appendChild(ddocument.createTextNode(xmlValue));

		Element element37 = ddocument.createElement("UnitOfMeasure");
		element26.appendChild(element37);
		element37.appendChild(ddocument.createTextNode(xmlValue));

		Element element38 = ddocument.createElement("UnitAcquisitionCost");
		element26.appendChild(element38);
		element38.appendChild(ddocument.createTextNode(xmlValue));

		Element element39 = ddocument.createElement("UseAsIs");
		element26.appendChild(element39);
		element39.appendChild(ddocument.createTextNode(xmlValue));

		Element element40 = ddocument.createElement("OnOrBeforeDate");
		element26.appendChild(element40);
		element40.appendChild(ddocument.createTextNode(xmlValue));

		Element element41 = ddocument.createElement("Duration");
		element26.appendChild(element41);
		element41.appendChild(ddocument.createTextNode(xmlValue));

		Element element42 = ddocument.createElement("TimeUnit");
		element26.appendChild(element42);
		element42.appendChild(ddocument.createTextNode(xmlValue));

		Element element43 = ddocument.createElement("DeliveryEvent");
		element26.appendChild(element43);
		element43.appendChild(ddocument.createTextNode(xmlValue));

		Element element44 = ddocument.createElement("Notes");
		element26.appendChild(element44);
		element44.appendChild(ddocument.createTextNode(xmlValue));

		// ******************* Begin Large Section
		Element element45 = ddocument.createElement("NonSeriallyManagedItemsList");
		rootElement.appendChild(element45);

		Element element46 = ddocument.createElement("LineNumber");
		element45.appendChild(element46);
		element46.appendChild(ddocument.createTextNode(xmlValue));

		Element element47 = ddocument.createElement("ItemName");
		element45.appendChild(element47);
		element47.appendChild(ddocument.createTextNode(xmlValue));

		Element element48 = ddocument.createElement("ItemDescription");
		element45.appendChild(element48);
		element48.appendChild(ddocument.createTextNode(xmlValue));

		Element element49 = ddocument.createElement("NationalStockNumber");
		element45.appendChild(element49);
		element49.appendChild(ddocument.createTextNode(xmlValue));

		Element element50 = ddocument.createElement("ManufacturerCAGE");
		element45.appendChild(element50);
		element50.appendChild(ddocument.createTextNode(xmlValue));

		Element element51 = ddocument.createElement("PartNumber");
		element45.appendChild(element51);
		element51.appendChild(ddocument.createTextNode(xmlValue));

		Element element52 = ddocument.createElement("ModelNumber");
		element45.appendChild(element52);
		element52.appendChild(ddocument.createTextNode(xmlValue));

		Element element55 = ddocument.createElement("Quantity");
		element45.appendChild(element55);
		element55.appendChild(ddocument.createTextNode(xmlValue));

		Element element56 = ddocument.createElement("UnitOfMeasure");
		element45.appendChild(element56);
		element56.appendChild(ddocument.createTextNode(xmlValue));

		Element element57 = ddocument.createElement("UnitAcquisitionCost");
		element45.appendChild(element57);
		element57.appendChild(ddocument.createTextNode(xmlValue));

		Element element58 = ddocument.createElement("UseAsIs");
		element45.appendChild(element58);
		element58.appendChild(ddocument.createTextNode(xmlValue));

		Element element59 = ddocument.createElement("OnOrBeforeDate");
		element45.appendChild(element59);
		element59.appendChild(ddocument.createTextNode(xmlValue));

		Element element60 = ddocument.createElement("Duration");
		element45.appendChild(element60);
		element60.appendChild(ddocument.createTextNode(xmlValue));

		Element element61 = ddocument.createElement("TimeUnit");
		element45.appendChild(element61);
		element61.appendChild(ddocument.createTextNode(xmlValue));

		Element element62 = ddocument.createElement("DeliveryEvent");
		element45.appendChild(element62);
		element62.appendChild(ddocument.createTextNode(xmlValue));

		Element element63 = ddocument.createElement("Notes");
		element45.appendChild(element63);
		element63.appendChild(ddocument.createTextNode(xmlValue));

		// ******************* Begin Large Section
		Element element64 = ddocument.createElement("RequisitionableList");
		rootElement.appendChild(element64);

		Element element65 = ddocument.createElement("RequisitionableItem");
		element64.appendChild(element65);

		Element element66 = ddocument.createElement("LineNumber");
		element65.appendChild(element66);
		element66.appendChild(ddocument.createTextNode(xmlValue));

		Element element67 = ddocument.createElement("ItemName");
		element65.appendChild(element67);
		element67.appendChild(ddocument.createTextNode(xmlValue));

		Element element68 = ddocument.createElement("ItemDescription");
		element65.appendChild(element68);
		element68.appendChild(ddocument.createTextNode(xmlValue));

		Element element69 = ddocument.createElement("NationalStockNumber");
		element65.appendChild(element69);
		element69.appendChild(ddocument.createTextNode(xmlValue));

		Element element70 = ddocument.createElement("ManufacturerCAGE");
		element65.appendChild(element70);
		element70.appendChild(ddocument.createTextNode(xmlValue));

		Element element71 = ddocument.createElement("PartNumber");
		element65.appendChild(element71);
		element71.appendChild(ddocument.createTextNode(xmlValue));

		Element element72 = ddocument.createElement("Quantity");
		element65.appendChild(element72);
		element72.appendChild(ddocument.createTextNode(xmlValue));

		Element element73 = ddocument.createElement("UnitOfMeasure");
		element65.appendChild(element73);
		element73.appendChild(ddocument.createTextNode(xmlValue));

		Element element74 = ddocument.createElement("UnitAcquisitionCost");
		element65.appendChild(element74);
		element74.appendChild(ddocument.createTextNode(xmlValue));

		Element element75 = ddocument.createElement("UseAsIs");
		element65.appendChild(element75);
		element75.appendChild(ddocument.createTextNode(xmlValue));

		// **** End XML generation.

		// Write the content into XML file.
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(ddocument);
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

public static void writeFullyPopulatedMergeableXMLFile(String xmlDataFilename)
{
	try
	{
		String xmlValue = "y";

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document document = docBuilder.newDocument();

		// This section is for the mergeable document.
		Element xfaDataset = document.createElement("xfa:datasets");
		xfaDataset.setAttribute("xmlns:xfa", "http://www.xfa.org/schema/xfa-data/1.0/");
		document.appendChild(xfaDataset);

		Element xfaData = document.createElement("xfa:data");
		xfaDataset.appendChild(xfaData);

		Element governmentPropertyElement = document.createElement("GovernmentProperty");
		xfaData.appendChild(governmentPropertyElement);

		Element elementb = document.createElement("DocumentInformation");
		governmentPropertyElement.appendChild(elementb);
		elementb.appendChild(document.createTextNode(xmlValue));

		Element element1 = document.createElement("AttachmentNumber");
		governmentPropertyElement.appendChild(element1);
		element1.appendChild(document.createTextNode(xmlValue));

		Element element2 = document.createElement("AttachmentFileNumber");
		governmentPropertyElement.appendChild(element2);
		element2.appendChild(document.createTextNode(xmlValue));

		Element element3 = document.createElement("AttachmentFileTotalNumber");
		governmentPropertyElement.appendChild(element3);
		element3.appendChild(document.createTextNode(xmlValue));

		Element element4 = document.createElement("AttachmentDate");
		governmentPropertyElement.appendChild(element4);
		element4.appendChild(document.createTextNode(xmlValue));

		Element contractingOfficerNameElement = document.createElement("ContractingOfficerName");
		governmentPropertyElement.appendChild(contractingOfficerNameElement);
		contractingOfficerNameElement.appendChild(document.createTextNode(xmlValue));

		Element element5 = document.createElement("ContractingOfficerEmailAddress");
		governmentPropertyElement.appendChild(element5);
		element5.appendChild(document.createTextNode(xmlValue));

		Element element6 = document.createElement("ContractingOfficerTelephoneNumber");
		governmentPropertyElement.appendChild(element6);
		element6.appendChild(document.createTextNode(xmlValue));

		Element element7 = document.createElement("ProcurementInstrument");
		governmentPropertyElement.appendChild(element7);

		Element element10 = document.createElement("DocumentDescription");
		element7.appendChild(element10);
		element10.appendChild(document.createTextNode(xmlValue));

		Element element11 = document.createElement("ProcurementInstrumentModificationNumber6");
		element7.appendChild(element11);
		element11.appendChild(document.createTextNode(xmlValue));

		Element element12 = document.createElement("AmendmentNumber");
		element7.appendChild(element12);
		element12.appendChild(document.createTextNode(xmlValue));

		Element element13 = document.createElement("ReferenceProcurementInstrument");
		element7.appendChild(element13);
		element13.appendChild(document.createTextNode(xmlValue));

		Element element14 = document.createElement("ProcurementInstrumentNumber");
		governmentPropertyElement.appendChild(element14);

		Element element15 = document.createElement("ActivityAddressCode");
		element14.appendChild(element15);
		element15.appendChild(document.createTextNode(xmlValue));

		Element element16 = document.createElement("Year");
		element14.appendChild(element16);
		element16.appendChild(document.createTextNode(xmlValue));

		Element element17 = document.createElement("ProcurementInstrumentTypeCode");
		element14.appendChild(element17);
		element17.appendChild(document.createTextNode(xmlValue));

		Element element18 = document.createElement("SerializedIdentifier");
		element14.appendChild(element18);
		element18.appendChild(document.createTextNode(xmlValue));

		Element element19 = document.createElement("ProcurementInstrumentOrderNumber");
		governmentPropertyElement.appendChild(element19);

		Element element20 = document.createElement("OrderNumber13");
		element19.appendChild(element20);

		Element element21 = document.createElement("ActivityAddressCode");
		element20.appendChild(element21);
		element21.appendChild(document.createTextNode(xmlValue));

		Element element22 = document.createElement("Year");
		element20.appendChild(element22);
		element22.appendChild(document.createTextNode(xmlValue));

		Element element23 = document.createElement("ProcurementInstrumentTypeCode");
		element20.appendChild(element23);
		element23.appendChild(document.createTextNode(xmlValue));

		Element element24 = document.createElement("SerializedIdentifier");
		element20.appendChild(element24);
		element24.appendChild(document.createTextNode(xmlValue));

		Element element25 = document.createElement("OrderNumber4");
		governmentPropertyElement.appendChild(element25);
		element25.appendChild(document.createTextNode(xmlValue));

		// ******************* Begin Large Section
		Element element26 = document.createElement("SeriallyManagedItemsList");
		xfaData.appendChild(element26);

		Element element27 = document.createElement("LineNumber");
		element26.appendChild(element27);
		element27.appendChild(document.createTextNode(xmlValue));

		Element element28 = document.createElement("ItemName");
		element26.appendChild(element28);
		element28.appendChild(document.createTextNode(xmlValue));

		Element element29 = document.createElement("ItemDescription");
		element26.appendChild(element29);
		element29.appendChild(document.createTextNode(xmlValue));

		Element element30 = document.createElement("NationalStockNumber");
		element26.appendChild(element30);
		element30.appendChild(document.createTextNode(xmlValue));

		Element element31 = document.createElement("ManufacturerCAGE");
		element26.appendChild(element31);
		element31.appendChild(document.createTextNode(xmlValue));

		Element element32 = document.createElement("PartNumber");
		element26.appendChild(element32);
		element32.appendChild(document.createTextNode(xmlValue));

		Element element33 = document.createElement("ModelNumber");
		element26.appendChild(element33);
		element33.appendChild(document.createTextNode(xmlValue));

		Element element34 = document.createElement("SerialNumber");
		element26.appendChild(element34);
		element34.appendChild(document.createTextNode(xmlValue));

		Element element35 = document.createElement("UniqueItemIdentifier");
		element26.appendChild(element35);
		element35.appendChild(document.createTextNode(xmlValue));

		Element element36 = document.createElement("Quantity");
		element26.appendChild(element36);
		element36.appendChild(document.createTextNode(xmlValue));

		Element element37 = document.createElement("UnitOfMeasure");
		element26.appendChild(element37);
		element37.appendChild(document.createTextNode(xmlValue));

		Element element38 = document.createElement("UnitAcquisitionCost");
		element26.appendChild(element38);
		element38.appendChild(document.createTextNode(xmlValue));

		Element element39 = document.createElement("UseAsIs");
		element26.appendChild(element39);
		element39.appendChild(document.createTextNode(xmlValue));

		Element element40 = document.createElement("OnOrBeforeDate");
		element26.appendChild(element40);
		element40.appendChild(document.createTextNode(xmlValue));

		Element element41 = document.createElement("Duration");
		element26.appendChild(element41);
		element41.appendChild(document.createTextNode(xmlValue));

		Element element42 = document.createElement("TimeUnit");
		element26.appendChild(element42);
		element42.appendChild(document.createTextNode(xmlValue));

		Element element43 = document.createElement("DeliveryEvent");
		element26.appendChild(element43);
		element43.appendChild(document.createTextNode(xmlValue));

		Element element44 = document.createElement("Notes");
		element26.appendChild(element44);
		element44.appendChild(document.createTextNode(xmlValue));

		// ******************* Begin Large Section
		Element element45 = document.createElement("NonSeriallyManagedItemsList");
		xfaData.appendChild(element45);

		Element element46 = document.createElement("LineNumber");
		element45.appendChild(element46);
		element46.appendChild(document.createTextNode(xmlValue));

		Element element47 = document.createElement("ItemName");
		element45.appendChild(element47);
		element47.appendChild(document.createTextNode(xmlValue));

		Element element48 = document.createElement("ItemDescription");
		element45.appendChild(element48);
		element48.appendChild(document.createTextNode(xmlValue));

		Element element49 = document.createElement("NationalStockNumber");
		element45.appendChild(element49);
		element49.appendChild(document.createTextNode(xmlValue));

		Element element50 = document.createElement("ManufacturerCAGE");
		element45.appendChild(element50);
		element50.appendChild(document.createTextNode(xmlValue));

		Element element51 = document.createElement("PartNumber");
		element45.appendChild(element51);
		element51.appendChild(document.createTextNode(xmlValue));

		Element element52 = document.createElement("ModelNumber");
		element45.appendChild(element52);
		element52.appendChild(document.createTextNode(xmlValue));

		Element element55 = document.createElement("Quantity");
		element45.appendChild(element55);
		element55.appendChild(document.createTextNode(xmlValue));

		Element element56 = document.createElement("UnitOfMeasure");
		element45.appendChild(element56);
		element56.appendChild(document.createTextNode(xmlValue));

		Element element57 = document.createElement("UnitAcquisitionCost");
		element45.appendChild(element57);
		element57.appendChild(document.createTextNode(xmlValue));

		Element element58 = document.createElement("UseAsIs");
		element45.appendChild(element58);
		element58.appendChild(document.createTextNode(xmlValue));

		Element element59 = document.createElement("OnOrBeforeDate");
		element45.appendChild(element59);
		element59.appendChild(document.createTextNode(xmlValue));

		Element element60 = document.createElement("Duration");
		element45.appendChild(element60);
		element60.appendChild(document.createTextNode(xmlValue));

		Element element61 = document.createElement("TimeUnit");
		element45.appendChild(element61);
		element61.appendChild(document.createTextNode(xmlValue));

		Element element62 = document.createElement("DeliveryEvent");
		element45.appendChild(element62);
		element62.appendChild(document.createTextNode(xmlValue));

		Element element63 = document.createElement("Notes");
		element45.appendChild(element63);
		element63.appendChild(document.createTextNode(xmlValue));

		// ******************* Begin Large Section
		Element element64 = document.createElement("RequisitionableList");
		xfaData.appendChild(element64);

		Element element65 = document.createElement("RequisitionableItem");
		element64.appendChild(element65);

		Element element66 = document.createElement("LineNumber");
		element65.appendChild(element66);
		element66.appendChild(document.createTextNode(xmlValue));

		Element element67 = document.createElement("ItemName");
		element65.appendChild(element67);
		element67.appendChild(document.createTextNode(xmlValue));

		Element element68 = document.createElement("ItemDescription");
		element65.appendChild(element68);
		element68.appendChild(document.createTextNode(xmlValue));

		Element element69 = document.createElement("NationalStockNumber");
		element65.appendChild(element69);
		element69.appendChild(document.createTextNode(xmlValue));

		Element element70 = document.createElement("ManufacturerCAGE");
		element65.appendChild(element70);
		element70.appendChild(document.createTextNode(xmlValue));

		Element element71 = document.createElement("PartNumber");
		element65.appendChild(element71);
		element71.appendChild(document.createTextNode(xmlValue));

		Element element72 = document.createElement("Quantity");
		element65.appendChild(element72);
		element72.appendChild(document.createTextNode(xmlValue));

		Element element73 = document.createElement("UnitOfMeasure");
		element65.appendChild(element73);
		element73.appendChild(document.createTextNode(xmlValue));

		Element element74 = document.createElement("UnitAcquisitionCost");
		element65.appendChild(element74);
		element74.appendChild(document.createTextNode(xmlValue));

		Element element75 = document.createElement("UseAsIs");
		element65.appendChild(element75);
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
public static void writeFullyPopulatedValidateableXMLFile(String xmlDataFilename)
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
public static void addXfaTags(String xmlFilename)
{
	String parts[];
	String name = "";
	String newString = "qq";
	try
	{
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(xmlFilename));
		String line = "";
		while ((line = bufferedReader.readLine()) != null)
		{
			System.out.println(line);
			parts = line.split("><");
			name = parts[0];
			if (!name.equals("GovernmentProperty"))
			{
				newString = newString + line + "\n"; // how to print the new line
			}

		}
		BufferedWriter eraserBufferedWriter = new BufferedWriter(new FileWriter("c:\\a\\j1.txt"));
		eraserBufferedWriter.write(newString);
		eraserBufferedWriter.close();

	}
	catch(IOException iOException)
	{
		System.out.println(iOException.getMessage());
	}

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
}