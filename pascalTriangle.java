import java.util.ArrayList;

public class pascalTriangle {

    /*
     * Name Of The Problem :- Pascal Triangle
     * Day : 18 
     * 
     * Problem Description
 
 

Given an integer A, equal to numRows, generate the first numRows of Pascal's triangle.
Pascal's triangle: To generate A[C] in row R, sum up A'[C] and A'[C-1] from the previous row R - 1.



Problem Constraints
0 <= A <= 25


Input Format
The first argument is an integer A, equal to the numRows.


Output Format
Return an array of array of integers, equal to pascal triangle.


Example Input
A = 5


Example Output
[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]



     */

     public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    if (A == 0) {
      return list;
    }
    for (int i = 0; i < A; i++) {
      ArrayList<Integer> temp = new ArrayList<>();
      for (int j = 0; j < i + 1; j++) {
        if (j == 0 || j == i) {
          temp.add(1);
        }
        else {
          temp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
        }
      }
      list.add(temp);
    }
    return list;
    }
}

    
}
