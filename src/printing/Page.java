package printing;

public class Page 
{
	private String printedText;

	public Page(String printedText) 
	{
		//super();
		this.printedText = printedText;
	}

	public String getPrintedText() {
		return printedText;
	}

	public void setPrintedText(String printedText) {
		this.printedText = printedText;
	}

}
