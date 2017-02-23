package fileProcessor;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.lowagie.text.Font;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

public class PdfWriterPss implements Outcome 
{
	private SharedUtilities sharedUtilities = new SharedUtilities();
	
	private Font titleFont = new Font(Font.TIMES_ROMAN, 30, Font.BOLD);
	private Font boldHeadingFont = new Font(Font.TIMES_ROMAN, 24, Font.BOLD);
	private Font normalFont = new Font(Font.TIMES_ROMAN, 16);

	public enum PageAlignment
	{
		LEFT,
		CENTER,
		RIGHT
	}
	
	public void writePDF1(String filename)
	{
		try 
		{
			Document document = new Document(PageSize.LEGAL.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			Paragraph paragraph = new Paragraph ("Government Furnished Property");
			document.add(paragraph);
			document.close();
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
	}
	public void writePDF2(String newPdfFilename)
	{
		try 
		{
			Document document = new Document(PageSize.LEGAL.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(newPdfFilename));
			document.open();

			DateFormat dateFormat = new SimpleDateFormat("MMM-d-yyyy HH:mm a");
			Date date = new Date();

			String documentGenerationTimestamp = "Document Generation Timestamp: " + dateFormat.format(date);

			Paragraph titleParagraph1 = new Paragraph(documentGenerationTimestamp, titleFont);
			titleParagraph1.setAlignment("ALIGN_CENTER");

			Paragraph titleParagraph = new Paragraph("Government Furnished Property", titleFont);
			titleParagraph.setAlignment("ALIGN_CENTER");

			document.add(titleParagraph1);
			document.add(titleParagraph);
			document.close();
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
	}
	public void writePDF3(String newPdfFilename)
	{
		try 
		{
			Document document = new Document(PageSize.LEGAL.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(newPdfFilename));
			document.open();

			document.add(generationTimestampParagraph());
			document.add(titleParagraph());
			document.add(governmentContractingOfficerParagraph());
			
			document.close();
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public Paragraph generationTimestampParagraph()
	{
		String documentGenerationTimestamp = "Document Generation Timestamp: " + sharedUtilities.GetTimestamp();
		Paragraph paragraph = new Paragraph(documentGenerationTimestamp, normalFont);
		return paragraph;
	}
	public Paragraph titleParagraph()
	{
		Paragraph paragraph = new Paragraph("Government Furnished Property", titleFont);
		paragraph.setAlignment(PageAlignment.CENTER.ordinal());
		return paragraph;
	}
	public Paragraph governmentContractingOfficerParagraph()
	{
		Paragraph paragraph = new Paragraph("Government Contracting Officer", boldHeadingFont);
		paragraph.setAlignment(PageAlignment.CENTER.ordinal());
		return paragraph;
	}
	public Paragraph footerParagraph()
	{
		Paragraph paragraph = new Paragraph("Consolidated GFP Attachment Version 1.0", normalFont);
		return paragraph;
	}
	public void writePDF4(String newPdfFilename)
	{
		try 
		{
			Document document = new Document(PageSize.LEGAL.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(newPdfFilename));
			document.open();

			document.add(generationTimestampParagraph());
			document.add(titleParagraph());
			document.add(attachmentNumberParagraph());
			document.add(governmentContractingOfficerParagraph());
			
			document.close();
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (FileNotFoundException fileNotFoundException) 
		{
		    System.out.println("FileNotFoundException was raised. Is the file open perchance?");
			fileNotFoundException.printStackTrace();
		} 
	}
	public void writePDF5(String newPdfFilename)
	{
		try 
		{
			Document document = new Document(PageSize.LEGAL.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(newPdfFilename));
			document.open();
			
			document.add(generationTimestampParagraph());
			document.add(titleParagraph());
			document.add(attachmentNumberParagraph());
			document.add(attachmentDateParagraph());
			document.add(attachmentFileParagraph());
			document.add(governmentContractingOfficerParagraph());
			document.add(footerParagraph());
			
			document.close();
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) 
		{
		    System.out.println("FileNotFoundException was raised. Is the file open perchance?");
			e.printStackTrace();
		} 
	}
	public Paragraph attachmentNumberParagraph()
	{
		Paragraph paragraph = new Paragraph("Attachment Number", normalFont);
		return paragraph;
	}
	public Paragraph attachmentFileParagraph()
	{
		Paragraph paragraph = new Paragraph("Attachment File", normalFont);
		return paragraph;
	}
	public Paragraph attachmentDateParagraph()
	{
		Paragraph paragraph = new Paragraph("Attachment Date", normalFont);
		return paragraph;
	}
	public void pdfFieldReader(String templatePdfFilename)
	{
//		refresh( plantCase );
		//          String  serverURL     = "http://localhost:1967/";
//		String  serverURL     = getApplicationBean().getResourceBean().getString( "local.resource.url" );
		//      String  serverURL     = "/";
//		String  myFilename    = serverURL + "pcarss/docs/DD_1637";
//		String  myTemplate    = templatePdfFilename;
		URL myTemplateURL = null;
		//		String  myReport      = (plantCase != null) ? myFilename + "_" + this.plantCase.getCaseNumber() + ".pdf" : null;
		// Creates a file on disk ...
		//      FileOutputStream fileStream = new FileOutputStream( myReport );
		// Creates a file in memory ...
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// Read the template file ...
		PdfReader pdfReader = null;
		try 
		{
			pdfReader = new PdfReader( templatePdfFilename );
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("IOException is being thrown on Sep-2-2016.");
			e.printStackTrace();
		}
		// Create the stamper file and save to disk or memory.
		// JRJ, Sep-2-2016 5:43 PM, WK-1. 
		PdfStamper pdfStamper = null;
		try 
		{
			pdfStamper = new PdfStamper( pdfReader, byteArrayOutputStream );
		} 
		catch (DocumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AcroFields myForm   = pdfStamper.getAcroFields();
		HashMap<String, ?> myFieldsHashMap = myForm.getFields();
//		Date caseEstablishedOn = plantCase.getEstablishedOn();
		
	}
	public void pdfFieldReader2(String templatePdfFilename)
	{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// Read the template file ...
		PdfReader pdfReader = null;
		try 
		{
			pdfReader = new PdfReader( templatePdfFilename );
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("IOException is being thrown on Sep-2-2016.");
			e.printStackTrace();
		}
		// Create the stamper file and save to disk or memory.
		// JRJ, Sep-2-2016 5:43 PM, WK-1. 
		PdfStamper pdfStamper = null;
		try 
		{
			pdfStamper = new PdfStamper( pdfReader, byteArrayOutputStream );
		} 
		catch (DocumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AcroFields myForm   = pdfStamper.getAcroFields();
		HashMap<String, ?> fieldsHashMap = myForm.getFields();
		
		System.out.println("Size = " + fieldsHashMap.size());
		System.out.println("Enter");
		for (Iterator<String> iterator = fieldsHashMap.keySet().iterator(); iterator.hasNext();)
		{
			String myKey = iterator.next();
//			if      ("1_Case_Number".equals( myKey ))                  myForm.setField( myKey, plantCase.getCaseNumber() );
			System.out.println("Key = " + myKey);
		}		
		System.out.println("Exit");
	}
}
