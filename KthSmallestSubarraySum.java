/*Given an integer array nums of length n and an integer k, return the k-th smallest subarray sum.
A subarray is defined as a non-empty contiguous sequence of elements in an array. A subarray 
sum is the sum of all elements in the subarray.
Example 1:
Input: nums = [2,1,3], k = 4
Output: 3
Explanation: The subarrays of [2,1,3] are:
• [2] with sum 2
• [1] with sum 1
• [3] with sum 3
• [2,1] with sum 3
• [1,3] with sum 4
• [2,1,3] with sum 6
Ordering the sums from smallest to largest gives 1, 2, 3, 3, 4, 6. The 4th smallest
is 3

TESTCASES
-----------------------

case=1
input=3
2
1
3
4
output=3*/
import java.util.*;
public class KthSmallestSubarraySum {
    public static int kthSmallestSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int num : nums) {
            left = Math.min(left, num);
            right += num;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countSubarrays(nums, mid) < k)
                left = mid + 1;
            else
                right = mid;
        }
        
        return left;
    }
    
    private static int countSubarrays(int[] nums, int target) {
        int count = 0;
        int sum = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        int k =sc.nextInt();
        System.out.println("Output: " + kthSmallestSubarraySum(nums, k));
    }
}

