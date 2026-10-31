import java.util.*;
abstract class Staff {
    String name;
    Staff(String name) {
        this.name = name;
    }
    abstract double calculatePay();
}
class FullTime extends Staff {
    double salary;
    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }
    double calculatePay() {
        return salary;
    }
}
class Hourly extends Staff {
    double hours;
    double rate;
    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}
class Intern extends Staff {
    double stipend;
    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    double calculatePay() {
        return stipend;
    }
}
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff;
            if (type.equals("FULLTIME")) {
                double salary = sc.nextDouble();
                staff = new FullTime(name, salary);
            } 
            else if (type.equals("HOURLY")) {
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                staff = new Hourly(name, hours, rate);
            } 
            else {
                double stipend = sc.nextDouble();
                staff = new Intern(name, stipend);
            }
            double pay = staff.calculatePay();
            System.out.printf("%s: %.2f%n", name, pay);
            total += pay;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}