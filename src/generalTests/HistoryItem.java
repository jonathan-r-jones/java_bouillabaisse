package generalTests;

public class HistoryItem
{

	private int total;
	private int id;
	private int amount;
	private String message;

	public HistoryItem(int id, int amount, String message, int total)
	{
		this.id = id;
		this.amount = amount;
		this.message = message;
		this.total = total;
		// TODO Auto-generated constructor stub
	}

	public String getOperation()
	{
		// TODO Auto-generated method stub
		return this.message;
	}

}
