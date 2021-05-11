import practice.data.BuildData;
import practice.model.Employee;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SortCollectionTypes {

    public static void main(String[] args) {
        primitiveDataTypes();

        ObjectDataComparator(BuildData.getEmployeeList());


    }

    private static void ObjectDataComparator(List<Employee> employeeList) {

        sortEmployeesCustomOrder(employeeList);
   //     sortEmployeesCustomOrder(buildDataWithMap());

    }

   /* private static List<Employee> buildDataWithMap() {
        Map<>
    }*/

    private static void sortEmployeesCustomOrder(List<Employee> employeeList) {
        List<Employee> sortedEmployees = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()).thenComparing(Employee::getName, Comparator.reverseOrder()).thenComparing(Employee::getId, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("Employes soerted by salary and then by name");
        sortedEmployees.forEach(employee -> System.out.println("Values supplied are : " + employee));
    }

    private static void primitiveDataTypes() {
        Map<Character, Integer> characterIntegerMap = BuildData.getMapData();

        Map<Character, Integer> sortedMap = sortMapByComparingKey(characterIntegerMap);

        Map<Integer, Set<Character>> groupedMap = mapByGroup(characterIntegerMap);


        printElements(sortedMap);
        System.out.println("Grouped Map");
        printMap(groupedMap);

        System.out.println("Sorted Map Reversing order");
        sortMapInreversingOrder(characterIntegerMap);

        Map<Integer, Character> sortedWithMapButRetunedwithValuesAsKey = swapKeyAndValueIntoResult(characterIntegerMap);

        System.out.println("values rearraanged: ");
        sortedWithMapButRetunedwithValuesAsKey.forEach((k, v) -> System.out.println("Key: " + k + " value : " + v));

        System.out.println("Grouping and then count :");
        collectorCountingExample(characterIntegerMap);
    }

    private static void collectorCountingExample(Map<Character, Integer> characterIntegerMap) {
        Map<Integer,Set<Character>> characterSetMap = characterIntegerMap.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toSet())));
        printMap(characterSetMap);
    }


    private static Map<Integer, Character> swapKeyAndValueIntoResult(Map<Character, Integer> characterIntegerMap) {
        return characterIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private static Map<Character, Integer> sortMapInreversingOrder(Map<Character, Integer> characterIntegerMap) {
        Map<Character, Integer> sortedMap = characterIntegerMap.entrySet().stream().
                sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        printElements(sortedMap);
        return sortedMap;
    }

    private static void printMap(Map<Integer, Set<Character>> groupedMap) {
        groupedMap.forEach((k, v) -> System.out.println("key: " + k + "value: " + v));
    }

    private static void printElements(Map<Character, Integer> sortedMap) {
        sortedMap.forEach((k, v) -> System.out.println("key :" + k + " value : " + v));
    }

    private static Map<Integer, Set<Character>> mapByGroup(Map<Character, Integer> characterIntegerMap) {

        return characterIntegerMap.entrySet().stream().
                collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toSet())));
    }

    private static Map<Character, Integer> sortMapByComparingKey(Map<Character, Integer> characterIntegerMap) {
        return characterIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }


}
