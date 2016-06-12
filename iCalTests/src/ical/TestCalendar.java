package ical;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import ical.*;
import org.junit.Test;

public class TestCalendar {



	@Test
	public void testGetName() {
		Calendar cal =new Calendar();
		String s = "test";
		assertEquals(s, cal.getName());
	}

	@Test
	public void testGetTimeZone() {
		Calendar cal =new Calendar();
		String s = "Europe/Berlin";
		assertEquals(s, cal.getTimeZone());
	}

	@Test
	public void testGetDaylightFrom() {
		Calendar cal =new Calendar();
		String s = "+0100";
		assertEquals(s, cal.getDaylightFrom());
	}

	@Test
	public void testGetDaylightTo() {
		Calendar cal =new Calendar();
		String s = "+0200";
		assertEquals(s, cal.getDaylightTo());
	}

	@Test
	public void testGetDaylightName() {
		Calendar cal =new Calendar();
		String s = "CEST";
		assertEquals(s, cal.getDaylightName());
	}

	@Test
	public void testGetStandardFrom() {
		Calendar cal =new Calendar();
		String s = "+0200";
		assertEquals(s, cal.getStandardFrom());
	}

	@Test
	public void testGetStandardTo() {
		Calendar cal =new Calendar();
		String s = "+0100";
		assertEquals(s, cal.getStandardTo());
	}

	@Test
	public void testGetStandardName() {
		Calendar cal =new Calendar();
		String s = "CET";
		assertEquals(s, cal.getStandardName());
	}

	@Test
	public void testGetEvents() {
		ArrayList<Event> even = new ArrayList<Event>();
		//even.add(new Event());
		Calendar cal =new Calendar();
		//assertEquals(even, cal.getEvents());
		assertNotEquals(even,cal.getEvents());
	}

	@Test
	public void testSetName() {
		Calendar cal =new Calendar();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      cal.setName("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("X-WR-CALNAME:a"+separator,outContent.toString());
	    
	}

	@Test
	public void testSetTimeZone() {
		Calendar cal =new Calendar();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      cal.setTimeZone("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("TZID:a"+separator,outContent.toString());
	}

	@Test
	public void testSetDaylightFrom() {
		Calendar cal =new Calendar();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      cal.setDaylightFrom("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("BEGIN:DAYLIGHT"+separator+"TZOFFSETFROM:a"+separator,outContent.toString());
	}

	@Test
	public void testSetDaylightTo() {
		Calendar cal =new Calendar();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      cal.setDaylightTo("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("TZOFFSETTO:a"+separator,outContent.toString());
	}

	@Test
	public void testSetDaylightName() {
		Calendar cal =new Calendar();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      cal.setDaylightName("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("TZNAME:a"+separator+"END:DAYLIGHT"+separator,outContent.toString());
	}

	@Test
	public void testSetStandardFrom() {
		Calendar cal =new Calendar();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      cal.setStandardFrom("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("BEGIN:STANDARD"+separator+"TZOFFSETFROM:a"+separator,outContent.toString());
	}

	@Test
	public void testSetStandardTo() {
		Calendar cal =new Calendar();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      cal.setStandardTo("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("TZOFFSETTO:a"+separator,outContent.toString());
	}

	@Test
	public void testSetStandardName() {
		Calendar cal =new Calendar();
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      cal.setStandardName("a");
	      String separator = System.getProperty("line.separator");
	      assertEquals("TZNAME:a"+separator+"END:STANDARD"+separator,outContent.toString());
	}

}
