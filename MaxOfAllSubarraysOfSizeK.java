
/*You are given an array of integers nums, there is a sliding window of size k which is moving from 
the very left of the array to the very right. You can only see the k numbers in the window. Each 
time the sliding window moves right by one position.
Return the max sliding window.
TEST CASE 1:
-----------------------
case=1
input=9
1
2
3
1
4
5
2
3
6
3
output=3 3 4 5 5 5 6
*/
import java.util.*;

public class MaxOfAllSubarraysOfSizeK {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        ArrayList<Integer> result = solve(n, k, arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static ArrayList<Integer> solve(int n, int k, int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (j < n) {
            maxi = Math.max(maxi, arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                al.add(maxi);
                if (arr[i] == maxi) {
                    maxi = Integer.MIN_VALUE;
                    for (int idx = i + 1; idx <= j; idx++) {
                        maxi = Math.max(maxi, arr[idx]);
                    }
                }
                i++;
                j++;
            }
        }
        return al;
    }
}
