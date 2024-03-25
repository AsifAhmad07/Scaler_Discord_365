public class day85 {


    Name Of The Problem :- Maximum Sum Triplet

    Date :- 26-march-2024


    Problem Description
 
 

Given an array A containing N integers.

You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.

If no such triplet exist return 0.



Problem Constraints
3 <= N <= 105.

1 <= A[i] <= 108.



Input Format
First argument is an integer array A.



Output Format
Return a single integer denoting the maximum sum of triplet as described in the question.



Example Input
Input 1:

 A = [2, 5, 3, 1, 4, 9]
Input 2:

 A = [1, 2, 3]


Example Output
Output 1:

 16
Output 2:

 6


Example Explanation
Explanation 1:

 All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
  Maximum sum = 16
Explanation 2:

 All possible triplets are:-
    1 2 3 => sum = 6
 Maximum sum = 6


 ----------------------------------------------------------------------------------------------------------------------------------------------------


 public class Solution {
    public int solve(int[] A) {
        
        int n = A.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], A[i]);
        TreeSet<Integer> leftMax = new TreeSet<>();
        leftMax.add(A[0]);

        int maxSum = Integer.MIN_VALUE;
        for (int j = 1; j < n - 1; j++) {
            int ak = rightMax[j + 1];
            if (A[j] < ak) {
                Integer ai = leftMax.lower(A[j]);
                if (ai != null)
                    maxSum = Math.max(maxSum, ai + A[j] + ak);
                leftMax.add(A[j]);
            }
        }

        return maxSum;
    }
}

    
}
