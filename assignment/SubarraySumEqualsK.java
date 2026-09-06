import java.util.*;
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currentSum = 0;
        int count = 0;
        for (int num : nums) {
            currentSum = currentSum + num;
            int required = currentSum - k;
            if (map.containsKey(required)) {
                count = count + map.get(required);
            }
            map.put(
                currentSum,
                map.getOrDefault(currentSum, 0) + 1
            );
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = subarraySum(nums, k);
        System.out.println("Number of Subarrays = " + result);
    }
}