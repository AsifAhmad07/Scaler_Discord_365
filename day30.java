public class day30 {

    Name Of The Problem :- Power Of Two Integers

    Date :- 31-jan-2024



    Problem Description
 
 

Given a positive integer that fits in a 32-bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0.
A and P both should be integers.


Problem Constraints
1 <= A <= 109


Input Format
The first argument is an integer A.


Output Format
Return an integer, 1 for True, 0 for False


Example Input
A = 4


Example Output
1


Example Explanation
A = 4, it can be written as 2 ^ 2

--------------------------------------------------------------------------------------------


public class Solution {
    public int isPower(int A) {
         if (A == 1) return 1;

        int p = 2;
        int a = 2;
        boolean flag = false;

        while (true) {
            p = 2;
            while (true){
                if (Math.pow(a, p) == A) {
                    flag = true;
                    break;
                }
                else if (Math.pow(a, p) > A) {
                    break;
                }
                p++;
            }

            a++;
            if (flag) break;
            else if (a > A){
                break;
            }
        }

        return flag ? 1 : 0;
    }
}

}