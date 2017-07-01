package app.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {
    public static final String fromLocalDate(LocalDate localDate) {
        if (localDate == null) return null;
        else return localDate.format (DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static final LocalDate fromString(String string) {
        if (string == null) return null;
        else return LocalDate.parse (string, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
