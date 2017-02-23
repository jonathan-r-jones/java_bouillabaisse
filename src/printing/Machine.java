package printing;

public class Machine 
{
	public boolean _isOn;
	
	public Machine(boolean isOn)
	{
		_isOn = isOn;
	}

	/*
	public Machine()
	{
		//_isOn = false;
	}
	*/

	public void TurnOn()
	{
		_isOn = true;
		System.out.println("Machine is now on.");
	}
	public void TurnOff()
	{
		_isOn = false;
		System.out.println("Machine is now off.");
	}
}
