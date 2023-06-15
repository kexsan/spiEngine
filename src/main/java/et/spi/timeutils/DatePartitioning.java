package et.spi.timeutils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DatePartitioning {
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
        Collections.sort(Arrays.asList(dates),comparator);
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

        for (String date : dates) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date parsedDate = dateFormat.parse(date);

                SimpleDateFormat monthFormat = new SimpleDateFormat("MM.yyyy");
                String month = monthFormat.format(parsedDate);

                List<String> monthDates = partitionedDates.getOrDefault(month, new ArrayList<>());
                monthDates.add(date);
                partitionedDates.put(month, monthDates);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return partitionedDates;
    }

   static Comparator<String> comparator = new Comparator<String>() {
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
    };


}