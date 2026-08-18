import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        // Handle base case if array has fewer than 2 elements
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Find the absolute minimum and maximum values
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        // If all elements are the same, the max gap is 0
        if (min == max) {
            return 0;
        }
        
        // Calculate the minimum possible gap size using the pigeonhole principle
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        
        // Track the min and max for each bucket
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        // Distribute each number into its corresponding bucket
        for (int num : nums) {
            int bucketIdx = (num - min) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }
        
        // Calculate the maximum gap between successive non-empty buckets
        int maxGap = 0;
        int previousMax = min; // Starts with the minimum value of the entire array
        
        for (int i = 0; i < bucketCount; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            // Gap is measured from current bucket's min to previous bucket's max
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }
        
        return maxGap;
    }
}