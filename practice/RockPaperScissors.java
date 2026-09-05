import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors{
    public static void main(String[] args) {
        int win = 0;
        int draw = 0;
        int loss = 0;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String[] moves = {"rock", "paper", "scissor"};
        System.out.print("Enter no of Rounds: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 1; i <= n; i++) {
            System.out.println("\nRound " + i);
            System.out.print("Enter your choice (Rock, Paper, Scissor): ");
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("rock")
                    && !choice.equalsIgnoreCase("paper")
                    && !choice.equalsIgnoreCase("scissor")) {
                System.out.println("Invalid Input!");
                i--; 
                continue;
            }
            String computerMove = moves[r.nextInt(moves.length)];
            System.out.println("Your choice: " + choice);
            System.out.println("Computer choice: " + computerMove);
            if (choice.equalsIgnoreCase(computerMove)) {
                draw++;
                System.out.println("Result: Draw");
            }
            else if ((choice.equalsIgnoreCase("rock")
                    && computerMove.equalsIgnoreCase("scissor"))
                    || (choice.equalsIgnoreCase("paper")
                    && computerMove.equalsIgnoreCase("rock"))
                    || (choice.equalsIgnoreCase("scissor")
                    && computerMove.equalsIgnoreCase("paper"))) {
                win++;
                System.out.println("Result: You Win!");
            }
            else {
                loss++;
                System.out.println("Result: You Lose!");
            }
        }
        System.out.println("\n========== GAME RESULT ==========");
        System.out.println("Total Wins   : " + win);
        System.out.println("Total Draws  : " + draw);
        System.out.println("Total Losses : " + loss);
        int percentage = (win * 100) / n;
        System.out.println("Your Win Percentage: " + percentage + "%");
        sc.close();
    }
}

