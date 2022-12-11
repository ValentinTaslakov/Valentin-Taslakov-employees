package factories;


import dateFormattors.DateFormat;
import model.Employee;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EmployeeFactory {

    public static Employee createEmployee(String line) {
        String[] data = line.split(", ");

        long employeeId = Long.parseLong(data[0]);
        long projectId = Long.parseLong(data[1]);

        DateTimeFormatter formatter = new DateFormat().getFormatter();

        try {
            LocalDate dateFrom = LocalDate.parse(data[2], formatter);
            LocalDate dateTo = data[3].equals("NULL") ? LocalDate.now() : LocalDate.parse(data[3], formatter);
            return new Employee(employeeId, projectId, dateFrom, dateTo);
        } catch (DateTimeParseException e) {

            throw new DateTimeException("This date format doesn't support!\nSend me a message and I'll add this format for next update.");
        }

    }
}
