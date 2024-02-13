public class day43 {

    Name Of The Problem :- Excel Column Title

    Date :- 13-feb-2024

    Problem Description

    Given a positive integer A, return its corresponding column title as appear in an Excel sheet.
    
    
    
    Problem Constraints
    1 <= A <= 1000000000
    
    
    
    Input Format
    First and only argument is integer A.
    
    
    
    Output Format
    Return a string, the answer to the problem.
    
    
    
    Example Input
    Input 1:
    
     A = 1
    Input 2:
    
     A = 28
    
    
    Example Output
    Output 1:
    
     "A"
    Output 2:
    
     "AB"
    
    
    Example Explanation
    Explanation 1:
    
     1 -> A
    Explanation 2:
    
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    
    
---------------------------------------------------------------------------------------------------


public class Solution {
    public String convertToTitle(int col) {
        
        StringBuilder sb = new StringBuilder("");
        while (col > 0) {
            if (col%26 == 0) {
                sb.append("Z");
                col = col/26 - 1;
            }
            else {
                sb.append((char)(65 + col%26 - 1));
                col /= 26;
            }
        }

        return sb.reverse().toString();
    }
}




    
}
