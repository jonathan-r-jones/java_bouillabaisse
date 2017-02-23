package pdfCreation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfCreation 
{
	public void CreatePDF1(String filename)
	{
		try 
		{
			Document document = new Document(PageSize.LEGAL.rotate());
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			Paragraph paragraph = new Paragraph ("Government Furnished Property");
			document.add(paragraph);
			//generateMetadata(document);
			//createPage(document);
			document.close();
		} 
		catch (DocumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
