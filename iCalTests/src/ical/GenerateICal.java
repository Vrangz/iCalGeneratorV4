package ical;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

class GenerateICal implements Operation {

    private GenerateICal(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter("iCalendar.ical", "UTF-8")) {
            writer.println("BEGIN:VCALENDAR");
            writer.println("VERSION:1.0");
            writer.println("PRODID:-//www.dupeczki.pl//iCal Calendar Generator");
            writer.println("X-WR-CALNAME:" + calendar.getName());
            writer.println("CALSCALE:GREGORIAN");
            writer.println("BEGIN:VTIMEZONE");
            writer.println("TZID:" + calendar.getTimeZone());
            writer.println("TZURL:http://tzurl.org/zoneinfo-outlook/" + calendar.getTimeZone());
            writer.println("X-LIC-LOCATION:" + calendar.getTimeZone());
            writer.println("BEGIN:DAYLIGHT");
            writer.println("TZOFFSETFROM:" + calendar.getDaylightFrom());
            writer.println("TZOFFSETTO:" + calendar.getDaylightTo());
            writer.println("TZNAME:" + calendar.getDaylightName());
            writer.println("DTSTART:19700329T020000");
            writer.println("RRULE:FREQ=YEARLY;BYMONTH=3;BYDAY=-1SU");
            writer.println("END:DAYLIGHT");
            writer.println("BEGIN:STANDARD");
            writer.println("TZOFFSETFROM:" + calendar.getStandardFrom());
            writer.println("TZOFFSETTO:" + calendar.getStandardTo());
            writer.println("TZNAME:" + calendar.getStandardName());
            writer.println("DTSTART:19701025T030000");
            writer.println("RRULE:FREQ=YEARLY;BYMONTH=10;BYDAY=-1SU");
            writer.println("END:STANDARD");
            writer.println("END:VTIMEZONE");
            for (Event e : calendar.getEvents()) {
                writer.println("BEGIN:VEVENT");
                writer.println("DTSTAMP:" + e.getDateDTS());
                writer.println("UID:" + e.getUID());
                writer.println("DTSTART;TZID=&quot;" + calendar.getTimeZone() + "&quot;:" + e.getDate());
                writer.println("DTEND;TZID=&quot;" + calendar.getTimeZone() + "&quot;:" + e.getDateEnd());
                writer.println("SUMMARY:" + e.getTitle());
                writer.println("DESCRIPTION:" + e.getDescription());
                if (e.hasAlarm()) {
                    writer.println("BEGIN:VALARM");
                    writer.println("ACTION:DISPLAY");
                    writer.println("DESCRIPTION:" + e.getTitle());
                    writer.println("TRIGGER:-PT" + e.getTrigger());
                    writer.println("END:VALARM");
                }
                writer.println("END:VEVENT");
            }
            writer.println("END:VCALENDAR");
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(GenerateICal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static GenerateICal instance = new GenerateICal(Main.calendar);
    private final Calendar calendar;
}
