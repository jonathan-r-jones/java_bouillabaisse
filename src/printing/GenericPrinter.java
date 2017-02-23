package printing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericPrinter<T> implements IMachine
{
	private Map<Integer, Page> pagesMap = new HashMap<Integer, Page>();
	private List<Page> pagesArrayList = new ArrayList<Page>();
	private T cartridge;
	private String textToPrint;
	public GenericPrinter(boolean isOn) {
		super();
		// TODO Auto-generated constructor stub
	}
	public GenericPrinter(boolean isOn, String textToPrint, T cartridge) 
	{
		super();
		this.cartridge = cartridge;
		this.textToPrint = textToPrint;
	}
	//public boolean isOn;
	public String modelNumber;
	public <U> void printUsingCartridge(U cartridge, String message)
	{
		System.out.println(cartridge.toString());
		System.out.println(message);
		System.out.println(cartridge.toString());
	}
	
	public void IsPrinterOn()
	{
		//return super(_isOn);
	}
	public void print()
	{
		System.out.println(cartridge.toString());
		System.out.println("Printing boss.");
	}
	public void print4()
	{
		pagesArrayList.add(new Page(this.textToPrint));
		outputPages();
		//System.out.println("Printing yeah!");
	}
	private int pageCounter = 0;
	public void print5()
	{
		pageCounter++;
		pagesMap.put(pageCounter, new Page("nuther page"));
	}
	private void outputPages()
	{
		for(Page currentPage : pagesArrayList)
		{
			System.out.println(currentPage.getPrintedText());
		}
	}
	public void print2(int numberOfCopiesToPrint) throws Exception
	{
		if(numberOfCopiesToPrint < 0)
		{
			throw new IllegalArgumentException("Can't print less than zero copies.");
		}
		else
		{
			throw new Exception( "Please select a requisition disposition type." );
		}
		//System.out.println("Printing again boss.");
	}
	public void print(String text)
	{
		System.out.println("Hey: " + text);
	}
	public void TurnOn()
	{
		System.out.println("This new style printer comes warmed up out of the box.");
	}
	@Override
	public void TurnOff() {
		// TODO Auto-generated method stub
	}
}