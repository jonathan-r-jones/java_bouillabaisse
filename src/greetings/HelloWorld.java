package greetings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import printing.ADifferentPrinter;
import printing.GenericPrinter;
import printing.IMachine;
import printing.Machine;
import printing.NewPrinter;
import printing.Printer;
import printing.WildCardPrinter;;

public class HelloWorld 
{
	private static int age = 50;
	public static void printOne(WildCardPrinter<? extends ICartridge> wildCardPrinter)
	{
		String	fillPercentage = "50%";	
	}
	public static void main(String[] arg)
	{
	    System.out.println("Hello world!");
	    
	    Printer printer = new Printer(false);
	    printer.modelNumber = "first P";
	    
	    Printer printer2 = new Printer(true);
	    printer2.modelNumber = "first P2";
	    
	    Printer printer3 = new Printer(false);
	    printer3.modelNumber = "P3";
	    
	    
	    int number = 3;

	    number += 15;
	    
	    int modNumber = 5 % 2;
	    String horseName = "Mr. Ed";
	    boolean value = true;
	    int[] numbers = new int[10];
	    numbers[0] = 25;

	    System.out.println(number);
	    System.out.println(horseName);
	    System.out.println(modNumber);
	    System.out.println(value);
	    System.out.println(!value);
	    System.out.println(horseName.indexOf('d'));
	    System.out.println(numbers[0]);
	    System.out.println(numbers[1]);
	    System.out.println(printer.modelNumber);
	    System.out.println(printer2.modelNumber);
	    printer.print();
	    printer.print("Billy");
	    System.out.println(printer3.modelNumber);
	    printer3.TurnOn();
	    System.out.println(printer3._isOn);
	    printer3.TurnOff();
	    System.out.println(printer3._isOn);
	    Machine machine = new Printer(true, "MY PRINTER");
	    machine.TurnOn();
	    Machine machine2 = new Machine(true);
	    machine2.TurnOn();
	    NewPrinter newPrinter = new NewPrinter(true);
	    newPrinter.TurnOn();
	    IMachine imachine = new NewPrinter(true);
	    imachine.TurnOn();
	    IMachine imachine2 = new ADifferentPrinter(true);
	    imachine2.TurnOn();
	    System.out.println("1. ****");
	    GenericPrinter<colorCartridge> genericPrinter = new GenericPrinter<colorCartridge>(true, "My Printer", new colorCartridge());
	    genericPrinter.print();
	    System.out.println("2. ****");
	    GenericPrinter<blackAndWhiteCartridge> genericPrinter2 = new GenericPrinter<blackAndWhiteCartridge>(true, "My Printer", new blackAndWhiteCartridge());
	    genericPrinter2.print();
	    System.out.println("3. ****");
	    GenericPrinter<colorCartridge> genericPrinter3 = new GenericPrinter<colorCartridge>(true, "My Printer", new colorCartridge());
	    genericPrinter3.printUsingCartridge(new blackAndWhiteCartridge(), "hey now");
	    System.out.println("4. ****");
	    GenericPrinter<colorCartridge> genericPrinter4 = new GenericPrinter<colorCartridge>(true, "My Printer", new colorCartridge());
	    genericPrinter4.printUsingCartridge(42, "hey now");
	    System.out.println("" );
	    System.out.println("5. ****");
	    GenericPrinter<colorCartridge> genericPrinter5 = new GenericPrinter<colorCartridge>(true, "My Printer", new colorCartridge());
	    try
	    {
		    genericPrinter5.print2(1);
	    }
	    catch(IllegalArgumentException exception)
	    {
		    System.out.println("Illegal arg.");
	    }
	    catch(Exception exception)
	    {
		    System.out.println("general exception");
	    }
	    System.out.println("6. ****");
	    GenericPrinter<colorCartridge> genericPrinter6 = new GenericPrinter<colorCartridge>(true, "My Printer", new colorCartridge());
	    genericPrinter6.print4();
	    System.out.println("7. **** Set collections have no duplicates.");
	    Set<Integer> mySet = new HashSet<Integer>();
	    mySet.add(1);
	    mySet.add(1);
	    mySet.add(2);
	    mySet.add(2);
	    mySet.add(3);
	    mySet.add(3);
	    System.out.println(mySet.size());
	    QueueDemo();
	    MapDemo();
	    System.out.println("8. **** Goodbye cruel world 9.");
	}
	private static int methodCounter = 7;
	private static void QueueDemo()
	{
		String fp = "Queues are a fifo implementation.";
	    System.out.println(++methodCounter + ". **** " + fp);
		Queue<String> myQueue = new LinkedList<String>();
		LinkedList<String> myQueue2 = new LinkedList<String>();
		myQueue.offer("a");
		myQueue.offer("b");
		myQueue.offer("c");
		while(myQueue.peek() != null)
		{
		    System.out.println(myQueue.poll());
		}
	}
	private static void MapDemo()
	{
		String fp = "Maps solve problems that would otherwise be more difficult.";
	    System.out.println(++methodCounter + ". **** " + fp);
	    HashMap<String, List<Integer>> testScores = new HashMap<String, List<Integer>>();

	    List<Integer> joesScores = new ArrayList<Integer>();
	    joesScores.add(65);
	    joesScores.add(75);
	    joesScores.add(85);
	    testScores.put("Joe", joesScores);
	    printScores("Joe", testScores);
	
	    List<Integer> timsScores = new ArrayList<Integer>();
	    timsScores.add(65);
	    timsScores.add(75);
	    timsScores.add(55);
	    testScores.put("Tim", timsScores);
	    printScores("Tim", testScores);
	
	    List<Integer> debbiesScores = new ArrayList<Integer>();
	    debbiesScores.add(65);
	    debbiesScores.add(75);
	    debbiesScores.add(100);
	    testScores.put("Debbie", debbiesScores);
	    printScores("Debbie", testScores);
}
	public static void printScores(String studentName, Map<String, List<Integer>> scoresMap)
	{
		List<Integer> scores = scoresMap.get(studentName);
		for(int score : scores)
		{
			System.out.println(score);
		}
	}
}