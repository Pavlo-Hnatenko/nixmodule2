package task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DateFormatter {

    public static List<String> formatDate(List<LocalDate> originDates) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return originDates.stream()
                .filter(localDate -> localDate.toString().matches("\\d{2,4}[/-]\\d{2,4}[/-]\\d{2,4}"))
                .map(localDate -> localDate.format(formatter))
                .collect(Collectors.toList());
    }
}
