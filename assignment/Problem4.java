import java.util.*;
abstract class Cab {
    protected double distance;
    protected static final double MINIMUM_FARE = 100.0;
    public Cab(double distance) {
        this.distance = distance;
    }
    protected abstract double getRate();
    public double calculateFare() {
        double fare = distance * getRate();
        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }
        return fare;
    }
}
interface NightService {
    double applyNightCharge(double fare);
}
class Mini extends Cab {
    public Mini(double distance) {
        super(distance);
    }
    @Override
    protected double getRate() {
        return 10.0;
    }
}
class Sedan extends Cab implements NightService {
    public Sedan(double distance) {
        super(distance);
    }
    @Override
    protected double getRate() {
        return 14.0;
    }
    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}
class SUV extends Cab implements NightService {
    public SUV(double distance) {
        super(distance);
    }
    @Override
    protected double getRate() {
        return 18.0;
    }
    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab;
            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
                default:
                    continue;
            }
            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.calculateFare();
            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightCharge(fare);
            }
            System.out.printf(Locale.US,"%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf(Locale.US,"Total: %.2f%n", total);
        sc.close();
    }
}