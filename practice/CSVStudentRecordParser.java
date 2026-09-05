import java.util.Scanner;
public class CSVStudentRecordParser {
    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            String name = fields[0];
            String rollNo = fields[1];
            String department = fields[2];
            System.out.println("Name: " + name +
                    " | Roll No: " + rollNo +
                    " | Dept: " + department);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student record: ");
        String csvLine = sc.nextLine();
        parseStudentRecord(csvLine);
        sc.close();
    }
}