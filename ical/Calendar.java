package ical;

import java.util.ArrayList;

/**
 * Opisuje kalendarz.
 */
class Calendar {
    
	/**
	 * Tworzy nowy kalendarz z pustymi wydarzeniami.
	 */
    public Calendar() {
        events = new ArrayList<>();
        events.add(new Event());
    }

	/**
	 * Zwraca nazwę kalendarza.
	 */
    public String getName() {
        return "test";
    }

	/**
	 * Zwraca strefę czasową kalendarza.
	 */
    public String getTimeZone() {
        return "Europe/Berlin";
    }

	/**
	 * Zwraca godzinę obowiązywania czasu letniego.
	 */
    public String getDaylightFrom() {
        return "+0100";
    }

	/**
	 * Zwraca godzinę zakończenia czasu letniego.
	 */
    public String getDaylightTo() {
        return "+0200";
    }

	/**
	 * Zwraca strefę czasową czasu letniego.
	 */
    public String getDaylightName() {
        return "CEST";
    }

	/**
	 * Zwraca godzinę obowiązywania czasu standardowego.
	 */
    public String getStandardFrom() {
        return "+0200";
    }

	/**
	 * Zwraca godzinę zakończenia czasu standardowego.
	 */
    public String getStandardTo() {
        return "+0100";
    }

	/**
	 * Zwraca strefę czasową czasu standardowego.
	 */
    public String getStandardName() {
        return "CET";
    }

	/**
	 * Zwraca wszystkie wydarzenia z kalendarza.
	 */
    public ArrayList<Event> getEvents() {
        return events;
    }

	/**
	 * Ustawia nazwę kalendarza.
	 */
    void setName(String value) {
        System.out.println("X-WR-CALNAME:" + value);
    }

	/**
	 * Ustawia strefę czasową kalendarza.
	 */
    void setTimeZone(String value) {
        System.out.println("TZID:" + value);
    }

	/**
	 * Ustawia godzinę obowiązywania czasu letniego.
	 */
    void setDaylightFrom(String value) {
        System.out.println("BEGIN:DAYLIGHT");
        System.out.println("TZOFFSETFROM:" + value);
    }

	/**
	 * Ustawia godzinę zakończenia czasu letniego.
	 */
    void setDaylightTo(String value) {
        System.out.println("TZOFFSETTO:" + value);
    }

	/**
	 * Ustawia strefę czasową czasu letniego.
	 */
    void setDaylightName(String value) {
        System.out.println("TZNAME:" + value);
        System.out.println("END:DAYLIGHT");
    }

	/**
	 * Ustawia godzinę obowiązywania czasu standardowego.
	 */
    void setStandardFrom(String value) {
        System.out.println("BEGIN:STANDARD");
        System.out.println("TZOFFSETFROM:" + value);
    }

	/**
	 * Ustawia godzinę zakończenia czasu standardowego.
	 */
    void setStandardTo(String value) {
        System.out.println("TZOFFSETTO:" + value);
    }

	/**
	 * Ustawia strefę czasową czasu standardowego.
	 */
    void setStandardName(String value) {
        System.out.println("TZNAME:" + value);
        System.out.println("END:STANDARD");
    }
    private final ArrayList<Event> events;
}
