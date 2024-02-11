public class day42 {



    Name Of The Problem :- Sorted Permutation Rank

    Date :- 12-feb-2024


    Problem Description
 
 

Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.

Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003



Problem Constraints
1 <= |A| <= 1000



Input Format
First argument is a string A.



Output Format
Return an integer denoting the rank of the given string.



Example Input
Input 1:

A = "acb"
Input 2:

A = "a"


Example Output
Output 1:

2
Output 2:

1


Example Explanation
Explanation 1:

Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:

Given A = "a".
Rank is clearly 1.

---------------------------------------------------------------------------------------------------

public class Solution {
    static final int M = 1000003;

    int[] fs;

    void fillFactorials(int l) {
        fs = new int[l + 1];
        fs[0] = 1;
        for (int i = 1; i <= l; i++) {
            fs[i] = (fs[i - 1] * i) % M;
        }
    }
    public int findRank(String A) {
        int l = A.length();
        fillFactorials(l);

        int[] chars = new int[256];
        for (int i = 0; i < A.length(); i++) {
            byte c = (byte) A.charAt(i);
            chars[c]++;
        }

        int res = 1;
        for (int i = 0; i < l ; i++) {
            int lessThan = 0;
            for (int j = 0; j < (byte) A.charAt(i); j++) {
                lessThan += chars[j];
            }
            res += fs[l - i - 1] * lessThan % M;
            chars[A.charAt(i)] = 0;
        }
        return res % M;
    }
}

    
}
