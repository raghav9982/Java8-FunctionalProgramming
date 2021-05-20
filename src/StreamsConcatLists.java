import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsConcatLists {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(4, 6, 7, 8);

        Set<Integer> fianlList = Stream.of(list1, list2)
                                .flatMap(e -> e.stream())
                                .collect(Collectors.toSet());

        fianlList.forEach(System.out::println);
    }
}
