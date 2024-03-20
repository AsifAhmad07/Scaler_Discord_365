public class day79 {

    Name Of The Problem :- Divide Integers



    Date :- 20-march-2024

    Problem Description
 
 

Divide two integers A and B, without using multiplication, division, and mod operator.
Return the floor of the result of the division.

Also, consider if there can be overflow cases. For overflow cases, return INT_MAX.
Note: INT_MAX = 2^31 - 1


Problem Constraints
INT_MIN <= A, B <= INT_MAX
B != 0


Input Format
The first argument is an integer A.
The second argument is an integer B.


Output Format
Return an integer equal to A / B.


Example Input
A = 5
B = 2


Example Output
2


Example Explanation
A = 5, B = 2, therefore A / B = 5 / 2 = 2.5
Taking the floor value of 2.5 is 2


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int divide(int A, int B) {
           long sign =((A < 0 ) ^ (B < 0)) ? -1 : 1;

        long dividend, divisor;

        dividend = Math.abs(Long.valueOf(A));
        divisor = Math.abs(Long.valueOf(B));

        long quotient = 0, temp = 0;
        for(int i=31; i>=0;i--){

            if(temp + (divisor << i) <= dividend){
                temp += divisor <<i;
                quotient |= 1L <<i;
            }
        }

        quotient = quotient*sign;
        return (quotient > Integer.MAX_VALUE || quotient < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int) quotient;

    }
}

    
}
