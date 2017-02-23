package printing;

public class Printer extends Machine
{

	public Printer(boolean isOn) {
		super(isOn);
		// TODO Auto-generated constructor stub
	}
	public Printer(boolean isOn, String printerName) {
		super(isOn);
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
		System.out.println("Warming up printer.");
		super.TurnOn();
	}
}
