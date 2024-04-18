import java.util.jar.Attributes.Name;

public class day108 {


    Name Of The Problem :- Counting Triangles


    Date :- 18-April-2024

    Problem Description
 
 

You are given an array of N non-negative integers, A0, A1,..., AN-1.
Considering each array element Ai as the edge length of some line segment, count the number of triangles that you can form using these array values.

Notes:
You can use any value only once while forming each triangle. The order of choosing the edge lengths doesn't matter. Any triangle formed should have a positive area.
Return answer modulo 109 + 7.


Problem Constraints
1 <= |A| <= 103
0 <= Ai <= 106


Input Format
The first argument is an integer array A.


Output Format
Return an integer equal to the count of the number of triangles that you can form.


Example Input
A = [1, 1, 1, 2, 2]


Example Output
4

*****************************************************************************************************************************************************

public class Solution {
    public int nTriang(int[] A) {
        int p = 1000000007, n = A.length;
        int res = 0;
        Arrays.sort(A);
        for (int k = 2; k < n; k++) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (A[i] + A[j] <= A[k])
                    i++;
                else {
                    res = (res + (j - i)) % p;
                    j--;
                }
            }
        }

        return res;
    }
}

    
}
