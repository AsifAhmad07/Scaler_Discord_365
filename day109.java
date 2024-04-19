public class day109 {


    Name Of The Problem :- Diffk


    Date :- 19-April-2024

    Problem Description
 
 

Given an array 'A' of sorted integers and another non-negative integer B, find if there exist 2 indices i and j such that A[i] - A[j] = k, i != j.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
Try doing this in less than linear space complexity.


Problem Constraints
1 <= |A| <= 106
0 <= B <= 109


Input Format
The first argument is an integer array A.
The second argument is an integer B.


Output Format
Return an integer, 0 / 1 ( 0 for false, 1 for true ) for this problem


Example Input
 A : [1 3 5] 
 B : 4


Example Output
1


Example Explanation
For the given, 
 A : [1 3 5] 
 B : 4
Output : YES
as 5 - 1 = 4


*****************************************************************************************************************************************************

public class Solution {
    public int diffPossible(int[] A, int B) {
        
        int n = A.length, i = 0, j = 1;
        while (i < n && j < n) {
            int diff = A[j] - A[i];
            if (diff == B && i != j)
                return 1;
            if (diff > B)
                i++;
            else
                j++;
        }

        return 0;
    }
}

    
}
