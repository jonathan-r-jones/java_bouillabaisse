package fileProcessor;

import java.io.*;
import org.faceless.report.ReportParser;
import org.xml.sax.SAXException;
import org.faceless.pdf2.PDF;

public class Bfo3 
{
	public void createPDF(String xmlfile, OutputStream out) throws SAXException, IOException
	{
		ReportParser parser = ReportParser.getInstance();
		PDF pdf = parser.parse(xmlfile);
		pdf.render(out);
		out.close();
	}

}
