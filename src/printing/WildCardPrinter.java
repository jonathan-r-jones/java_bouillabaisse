package printing;
public class WildCardPrinter<T> implements IMachine
{
	private T cartridge;
	public WildCardPrinter(boolean isOn) {
		super();
		// TODO Auto-generated constructor stub
	}
	public WildCardPrinter(boolean isOn, String printerName, T cartridge) 
	{
		super();
		this.cartridge = cartridge;
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