import java.util.ArrayList;
import java.util.Arrays;

public class day16 {
    
     * Name Of The Problem :- Set Matrix Zeros
     * Day :- 16
     * Problem Description
 
 

Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.



Problem Constraints
1 <= N, M <= 1000
0 <= A[i][j] <= 1


Input Format
The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.


Output Format
Return a 2-d matrix that satisfies the given conditions.


Example Input
Input 1:
[   [1, 0, 1],
    [1, 1, 1], 
    [1, 1, 1]   ]
Input 2:
[   [1, 0, 1],
    [1, 1, 1],
    [1, 0, 1]   ]


Example Output
Output 1:
[   [0, 0, 0],
    [1, 0, 1],
    [1, 0, 1]   ]
Output 2:
[   [0, 0, 0],
    [1, 0, 1],
    [0, 0, 0]   ]

 -------------------------------------------------------------------------------
 
 
    public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rowSize = a.size();
        int colSize = a.get(0).size();

        int[] rows = new int[rowSize];
        Arrays.fill(rows, 0);
        int[] cols = new int[colSize];
        Arrays.fill(cols, 0);

        int rowZero = 0, colZero = 0;

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(a.get(i).get(j) == 0 ){
                    if(i == 0){
                        rowZero = 1;
                    }
                    if(j == 0){
                        colZero = 1;
                    }
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(rows[i] == 1 || cols[j] == 1){
                    a.get(i).set(j, 0);
                }
                if(i == 0 && rowZero == 1){
                    a.get(0).set(j, 0);
                }
                if( j == 0 && colZero == 1){
                    a.get(i).set(0, 0);
                }
            }
        }
	}
}

    
}
