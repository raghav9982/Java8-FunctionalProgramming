import practice.data.BuildData;
import practice.model.Employee;
import practice.model.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsConcatLists {

    public static void main(String[] args) {
        concatPrimitiveLists();
        concatTwoObjectList(BuildData.getEmployeeList());
    }

    private static void concatTwoObjectList(List<Employee> employeeList) {
        List<Employee> e1 = Collections.singletonList(employeeList.get(2));
        List<Employee> e2 = Arrays.asList(employeeList.get(0), employeeList.get(1), employeeList.get(3));

        concatAndExtractList(e1, e2);
        concatAndExtractSet(e1, e2);

        convertOneObjectToAnother(e1,e2);

    }

    private static void convertOneObjectToAnother(List<Employee> e1, List<Employee> e2) {
        List<Person> sortedTransformedList = Stream.of(e1, e2)
                .flatMap(List::stream)
                .map(e -> new Person(e.getId(), e.getName()))
                .filter(p -> p.getId() > 2)
                .sorted(Comparator.comparing(Person::getId).thenComparing(Person::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        sortedTransformedList.forEach(System.out::println);

    }

    private static void concatAndExtractList(List<Employee> e1, List<Employee> e2) {
        List<Employee> sortedSet = Stream.of(e1, e2)
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Employee::getId, Comparator.reverseOrder()).thenComparing(Employee::getSalary))
                .distinct()
                .collect(Collectors.toList());
        sortedSet.forEach(System.out::println);
    }

    private static void concatAndExtractSet(List<Employee> e1, List<Employee> e2) {

        // 1. sort it before and then use linkedHashSet
        Set<Employee> sortedSet = Stream.of(e1, e2)
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Employee::getId, Comparator.reverseOrder()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        sortedSet.forEach(System.out::println);


        //2. Even better if you can do comparator within Collectors
        Set<Employee> sortedSetWithComparatorInCollections = Stream.of(e1, e2)
                .flatMap(List::stream)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getId, Comparator.reverseOrder()))));
        sortedSetWithComparatorInCollections.forEach(System.out::println);


    }

    private static void concatPrimitiveLists() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(4, 6, 7, 8);

        Set<Integer> finalConcatList = Stream.of(list1, list2)
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        finalConcatList.forEach(System.out::println);
    }
}
