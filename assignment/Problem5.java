import java.util.*;
abstract class Appliance {
    protected double hours;
    public Appliance(double hours) {
        this.hours = hours;
    }
    protected abstract double getPower();
    public double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }
    public double calculateCost() {
        return calculateUnits() * 8.0;
    }
}
interface SaverMode {
    double applySaver(double units);
}
class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }
    @Override
    protected double getPower() {
        return 150.0;
    }
}
class AC extends Appliance implements SaverMode {
    public AC(double hours) {
        super(hours);
    }
    @Override
    protected double getPower() {
        return 1500.0;
    }
    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}
class TV extends Appliance {
    public TV(double hours) {
        super(hours);
    }
   @Override
    protected double getPower() {
        return 100.0;
    }
}
class Washer extends Appliance implements SaverMode {
    public Washer(double hours) {
        super(hours);
    }
    @Override
    protected double getPower() {
        return 500.0;
    }
    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saverRequested = false;
            if (sc.hasNext("SAVER")) {
                sc.next();
                saverRequested = true;
            }
            Appliance appliance;
            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    continue;
            }
            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = appliance.calculateUnits();
            if (saverRequested) {
                SaverMode saver = (SaverMode) appliance;
                units = saver.applySaver(units);
            }
            double cost = units * 8.0;
            System.out.printf(Locale.US,"%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);
            totalCost += cost;
        }
        System.out.printf(Locale.US,"Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}