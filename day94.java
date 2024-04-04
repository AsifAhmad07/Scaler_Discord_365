public class day94 {


    Name Of The Problem :- Kth Row of Pascal's Triangle

    Date :- 04-April-2024


    Problem Description

Given an index k, return the kth row of the Pascal's triangle.
Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.

Example:

Input : k = 3


Return : [1,3,3,1]

Note: k is 0 based. k = 0, corresponds to the row [1]. 

Note: Could you optimize your algorithm to use only O(k) extra space?



-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int[] getRow(int A) {
        
         int[] res = new int[A + 1];
        res[0] = 1;
        for (int i = 1; i <= A / 2; i++)
            res[i] = res[i - 1] * (A - i + 1) / i;
        for (int i = A / 2 + 1; i <= A; i++)
            res[i] = res[A - i];

        return res;
    }
}


    
    
}
