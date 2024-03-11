public class day70 {

    Name Of The Problem :- Longest Substring Without Repeat


    Date :- 11-march-2024


    Problem Description
 
 

Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.



Problem Constraints
1 <= size(A) <= 106

 String consists of lowerCase,upperCase characters and digits are also present in the string A.



Input Format
Single Argument representing string A.



Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.



Example Input
Input 1:

 A = "abcabcbb"
Input 2:

 A = "AaaA"


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:

 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.


-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int lengthOfLongestSubstring(String A) {
        
    int maxLength = 0;
    int start = 0;
    int end = 0;
    int n = A.length();
    Map<Character, Integer> map = new HashMap<>();
    while (end < n) {
      char c = A.charAt(end);
      map.put(c, map.getOrDefault(c, 0) + 1);
      while (map.get(c) > 1) {
        map.put(A.charAt(start), map.get(A.charAt(start)) - 1);
        start++;
      }
      end++;
      maxLength = Math.max(maxLength, end - start);
    }
    return maxLength;
    }
}

    
}
