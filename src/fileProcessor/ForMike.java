package fileProcessor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.faceless.pdf2.PDF;
import org.faceless.pdf2.PDFReader;

public class ForMike 
{
	public void createPdf(String templatePDFFilename, String xmlDataFilename, String codeGeneratedPdfFilename)
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
            //System.err.println(stringBuffer.toString());
            
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
