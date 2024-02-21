import java.util.ArrayList;

public class day52 {

    Name Of The Problem :- Matrix Search

    Date :- 22-feb-2024


    Problem Description
 
 

Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A. 

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints
1 <= N, M <= 1000

1 <= A[i][j], B <= 106



Input Format
The first argument given is the integer matrix A.

The second argument given is the integer B.



Output Format
Return 1 if B is present in A else, return 0.



Example Input
Input 1: 

A = [ 
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]

    ]
B = 3
Input 2:

A = [

      [5, 17, 100, 111]
      [119, 120, 127, 131]

    ]
B = 3


Example Output
Output 1: 

1
Output 2:

0


Example Explanation
Explanation 1: 

 3 is present in the matrix at A[0][1] position so return 1.
Explanation 2:

 3 is not present in the matrix so return 0.


-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        
     if (A.size() == 0 || A.get(0).size() == 0) {
      return 0;
    }
    int start = 0;
    int end = A.size() - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (A.get(mid).get(0) > B) {
        end = mid - 1;
      }
      else {
        int tempIdx = binarySearchHelper(A.get(mid), B);
        if (tempIdx != -1) {
          return 1;
        }
        start = mid + 1;
      }
    }
    return 0;
    }
    
    private int binarySearchHelper(ArrayList<Integer> A, int B) {
    int start = 0;
    int end = A.size() - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (A.get(mid) == B) {
        return mid;
      }
      else if (A.get(mid) > B) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return -1;
  }
}

}