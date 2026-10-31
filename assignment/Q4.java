import java.util.*;
public class Q4 {
    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            result[newIndex] = names[i];
        }
        return result;
    }
    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int k = 2;
        String[] result = rotateRoster(names, k);
        System.out.println(Arrays.toString(result));
    }
}