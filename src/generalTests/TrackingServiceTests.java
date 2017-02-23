package generalTests;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;

import static org.hamcrest.CoreMatchers.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class TrackingServiceTests
{
	private static TrackingService trackingService;

	@BeforeClass
	public static void setUpClass() 
	{
		System.out.println("BeforeClass");
	}
	@AfterClass
	public static void tearDownClass() 
	{
		System.out.println("AfterClass");
		trackingService = null;
	}
	@Before
	public void setUp() 
	{
		trackingService = new TrackingService(new NotifierStub());
		System.out.println("Before");
	}
	@Before
	public void tearDown() 
	{
		System.out.println("After");
	}
	@Test
	public void test1() 
	{
		trackingService.addProtein(10);
		assertEquals(10, trackingService.getTotal());
	}
	@Test
	public void test2() 
	{
		trackingService.removeProtein(15);
		assertEquals(0, trackingService.getTotal());
	}
	@Test
	public void test2_2() 
	{
		trackingService.addProtein(15);
		assertThat(trackingService.getTotal(), is(15));
	}
	@Test
	public void test2_3() 
	{
		trackingService.addProtein(11);
		assertThat(trackingService.getTotal(), allOf(is(11), instanceOf(Integer.class)));
	}
	@Test
	public void test3() 
	{
		trackingService.removeProtein(15);
		assertEquals(0, trackingService.getTotal());
	}
	@Test
	public void test4() 
	{
		trackingService.addProtein(13);
		assertEquals(13, trackingService.getTotal());
	}
	@Test
	@Ignore
	public void test5() 
	{
		trackingService.addProtein(132);
		assertEquals(13, trackingService.getTotal());
	}
	@Test(expected = InvalidGoalException.class)
	public void test6() throws InvalidGoalException 
	{
		trackingService.setGoal(-1);
	}
	@Test
	public void test6_2() throws InvalidGoalException 
	{
		thrownExpectedException.expect(InvalidGoalException.class);
		thrownExpectedException.expectMessage("Goal was less than zero.");
		trackingService.setGoal(-1);
	}
	@Test
	public void test6_3() throws InvalidGoalException 
	{
		thrownExpectedException.expect(InvalidGoalException.class);
		thrownExpectedException.expectMessage(containsString("zero."));
		trackingService.setGoal(-1);
	}
	@Rule
		public ExpectedException thrownExpectedException = ExpectedException.none();
	@SuppressWarnings("deprecation")
	@Rule
	public Timeout timeout = new Timeout(200);
	@Test(timeout = 200)
	@Category({GoodTestsCategory.class, BadTestsCategory.class})
	public void test7() 
	{
		for(int i = 0; i < 100000; i++)
		{
			trackingService.addProtein(1);
		}
	}
	@Test()
	@Category(GoodTestsCategory.class)
	public void test8() 
	{
		int i = 0;
		if(i != 0)
		{
			Assert.fail("i was less than one.");
		}
	}
	@Test()
	public void test9() throws InvalidGoalException 
	{
		// fp: Example of how to use a stub. 
		trackingService.setGoal(5);
		trackingService.addProtein(6);
		HistoryItem historyItem = trackingService.getHistory().get(1);
		assertEquals("sent:goal met", historyItem.getOperation());
	}
	@Test()
	public void test10() throws InvalidGoalException 
	{
		// fp: Example of how to use a mock. 
		Mockery mockery = new Mockery();
		final Notifier mockNotifier = mockery.mock(Notifier.class);
		trackingService = new TrackingService(mockNotifier);
		mockery.checking(new Expectations() {{
			oneOf(mockNotifier).send("goal met");
			will(returnValue(true));
		}});
	
		trackingService.setGoal(5);
		trackingService.addProtein(6);
		HistoryItem historyItem = trackingService.getHistory().get(1);
		assertEquals("sent:goal met", historyItem.getOperation());
		mockery.assertIsSatisfied();
	}
}
