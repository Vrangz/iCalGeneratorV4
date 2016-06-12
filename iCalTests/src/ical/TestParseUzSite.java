package ical;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class TestParseUzSite {

	@Test
	public void testParseUz1() throws IOException {
		ParseUzSite plan = new ParseUzSite("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16664");
		plan.parseUz();
		assertTrue(plan.getStartHourArray().contains("13-06-2016 09:15"));
	}

	@Test
	public void testParseUz2() throws IOException {
		try {
			ParseUzSite plan = new ParseUzSite("http://www.google.pl");
			plan.parseUz();
			fail();
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		fail();

	}

	@Test
	public void testGetStartHourArray() throws IOException {
		ParseUzSite plan = new ParseUzSite("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16664");
		plan.parseUz();
		assertTrue(plan.getStartHourArray().contains("13-06-2016 09:15"));
	}

	@Test
	public void testGetEndHourArray() throws IOException {
		ParseUzSite plan = new ParseUzSite("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16664");
		plan.parseUz();
		assertTrue(plan.getEndHourArray().contains("13-06-2016 10:45"));
	}

	@Test
	public void testGetName() throws IOException {
		ParseUzSite plan = new ParseUzSite("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16664");
		plan.parseUz();
		assertTrue(plan.getName().contains("Architektura komputerów II"));
	}

	@Test
	public void testSetUrl() throws Exception {
		ParseUzSite plan = new ParseUzSite("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16664");
		plan.setUrl("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16669&pTyp=P");
		assertEquals(plan.url, "http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16669&pTyp=P");
	}

	@Test
	public void testPrintEvents() throws IOException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ParseUzSite plan = new ParseUzSite("http://plan.uz.zgora.pl/grupy_plan.php?pId_Obiekt=16664");
		plan.parseUz();
		plan.printEvents();
		assertTrue(outContent.toString().contains("29-02-2016 09:15 - 29-02-2016 10:45 Architektura komputerów II"));
	}

}
