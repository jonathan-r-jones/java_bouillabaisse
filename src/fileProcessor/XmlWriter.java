package fileProcessor;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWriter 
{
	public static void writeXMLFile(String xmlDataFilename)
	{
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document ddocument = docBuilder.newDocument();
			Element rootElement = ddocument.createElement("GovernmentProperty");
			ddocument.appendChild(rootElement);

			Element documentInformationElement = ddocument.createElement("DocumentInformation");
			rootElement.appendChild(documentInformationElement);

			Element element1 = ddocument.createElement("AttachmentNumber");
			documentInformationElement.appendChild(element1);
			element1.appendChild(ddocument.createTextNode("x"));

			Element element2 = ddocument.createElement("AttachmentFileNumber");
			documentInformationElement.appendChild(element2);
			element2.appendChild(ddocument.createTextNode("x"));

			Element element3 = ddocument.createElement("AttachmentFileTotalNumber");
			documentInformationElement.appendChild(element3);
			element3.appendChild(ddocument.createTextNode("x"));

			Element element4 = ddocument.createElement("AttachmentDate");
			documentInformationElement.appendChild(element4);
			element4.appendChild(ddocument.createTextNode("x"));

			Element contractingOfficerNameElement = ddocument.createElement("ContractingOfficerName");
			documentInformationElement.appendChild(contractingOfficerNameElement);
			contractingOfficerNameElement.appendChild(ddocument.createTextNode("x"));

			Element element5 = ddocument.createElement("ContractingOfficerEmailAddress");
			documentInformationElement.appendChild(element5);
			element5.appendChild(ddocument.createTextNode("x"));

			Element element6 = ddocument.createElement("ContractingOfficerTelephoneNumber");
			documentInformationElement.appendChild(element6);
			element6.appendChild(ddocument.createTextNode("x"));

			Element element7 = ddocument.createElement("ProcurementInstrument");
			documentInformationElement.appendChild(element7);

			Element element10 = ddocument.createElement("DocumentDescription");
			element7.appendChild(element10);
			element10.appendChild(ddocument.createTextNode("x"));

			Element element11 = ddocument.createElement("ProcurementInstrumentModificationNumber6");
			element7.appendChild(element11);
			element11.appendChild(ddocument.createTextNode("x"));

			Element element12 = ddocument.createElement("AmendmentNumber");
			element7.appendChild(element12);
			element12.appendChild(ddocument.createTextNode("x"));

			Element element13 = ddocument.createElement("ReferenceProcurementInstrument");
			element7.appendChild(element13);
			element13.appendChild(ddocument.createTextNode("x"));

			Element element14 = ddocument.createElement("ProcurementInstrumentNumber");
			documentInformationElement.appendChild(element14);

			Element element15 = ddocument.createElement("ActivityAddressCode");
			element14.appendChild(element15);
			element15.appendChild(ddocument.createTextNode("x"));

			Element element16 = ddocument.createElement("Year");
			element14.appendChild(element16);
			element16.appendChild(ddocument.createTextNode("x"));

			Element element17 = ddocument.createElement("ProcurementInstrumentTypeCode");
			element14.appendChild(element17);
			element17.appendChild(ddocument.createTextNode("x"));

			Element element18 = ddocument.createElement("SerializedIdentifier");
			element14.appendChild(element18);
			element18.appendChild(ddocument.createTextNode("x"));

			Element element19 = ddocument.createElement("ProcurementInstrumentOrderNumber");
			documentInformationElement.appendChild(element19);

			Element element20 = ddocument.createElement("OrderNumber13");
			element19.appendChild(element20);

			Element element21 = ddocument.createElement("ActivityAddressCode");
			element20.appendChild(element21);
			element21.appendChild(ddocument.createTextNode("x"));

			Element element22 = ddocument.createElement("Year");
			element20.appendChild(element22);
			element22.appendChild(ddocument.createTextNode("x"));

			Element element23 = ddocument.createElement("ProcurementInstrumentTypeCode");
			element20.appendChild(element23);
			element23.appendChild(ddocument.createTextNode("x"));

			Element element24 = ddocument.createElement("SerializedIdentifier");
			element20.appendChild(element24);
			element24.appendChild(ddocument.createTextNode("x"));

			Element element25 = ddocument.createElement("OrderNumber4");
			documentInformationElement.appendChild(element25);
			element25.appendChild(ddocument.createTextNode("x"));

			
			
			// ******************* Begin Large Section
			Element element26 = ddocument.createElement("SeriallyManagedItemsList");
			rootElement.appendChild(element26);

			Element element27 = ddocument.createElement("LineNumber");
			element26.appendChild(element27);
			element27.appendChild(ddocument.createTextNode("x"));

			Element element28 = ddocument.createElement("ItemName");
			element26.appendChild(element28);
			element28.appendChild(ddocument.createTextNode("x"));

			Element element29 = ddocument.createElement("ItemDescription");
			element26.appendChild(element29);
			element29.appendChild(ddocument.createTextNode("x"));

			Element element30 = ddocument.createElement("NationalStockNumber");
			element26.appendChild(element30);
			element30.appendChild(ddocument.createTextNode("x"));

			Element element31 = ddocument.createElement("ManufacturerCAGE");
			element26.appendChild(element31);
			element31.appendChild(ddocument.createTextNode("x"));

			Element element32 = ddocument.createElement("PartNumber");
			element26.appendChild(element32);
			element32.appendChild(ddocument.createTextNode("x"));

			Element element33 = ddocument.createElement("ModelNumber");
			element26.appendChild(element33);
			element33.appendChild(ddocument.createTextNode("x"));

			Element element34 = ddocument.createElement("SerialNumber");
			element26.appendChild(element34);
			element34.appendChild(ddocument.createTextNode("x"));

			Element element35 = ddocument.createElement("UniqueItemIdentifier");
			element26.appendChild(element35);
			element35.appendChild(ddocument.createTextNode("x"));

			Element element36 = ddocument.createElement("Quantity");
			element26.appendChild(element36);
			element36.appendChild(ddocument.createTextNode("x"));

			Element element37 = ddocument.createElement("UnitOfMeasure");
			element26.appendChild(element37);
			element37.appendChild(ddocument.createTextNode("x"));

			Element element38 = ddocument.createElement("UnitAcquisitionCost");
			element26.appendChild(element38);
			element38.appendChild(ddocument.createTextNode("x"));

			Element element39 = ddocument.createElement("UseAsIs");
			element26.appendChild(element39);
			element39.appendChild(ddocument.createTextNode("x"));

			Element element40 = ddocument.createElement("OnOrBeforeDate");
			element26.appendChild(element40);
			element40.appendChild(ddocument.createTextNode("x"));

			Element element41 = ddocument.createElement("Duration");
			element26.appendChild(element41);
			element41.appendChild(ddocument.createTextNode("x"));

			Element element42 = ddocument.createElement("TimeUnit");
			element26.appendChild(element42);
			element42.appendChild(ddocument.createTextNode("x"));

			Element element43 = ddocument.createElement("DeliveryEvent");
			element26.appendChild(element43);
			element43.appendChild(ddocument.createTextNode("x"));

			Element element44 = ddocument.createElement("Notes");
			element26.appendChild(element44);
			element44.appendChild(ddocument.createTextNode("x"));

			
			
			// ******************* Begin Large Section
			Element element45 = ddocument.createElement("NonSeriallyManagedItemsList");
			rootElement.appendChild(element45);

			Element element46 = ddocument.createElement("LineNumber");
			element45.appendChild(element46);
			element46.appendChild(ddocument.createTextNode("x"));

			Element element47 = ddocument.createElement("ItemName");
			element45.appendChild(element47);
			element47.appendChild(ddocument.createTextNode("x"));

			Element element48 = ddocument.createElement("ItemDescription");
			element45.appendChild(element48);
			element48.appendChild(ddocument.createTextNode("x"));

			Element element49 = ddocument.createElement("NationalStockNumber");
			element45.appendChild(element49);
			element49.appendChild(ddocument.createTextNode("x"));

			Element element50 = ddocument.createElement("ManufacturerCAGE");
			element45.appendChild(element50);
			element50.appendChild(ddocument.createTextNode("x"));

			Element element51 = ddocument.createElement("PartNumber");
			element45.appendChild(element51);
			element51.appendChild(ddocument.createTextNode("x"));

			Element element52 = ddocument.createElement("ModelNumber");
			element45.appendChild(element52);
			element52.appendChild(ddocument.createTextNode("x"));

			Element element55 = ddocument.createElement("Quantity");
			element45.appendChild(element55);
			element55.appendChild(ddocument.createTextNode("x"));

			Element element56 = ddocument.createElement("UnitOfMeasure");
			element45.appendChild(element56);
			element56.appendChild(ddocument.createTextNode("x"));

			Element element57 = ddocument.createElement("UnitAcquisitionCost");
			element45.appendChild(element57);
			element57.appendChild(ddocument.createTextNode("x"));

			Element element58 = ddocument.createElement("UseAsIs");
			element45.appendChild(element58);
			element58.appendChild(ddocument.createTextNode("x"));

			Element element59 = ddocument.createElement("OnOrBeforeDate");
			element45.appendChild(element59);
			element59.appendChild(ddocument.createTextNode("x"));

			Element element60 = ddocument.createElement("Duration");
			element45.appendChild(element60);
			element60.appendChild(ddocument.createTextNode("x"));

			Element element61 = ddocument.createElement("TimeUnit");
			element45.appendChild(element61);
			element61.appendChild(ddocument.createTextNode("x"));

			Element element62 = ddocument.createElement("DeliveryEvent");
			element45.appendChild(element62);
			element62.appendChild(ddocument.createTextNode("x"));

			Element element63 = ddocument.createElement("Notes");
			element45.appendChild(element63);
			element63.appendChild(ddocument.createTextNode("x"));

			
			
			// ******************* Begin Large Section
			Element element64 = ddocument.createElement("RequisitionableList");
			rootElement.appendChild(element64);

			Element element65 = ddocument.createElement("RequisitionableItem");
			element64.appendChild(element65);

			Element element66 = ddocument.createElement("LineNumber");
			element65.appendChild(element66);
			element66.appendChild(ddocument.createTextNode("x"));

			Element element67 = ddocument.createElement("ItemName");
			element65.appendChild(element67);
			element67.appendChild(ddocument.createTextNode("x"));

			Element element68 = ddocument.createElement("ItemDescription");
			element65.appendChild(element68);
			element68.appendChild(ddocument.createTextNode("x"));

			Element element69 = ddocument.createElement("NationalStockNumber");
			element65.appendChild(element69);
			element69.appendChild(ddocument.createTextNode("x"));

			Element element70 = ddocument.createElement("ManufacturerCAGE");
			element65.appendChild(element70);
			element70.appendChild(ddocument.createTextNode("x"));

			Element element71 = ddocument.createElement("PartNumber");
			element65.appendChild(element71);
			element71.appendChild(ddocument.createTextNode("x"));

			Element element72 = ddocument.createElement("Quantity");
			element65.appendChild(element72);
			element72.appendChild(ddocument.createTextNode("x"));

			Element element73 = ddocument.createElement("UnitOfMeasure");
			element65.appendChild(element73);
			element73.appendChild(ddocument.createTextNode("x"));

			Element element74 = ddocument.createElement("UnitAcquisitionCost");
			element65.appendChild(element74);
			element74.appendChild(ddocument.createTextNode("x"));

			Element element75 = ddocument.createElement("UseAsIs");
			element65.appendChild(element75);
			element75.appendChild(ddocument.createTextNode("x"));
			
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
		catch (ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		catch (TransformerException tfe)
		{
			tfe.printStackTrace();
		}
	}
}
