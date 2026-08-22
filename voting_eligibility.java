import java.util.Scanner;
public class voting_eligibility{
   int age;
        boolean isEligible = (age >= 18);
        void checkvotingEligibility(int age){
            this.age = age;
            this.isEligible = (age >= 18);
            if (isEligible) {
                System.out.println("You are eligible to vote.");
            } else {
                System.out.println("You are not eligible to vote.");
            }
        }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       voting_eligibility v = new voting_eligibility();
       v.checkvotingEligibility(17);
    }
}