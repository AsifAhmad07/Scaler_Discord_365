import java.util.Collections;

public class day75 {

    Name Of The Problem :- Reverse Bits

    Date :- 16-march-2024

    Problem Description

Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints
0 <= A <= 232



Input Format
First and only argument of input contains an integer A.



Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.



Example Input
Input 1:

 0
Input 2:

 3


Example Output
Output 1:

 0
Output 2:

 3221225472


Example Explanation
Explanation 1:

        00000000000000000000000000000000

=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011    
=>      11000000000000000000000000000000


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
	public long reverse(long a) {
        
        StringBuilder sb = new StringBuilder(Long.toBinaryString(a));
	    sb.insert(0, String.join("", Collections.nCopies(32-sb.length(), "0")));
	    String  s = sb.reverse().toString();
	    return Long.parseLong(s, 2);
	}
}

    
}
