import java.util.List;

public class day20 {

    
     * Name Of The Problem :- Max Distance
     * Day :- 20
     * Problem Description
 
 

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].



Problem Constraints
1 <= |A| <= 106
-109 <= Ai <= 109


Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the maximum value of j - i;



Example Input
Input 1:

 A = [3, 5, 4, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Maximum value occurs for pair (3, 4).


-----------------------------------------------------------------------------


     public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int maxDiff;
        int i, j;

        int n = A.size();
        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = A.get(0);

        for (i = 1; i < n; ++i) {
            LMin[i] = Math.min(A.get(i), LMin[i - 1]);
        }

        RMax[n - 1] = A.get(n - 1);
        for (j = n - 2; j >= 0; --j) {
            RMax[j] = Math.max(A.get(j), RMax[j + 1]);
        }

        i = 0; j = 0; maxDiff = 0;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            }
            else {
                i++;
            }
        }

        return maxDiff;
    }
}

    
}
