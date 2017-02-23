package fileProcessor;

import org.faceless.report.*;
import org.faceless.pdf2.*;
import org.xml.sax.SAXException;
import java.io.*;

public class BFO_Hello_World 
{
	public static void main(String[] args) throws SAXException 
	{
		if (args.length == 0) {
			System.err.println("Usage: java Sample <infile1.xml> [<infile2.xml> ...]");
			System.exit(0);
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Parsing files. Note the first file will take longer");
		System.out.println("as it must load various static resources.");
		System.out.println("---------------------------------------------------");

		ReportParser parser = ReportParser.getInstance();
		for (int i=0;i<args.length;i++) {
			doParse(parser, new File(args[i]));
		}

		System.out.println("---------------------------------------------------");
	}

	public static void mainDuplicate(String string) throws SAXException 
	{
		if (string.length() == 0) 
		{
			System.err.println("Usage: java Sample <infile1.xml> [<infile2.xml> ...]");
			System.exit(0);
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Parsing files. Note the first file will take longer");
		System.out.println("as it must load various static resources.");
		System.out.println("---------------------------------------------------");

		ReportParser parser = ReportParser.getInstance();
		doParse(parser, new File(string));

		System.out.println("**** jrj end ---------------------------");
	}

	public static void doParse(ReportParser parser, File infile) 
	{
		File outfile = new File(infile.getParent(),  infile.getName().replaceAll("\\.xml$", "")+".pdf");
		FileOutputStream out = null;

		try {
			System.out.print("Parsing \""+infile+"\"... ");
			long now = System.currentTimeMillis();
			PDF pdf = parser.parse(infile);
			out = new FileOutputStream(outfile);
			pdf.render(out);
			System.out.println("created \""+outfile+"\" in "+(System.currentTimeMillis()-now)+"ms");
		} catch (Exception e) {
			System.out.println();
			if (e instanceof SAXException && ((SAXException)e).getException() != null) {
				((SAXException)e).getException().printStackTrace();
			} else {
				e.printStackTrace();
			}
		} finally {
			if (out != null) {
				try { out.close(); } catch (Exception e) {}
			}
		}
	}
	public static void test1() 
	{
		System.out.println("hey");
	}

}
