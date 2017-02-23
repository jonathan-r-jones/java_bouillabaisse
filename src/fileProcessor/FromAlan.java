package fileProcessor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.faceless.pdf2.PDF;
import org.faceless.pdf2.PDFReader;

public class FromAlan 
{
	String wp = FileProcessor.WORKSPACE_PATH;

	public PDF createPdfUnchanged()
    {

        PDF pdf = null;
		BufferedReader xfaDataReader = null;

		try {
            pdf = new PDF(new PDFReader(new File("MyTemplate.pdf")));

            xfaDataReader = new BufferedReader(
                				new InputStreamReader(
                					new FileInputStream(new File("MyXFA.xml"))
                				));

            StringBuffer xfaDataBuffer = new StringBuffer(); String s = null;
            while ((s = xfaDataReader.readLine()) != null) { xfaDataBuffer.append(s); }
            xfaDataReader.close();
            
            pdf.getForm().setXFADatasets(xfaDataBuffer.toString());
            ByteArrayOutputStream pdfDataOutputStream = new ByteArrayOutputStream();
           
			pdf.render(pdfDataOutputStream);
			pdfDataOutputStream.flush();

			pdf.render(new FileOutputStream(new File("MyPdf.pdf")));
			
			return pdf;

        } catch (Exception e) {
			System.err.println(e.getClass()+"; "+e.getMessage());
		}
		return pdf;
    }

	public PDF createPdf(String templatePDFFilename, String xmlDataFilename, String codeGeneratedPdfFilename)
    {
        PDF pdf = null;
		BufferedReader xfaDataBufferedReader = null;

		try {
            pdf = new PDF(new PDFReader(new File(templatePDFFilename)));

            xfaDataBufferedReader = new BufferedReader(
            						new InputStreamReader(
                					new FileInputStream(new File(xmlDataFilename))
                				));

            StringBuffer xfaDataStringBuffer = new StringBuffer(); 
            String myString = null;
            while ((myString = xfaDataBufferedReader.readLine()) != null) 
            { 
            	xfaDataStringBuffer.append(myString); 
            }
            xfaDataBufferedReader.close();
            
            pdf.getForm().setXFADatasets(xfaDataStringBuffer.toString());
            ByteArrayOutputStream pdfDataOutputStream = new ByteArrayOutputStream();
           
			pdf.render(pdfDataOutputStream);
			pdfDataOutputStream.flush();

			pdf.render(new FileOutputStream(new File(codeGeneratedPdfFilename)));
			
			return pdf;

        } catch (Exception e) 
		{
			System.err.println(e.getClass()+"; "+e.getMessage());
		}
		return pdf;
    }
	public PDF createPdf2(String templatePDFFilename, String xmlDataFilename, String codeGeneratedPdfFilename)
    {
        PDF pdf = null;
		BufferedReader xfaDataBufferedReader = null;

		try {
            pdf = new PDF(new PDFReader(new File(templatePDFFilename)));

            xfaDataBufferedReader = new BufferedReader(
            						new InputStreamReader(
                					new FileInputStream(new File(xmlDataFilename))
                				));

            StringBuffer xfaDataStringBuffer = new StringBuffer(); String s = null;
            while ((s = xfaDataBufferedReader.readLine()) != null) { xfaDataStringBuffer.append(s); }
            xfaDataBufferedReader.close();
            
            pdf.getForm().setXFADatasets(xfaDataStringBuffer.toString());
            ByteArrayOutputStream pdfDataOutputStream = new ByteArrayOutputStream();
           
			pdf.render(pdfDataOutputStream);
			pdfDataOutputStream.flush();

			pdf.render(new FileOutputStream(new File(codeGeneratedPdfFilename)));
			
			return pdf;

        } catch (Exception e) {
			System.err.println(e.getClass()+"; "+e.getMessage());
		}
		return pdf;
    }
	public PDF createPdfOriginalMinimallyChanged()
    {
        PDF pdf = null;
		BufferedReader xfaDataBufferedReader = null;
		try 
		{
			String templatePDFFilename = wp + "123data.pdf"; 
			String xmlDataFilename = wp + "backbone1.xml";
			String codeGeneratedPdfFilename = wp + "minimall changed backbone.pdf";

            pdf = new PDF(new PDFReader(new File(templatePDFFilename)));
            xfaDataBufferedReader = new BufferedReader(new InputStreamReader(
                					new FileInputStream(new File(xmlDataFilename))
                				));
            StringBuffer xfaDataStringBuffer = new StringBuffer(); 
            String currentLine = null;
            while ((currentLine = xfaDataBufferedReader.readLine()) != null) 
            { 
            	xfaDataStringBuffer.append(currentLine); 
            }
            xfaDataBufferedReader.close();
            pdf.getForm().setXFADatasets(xfaDataStringBuffer.toString());
            ByteArrayOutputStream pdfDataOutputStream = new ByteArrayOutputStream();
			pdf.render(pdfDataOutputStream);
			pdfDataOutputStream.flush();
			pdf.render(new FileOutputStream(new File(codeGeneratedPdfFilename)));
			return pdf;
        }
		catch (Exception e) 
		{
			System.err.println(e.getClass() + "; " + e.getMessage());
		}
		return pdf;
    }
	public void createPdf3(String templatePDFFilename, String xmlDataFilename, String codeGeneratedPdfFilename)
    {
		// Function Purpose: Refactor Alan's method to use my standards and for my understanding. 
		//    Creation Date: Sep-29-2016
        PDF pdf = null;
		BufferedReader bufferedReader = null;
		try 
		{
            pdf = new PDF(new PDFReader(new File(templatePDFFilename)));
            bufferedReader = new BufferedReader(
            						new InputStreamReader(
                					new FileInputStream(new File(xmlDataFilename))
                				));
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
		catch (Exception exception) 
		{
			System.err.println(exception.getClass() + ": " + exception.getMessage());
		}
    }
	
}