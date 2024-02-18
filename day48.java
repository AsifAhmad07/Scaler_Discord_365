public class day48 {

    Name Of The Problem :- Large Factorial

    Date :- 18-feb-2024


    Problem Description

Given a number A. Find the fatorial of the number.



Problem Constraints
1 <= A <= 100



Input Format
First and only argument is the integer A.



Output Format
Return a string, the factorial of A.



Example Input
Input 1:

A = 2
Input 2:

A = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

2! = 2 .
Explanation 2:

3! = 6 .


-----------------------------------------------------------------------------------------------------------------------------------------------------

import java.math.BigInteger;
public class Solution {
    public String solve(int A) {
        
         BigInteger res = BigInteger.ONE;
        
        for (int i = A; i > 1; --i) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        return String.valueOf(res);
    }
}



    
}
