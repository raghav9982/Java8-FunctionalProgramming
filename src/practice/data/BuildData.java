package practice.data;

import practice.model.Employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildData {
    public static List<Employee> getEmployeeList() {
        Employee e = new Employee();
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();

        e.setId(1);
        e.setName("Venkat");
        e.setSalary(20000L);

        e1.setId(2);
        e1.setSalary(30000L);
        e1.setName("Raghav");

        e2.setId(3);
        e2.setSalary(30000L);
        e2.setName("Purimetla");

        e3.setId(4);
        e3.setName("Venkat");
        e3.setSalary(20000L);
        return Arrays.asList(e, e1, e2, e3);
    }

    public static Map<Character, Integer> getMapData() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.put('a', 2);
        characterIntegerMap.put('b', 5);
        characterIntegerMap.put('d', 1);
        characterIntegerMap.put('e', 2);
      //  return Collections.unmodifiableMap(characterIntegerMap);
        return characterIntegerMap;
    }

    public static Map<Character, Integer> getDuplicateMapData() {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        characterIntegerMap.put('a', 2);
        characterIntegerMap.put('b', 5);
        characterIntegerMap.put('d', 1);
        characterIntegerMap.put('e', 2);
        characterIntegerMap.put('f', 2);
     //   return Collections.unmodifiableMap(characterIntegerMap);
        return  characterIntegerMap;
    }

    public static List<Integer> getShortCircuitData() {
        return Arrays.asList(1, 2, 2, 3, 4, 5);
    }
    public static List<Integer> getShortCircuitDataForParallel() {
        return Arrays.asList(1, 2, 2, 3, 4, 5, 1, 2, 2, 3, 4, 5, 1, 2, 2, 3, 4, 5);
    }

    public static List<String> getWordsDats() {
        return Arrays.asList("Hello", "World", "Crazy", "Kiya", "re");
    }

    public static Map<Integer, Integer> getMapIntegerIntegerData() {
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();

        integerIntegerMap.put(1000, 2);
        integerIntegerMap.put(2000, 5);
        integerIntegerMap.put(55, 1);
        integerIntegerMap.put(99, 2);
        integerIntegerMap.put(999, 2);
        return integerIntegerMap;
    }


}
