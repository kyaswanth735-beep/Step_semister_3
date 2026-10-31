import java.util.*;
abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;
    public Ticket(int count) {
        this.count = count;
    }
    protected abstract double getPrice();
    public double getAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}
class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }
    @Override
    protected double getPrice() {
        return 150.0;
    }
}
class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }
    @Override
    protected double getPrice() {
        return 250.0;
    }
}
class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }
    @Override
    protected double getPrice() {
        return 400.0;
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket ticket;
            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
                default:
                    continue;
            }
            double amount = ticket.getAmount();
            System.out.printf(Locale.US,"%s: %.2f%n", seat, amount);
            total += amount;
        }
        System.out.printf(Locale.US,"Total: %.2f%n", total);
        sc.close();
    }
}