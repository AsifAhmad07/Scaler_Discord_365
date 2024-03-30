public class day89 {

    Name Of The Problem :- Maximum Sum Square SubMatrix


    Date :- 30.march-2023


    Problem Description

Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1, such that sum of all the elements in submatrix is maximum.



Problem Constraints
1 <= N <= 103.

1 <= B <= N 

-102 <= A[i][j] <= 102.



Input Format
First arguement is an 2D integer matrix A.

Second argument is an integer B.



Output Format
Return a single integer denoting the maximum sum of submatrix of size B x B.



Example Input
Input 1:

 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:

 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2


Example Output
Output 1:

 48
Output 2:

 8


Example Explanation
Explanation 1:

    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48
Explanation 2:

 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8


-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int solve(int[][] A, int B) {
        
         int n = A.length;
        for (int i = 1; i < n; i++) {
            A[0][i] += A[0][i - 1];
            A[i][0] += A[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++)
                A[i][j] += A[i - 1][j] + A[i][j - 1] - A[i - 1][j - 1];
        }
        int res = A[B - 1][B - 1];
        for (int i = B; i < n; i++) {
            res = Math.max(res, A[B - 1][i] - A[B - 1][i - B]);
            res = Math.max(res, A[i][B - 1] - A[i - B][B - 1]);
        }
        for (int i = B; i < n; i++) {
            for (int j = B; j < n; j++) {
                int matrixSum = A[i][j] - A[i - B][j] - A[i][j - B] + A[i - B][j - B];
                res = Math.max(res, matrixSum);
            }
        }

        return res;
    }
}

    
}
