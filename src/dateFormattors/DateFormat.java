package dateFormattors;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateFormat {

    public DateTimeFormatter getFormatter() {
        DateTimeFormatter form1 = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd")
                .toFormatter();
        DateTimeFormatter form2 = new DateTimeFormatterBuilder()
                .appendPattern("yyyy/MM/dd")
                .toFormatter();
        DateTimeFormatter form3 = new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-yyyy")
                .toFormatter();
        DateTimeFormatter form4 = new DateTimeFormatterBuilder()
                .appendPattern("MMMM dd,yyyy")
                .toFormatter();
        DateTimeFormatter form5 = new DateTimeFormatterBuilder()
                .appendPattern("dd.MMMM.yyyy")
                .toFormatter();


        return new DateTimeFormatterBuilder()
                .appendOptional(form1)
                .appendOptional(form2)
                .appendOptional(form3)
                .appendOptional(form4)
                .appendOptional(form5)
                .toFormatter();
    }
}
