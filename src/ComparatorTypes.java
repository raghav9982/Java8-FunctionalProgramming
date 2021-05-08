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
        List<Integer> secondValueList = list.stream().sorted(Comparator.reverseOrder()).map(val -> val + 5).limit(2).collect(Collectors.toList());

        oneValue.ifPresent(val -> System.out.println(val));
        sortedList.forEach(val -> System.out.println(val));
        secondValueList.forEach(val-> {
            System.out.print("Values :");
            System.out.println(val);
        });
    }

    private static List<Integer> sortInt(List<Integer> list) {
        List<Integer> sortedList = list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .collect(Collectors.toList());
        return sortedList;
    }
}
