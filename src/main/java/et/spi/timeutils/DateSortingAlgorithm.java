package et.spi.timeutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DateSortingAlgorithm {
    public static void main(String[] args) {
        String[] dates = {
                "15.06.2023",
                "01.05.2023",
                "10.05.2023",
                "05.06.2023",
                "05.06.2023",
                "05.07.2023",
                "05.08.2023"
        };

        sortDates(dates);

        // Вывод отсортированных дат
        for (String date : dates) {
            System.out.println(date);
        }
    }

    public static void sortDates(String[] dates) {
        Arrays.sort(dates, new Comparator<String>() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

            @Override
            public int compare(String date1, String date2) {
                try {
                    Date parsedDate1 = dateFormat.parse(date1);
                    Date parsedDate2 = dateFormat.parse(date2);
                    return parsedDate1.compareTo(parsedDate2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }
}