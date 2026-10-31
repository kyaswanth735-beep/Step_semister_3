import java.util.*;
import java.util.function.BiFunction;
public class Problem4 {
    static abstract class Employee {
        protected String name;
        protected double salary;
        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
        public abstract double calculateBonus();
        public String getName() {
            return name;
        }
    }
    static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double salary) {
            super(name, salary);
        }
        @Override
        public double calculateBonus() {
            return salary * 0.10;
        }
    }
    static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double salary) {
            super(name, salary);
        }
        @Override
        public double calculateBonus() {
            return salary * 0.05;
        }
    }
    static class Intern extends Employee {
        public Intern(String name, double salary) {
            super(name, salary);
        }
        @Override
        public double calculateBonus() {
            return 2000;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BiFunction<String, Double, Employee>> employeeFactory =
                new HashMap<>();
        employeeFactory.put("FULLTIME",FullTimeEmployee::new);
        employeeFactory.put("PARTTIME",PartTimeEmployee::new);
        employeeFactory.put("INTERN",Intern::new);
        int n = sc.nextInt();
        double totalBonus = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee employee =employeeFactory.get(type).apply(name, salary);
            double bonus = employee.calculateBonus();
            System.out.printf("%s: %.2f%n",employee.getName(),bonus );
            totalBonus += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n",totalBonus);
        sc.close();
    }
}