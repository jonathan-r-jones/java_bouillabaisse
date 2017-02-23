package XmlOperations;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.faceless.pdf2.PDF;
import org.faceless.pdf2.PDFReader;

public class MergeFile 
{

	public PDF createPdfOriginal()
    {
        PDF pdf = null;
		BufferedReader xfaDataBufferedReader = null;
		try 
		{
            pdf = new PDF(new PDFReader(new File("MyTemplate.pdf")));
            xfaDataBufferedReader = new BufferedReader(new InputStreamReader(
                					new FileInputStream(new File("MyXFA.xml"))
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
			pdf.render(new FileOutputStream(new File("MyPdf.pdf")));
			return pdf;
        }
		catch (Exception e) 
		{
			System.err.println(e.getClass() + "; " + e.getMessage());
		}
		return pdf;
    }
	public PDF createPdf(String pdfTemplateFilename, String xmlDataFilename)
    {
        PDF pdf = null;
		BufferedReader xfaDataBufferedReader = null;
		try 
		{
            pdf = new PDF(new PDFReader(new File(pdfTemplateFilename)));
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
			pdf.render(new FileOutputStream(new File("000 - NewLoadedPdf.pdf")));
			return pdf;
        }
		catch (Exception e) 
		{
			System.err.println(e.getClass() + "; " + e.getMessage());
		}
		return pdf;
    }
	public PDF createPdf(String pdfTemplateFilename)
    {
        PDF pdf = null;
		try 
		{
            pdf = new PDF(new PDFReader(new File(pdfTemplateFilename)));
        }
		catch (Exception e) 
		{
			System.err.println(e.getClass() + "; " + e.getMessage());
		}
		return pdf;
    }
}