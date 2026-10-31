import java.util.*;
import java.time.LocalDate;
import java.util.function.Function;
public class Problem5 {
    static abstract class Plan {
        protected LocalDate startDate;
        public Plan(LocalDate startDate) {
            this.startDate = startDate;
        }
        public abstract int getValidityDays();
        public LocalDate getRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }
    static class BasicPlan extends Plan {
        public BasicPlan(LocalDate startDate) {
            super(startDate);
        }
        @Override
        public int getValidityDays() {
            return 30;
        }
    }
    static class StandardPlan extends Plan {
        public StandardPlan(LocalDate startDate) {
            super(startDate);
        }
        @Override
        public int getValidityDays() {
            return 90;
        }
    }
    static class PremiumPlan extends Plan {
        public PremiumPlan(LocalDate startDate) {
            super(startDate);
        }
        @Override
        public int getValidityDays() {
            return 365;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<LocalDate, Plan>> planFactory =new HashMap<>();
        planFactory.put("BASIC", BasicPlan::new);
        planFactory.put("STANDARD", StandardPlan::new);
        planFactory.put("PREMIUM", PremiumPlan::new);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();
            LocalDate startDate = LocalDate.parse(date);
            Plan plan =planFactory.get(type).apply(startDate);
            LocalDate renewalDate =plan.getRenewalDate();
            System.out.println(name + ": " + renewalDate);
        }
        sc.close();
    }
}