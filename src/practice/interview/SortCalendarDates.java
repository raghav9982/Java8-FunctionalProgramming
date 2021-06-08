package practice.interview;

import practice.model.DateMonthYear;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SortCalendarDates {
    public static void main(String[] args) {
        List<String> datesString = Arrays.asList("03-9-2020", "07-2-2019", "08-1-2019");

         datesString.stream()
                 .map(SortCalendarDates::splitAndMerge)
                 .sorted().map(SortCalendarDates::splitAndMerge)
                 .forEach(System.out::println);


        datesString.stream().sorted((a, b) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            Date d1 = null;
            try {
                d1 = sdf.parse(a);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date d2 = null;
            try {
                d2 = sdf.parse(b);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            assert d1 != null;
            return d1.compareTo(d2);
        }).forEach(System.out::println);

        datesString.stream().map(t -> new DateMonthYear(t.split("-")[0], t.split("-")[1], t.split("-")[2]))
                .sorted(Comparator.comparing(DateMonthYear::getYear).thenComparing(DateMonthYear::getMonth).thenComparing(DateMonthYear::getDate))
                .forEach(System.out::println);

    }

    private static String splitAndMerge(String r) {

        StringBuilder sbuilder = new StringBuilder();
        String[] strArray = r.split("-");
        return sbuilder.append(strArray[2]).append("-").append(strArray[1]).append("-").append(strArray[0]).toString();


    }


}
