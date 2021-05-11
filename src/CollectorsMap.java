import practice.data.BuildData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMap {

    public static void main(String[] args) {

        collectorCountingExample(BuildData.getMapIntegerIntegerData());
        countKeysinMap(BuildData.getMapIntegerIntegerData());

        mergeTwoMaps(BuildData.getMapData(), BuildData.getDuplicateMapData());
        mergeTwoSets(BuildData.getMapData(), BuildData.getDuplicateMapData());

        collectorsJoiningExample(BuildData.getWordsDats());

    }

    private static void collectorsJoiningExample(List<String> wordsArray) {

        String words = wordsArray.stream().collect(Collectors.joining("-", "!", "!"));
        System.out.println("joined words : " + words);
    }

    private static void mergeTwoMaps(Map<Character, Integer> mapData, Map<Character, Integer> duplicateMapData) {
        Map<Character, Integer> combinedStream = Stream.of(mapData, duplicateMapData).flatMap(e -> e.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Math::addExact, LinkedHashMap::new));
        combinedStream.forEach((k, v) -> System.out.println(k + " " + v));
    }

    private static void mergeTwoSets(Map<Character, Integer> mapData, Map<Character, Integer> duplicateMapData) {
        Set<Character> mergedSets = Stream.of(mapData.keySet(), duplicateMapData.keySet()).flatMap(Set::stream).collect(Collectors.toSet());
        mergedSets.forEach(System.out::println);
    }

    private static void collectorCountingExample(Map<Integer, Integer> integerIntegerMap) {
        Map<Integer, Integer> addValuesMap = integerIntegerMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, Math::addExact));
        addValuesMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static void countKeysinMap(Map<Integer, Integer> integerIntegerMap) {
        System.out.println("Values in countKeysinMap: ");
        Map<Integer, Integer> countValuesMap = integerIntegerMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, e -> 1, (e1, e2) -> e1 + 1, TreeMap::new));
        countValuesMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
