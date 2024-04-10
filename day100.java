public class day100 {


    Name Of The Problem :- Divisible by 60


    Date :- 10-April-2024

    Problem Description
 
 

Given a large number represent in the form of an integer array A, where each element is a digit.

You have to find whether there exists any permutation of the array A such that the number becomes divisible by 60.

Return 1 if it exists, 0 otherwise.



Problem Constraints
1 <= |A| <= 105
0 <= Ai <= 9


Input Format
The first argument is an integer array A.


Output Format
Return a single integer '1' if there exists a permutation, '0' otherwise.


Example Input
Input 1:
A = [0, 6]
Input 2:

A = [2, 3]


Example Output
Output 1:
1
Output 2:

0


Example Explanation
Explanation 1:
We can rearrange the digits to form 60, which is divisible by 60.
Explanation 2:

There are only two possible permutations: [23, 32].
Both of them are not divisible by 60.


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int divisibleBy60(int[] A) {
         if (A.length == 1)
            return A[0] == 0 ? 1 : 0;
        if (A.length == 2)
            return ((A[0] == 0 && A[1] == 6) || (A[0] == 6 && A[1] == 0)) ? 1 : 0;
        boolean zero = false, even = false;
        int sum = 0;

        for (int digit : A) {
            if (digit == 0)
                zero = true;
            else if (digit % 2 == 0)
                even = true;
            sum += digit;
        }

        return zero && even && (sum % 3 == 0) ? 1 : 0;
    }
}

    
}
