import java.util.Set;

public class day83 {

    Name Of The Problem :- Count Total Set Bits


    Date :- 24-march-2024


    Problem Description

Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.



Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.



Example Input
Input 1:

 A = 3
Input 2:

 A = 1


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4
Explanation 2:

 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1


-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int solve(int A) {
        
         int p = 1000000007, cnt = 0;
        int powerOfTwo = 2, a = A;
        while (a > 0) {
            int noOfGroups = A / powerOfTwo;
            cnt = (cnt + noOfGroups * (powerOfTwo >> 1)) % p;
            if (A % powerOfTwo >= (powerOfTwo >> 1) - 1)
                cnt = (cnt + (A % powerOfTwo) - ((powerOfTwo >> 1) - 1)) % p;

            a >>= 1;
            powerOfTwo <<= 1;
        }

        return cnt;
    }
}

    
}
