public class day12 {
    
     * Name Of The Problem :- Maximum Absolute Difference
     * Problem Description
 
 

You are given an array of N integers, A1, A2 ,..., AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.


Problem Constraints
1 <= |A| <= 105
-109 <= Ai <= 109


Input Format
The first argument is an integer array A.


Output Format
Return an integer equal to the maximum value of f(i, j)


Example Input
A = [1, 3, -1]


Example Output
5


Example Explanation
Given A = [1, 3, -1], 
f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
The maximum value is 5, which is of f(2, 3)


Show similar questions
--------------------------------------------------------------------------------

    public class Solution {
        public int maxArr(int[] nums) {
      int mx1 = Integer.MIN_VALUE, mn1 = Integer.MAX_VALUE, mx2 = Integer.MIN_VALUE, mn2 = Integer.MAX_VALUE;
            
            for (int i = 0; i < nums.length; ++i) {
                // for eq 1
                mx1 = Math.max(mx1, nums[i] + i);
                mn1 = Math.min(mn1, nums[i] + i);
    
                // for eq2
                mx2 = Math.max(mx2, nums[i] - i);
                mn2 = Math.min(mn2, nums[i] - i);
            }
    
            int ans1 = mx1 - mn1;
            int ans2 = mx2 - mn2;
    
            return Math.max(ans1, ans2);
        }
    }
    
}
