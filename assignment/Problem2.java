import java.util.*;
import java.util.function.Function;
public class Problem2 {
    static abstract class Vehicle {
        protected int hours;
        public Vehicle(int hours) {
            this.hours = hours;
        }
        public abstract double calculateCharge();
        public abstract String getType();
    }
    static class Bike extends Vehicle {
        public Bike(int hours) {
            super(hours);
        }
        @Override
        public double calculateCharge() {
            return hours * 10;
        }
        @Override
        public String getType() {
            return "BIKE";
        }
    }
    static class Car extends Vehicle {
        public Car(int hours) {
            super(hours);
        }
        @Override
        public double calculateCharge() {
            if (hours == 1) {
                return 30;
            }
            return 30 + (hours - 1) * 20;
        }
        @Override
        public String getType() {
            return "CAR";
        }
    }
    static class Truck extends Vehicle {
        public Truck(int hours) {
            super(hours);
        }
        @Override
        public double calculateCharge() {
            return Math.max(100, hours * 50);
        }
        @Override
        public String getType() {
            return "TRUCK";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<Integer, Vehicle>> vehicleFactory =new HashMap<>();
        vehicleFactory.put("BIKE", Bike::new);
        vehicleFactory.put("CAR", Car::new);
        vehicleFactory.put("TRUCK", Truck::new);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle = vehicleFactory.get(type).apply(hours);
            double charge = vehicle.calculateCharge();
            System.out.printf("%s: %.2f%n",vehicle.getType(),charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}