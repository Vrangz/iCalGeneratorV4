package ical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCalendar.class, TestEvent.class, TestGenerateICal.class, TestLoadICal.class,
		TestParseUzSite.class })
public class TestAll {

}
