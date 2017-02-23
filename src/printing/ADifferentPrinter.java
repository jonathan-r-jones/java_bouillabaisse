package printing;
public class ADifferentPrinter implements IMachine
{
	public ADifferentPrinter(boolean isOn) {
		super();
		// TODO Auto-generated constructor stub
	}
	public ADifferentPrinter(boolean isOn, String printerName) {
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
		System.out.println("This new style printer comes warmed up out of the box.");
	}
	@Override
	public void TurnOff() {
		// TODO Auto-generated method stub
	}
}