import java.util.HashMap;
import java.util.Map;

public class day67 {


    Name Of The problem :- Window String

    Date :- 08-march-2024


    Problem Description
 
 

Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
 Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
 



Problem Constraints
1 <= size(A), size(B) <= 106



Input Format
The first argument is a string A.
The second argument is a string B.



Output Format
Return a string denoting the minimum window.



Example Input
Input 1:

 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:

 A = "Aa91b"
 B = "ab"
 



Example Output
Output 1:

 "BANC"
Output 2:

 "a91b"


Example Explanation
Explanation 1:

 "BANC" is a substring of A which contains all characters of B.
Explanation 2:

 "a91b" is the substring of A which contains all characters of B.

 ----------------------------------------------------------------------------------------------------------------------------------------------------

 public class Solution {
    public String minWindow(String A, String B) {
        
          Map<Character, Integer> map = new HashMap<>();
        for (char c : B.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();
        int idx = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int endIdx = -1;

        while (idx < A.length()) {
            if (map.containsKey(A.charAt(idx))) {
                map.put(A.charAt(idx), map.get(A.charAt(idx)) - 1);
                if (map.get(A.charAt(idx)) == 0) {
                    count--;
                }
            }

            while (start < A.length() && count == 0) {
                if (minLen > idx - start + 1) {
                    startIdx = start;
                    endIdx = idx + 1;
                    minLen = idx - start + 1;
                }
                if (map.containsKey(A.charAt(start))) {
                    map.put(A.charAt(start), map.get(A.charAt(start)) + 1);
                    if (map.get(A.charAt(start)) == 1) {
                        count++;
                    }
                }

                start++;
            }

            idx++;
        }

        return minLen == Integer.MAX_VALUE ? "" : A.substring(startIdx, endIdx);
    }
}

    
}
