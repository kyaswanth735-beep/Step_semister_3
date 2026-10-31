import java.util.*;
abstract class Parcel {
    protected double weight;
    protected double declaredValue;
    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }
    public abstract double calculateCharge();
    public double calculateTotal() {
        return calculateCharge();
    }
}
interface Insurable {
    double calculateInsurance();
}
class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    @Override
    public double calculateCharge() {
        return 40 + (10 * weight);
    }
}
class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    @Override
    public double calculateCharge() {
        return 80 + (15 * weight);
    }
    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}
class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    @Override
    public double calculateCharge() {
        return (40 + (10 * weight)) + 50;
    }
    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();
            Parcel parcel;
            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;
                default:
                    continue;
            }
            double charge = parcel.calculateCharge();
            double insurance = 0.0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).calculateInsurance();
            }
            double total = charge + insurance;
            System.out.printf(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf(Locale.US,
                "Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}