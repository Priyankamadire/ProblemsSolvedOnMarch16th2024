
/*525. Contiguous Array
Medium
Topics
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. */
import java.util.*;

public class ContiguousWith0s1s {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(solve(n, arr));
    }

    public static int solve(int n, int arr[]) {
        int sum = 0, maxi = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i] == 0 ? -1 : 1;
            if (hm.containsKey(sum)) {
                maxi = Math.max(i-hm.get(sum), maxi);
            } else {
                hm.put(sum, i);
            }
        }
        return maxi;
    }

}