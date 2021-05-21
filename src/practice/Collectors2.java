package practice;

import practice.data.BuildData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors2 {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = BuildData.getMapWithListValues();
        Map<Integer, Integer> mapSumLambda = new HashMap<>();
        Map<Integer, Integer> mapSumMethodReference;

        mapSumMethodReference = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(e -> e.getValue().stream().reduce(0, Math::addExact))));

        mapSumMethodReference.forEach((key, value) -> System.out.println("Key :" + key + " Value : " + value));

        map.forEach((key, value) -> mapSumLambda.put(key, value.stream().reduce(0, Math::addExact)));

        mapSumLambda.forEach((key, value) -> System.out.println("Key :" + key + " Value : " + value));


    }
}
