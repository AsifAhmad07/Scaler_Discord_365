public class day44 {

    Name Of The Problem :- Excel Column Number

    Date :- 14-feb-2024


    Problem Description
 
 

Given a column title A as appears in an Excel sheet, return its corresponding column number.



Problem Constraints
1 <= |A| <= 100



Input Format
First and only argument is string A.



Output Format
Return an integer



Example Input
Input 1:

 "A"
Input 2:

 "AB"


Example Output
Output 1:

 1
Output 2:

 28


Example Explanation
Explanation 1:

 A -> 1
Explanation 2:

A  -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 


---------------------------------------------------------------------------------------------------

public class Solution {
    public int titleToNumber(String A) {
        int col = 0;
        int mul = 26;
        int pow = A.length()-1;
        
        for (int i=0; i<A.length(); i++) {
            if (i == A.length()-1) {
                col += (int)A.charAt(i) - 65 + 1;
            }
            else {
                col += (Math.pow(26, pow))*((int)A.charAt(i) - 65 + 1);
            }
            pow--;
        }
        
        return col;
    }
}

    
}
