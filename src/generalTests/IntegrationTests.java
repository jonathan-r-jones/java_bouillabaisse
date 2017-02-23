package generalTests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techventus.server.voice.Voice;
import com.techventus.server.voice.datatypes.records.SMSThread;

public class IntegrationTests
{

private Voice voice;

@Before
public void setUp() throws IOException
{
	voice = new Voice("jonathan.r.jones.7@gmail.com", "fightlaziness", "2028541861");
}
@Test
public void test1() throws InvalidGoalException, IOException
{
	TrackingService trackingService = new TrackingService(new SMSNotifier("jonathan.r.jones.7@gmail.com", "fightlaziness", "2028541861"));
	trackingService.setGoal(50);
	trackingService.addProtein(51);
	assertTrue(voice.getSMS().contains("goal met"));
}
@After
public void tearDown() throws IOException
{
	for(SMSThread sMSThread : voice.getSMSThreads())
	{
		//voice.deleteMessage(sMSThread.getId());
	}
}

}
