public class day45 {


    Name Of The Problem :- Rotate Matrix

    Date :- 15-feb-2024


    Problem Description
 
 

You are given a N x N 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place. Update the given matrix A.

Note: If you end up using an additional array, you will only receive a partial score.



Problem Constraints
1 <= N <= 1000



Input Format
First argument is a 2D matrix A of integers



Output Format
Rotate the given 2D matrix A.



Example Input
Input 1:

 [
    [1, 2],
    [3, 4]
 ]
Input 2:

 [
    [1]
 ]


Example Output
Output 1:

 [
    [3, 1],
    [4, 2]
 ]
Output 2:

 [
    [1]
 ]


Example Explanation
Explanation 1:

 After rotating the matrix by 90 degree:
 1 goes to 2, 2 goes to 4
 4 goes to 3, 3 goes to 1
Explanation 2:

 2D array remains the ssame as there is only element.


 ----------------------------------------------------------------------------------------------------------------------

 public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
        
        int N = a.size()-1;
	    for (int i=0;i < a.size()/2; i++) {
	        for (int j=i; j<N-i; j++) {
	            int temp1 = a.get(N-j).get(i);
	            int temp2 = a.get(N-i).get(N-j);
	            int temp3 = a.get(j).get(N-i);
	            int temp4 = a.get(i).get(j);

	            a.get(i).set(j, temp1);
	            a.get(N-j).set(i, temp2);
	            a.get(N-i).set(N-j, temp3);
	            a.get(j).set(N-i, temp4);
            }
        }
	}
}

    
}
