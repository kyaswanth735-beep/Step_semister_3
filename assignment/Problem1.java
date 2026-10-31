import java.util.*;
import java.util.function.Function;
public class Problem1 {
    static abstract class Bill {
        protected double amount;
        public Bill(double amount) {
            this.amount = amount;
        }
        public abstract double calculateAmount();
        public abstract String getType();
    }
    static class StudentBill extends Bill {
        public StudentBill(double amount) {
            super(amount);
        }
        @Override
        public double calculateAmount() {
            return amount * 0.90;
        }
        @Override
        public String getType() {
            return "STUDENT";
        }
    }
    static class StaffBill extends Bill {
        public StaffBill(double amount) {
            super(amount);
        }
        @Override
        public double calculateAmount() {
            return amount * 0.95;
        }
        @Override
        public String getType() {
            return "STAFF";
        }
    }
    static class GuestBill extends Bill {
        public GuestBill(double amount) {
            super(amount);
        }
        @Override
        public double calculateAmount() {
            return amount + 10;
        }
        @Override
        public String getType() {
            return "GUEST";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<Double, Bill>> billFactory = new HashMap<>();
        billFactory.put("STUDENT", StudentBill::new);
        billFactory.put("STAFF", StaffBill::new);
        billFactory.put("GUEST", GuestBill::new);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Bill bill = billFactory.get(type).apply(amount);
            double finalAmount = bill.calculateAmount();
            System.out.printf("%s: %.2f%n",bill.getType(),finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}