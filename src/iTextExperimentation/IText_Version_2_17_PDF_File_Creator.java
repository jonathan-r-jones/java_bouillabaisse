package iTextExperimentation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;

public class IText_Version_2_17_PDF_File_Creator 
{
	public void createPdfOriginal(InputStream inputStream)
    {
		InputStreamReader reader = new InputStreamReader(inputStream);

		ByteArrayOutputStream outputStream = null;
		try 
		{
			Document document = new Document();
			outputStream = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, outputStream);

			Map<String, String> pc2 = new HashMap<String, String>();
			pc2.put("line-height", "115%");
			pc2.put("margin-bottom", "6.0pt");
			pc2.put("text-align", "center");

			Map<String, String> spanc1 = new HashMap<String, String>();
			spanc1.put("line-height", "115%");
			spanc1.put("font-family", "\"Arial\",serif");
			spanc1.put("color", "black");
			spanc1.put("letter-spacing", "10pt");
			StyleSheet styles = new StyleSheet();
			//styles.loadTagStyle("p", pc2);
			//styles.loadTagStyle("span", spanc1);
			BaseFont bf = BaseFont.createFont( "arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bf, 12);
			document.open();
			document.add(new Paragraph(" The rain in spain." , font));
			document.add(new LineSeparator(0.5f, 100, null, 0, -5));
			document.close();
			document.open();
			HTMLWorker htmlWorker = new HTMLWorker(document);
			document.close();
			htmlWorker.setStyleSheet(styles);
			htmlWorker.parse(reader);
		} 
		catch (DocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    }
}
