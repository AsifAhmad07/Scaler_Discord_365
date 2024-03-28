import java.nio.file.Files;

public class day88 {

    Name Of The Problem :- Reorder Data in Log Files


    Date :- 29-march-2024

    Problem Description
 
 

You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.

Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.

Return the final order of the logs.


Problem Constraints
1 <= logs.length <= 1000
3 <= logs[i].length <= 1000
All the tokens of logs[i] are separated by a single space.
logs[i] is guaranteed to have an identifier and at least one word after the identifier.


Input Format
The first argument is a string array A where each element is a log.


Output Format
Return the string array A after making the changes.


Example Input
Input 1:
A = ["dig1-8-1-5-1", "let1-art-can", "dig2-3-6", "let2-own-kit-dig", "let3-art-zero"]
Input 2:

A = ["a1-9-2-3-1","g1-act-car","zo4-4-7","ab1-off-key-dog","a8-act-zoo"]


Example Output
Output 1:
["let1-art-can","let3-art-zero","let2-own-kit-dig","dig1-8-1-5-1","dig2-3-6"]
Output 2:

["g1-act-car", "a8-act-zoo", "ab1-off-key-dog", "a1-9-2-3-1", "zo4-4-7"]


Example Explanation
Explanation 1:
The letter-log contents are all different, so their ordering is "art-can", "art-zero", "own-kit-dig".
The digit-logs have a relative order of "dig1-8-1-5-1", "dig2-3-6".
Explanation 2:

The array has been sorted restricted to the conditions given.


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public String[] reorderLogs(String[] A) {
         int pi = partition(A);
        Arrays.sort(A, 0, pi, (s1, s2) -> {
            int pos1 = s1.indexOf("-"), pos2 = s2.indexOf("-");
            int comp = s1.substring(pos1 + 1).compareTo(s2.substring(pos2 + 1));
            if (comp == 0)
                return s1.substring(0, pos1).compareTo(s2.substring(0, pos2));
            return comp;
        });

        return A;
    }
     private static int partition(String[] A) {
        int n = A.length, pi = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int pos = A[i].indexOf("-");
            if (Character.isDigit(A[i].charAt(pos + 1))) {
                String temp = A[i];
                A[i] = A[pi];
                A[pi--] = temp;
            }
        }

        return pi + 1;
     }
}

    
}
