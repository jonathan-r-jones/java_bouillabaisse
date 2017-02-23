package printing;
public class NewPrinter implements IMachine
{
	public NewPrinter(boolean isOn) {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewPrinter(boolean isOn, String printerName) {
		super();
	}
	//public boolean isOn;
	public String modelNumber;
	
	public void IsPrinterOn()
	{
		//return super(_isOn);
	}
	public void print()
	{
		System.out.println(modelNumber);
	}
	public void print(String text)
	{
		System.out.println("Hey: " + text);
	}
	public void TurnOn()
	{
		System.out.println("Really, really warming up the ole printer.");
	}
	@Override
	public void TurnOff() {
		// TODO Auto-generated method stub
	}
}