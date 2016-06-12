package ical;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestLoadICal {

	@Test
	public void testRun() {
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  System.setOut(new PrintStream(baos));
		 loadICal.run();
		 String output = new String(baos.toByteArray());
		 assertTrue(output.contains("X-WR-CALNAME:test"));
		 assertTrue(output.contains("TZNAME:CEST"));
		 
		 
	}
	static Calendar calendar = new Calendar();
    static Operation loadICal = LoadICal.instance;
}
