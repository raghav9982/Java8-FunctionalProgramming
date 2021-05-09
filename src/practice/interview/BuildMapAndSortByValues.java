package practice.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BuildMapAndSortByValues {
    public static void main(String[] args) {
        Character[] arr = {'a', 'd', 'a', 'k', 'b', 'h', 'b', 'a', 'b', 'a', 'k'};
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        Arrays.asList(arr).forEach(x -> characterIntegerMap.put(x, characterIntegerMap.getOrDefault(x, 0) + 1));
        Map<Character, Integer> sortedHashMap = characterIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        sortedHashMap.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));

    }
}
