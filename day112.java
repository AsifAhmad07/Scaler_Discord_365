public class day112 {


    Name Of The Problem :- Array 3 Pointers


    Date :- 22-April-2024


    You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :

max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 


*****************************************************************************************************************************************************

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        
         int i = 0, j = 0, k = 0;
        int diff = Integer.MAX_VALUE;

        while (i < A.length && j < B.length && k < C.length) {
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            int min = Math.min(A[i], Math.min(B[j], C[k]));
            diff = Math.min(diff, max - min);
            if (min == A[i])
                i++;
            else if (min == B[j])
                j++;
            else
                k++;
        }
        return diff;
    }
}

    
}
