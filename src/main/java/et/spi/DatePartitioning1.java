package et.spi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DatePartitioning1 {
    public static void main(String[] args) {
        String[] dates = {
                "15.01.2023",
                "10.01.2023",
                "05.01.2023",
                "22.01.2023",
                "21.02.2023",
                "27.02.2023",
                "22.02.2023",
                "10.02.2023"
        };

        Arrays.sort(dates, comparator);

        Map<String, List<String>> partitionedDates = partitionDatesByMonth(dates);

        // Вывод разбитых дат по месяцам
        for (Map.Entry<String, List<String>> entry : partitionedDates.entrySet()) {
            String month = entry.getKey();
            List<String> monthDates = entry.getValue();

            System.out.println("Month: " + month);
            for (String date : monthDates) {
                System.out.println(date);
            }
            System.out.println();
        }
    }

    public static Map<String, List<String>> partitionDatesByMonth(String[] dates) {
        Map<String, List<String>> partitionedDates = new TreeMap<>();

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM.yyyy");

        for (String date : dates) {
            try {
                LocalDate parsedDate = LocalDate.parse(date, inputFormatter);

                String month = parsedDate.format(outputFormatter);

                List<String> monthDates = partitionedDates.getOrDefault(month, new ArrayList<>());
                monthDates.add(date);
                partitionedDates.put(month, monthDates);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return partitionedDates;
    }

    static Comparator<String> comparator = Comparator.comparing((String date) -> LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
}