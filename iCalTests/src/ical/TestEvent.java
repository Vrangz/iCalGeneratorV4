package ical;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestEvent {



	@Test
	public void testGetDateDTS() {
		Event eve = new Event();
		assertEquals("20160302T174116Z", eve.getDateDTS());
	}

	@Test
	public void testGetUID() {
		Event eve = new Event();
		assertEquals("1@example.com", eve.getUID());
	}

	@Test
	public void testGetDate() {
		Event eve = new Event();
		assertEquals("20160302T120000", eve.getDate());
	}

	@Test
	public void testGetDateEnd() {
		Event eve = new Event();
		assertEquals("20160316T121500", eve.getDateEnd());
	}

	@Test
	public void testGetTitle() {
		Event eve = new Event();
		assertEquals("eewe", eve.getTitle());
	}

	@Test
	public void testGetDescription() {
		Event eve = new Event();
		assertEquals("weweew", eve.getDescription());
	}

	@Test
	public void testHasAlarm() {
		Event eve = new Event();
		assertEquals(true, eve.hasAlarm());
	}

	@Test
	public void testGetTrigger() {
		Event eve = new Event();
		assertEquals("15M", eve.getTrigger());
	}

	@Test
	public void testSetDateDTS() {
		Event eve =new Event();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      eve.setDateDTS("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("BEGIN:VEVENT"+separator+"DTSTAMP:a"+separator,outContent.toString());
	}

	@Test
	public void testSetUID() {
		Event eve =new Event();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      eve.setUID("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("UID:a"+separator,outContent.toString());
	}

	@Test
	public void testSetDate() {
		Event eve =new Event();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      eve.setDate("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("DTSTART:a"+separator,outContent.toString());
	}

	@Test
	public void testSetDateEnd() {
		Event eve =new Event();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      eve.setDateEnd("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("DTEND:a"+separator,outContent.toString());
	}

	@Test
	public void testSetTitle() {
		Event eve =new Event();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      eve.setTitle("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("SUMMARY:a"+separator,outContent.toString());
	}

	@Test
	public void testSetDescription() {
		Event eve =new Event();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      eve.setDescription("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("DESCRIPTION:a"+separator,outContent.toString());
	}

	@Test
	public void testSetAlarm() {
		Event eve =new Event();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      eve.setAlarm("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("TRIGGER:a"+separator+"END:VEVENT"+separator,outContent.toString());
	}

}
