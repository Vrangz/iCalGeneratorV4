package ical;

class Event {

    public Event() {
    }

    public String getDateDTS() {
        return "20160302T174116Z";
    }

    public String getUID() {
        return "1@example.com";
    }

    public String getDate() {
        return "20160302T120000";
    }

    public String getDateEnd() {
        return "20160316T121500";
    }

    public String getTitle() {
        return "eewe";
    }

    public String getDescription() {
        return "weweew";
    }

    public boolean hasAlarm() {
        return true;
    }

    public String getTrigger() {
        return "15M";
    }

    public void setDateDTS(String value) {
        System.out.println("BEGIN:VEVENT");
        System.out.println("DTSTAMP:" + value);
    }

    public void setUID(String value) {
        System.out.println("UID:" + value);
    }

    public void setDate(String value) {
        System.out.println("DTSTART:" + value);
    }

    public void setDateEnd(String value) {
        System.out.println("DTEND:" + value);
    }

    public void setTitle(String value) {
        System.out.println("SUMMARY:" + value);
    }

    public void setDescription(String value) {
        System.out.println("DESCRIPTION:" + value);
    }

    public void setAlarm(String value) {
        System.out.println("TRIGGER:" + value);
        System.out.println("END:VEVENT");
    }
}
