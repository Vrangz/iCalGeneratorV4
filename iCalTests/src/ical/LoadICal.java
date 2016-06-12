package ical;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadICal implements Operation {

    private LoadICal(Calendar c) {
        this.calendar = c;
    }

    @Override
    public void run() {
        try {
            Scanner reader = new Scanner(new File("iCalendar.ical"));
            String line;
            String[] param_val;
            String parameter;
            String value;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                param_val = line.split(":");
                parameter = param_val[0];
                value = param_val[1];
                switch (parameter) {
                    case "BEGIN":
                        switch (value) {
                            case "VCALENDAR":
                                break;
                            case "VTIMEZONE":
                                break;
                            case "DAYLIGHT":
                                while (!line.equals("END:DAYLIGHT")) {
                                    line = reader.nextLine();
                                    param_val = line.split(":");
                                    parameter = param_val[0];
                                    value = param_val[1];
                                    switch (parameter) {
                                        case "TZOFFSETFROM":
                                            calendar.setDaylightFrom(value);
                                            break;
                                        case "TZOFFSETTO":
                                            calendar.setDaylightTo(value);
                                            break;
                                        case "TZNAME":
                                            calendar.setDaylightName(value);
                                            break;
                                    }
                                }
                                break;
                            case "STANDARD":
                                while (!line.equals("END:STANDARD")) {
                                    line = reader.nextLine();
                                    param_val = line.split(":");
                                    parameter = param_val[0];
                                    value = param_val[1];
                                    switch (parameter) {
                                        case "TZOFFSETFROM":
                                            calendar.setStandardFrom(value);
                                            break;
                                        case "TZOFFSETTO":
                                            calendar.setStandardTo(value);
                                            break;
                                        case "TZNAME":
                                            calendar.setStandardName(value);
                                            break;
                                    }
                                }
                                break;
                            case "VEVENT":
                                while (!line.equals("END:VEVENT")) {
                                    line = reader.nextLine();
                                    param_val = line.split(":");
                                    parameter = param_val[0];
                                    value = param_val[1];
                                    Event e = new Event();
                                    switch (parameter) {
                                        case "DTSTAMP":
                                            e.setDateDTS(value);
                                            break;
                                        case "UID":
                                            e.setUID(value);
                                            break;
                                        case "SUMMARY":
                                            e.setTitle(value);
                                            break;
                                        case "DESCRIPTION":
                                            e.setDescription(value);
                                            break;
                                        case "TRIGGER":
                                            e.setAlarm(value);
                                            break;
                                    }
                                    if (("DTSTART;TZID=&quot;" + calendar.getTimeZone() + "&quot;").equals(parameter)) {
                                        e.setDate(value);
                                    } else if (("DTEND;TZID=&quot;" + calendar.getTimeZone() + "&quot;").equals(parameter)) {
                                        e.setDateEnd(value);
                                    }
                                }
                        }
                    case "VERSION":
                        break;
                    case "PRODID":
                        break;
                    case "X-WR-CALNAME":
                        calendar.setName(value);
                        break;
                    case "CALSCALE":
                        break;
                    case "TZID":
                        calendar.setTimeZone(value);
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadICal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static LoadICal instance = new LoadICal(Main.calendar);
    private final Calendar calendar;
}
