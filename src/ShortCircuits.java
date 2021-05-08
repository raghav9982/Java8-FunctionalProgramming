import practice.data.BuildData;
import practice.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ShortCircuits {
    public static void main(String[] args) {

        List<Integer> listOfNumbers = BuildData.getShortCircuitData();

        //Intermediary distinct check
        distinctVstoSet();
        limit();
        anyMatch();
        allMatch();
        noneMatch();
        findFirst();
        findAnyParallel();

    }

    private static void findAnyParallel() {
        //  IntStream.range(1,100).parallel().filter(x->x>55 && x<87).findAny().ifPresent(System.out::println);
        List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");
        List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");

        Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();
        Optional<String> findAny = lst2.parallelStream().filter(s -> s.startsWith("J")).findAny();

        findFirst.ifPresent(System.out::println);
        findAny.ifPresent(System.out::println);
    }

    private static void findFirst() {
        BuildData.getShortCircuitData().stream().filter(x->x>3).findAny().ifPresent(System.out::println);
    }

    private static void noneMatch() {
            boolean noneMatch = BuildData.getShortCircuitData().stream().noneMatch(val -> val > 3);
            System.out.println("noneMatch Value: " + noneMatch);
    }

    private static void allMatch() {
        boolean allMatchValue = BuildData.getShortCircuitData().stream().allMatch(val -> val > 3);
        System.out.println("allMatch Value: " + allMatchValue);
    }

    private static void anyMatch() {
        boolean anyMatchValue = BuildData.getShortCircuitData().stream().anyMatch(val -> val > 3);
        System.out.println("anyMatch Value: " + anyMatchValue);
    }

    private static void distinctVstoSet() {
        Set<String> noDuplicates = BuildData.getEmployeeList().stream().map(Employee::getName).collect(Collectors.toSet());
        List<String> distinctNames = BuildData.getEmployeeList().stream().map(Employee::getName).distinct().collect(Collectors.toList());

        System.out.println(" with collectors to set : ");
        noDuplicates.forEach(System.out::println);

        System.out.println("with distinct: ");
        distinctNames.forEach(System.out::println);
    }

    private static void limit() {
        System.out.println();
        System.out.println("Limit to 3 values using Limit function");
        BuildData.getEmployeeList().stream().map(Employee::getName).limit(3).forEach(System.out::println);

    }
}
