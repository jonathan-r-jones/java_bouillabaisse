package generalTests;

import java.util.ArrayList;
import java.util.List;

public class TrackingService
{

private int _total;
private int _goal;
private List<HistoryItem> _history = new ArrayList<HistoryItem>();
private int _historyId = 0;
private Notifier _notifier;
	
	public TrackingService (Notifier notifier)
	{
		_notifier = notifier;
	}
	public void addProtein(int amount)
	{
		_total += amount;
		_history.add(new HistoryItem(_historyId++, amount, "add", _total));
		if (_total > _goal)
		{
			boolean sendResult = _notifier.send("goal met");
			String historyMessage = "sent:goal met";
			if (!sendResult)
			{
				historyMessage = "send_error:goal met";
			}
			_history.add(new HistoryItem(_historyId++, 0, historyMessage, _total));
		}
	}
	public void removeProtein(int amount)
	{
		_total -= amount;
		if(_total < 0)
		{
			_total = 0;
		}
		_history.add(new HistoryItem(_historyId++, amount, "remove", _total));
	}
	public int getTotal()
	{
		return _total; 
	}
	public void setGoal(int value) throws InvalidGoalException
	{
		if(value < 0)
		{
			throw new InvalidGoalException("Error: Goal was less than zero."); 
		}
		_goal = value; 
	}
	public List<HistoryItem> getHistory()
	{
		return _history;
	}

}
