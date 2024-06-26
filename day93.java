import java.util.Arrays;
import java.util.Set;

public class day93 {


    Name Of The Problem :- Set Intersection

    Date :- 03-April-2024


    Problem Description
 
 

An integer interval [X, Y] (for integers X < Y) is a set of all consecutive integers from X to Y, including X and Y.

You are given a 2D array A with dimensions N x 2, where each row denotes an interval.

Find the minimum size of a set S such that for every integer interval Z in A, the intersection of S with Z has a size of at least two.



Problem Constraints
1 <= N <= 105
1 <= A[i][0] < A[i][1] <= 109


Input Format
The first argument is a 2D integer array A.


Output Format
Return a single integer denoting the minimum size of S.


Example Input
Input 1:
A = [[1, 3], [1, 4], [2, 5], [3, 5]]
Input 2:

A = [[1, 2], [2, 3], [2, 4], [4, 5]]


Example Output
Output 1:
3
Output 2:

5


Example Explanation
Explanation 1:
Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
Also, there isn't a smaller size set that fulfills the above condition.
Thus, we output the size of this set, which is 3.
Explanation 2:

An example of a minimum sized set is {1, 2, 3, 4, 5}.


-----------------------------------------------------------------------------------------------------------------------------------------------------
public class Solution {
    public int setIntersection(int[][] A) {
        
         Arrays.sort(A, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int secondLast = A[0][1] - 1, last = A[0][1], res = 2;
        for (int i = 1; i < A.length; i++) {
            int start = A[i][0], end = A[i][1];
            if (start > last) {
                secondLast = end - 1;
                last = end;
                res += 2;
            }
            else if (start == last || start > secondLast) {
                secondLast = last;
                last = end;
                res++;
            }
        }

        return res;
    }
    
}

    
}
