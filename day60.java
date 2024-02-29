import java.util.ArrayList;

public class day60 {


    Name Of The Problem :- Add One To Number

    Date :- 01-march-2024

    Problem Description
 
 

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: 
for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= |A| <= 106
0 <= Ai <= 9


Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        
        int n = A.size();

        int carry = (A.get(n-1)+1)/10;
        A.set(n-1, (A.get(n-1) + 1)%10);
        for (int i = n-2; i >= 0; i--) {
            int temp = (A.get(i) + carry)/10;
            A.set(i, (A.get(i) + carry)%10);
            carry = temp;
            if (carry == 0){
                break;
            }
        }

        if (carry == 1){
            A.add(0, carry);
            return A;
        }
        else{
            int start = 0;
            for (Integer aA : A) {
                if (aA == 0) {
                    start++;
                } else {
                    break;
                }
            }
            return new ArrayList<>(A.subList(start, A.size()));
        }
    }
}

    
}
