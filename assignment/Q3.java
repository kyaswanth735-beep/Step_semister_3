import java.util.*;
public class Q3 {
    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            }
            else if (score > second && score != highest) {
                second = score;
            }
        }
        return second;
    }
    public static void main(String[] args) {
        int[] scores = {45, 78, 92, 78, 60};
        int result = secondHighest(scores);
        System.out.println(result);
    }
}