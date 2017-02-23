package fileProcessor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import org.faceless.pdf2.OutputProfile;
import org.faceless.pdf2.PDF;
import org.faceless.pdf2.PDFReader;

//import javax.servlet.ServletOutputStream;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfWriter;

import java.util.Map; 
 
import javax.swing.JInternalFrame; 
import javax.swing.JOptionPane; 
 
import com.lowagie.text.pdf.PdfEncryptor; 
//import com.lowagie.toolbox.AbstractTool; 
//import com.lowagie.toolbox.arguments.AbstractArgument; 
//import com.lowagie.toolbox.arguments.FileArgument; 
//import com.lowagie.toolbox.arguments.StringArgument; 
//import com.lowagie.toolbox.arguments.filters.PdfFilter; 


public class PdfProcessor 
{
	public void pdfFieldReader3(String templatePdfFilename)
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
			System.out.println("Key = " + myKey);
		}		
		System.out.println("Exit");
	}
	public int countFields(String pdfFilename) throws IOException, DocumentException
	{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// Read the template file ...
		PdfReader pdfReader = null;
		pdfReader = new PdfReader(pdfFilename);
		PdfStamper pdfStamper = null;
		pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
		AcroFields myForm   = pdfStamper.getAcroFields();
		HashMap<String, ?> fieldsHashMap = myForm.getFields();
		return fieldsHashMap.size();
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
		catch (Exception exception) 
		{
			System.err.println(exception.getClass() + ": " + exception.getMessage());
		}
        return pdf.getBasicOutputProfile().isSet(OutputProfile.Feature.XFAForm);
    }
	public void pdfFieldReader4(String templatePdfFilename) throws IOException, DocumentException
	{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// Read the template file ...
		PdfReader pdfReader = null;
		pdfReader = new PdfReader( templatePdfFilename );
		PdfStamper pdfStamper = null;
		pdfStamper = new PdfStamper( pdfReader, byteArrayOutputStream );
		AcroFields myForm   = pdfStamper.getAcroFields();
		HashMap<String, ?> fieldsHashMap = myForm.getFields();
		System.out.println("Size = " + fieldsHashMap.size());
		System.out.println("Loop Entry Point");
		for (Iterator<String> iterator = fieldsHashMap.keySet().iterator(); iterator.hasNext();)
		{
			String myKey = iterator.next();
			System.out.println("Key = " + myKey);
			String myValue = iterator.toString();
			System.out.println("Value = " + myValue);
		}		
		System.out.println("Loop Exit Point");
	}
	public void pdfFieldReader5(String templatePdfFilename)
	{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// Read the template file ...
		PdfReader pdfReader = null;
		try
		{
			pdfReader = new PdfReader(templatePdfFilename);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PdfStamper pdfStamper = null;
		try 
		{
			pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
		} 
		catch (DocumentException | IOException e) 
		{
			e.printStackTrace();
		}
		AcroFields myFormAcroFields   = pdfStamper.getAcroFields();
		HashMap<String, ?> fieldsHashMap = myFormAcroFields.getFields();
		System.out.println("Size = " + fieldsHashMap.size());
		System.out.println("Loop Entry Point");
		for (Iterator<String> iterator = fieldsHashMap.keySet().iterator(); iterator.hasNext();)
		{
			String myKey = iterator.next();
			System.out.print("Key = " + myKey);
			System.out.println(", Value = " + myFormAcroFields.getField(myKey));
		}		
		System.out.println("Loop Exit Point");
	}
	public int pdfReader6(String myFilename)
	{
		int numberOfBytesInFile = 0;
		try
		{
			// JRJ, Oct-11-2016 12:55 PM, WK-1. 
			URL myTemplateURL = new URL(myFilename);

			// Creates a file on disk ...
//			FileOutputStream fileStream = new FileOutputStream( myReport );

			// Creates a file in memory ...
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();

			// Read the template file ...
			PdfReader pdfReader = new PdfReader(myTemplateURL);

			// Create the stamper file and save to disk or memory.
			PdfStamper stamper = new PdfStamper( pdfReader, byteArrayOutputStream );

			AcroFields myFormAcroFields   = stamper.getAcroFields();
			HashMap myFieldsHashMap = myFormAcroFields.getFields();

			String assigneeName = "";
			String from_address1 = "";
			String from_address2 = "";
			String from_address3 = "";

			Calendar start = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd MMM yyyy" );

			String caseClosed_DATE = "";
			Calendar end = Calendar.getInstance();

			long deltaDays = (end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60 * 24);

			String           scheduleNumber = null;
			String  terminationDocketNumber = null;
			String  tier1_subcontractNumber = null;
			String  tier2_subcontractNumber = null;
			String        subcontractNumber = null;

			DecimalFormat df = new DecimalFormat( "###,###,###,##0.00" );

			String  subOrPrime_CSZC    = null;

			//MIKE: prevents Lazy-Loading errors ...
			String  primeIfSub_CSZC    = null;

			//MIKE: Calculate LineItem info and Acquisition Costs ...
			int        lineItems_submitted = 0;
			double       acqCost_submitted = 0.0;

			int      lineItems_Disposal_PR = 0;
			double     acqCost_Disposal_PR = 0.0;

			int      lineItems_Disposal_RS = 0;
			double     acqCost_Disposal_RS = 0.0;

			int     lineItems_OwningAgency = 0;
			double    acqCost_OwningAgency = 0.0;

			int      lineItems_OtherAgency = 0;
			double     acqCost_OtherAgency = 0.0;

			int  lineItems_Redistributions = 0;
			double acqCost_Redistributions = 0.0;

			int        lineItems_Donations = 0;
			double       acqCost_Donations = 0.0;

			int            lineItems_Sales = 0;
			double           acqCost_Sales = 0.0;

			int         lineItems_Overhead = 0;
			double        acqCost_Overhead = 0.0;

			int          lineItems_Other_F = 0;
			double         acqCost_Other_F = 0.0;

			int     lineItems_Credit_Total = 0;
			double    acqCost_Credit_Total = 0.0;

			int        lineItems_Abandoned = 0;
			double       acqCost_Abandoned = 0.0;

			int   lineItems_DestroyAbandon = 0;
			double  acqCost_DestroyAbandon = 0.0;

			int     lineItems_DestroyScrap = 0;
			double    acqCost_DestroyScrap = 0.0;

			int            lineItems_Other = 0;
			double           acqCost_Other = 0.0;

			int       lineItems_Disp_Total = 0;
			double      acqCost_Disp_Total = 0.0;

			String remarks = "";


			lineItems_Redistributions = lineItems_OwningAgency
			                          + lineItems_OtherAgency;

			acqCost_Redistributions   = acqCost_OwningAgency
			                          + acqCost_OtherAgency;

			lineItems_Credit_Total = lineItems_Disposal_PR
			                       + lineItems_Disposal_RS
			                       + lineItems_Sales;

			acqCost_Credit_Total   = acqCost_Disposal_PR
			                       + acqCost_Disposal_RS
			                       + acqCost_Sales;

			lineItems_Disp_Total = lineItems_Disposal_PR
			                     + lineItems_Disposal_RS
			                     + lineItems_OwningAgency
			                     + lineItems_OtherAgency
			                     + lineItems_Donations
			                     + lineItems_Sales
			                     + lineItems_Overhead
			                     + lineItems_Other_F
			                     + lineItems_Abandoned
			                     + lineItems_DestroyAbandon
			                     + lineItems_DestroyScrap;

			acqCost_Disp_Total   = acqCost_Disposal_PR
		                         + acqCost_Disposal_RS
		                         + acqCost_OwningAgency
		                         + acqCost_OtherAgency
		                         + acqCost_Donations
		                         + acqCost_Sales
		                         + acqCost_Overhead
		                         + acqCost_Other_F
		                         + acqCost_Abandoned
		                         + acqCost_DestroyAbandon
		                         + acqCost_DestroyScrap;

			String subOrPrime_CityZip = (subOrPrime_CSZC          != null) ? subOrPrime_CSZC          : "";

			String primeIfSub_CityZip = (primeIfSub_CSZC          != null) ? primeIfSub_CSZC          : "";

			for (Iterator i=myFieldsHashMap.keySet().iterator(); i.hasNext();)
			{
				String myKey = (String) i.next();


				if ("FROM_Name".equals(                    myKey ))  myFormAcroFields.setField( myKey, assigneeName );
				else if ("FROM_Address1".equals(                myKey ))  myFormAcroFields.setField( myKey, from_address1 );
				else if ("FROM_Address2".equals(                myKey ))  myFormAcroFields.setField( myKey, from_address2 );
				else if ("FROM_Address3".equals(                myKey ))  myFormAcroFields.setField( myKey, from_address3 );

				else if ("2_Case_Closed_Date".equals(           myKey ))  myFormAcroFields.setField( myKey, caseClosed_DATE );
				else if ("3_Days_Between".equals(               myKey ))  myFormAcroFields.setField( myKey, "" + deltaDays );

				else if ("4_SubOrPrime_Address2".equals(        myKey ))  myFormAcroFields.setField( myKey, subOrPrime_CityZip );

				else if ("5_PrimeIfSub_Address2".equals(        myKey ))  myFormAcroFields.setField( myKey, primeIfSub_CityZip );


				else if ("8_Termination_Docket_Number".equals(  myKey ))  myFormAcroFields.setField( myKey, terminationDocketNumber );
				else if ("9_Subcontract_Number".equals(         myKey ))  myFormAcroFields.setField( myKey, subcontractNumber );
				else if ("10_Inventory_Schedule_Number".equals( myKey ))  myFormAcroFields.setField( myKey, scheduleNumber );

				else if ("11_LineItems_Submitted".equals(       myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_submitted );
				else if ("11_AcqCost_Submitted".equals(         myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_submitted ));

				else if ("13_LineItems_Adjusted".equals(        myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_submitted );
				else if ("13_AcqCost_Adjusted".equals(          myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_submitted ));

				else if ("14_LineItems_Disposal_PR".equals(     myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Disposal_PR );
				else if ("14_AcqCost_Disposal_PR".equals(       myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Disposal_PR ));

				else if ("15_LineItems_Disposal_RS".equals(     myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Disposal_RS );
				else if ("15_AcqCost_Disposal_RS".equals(       myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Disposal_RS ));

				else if ("16a_LineItems_OwningAgency".equals(   myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_OwningAgency );
				else if ("16a_AcqCost_OwningAgency".equals(     myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_OwningAgency ));

				else if ("16b_LineItems_OtherAgencies".equals(  myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_OtherAgency );
				else if ("16b_AcqCost_OtherAgencies".equals(    myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_OtherAgency ));

				else if ("16_LineItems_Redistributions_Total".equals( myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Redistributions );
				else if ("16_AcqCost_Redistributions_Total".equals(   myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Redistributions ));

				else if ("17_LineItems_Donations".equals(       myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Donations );
				else if ("17_AcqCost_Donations".equals(         myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Donations ));

				else if ("18_LineItems_Sales".equals(           myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Sales );
				else if ("18_AcqCost_Sales".equals(             myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Sales ));

				else if ("19_LineItems_Overhead".equals(        myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Overhead );
				else if ("19_AcqCost_Overhead".equals(          myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Overhead ));

				else if ("20_Description_F".equals(             myKey ))  myFormAcroFields.setField( myKey, "TRANSFER TO DRMO" );
				else if ("20_LineItems_Other_F".equals(         myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Other_F );
				else if ("20_AcqCost_Other_F".equals(           myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Other_F ));

				else if ("22_LineItems_Credit_Total".equals(    myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Credit_Total );
				else if ("22_AcqCost_Credit_Total".equals(      myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Credit_Total ));

				else if ("23_LineItems_Abandoned".equals(       myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Abandoned );
				else if ("23_AcqCost_Abandoned".equals(         myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Abandoned ));

				else if ("24_LineItems_DestroyAbandon".equals(  myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_DestroyAbandon );
				else if ("24_AcqCost_DestroyAbandon".equals(    myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_DestroyAbandon ));

				else if ("25_LineItems_DestroyScrap".equals(    myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_DestroyScrap );
				else if ("25_AcqCost_DestroyScrap".equals(      myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_DestroyScrap ));

				else if ("26_LineItems_Other".equals(           myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_Other );
				else if ("26_AcqCost_Other".equals(             myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_Other ));

				else if ("27_LineItems_Dispositions_Total".equals( myKey ))  myFormAcroFields.setField( myKey, "" + lineItems_submitted );
				else if ("27_AcqCost_Dispositions_Total".equals(   myKey ))  myFormAcroFields.setField( myKey, "$" + df.format( acqCost_submitted ));
				else if ("28_Remarks".equals(                   myKey ))  myFormAcroFields.setField( myKey, remarks );
				else if ("AuthorizedSigner_Name".equals(        myKey ))  myFormAcroFields.setField( myKey, assigneeName );
				else if ("AuthorizedSigner_Title".equals(       myKey ))  myFormAcroFields.setField( myKey, "Plant Clearance Officer" );
				else if ("AuthorizedSigner_Date".equals(        myKey ))  myFormAcroFields.setField( myKey, caseClosed_DATE );
				else  myFormAcroFields.setField( myKey, "" );
			}
			stamper.close();
			// Send output to browser ...
		    //Needed for download via HTTPS on portal and iChain environment ...
            numberOfBytesInFile = byteArrayOutputStream.size();
			//ServletOutputStream sos = response.getOutputStream();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        return(numberOfBytesInFile);
	}
	public int pdfReader7(String myFilename)
	{
		int numberOfBytesInFile = 0;
		try
		{
			// JRJ, Oct-11-2016 12:55 PM, WK-1. 
			
			// Creates a file on disk ...
//			FileOutputStream fileStream = new FileOutputStream( myReport );
			
			// Creates a file in memory ...
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			
			// Read the template file ...
			PdfReader pdfReader = new PdfReader(myFilename);
			
			// Create the stamper file and save to disk or memory.
			PdfStamper stamper = new PdfStamper( pdfReader, byteArrayOutputStream );
			
			AcroFields myFormAcroFields   = stamper.getAcroFields();
			HashMap myFieldsHashMap = myFormAcroFields.getFields();
			
			String assigneeName = "";
			String from_address1 = "";
			String from_address2 = "";
			String from_address3 = "";
			
			Calendar start = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat( "dd MMM yyyy" );
			
			String caseClosed_DATE = "";
			Calendar end = Calendar.getInstance();
			
			long deltaDays = (end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60 * 24);

			System.out.println("Begin loop.");
			for (Iterator i = myFieldsHashMap.keySet().iterator(); i.hasNext();)
			{
				String myKey = (String) i.next();
				// JRJ, Oct-11-2016 1:42 PM, WK-1. 
				
				System.out.print("Key = " + myKey);
				System.out.println(", Value = " + myFormAcroFields.getField(myKey));

				//myFormAcroFields.setField( myKey, "" );
			}
			System.out.println("End loop.");
			stamper.close();
			// Send output to browser ...
			//Needed for download via HTTPS on portal and iChain environment ...
			numberOfBytesInFile = byteArrayOutputStream.size();
			//ServletOutputStream sos = response.getOutputStream();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return(numberOfBytesInFile);
	}
	 public void pdfReader8(String pdfFilename)
	 {
		 try 
		 {

			 PdfReader reader = new PdfReader("c:/temp/test.pdf");
			 System.out.println("This PDF has "+reader.getNumberOfPages()+" pages.");
			 //String page = PdfTextExtractor.getTextFromPage(reader, 2);
			 //System.out.println("Page Content:\n\n"+page+"\n\n");
			 System.out.println("Is this document tampered: "+reader.isTampered());
			 System.out.println("Is this document encrypted: "+reader.isEncrypted());

		 } 
		 catch (IOException e) 
		 {
			 e.printStackTrace();
		 }
	 }
	 
}
