import java.util.*;
public class Q1 {
    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    static int countInBand(int[] scores, int low, int high) {
        int first = lowerBound(scores, low);
        int last = upperBound(scores, high);
        return last - first;
    }
    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        int low = 42;
        int high = 58;
        int result = countInBand(scores, low, high);
        System.out.println(result);
    }
}