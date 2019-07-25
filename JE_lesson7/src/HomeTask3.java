import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

/**
 3. Задана строка с датой вида "22.01.2019 19:15:00".
 Написать метод который преобразовывает ее в формат "22 Jan, 7:15 PM".
 Предусмотреть обработку ситуации если входящая дата в недопустимом формате.
* */

public class HomeTask3 {
    private static String dateReformat (String givenDate) throws DateTimeException {
        try {
            DateTimeFormatter givenFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").withLocale(Locale.US);
            int year = LocalDate.from(givenFormat.parse(givenDate)).getYear();
            int month = LocalDate.from(givenFormat.parse(givenDate)).getMonthValue();
            int day = LocalDate.from(givenFormat.parse(givenDate)).getDayOfMonth();
            int hour = LocalDateTime.from(givenFormat.parse(givenDate)).getHour();
            int minute = LocalDateTime.from(givenFormat.parse(givenDate)).getMinute();
            int second = LocalDateTime.from(givenFormat.parse(givenDate)).getSecond();
            DateTimeFormatter outFormat = DateTimeFormatter.ofPattern("dd MMM, hh:mm a").withLocale(Locale.US);
            String result = outFormat.format(LocalDateTime.of(year, month, day, hour, minute, second));

            return result;
        } catch (DateTimeException e){
            throw new DateTimeException("Incorrect format of date. Need format dd.MM.yyyy HH:mm:ss");
        }
    }


    public static void main(String[] args){
        System.out.println(dateReformat("22.03.2019 09:15:05"));
    }
}
