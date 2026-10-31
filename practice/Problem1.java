import java.util.*;
import java.util.function.Function;
public class Problem1 {
    static abstract class Payment {
        protected double amount;
        public Payment(double amount) {
            this.amount = amount;
        }
        public abstract double calculateAmount();
    }
    static class CardPayment extends Payment {
        public CardPayment(double amount) {
            super(amount);
        }
        @Override
        public double calculateAmount() {
            return amount * 1.02;
        }
    }
    static class WalletPayment extends Payment {
        public WalletPayment(double amount) {
            super(amount);
        }
        @Override
        public double calculateAmount() {
            return amount * 1.01;
        }
    }
    static class BankTransfer extends Payment {
        public BankTransfer(double amount) {
            super(amount);
        }
        @Override
        public double calculateAmount() {
            return amount;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<Double, Payment>> factory = new HashMap<>();
        factory.put("CARD", CardPayment::new);
        factory.put("WALLET", WalletPayment::new);
        factory.put("BANKTRANSFER", BankTransfer::new);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment payment = factory.get(type).apply(amount);
            double result = payment.calculateAmount();
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}