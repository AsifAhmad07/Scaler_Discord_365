public class day98 {


    Name Of The Problem :- Next Smallest Palindrome!

    Date :- 08-April-2024

    Problem Description

Given a numeric string A representing a large number you need to find the next smallest palindrome greater than this number.



Problem Constraints
1 <= |A| <= 100

A doesn't start with zeroes and always contain digits from 0-9.



Input Format
First and only argument is an string A.



Output Format
Return a numeric string denoting the next smallest palindrome greater than A.



Example Input
Input 1:

 A = "23545"
Input 2:

 A = "999"


Example Output
Output 1:

 "23632"
Output 2:

 "1001"


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public String solve(String A) {
        int n = A.length();
        if (allNines(A)) {
            StringBuilder builder = new StringBuilder("1");
            for (int i = 0; i < n - 1; i++)
                builder.append(0);
            builder.append(1);
            return builder.toString();
        }
        int mid = n / 2;
        int i = mid - 1, j = (n % 2 == 0) ? mid : mid + 1;
        while (i >= 0 && A.charAt(i) == A.charAt(j)) {
            i--;
            j++;
        }
        boolean leftSmaller = (i < 0) || (A.charAt(i) < A.charAt(j));

        StringBuilder builder = new StringBuilder(A);
        while (i >= 0)
            builder.setCharAt(j++, A.charAt(i--));
        if (!leftSmaller)
            return builder.toString();
        int carry = 1;
        if (n % 2 == 1) {
            int num = A.charAt(mid) - '0' + carry;
            char c = (char) ('0' + num % 10);
            carry = num / 10;
            builder.setCharAt(mid, c);
        }
        i = mid - 1;
        j = (n % 2 == 0) ? mid : mid + 1;
        while (i >= 0 && carry > 0) {
            int num = A.charAt(i) - '0' + carry;
            char c = (char) ('0' + num % 10);
            carry = num / 10;
            builder.setCharAt(i--, c);
            builder.setCharAt(j++, c);
        }

        return builder.toString();


    }
    private static boolean allNines(String A) {
        for (char c : A.toCharArray()) {
            if (c != '9')
                return false;
        }

        return true;
    }
}

    
}
