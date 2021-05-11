import practice.data.BuildData;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMap {

    public static void main(String[] args) {

        collectorCountingExample(BuildData.getMapIntegerIntegerData());
        countKeysinMap(BuildData.getMapIntegerIntegerData());

        mergeTwoMaps(BuildData.getMapData(), BuildData.getDuplicateMapData());
        mergeTwoSets(BuildData.getMapData(), BuildData.getDuplicateMapData());

        collectorsJoiningExample(BuildData.getWordsDats());

        collectorsReducingExample(BuildData.getShortCircuitData());

    }

    private static void collectorsReducingExample(List<Integer> shortCircuitData) {
        Optional<Integer> finalCount = shortCircuitData.stream().reduce(Math::addExact);
        System.out.println("final Count after reducing is :" + finalCount);

        int finalCountWithInitialzer = shortCircuitData.stream().reduce(0, Math::addExact);
        System.out.println("finalCountWithInitialzer in Reducer: " + finalCountWithInitialzer);

        int finalCountWithInitialzerWithMultiplier = shortCircuitData.stream().reduce(0, Math::multiplyExact);
        System.out.println("finalCountWithInitialzerWithMultiplier in Reducer: " + finalCountWithInitialzerWithMultiplier);


        String finalCountWithInitialzerMapping = shortCircuitData.stream().map(x -> Integer.toString(x)).reduce("", (e1, e2) -> e1 + e2);
        System.out.println("finalCountWithInitialzerMapping: " + finalCountWithInitialzerMapping);

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
               .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getValue, e -> 1, (e1, e2) -> e1 + 1, LinkedHashMap::new));
        //   countValuesMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap())
        countValuesMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
