package practice.interview;

import java.util.Arrays;
import java.util.stream.Stream;

public class FilterLetterOnlyAndSortAscending {
    public static void main(String[] args) {
        String s = "Thriveni9";

        Stream.of(s)
                .map(c -> c.split(""))
                .flatMap(Arrays::stream)
                .map(c -> c.toCharArray()[0])
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .sorted()
                .forEach(System.out::println);
    }


}
