public class day111 {


    Name Of The Problem :- Maximum Ones After Modification

    Date :- 21-April-2024


    Problem Description

Given a binary array A and a number B, we need to find length of the longest subsegment of ‘1’s possible by changing at most B ‘0’s.



Problem Constraints
 1 <= N, B <= 105

 A[i]=0 or A[i]=1



Input Format
First argument is an binary array A.

Second argument is an integer B.



Output Format
Return a single integer denoting the length of the longest subsegment of ‘1’s possible by changing at most B ‘0’s.



Example Input
Input 1:

 A = [1, 0, 0, 1, 1, 0, 1]
 B = 1
Input 2:

 A = [1, 0, 0, 1, 0, 1, 0, 1, 0, 1]
 B = 2


Example Output
Output 1:

 4
Output 2:

 5


Example Explanation
Explanation 1:

 Here, we should only change 1 zero(0). Maximum possible length we can get is by changing the 3rd zero in the array,
 we get a[] = {1, 0, 0, 1, 1, 1, 1}
Explanation 2:

 Here, we can change only 2 zeros. Maximum possible length we can get is by changing the 3rd and 4th (or) 4th and 5th zeros.


*****************************************************************************************************************************************************



public class Solution {
    public int solve(int[] A, int B) {
        
        int start = 0, end = 0;
        int bestWindow = 0, cnt = 0;
        while (end < A.length) {
            if (cnt <= B) {
                if (A[end] == 0)
                    cnt++;
                end++;
                if (cnt <= B && bestWindow < end - start)
                    bestWindow = end - start;
            }
            else {
                if (A[start] == 0)
                    cnt--;
                start++;
            }
        }

        return bestWindow;
    }
}
    
}
