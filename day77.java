import java.text.Format;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day77 {

    Name Of The Problem :- Single Number II

    Date :- 18-march-2024


    Problem Description
 
 

Given an array of integers, every element appears thrice except for one, which occurs once.
 Find that element that does not appear thrice.
 NOTE: Your algorithm should have a linear runtime complexity.
 Can you implement it without using extra memory?



Problem Constraints
2 <= A <= 5*106
0 <= A <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer.



Example Input
Input 1:

 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:

 A = [0, 0, 0, 1]


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        
          Map<Integer, Integer> map = new HashMap<>();

        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
                break;
            }
        }

        return ans;
    }
}


}