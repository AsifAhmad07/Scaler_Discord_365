public class searchForARange {
    /*
     * Name Of The Problem :- Search for a Range
     * Given a sorted array of integers A(0 based index) of size N, find the starting and the ending position of a given integer B in array A.

Your algorithm's runtime complexity must be in the order of O(log n).

Return an array of size 2, such that the first element = starting position of B in A and the second element = ending position of B in A, if B is not found in A return [-1, -1].



Problem Constraints
1 <= N <= 106

1 <= A[i], B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return an array of size 2, such that the first element = starting position of B in A and the second element = the ending position of B in A if B is not found in A return [-1, -1].



Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 The first occurence of 8 in A is at index 3.
 The second occurence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:

 There is no occurence of 3 in the array.
     */
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] searchRange(final int[] A, int B) {
            int first = -1, last = -1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == B) {
                    if (first == -1) {
                        first = i;
                    }
                    last = i;
                }
            }
            return new int[]{first, last};
        }
    }
    
    
}
