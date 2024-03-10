import java.text.Format;
import java.util.HashMap;
import java.util.Map;

public class day69 {

    Name Of The Problem :- Fraction

    Date :- 10-march-2024

    Problem Description
 
 

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.


Problem Constraints
INTMIN <= A, B <= INTMAX


Input Format
The first integer A represents the numerator.
The second integer B represents the denominator.


Output Format
Return a string


Example Input
Input 1:
A = 1
B = 2
Input 2:
A = 2
B = 1
Input 3:
A = 2
B = 3


Example Output
Output 1:
"0.5"
Output 2:
"2"
Output 3:
"0.(6)"


Example Explanation
Explanation 1:
Given numerator = 1, denominator = 2, return "0.5"
Explanation 1:
Given numerator = 2, denominator = 1, return "2"
Explanation 1:
Given numerator = 2, denominator = 3, return "0.(6)"


-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public String fractionToDecimal(int A, int B) {
        
        
         long num = A;
        long den = B;

        boolean neg = false;
        if(num < 0 && den < 0){
            num = Math.abs(num);
            den = Math.abs(den);
        }
        else if(num < 0 || den < 0){
            neg = true;
            num = Math.abs(num);
            den = Math.abs(den);
        }

        StringBuilder s = new StringBuilder();
        s.append(num/den);
        num = num%den;

        if(num == 0){
            return s.toString();
        }

        s.append(".");
        boolean repeat = false;
        long rem = num;
        Map<Long, Integer> map = new HashMap<>();

        int index = -1;

        while(rem>0 && !repeat){

            if(map.containsKey(rem)){
                repeat = true;
                index = map.get(rem);
                break;
            }
            else{
                map.put(rem, s.length());
            }

            rem *= 10;
            long temp = rem/den;
            s.append(temp);
            rem %= den;
        }

        if(repeat){
            s.append(')');
            s.insert(index,'(');
        }

        if(neg){
            s.insert(0,'-');
        }

        return s.toString();
    }
}

    
}
