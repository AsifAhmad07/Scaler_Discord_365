import java.util.ArrayList;
import java.util.Collections;

public class day73 {

    Name Of The Problem :- 3 Sum

    Date :- 14-march-2024

    Problem Description
 
 

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints
-3 * 108 <= B <= 3 * 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format
Return a single integer denoting the sum of three integers which is closest to B.



Example Input
Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:

 
A = [1, 2, 3]
B = 6


Example Output
Output 1:

2
Output 2:

6


Example Explanation
Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.

-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        
    Collections.sort(A);
        int closest = Integer.MAX_VALUE;
        int res = 0;
        
        for (int i = 0; i < A.size() - 2; i++) {
            int start = i + 1;
            int end = A.size() - 1;
            
            while (start < end) {
                int currSum = A.get(i) + A.get(start) + A.get(end);
                int diff = Math.abs(currSum - B);
                
                if (diff == 0) {
                    return B;
                }
                
                if (diff < closest) {
                    closest = diff;
                    res = currSum;
                }
                
                if (currSum < B) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}



    
}
