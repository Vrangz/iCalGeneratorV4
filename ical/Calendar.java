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
        events.add(new Event()); // Dla testów
    }

	/**
	 * Zwraca nazwę kalendarza.
     * @return nazwa kalendarza
	 */
    public String getName() {
        return "test";
    }

	/**
	 * Zwraca strefę czasową kalendarza.
     * @return strefa czasowa kalendarza
	 */
    public String getTimeZone() {
        return "Europe/Berlin";
    }

	/**
	 * Zwraca godzinę obowiązywania czasu letniego.
     * @return godzina rozpoczęcia czasu letniego
	 */
    public String getDaylightFrom() {
        return "+0100";
    }

	/**
	 * Zwraca godzinę zakończenia czasu letniego.
     * @return godzina zakończenia czasu letniego
	 */
    public String getDaylightTo() {
        return "+0200";
    }

	/**
	 * Zwraca strefę czasową czasu letniego.
     * @return strefa czasowa czasu letniego
	 */
    public String getDaylightName() {
        return "CEST";
    }

	/**
	 * Zwraca godzinę obowiązywania czasu standardowego.
     * @return godzina rozpoczęcia czasu zimowego
	 */
    public String getStandardFrom() {
        return "+0200";
    }

	/**
	 * Zwraca godzinę zakończenia czasu standardowego.
     * @return godzina zakończenia czasu zimowego
	 */
    public String getStandardTo() {
        return "+0100";
    }

	/**
	 * Zwraca strefę czasową czasu standardowego.
     * @return strefa czasowa czasu zimowego
	 */
    public String getStandardName() {
        return "CET";
    }

	/**
	 * Zwraca wszystkie wydarzenia z kalendarza.
     * @return lista wydarzeń kalendarza
	 */
    public ArrayList<Event> getEvents() {
        return events;
    }

	/**
	 * Ustawia nazwę kalendarza.
     * @return nazwa kalendarza
	 */
    void setName(String value) {
        System.out.println("X-WR-CALNAME:" + value);
    }

	/**
	 * Ustawia strefę czasową kalendarza.
     * @param value strefa czasowa kalendrza
	 */
    void setTimeZone(String value) {
        System.out.println("TZID:" + value);
    }

	/**
	 * Ustawia godzinę obowiązywania czasu letniego.
     * @param value godzina rozpoczęcia czasu letniego
	 */
    void setDaylightFrom(String value) {
        System.out.println("BEGIN:DAYLIGHT");
        System.out.println("TZOFFSETFROM:" + value);
    }

	/**
	 * Ustawia godzinę zakończenia czasu letniego.
     * @param value godzina zakończenia czasu letniego
	 */
    void setDaylightTo(String value) {
        System.out.println("TZOFFSETTO:" + value);
    }

	/**
	 * Ustawia strefę czasową czasu letniego.
     * @param value strefa czasowa czasu zimowego
	 */
    void setDaylightName(String value) {
        System.out.println("TZNAME:" + value);
        System.out.println("END:DAYLIGHT");
    }

	/**
	 * Ustawia godzinę obowiązywania czasu standardowego.
     * @param value godzina rozpoczęcia czasu zimowego
	 */
    void setStandardFrom(String value) {
        System.out.println("BEGIN:STANDARD");
        System.out.println("TZOFFSETFROM:" + value);
    }

	/**
	 * Ustawia godzinę zakończenia czasu standardowego.
     * @param value godzina zakończenia czasu zimowego
	 */
    void setStandardTo(String value) {
        System.out.println("TZOFFSETTO:" + value);
    }

	/**
	 * Ustawia strefę czasową czasu standardowego.
     * @param value strefa czasowa czasu zimowego
	 */
    void setStandardName(String value) {
        System.out.println("TZNAME:" + value);
        System.out.println("END:STANDARD");
    }
    private final ArrayList<Event> events;
}
