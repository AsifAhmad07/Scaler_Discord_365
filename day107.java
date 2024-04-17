public class day107 {


    Name Of The Problem :- Palindromic Binary Representation


    Date :- 17-April-2024

    Problem Description

Given an integer A find the Ath number whose binary representation is a palindrome.

NOTE:

Consider the 1st number whose binary representation is palindrome as 1, instead of 0
Do not consider the leading zeros, while considering the binary representation.


Problem Constraints
 1 <= A <= 2104



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the Ath number whose binary representation is a palindrome.



Example Input
Input 1:

 A = 1
Input 1:

 A = 9


Example Output
Output 1:

 1
Output 2:

 27


Example Explanation*
Explanation 1:

 1st Number whose binary representation is palindrome is 1
Explanation 2

 9th Number whose binary representation is palindrome is 27 (11011)


*****************************************************************************************************************************************************

public class Solution {
    public int solve(int A) {
         if (A == 1)
            return 1;
        Queue<String> q = new LinkedList<>();
        q.add("11");
        String front = "";
        for (int i = 2; i <= A; i++) {
            front = q.poll();
            int len = front.length();
            if (len % 2 == 0) {
                q.add(front.substring(0, len / 2) + '0' + front.substring(len / 2));
                q.add(front.substring(0, len / 2) + '1' + front.substring(len / 2));
            }
            else {
                char mid = front.charAt(len / 2);
                q.add(front.substring(0, len / 2) + mid + front.substring(len / 2));
            }
        }
        return binaryStringToInteger(front);
    }
     private static int binaryStringToInteger(String A) {
        int res = 0;
        for (char c : A.toCharArray())
            res = (res << 1) | (c - '0');

        return res;
    }
}

    
}
