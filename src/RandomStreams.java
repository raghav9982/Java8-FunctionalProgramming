import practice.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RandomStreams {

    public static void main(String[] args) {
        List<Employee> employeeList = buildData();
        getEmplyeesListwithSalaryFilter(employeeList);

        List<String> employeeNames = getEmplyeesListwithSalaryFilter(employeeList);
        employeeNames.forEach(value -> System.out.println(value));

    }


    private static List<String> getEmplyeesListwithSalaryFilter(List<Employee> employeeList) {
        Predicate<Employee> isSalaryGreater = val -> val.getSalary() > 25000L;

        List<String> names = employeeList.stream()
                .filter(isSalaryGreater)
                .map(e -> customCasingName(e))
                .collect(Collectors.toList());
        return names;
    }

    private static String customCasingName(Employee e) {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(e.getName().substring(0, 1).toLowerCase());
        sbuf.append(e.getName().substring(1, e.getName().length()).toUpperCase(Locale.ROOT));
        return sbuf.toString();
    }


    private static List<Employee> buildData() {
        Employee e = new Employee();
        Employee e1 = new Employee();

        e.setId(1);
        e.setName("Venkat");
        e.setSalary(20000L);

        e1.setId(2);
        e1.setSalary(30000L);
        e1.setName("Raghav");

        return Arrays.asList(e1, e);
    }
}
