public class day114 {


    Name Of The Problem :- Max Continuous Series of 1s


    Date :- 24-April-2024

    Problem Description
 
 

Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.

For this problem, return the indices of maximum continuous series of 1s in order.

If there are multiple possible solutions, return the sequence which has the minimum start index.



Problem Constraints
 0 <= B <= 105

 1 <= size(A) <= 105

 0 <= A[i] <= 1



Input Format
First argument is an binary array A.

Second argument is an integer B.



Output Format
 Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.



Example Input
Input 1:

 A = [1 1 0 1 1 0 0 1 1 1 ]
 B = 1
Input 2:

 A = [1, 0, 0, 0, 1, 0, 1]
 B = 2


Example Output
Output 1:

 [0, 1, 2, 3, 4]
Output 2:

 [3, 4, 5, 6]


Example Explanation
Explanation 1:

 Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
Explanation 2:

 Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].


 ****************************************************************************************************************************************************

 public class Solution {
    public int[] maxone(int[] A, int B) {
        int start = 0, end = 0;
        int bestStart = 0, bestWindow = 0, cnt = 0;
        while (end < A.length) {
            if (cnt <= B) {
                if (A[end] == 0)
                    cnt++;
                end++;
                if (cnt <= B && bestWindow < end - start) {
                    bestWindow = end - start;
                    bestStart = start;
                }
            }
            else {
                if (A[start] == 0)
                    cnt--;
                start++;
            }
        }
        int[] res = new int[bestWindow];
        for (int i = 0; i < bestWindow; i++)
            res[i] = bestStart + i;

        return res;
    }
}

    
}
