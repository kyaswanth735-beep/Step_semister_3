import java.util.*;
import java.time.LocalDate;
import java.util.function.Function;
public class Problem2 {
    static abstract class LibraryItem {
        protected String title;
        public LibraryItem(String title) {
            this.title = title;
        }
        public abstract int getBorrowingDays();
        public LocalDate getDueDate() {
            LocalDate currentDate = LocalDate.of(2023, 10, 26);
            return currentDate.plusDays(getBorrowingDays());
        }
    }
    static class Book extends LibraryItem {
        public Book(String title) {
            super(title);
        }
        @Override
        public int getBorrowingDays() {
            return 14;
        }
    }
    static class DVD extends LibraryItem {
        public DVD(String title) {
            super(title);
        }
        @Override
        public int getBorrowingDays() {
            return 7;
        }
    }
    static class Magazine extends LibraryItem {
        public Magazine(String title) {
            super(title);
        }
        @Override
        public int getBorrowingDays() {
            return 3;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Function<String, LibraryItem>> factory =new HashMap<>();
        factory.put("BOOK", Book::new);
        factory.put("DVD", DVD::new);
        factory.put("MAGAZINE", Magazine::new);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }
            LibraryItem item = factory.get(type).apply(title);
            System.out.println(item.title + ": " + item.getDueDate());
        }
        sc.close();
    }
}