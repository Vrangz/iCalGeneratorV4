package ical;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Test;

public class TestGenerateICal {

	@Test
	public void testRun() throws FileNotFoundException {
		generateICal.run();
		String path = System.getProperty("user.dir")+"/iCalendar.ical";
		   File shouldExist = new File(path);
		 //czy istnieje
		    assertTrue(shouldExist.exists());
		    FileReader fr = new FileReader(shouldExist);
		    Scanner plik =new Scanner(fr);
		    //czy 1 linia kodu sie zgadza
		   assertEquals("BEGIN:VCALENDAR", plik.next());
		   
	}
	 static Calendar calendar = new Calendar();
	 static Operation generateICal = GenerateICal.instance;
}
