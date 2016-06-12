package ical;

import java.util.ArrayList;

/**
 * Opisuje kalendarz.
 */
public class Calendar {
    
	/**
	 * Tworzy nowy kalendarz bez wydarzeń.
	 */
    public Calendar() {
        events = new ArrayList<>();
    }

	/**
	 * Zwraca nazwę kalendarza.
     * @return nazwa kalendarza
	 */
    public String getName() {
        return name;
    }

	/**
	 * Zwraca strefę czasową kalendarza.
     * @return strefa czasowa kalendarza
	 */
    public String getTimeZone() {
        return timeZone;
    }

	/**
	 * Zwraca godzinę obowiązywania czasu letniego.
     * @return godzina rozpoczęcia czasu letniego
	 */
    public String getDaylightFrom() {
        return daylightFrom;
    }

	/**
	 * Zwraca godzinę zakończenia czasu letniego.
     * @return godzina zakończenia czasu letniego
	 */
    public String getDaylightTo() {
        return daylightTo;
    }

	/**
	 * Zwraca strefę czasową czasu letniego.
     * @return strefa czasowa czasu letniego
	 */
    public String getDaylightName() {
        return daylightName;
    }

	/**
	 * Zwraca godzinę obowiązywania czasu standardowego.
     * @return godzina rozpoczęcia czasu zimowego
	 */
    public String getStandardFrom() {
        return standardFrom;
    }

	/**
	 * Zwraca godzinę zakończenia czasu standardowego.
     * @return godzina zakończenia czasu zimowego
	 */
    public String getStandardTo() {
        return standardTo;
    }

	/**
	 * Zwraca strefę czasową czasu standardowego.
     * @return strefa czasowa czasu zimowego
	 */
    public String getStandardName() {
        return standardName;
    }

	/**
	 * Zwraca wszystkie wydarzenia z kalendarza.
     * @return lista wydarzeń kalendarza
	 */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
	 * Dodaje nowe wydarzenie do kalendarza.
     * @param e wydarzenie
	 */
    public void addEvent(Event e) {
        events.add(e);
    }
	/**
	 * Ustawia nazwę kalendarza.
     * @param value nazwa kalendarza
	 */
    public void setName(String value) {
        name = value;
    }

	/**
	 * Ustawia strefę czasową kalendarza.
     * @param value strefa czasowa kalendrza
	 */
    public void setTimeZone(String value) {
        timeZone = value;
    }

	/**
	 * Ustawia godzinę obowiązywania czasu letniego.
     * @param value godzina rozpoczęcia czasu letniego
	 */
    public void setDaylightFrom(String value) {
        daylightFrom = value;
    }

	/**
	 * Ustawia godzinę zakończenia czasu letniego.
     * @param value godzina zakończenia czasu letniego
	 */
    public void setDaylightTo(String value) {
        daylightTo = value;
    }

	/**
	 * Ustawia strefę czasową czasu letniego.
     * @param value strefa czasowa czasu zimowego
	 */
    public void setDaylightName(String value) {
        daylightName = value;
    }

	/**
	 * Ustawia godzinę obowiązywania czasu standardowego.
     * @param value godzina rozpoczęcia czasu zimowego
	 */
    public void setStandardFrom(String value) {
        standardFrom = value;
    }

	/**
	 * Ustawia godzinę zakończenia czasu standardowego.
     * @param value godzina zakończenia czasu zimowego
	 */
    public void setStandardTo(String value) {
        standardTo = value;
    }

	/**
	 * Ustawia strefę czasową czasu standardowego.
     * @param value strefa czasowa czasu zimowego
	 */
    public void setStandardName(String value) {
        standardName = value;
    }
    private final ArrayList<Event> events;
    private String name;
    private String timeZone;
    private String daylightFrom;
    private String daylightTo;
    private String daylightName;
    private String standardFrom;
    private String standardTo;
    private String standardName;
}
