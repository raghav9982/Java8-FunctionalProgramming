import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ComparatorTypes {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8, 5, 9, 20);
        List<Integer> sortedList = sortInt(list);

        Optional<Integer> oneValue = list.stream().min(Integer::compareTo);

        //using comparator
        list.stream().sorted().limit(1).findAny().ifPresent(val -> System.out.println("min Value after existing is :" + val));
        list.stream().sorted(Comparator.reverseOrder()).limit(1).findAny().ifPresent(val -> System.out.println("max Value after existing is :" + val));

        // easily done by using min and max - avoids comparator and extra stuff
        list.stream().min(Integer::compareTo).ifPresent(val -> System.out.println("Min values using min function: " + val));
        list.stream().max(Integer::compareTo).ifPresent(val -> System.out.println("Min values using min function: " + val));


        list.stream()
                .sorted(Comparator.reverseOrder())
                .map(val -> val + 5)
                .limit(2)
                .forEach(System.out::println);
    }

    private static List<Integer> sortInt(List<Integer> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .collect(Collectors.toList());
    }
}
