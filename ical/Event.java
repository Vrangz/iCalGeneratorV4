package ical;

/**
 * Opisuje jedno zdarzenie w kalendarzu.
 */
class Event {

	/**
	 * Tworzy puste wydarzenie.
	 */
    public Event() {
    }

	/**
	 * Zwraca datę początkową.
	 */
    public String getDateDTS() {
        return "20160302T174116Z";
    }

	/**
	 * Zwraca unikalne ID wydarzenia.
	 */
    public String getUID() {
        return "1@example.com";
    }

	/**
	 * Zwraca datę rozpoczęcia wydarzenia.
	 */
    public String getDate() {
        return "20160302T120000";
    }

	/**
	 * Zwraca datę zakończenia wydarzenia.
	 */
    public String getDateEnd() {
        return "20160316T121500";
    }

	/**
	 * Zwraca nazwę wydarzenia.
	 */
    public String getTitle() {
        return "eewe";
    }

	/**
	 * Zwraca opis wydarzenia.
	 */
    public String getDescription() {
        return "weweew";
    }

	/**
	 * Zwraca czy jest ustawiony alarm na wydarzeniu.
	 */
    public boolean hasAlarm() {
        return true;
    }

	/**
	 * Zwraca godzinę ustawionego alarmu.
	 */
    public String getTrigger() {
        return "15M";
    }

	/**
	 * Ustawia początkową datę.
	 */
    public void setDateDTS(String value) {
        System.out.println("BEGIN:VEVENT");
        System.out.println("DTSTAMP:" + value);
    }

	/**
	 * Ustawia unikalne ID wydarzenia.
	 */
    public void setUID(String value) {
        System.out.println("UID:" + value);
    }

	/**
	 * Ustawia datę rozpoczęcia wydarzenia.
	 */
    public void setDate(String value) {
        System.out.println("DTSTART:" + value);
    }

	/**
	 * Ustawia datę zakończenia wydarzenia.
	 */
    public void setDateEnd(String value) {
        System.out.println("DTEND:" + value);
    }

	/**
	 * Ustawia nazwę wydarzenia.
	 */
    public void setTitle(String value) {
        System.out.println("SUMMARY:" + value);
    }

	/**
	 * Ustawia opis wydarzenia.
	 */
    public void setDescription(String value) {
        System.out.println("DESCRIPTION:" + value);
    }

	/**
	 * Ustawia alarm na wydarzeniu.
	 */
    public void setAlarm(String value) {
        System.out.println("TRIGGER:" + value);
        System.out.println("END:VEVENT");
    }
}
