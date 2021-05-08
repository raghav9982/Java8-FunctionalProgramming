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
        return Arrays.asList(e1, e, e2, e3);
    }

    public static Map<Character, Integer> getMapData() {
        Map<Character, Integer> characterIntegerMap = new HashMap<Character, Integer>();

        characterIntegerMap.put('a', 2);
        characterIntegerMap.put('b', 5);
        characterIntegerMap.put('d', 1);
        characterIntegerMap.put('e', 2);
        return characterIntegerMap;
    }
}
