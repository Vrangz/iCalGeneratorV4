package ical;

/**
 * Opisuje jedno zdarzenie w kalendarzu.
 */
public class Event {

	/**
	 * Tworzy puste wydarzenie.
	 */
    public Event() {
    }

	/**
	 * Zwraca datę początkową.
     * @return stała data
	 */
    public String getDateDTS() {
        return dateDTS;
    }

	/**
	 * Zwraca unikalne ID wydarzenia.
     * @return ID wydarzenia
	 */
    public String getUID() {
        return uID;
    }

	/**
	 * Zwraca datę rozpoczęcia wydarzenia.
     * @return data rozpoczęcia wydarzenia
	 */
    public String getDate() {
        return date;
    }

	/**
	 * Zwraca datę zakończenia wydarzenia.
     * @return data zakończenia wydarzenia
	 */
    public String getDateEnd() {
        return dateEnd;
    }

	/**
	 * Zwraca nazwę wydarzenia.
     * @return nazwa wydarzenia
	 */
    public String getTitle() {
        return title;
    }

	/**
	 * Zwraca opis wydarzenia.
     * @return opis wydarzenia
	 */
    public String getDescription() {
        return description;
    }

	/**
	 * Zwraca czy jest ustawiony alarm na wydarzeniu.
     * @return czy ustawiony alarm
	 */
    public boolean hasAlarm() {
        return alarm;
    }

	/**
	 * Zwraca godzinę ustawionego alarmu.
     * @return ustawiona godzina alarmu
	 */
    public String getTrigger() {
        return trigger;
    }

	/**
	 * Ustawia początkową datę.
     * @param value stała data
	 */
    public void setDateDTS(String value) {
        dateDTS = value;
    }

	/**
	 * Ustawia unikalne ID wydarzenia.
     * @param value ID wydarzenia
	 */
    public void setUID(String value) {
        uID = value;
    }

	/**
	 * Ustawia datę rozpoczęcia wydarzenia.
     * @param value data rozpoczęcia wydarzenia
	 */
    public void setDate(String value) {
        date = value;
    }

	/**
	 * Ustawia datę zakończenia wydarzenia.
     * @param value data zakończenia wydarzenia
	 */
    public void setDateEnd(String value) {
        dateEnd = value;
    }

	/**
	 * Ustawia nazwę wydarzenia.
     * @param value nazwa wydarzenia
	 */
    public void setTitle(String value) {
        title = value;
    }

	/**
	 * Ustawia opis wydarzenia.
     * @param value opis wydarzenia
	 */
    public void setDescription(String value) {
        description = value;
    }

	/**
	 * Ustawia alarm na wydarzeniu.
     * @param value żądana godzina alarmu
	 */
    public void setAlarm(String value) {
        alarm = true;
        trigger = value;
    }
    private String dateDTS;
    private String uID;
    private String date;
    private String dateEnd;
    private String title;
    private String description;
    private boolean alarm;
    private String trigger;
}
