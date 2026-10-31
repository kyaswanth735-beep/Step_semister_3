import java.util.*;
import java.util.function.Function;
public class Problem3 {
    static abstract class Room {
        protected int units;
        public Room(int units) {
            this.units = units;
        }
        public abstract double calculateBill();
        public abstract String getType();
    }
    static class SingleRoom extends Room {
        public SingleRoom(int units) {
            super(units);
        }
        @Override
        public double calculateBill() {
            return units * 8;
        }
        @Override
        public String getType() {
            return "SINGLE";
        }
    }
    static class SharedRoom extends Room {
        private int occupants;
        public SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }
        @Override
        public double calculateBill() {
            return (units * 6.0) / occupants;
        }
        @Override
        public String getType() {
            return "SHARED";
        }
    }
    static class ACRoom extends Room {
        public ACRoom(int units) {
            super(units);
        }
        @Override
        public double calculateBill() {
            return units * 10 + 200;
        }
        @Override
        public String getType() {
            return "AC";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<int[], Room>> roomFactory =
                new HashMap<>();
        roomFactory.put("SINGLE",
                values -> new SingleRoom(values[0]));
        roomFactory.put("AC",
                values -> new ACRoom(values[0]));
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            Room room;
            if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else {
                int units = sc.nextInt();
                room = roomFactory.get(type)
                        .apply(new int[]{units});
            }
            double bill = room.calculateBill();
            System.out.printf(
                "%s: %.2f%n",
                room.getType(),
                bill
            );
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}