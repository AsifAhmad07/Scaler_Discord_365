public class day31 {

    Name Of The Problem :- Reverse integer

    Date :- 01-feb-2024


    Problem Description

You are given an integer N and the task is to reverse the digits of the given integer. Return 0 if the result overflows and does not fit in a 32 bit signed integer


Look at the example for clarification.



Problem Constraints
N belongs to the Integer limits.



Input Format
Input an Integer.



Output Format
Return a single integer denoting the reverse of the given integer.



Example Input
Input 1:

 x = 123


Input 2:

 x = -123


Example Output
Output 1:

 321


Ouput 2:

 -321


Example Explanation
 If the given integer is negative like -123 the output is also negative -321.


-------------------------------------------------------------------------------------------


public class Solution {
    public int reverse(int A) {
        boolean negative = false;
        if (A < 0) {
            negative = true;
            A *= -1;
        }
        
        int rev = 0;
        int prevRev = 0;
        while (A > 0) {
            int curr = A%10;
            rev = rev*10 + curr;
            if ((rev - curr)/10 != prevRev) return 0;
            prevRev = rev;
            A /= 10;
        }
        
        return negative ? -1*rev : rev;
    }
}



    
}
