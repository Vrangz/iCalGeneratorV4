package ical;

import java.util.ArrayList;

class Calendar {
    
    public Calendar() {
        events = new ArrayList<>();
        events.add(new Event());
    }

    public String getName() {
        return "test";
    }

    public String getTimeZone() {
        return "Europe/Berlin";
    }

    public String getDaylightFrom() {
        return "+0100";
    }

    public String getDaylightTo() {
        return "+0200";
    }

    public String getDaylightName() {
        return "CEST";
    }

    public String getStandardFrom() {
        return "+0200";
    }

    public String getStandardTo() {
        return "+0100";
    }

    public String getStandardName() {
        return "CET";
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    void setName(String value) {
        System.out.println("X-WR-CALNAME:" + value);
    }

    void setTimeZone(String value) {
        System.out.println("TZID:" + value);
    }

    void setDaylightFrom(String value) {
        System.out.println("BEGIN:DAYLIGHT");
        System.out.println("TZOFFSETFROM:" + value);
    }

    void setDaylightTo(String value) {
        System.out.println("TZOFFSETTO:" + value);
    }

    void setDaylightName(String value) {
        System.out.println("TZNAME:" + value);
        System.out.println("END:DAYLIGHT");
    }

    void setStandardFrom(String value) {
        System.out.println("BEGIN:STANDARD");
        System.out.println("TZOFFSETFROM:" + value);
    }

    void setStandardTo(String value) {
        System.out.println("TZOFFSETTO:" + value);
    }

    void setStandardName(String value) {
        System.out.println("TZNAME:" + value);
        System.out.println("END:STANDARD");
    }
    private final ArrayList<Event> events;
}
