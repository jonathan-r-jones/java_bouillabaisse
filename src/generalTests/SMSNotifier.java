package generalTests;

import com.techventus.server.voice.Voice;

public class SMSNotifier implements Notifier
{

private String username;
private String password;
private String numberToMessage;

public SMSNotifier(String username, String password, String numberToMessage)
{
	this.username = username;
	this.password = password;
	this.numberToMessage = numberToMessage;
}

@Override
public boolean send(String message)
{
	try
	{
		Voice voice = new Voice(username, password);
		voice.sendSMS(numberToMessage, message);
	}
	catch (Exception e) 
	{
		return false;
	}
	return true;	
}

}
