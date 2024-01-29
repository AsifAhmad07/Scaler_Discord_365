public class day29 {

    Name Of The Problem :- Rearrange Array


    Date :- 30-jan-2024


    Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.
Lets say N = size of the array. Then, following holds true :

All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer

Constraints:

1 <= N <= 5×104

0 <= A[i] <= N - 1

The elements of A are distinct 

Input Format

The argument A is an array of integers

Example 1:

Input : [1, 0]
Return : [0, 1]
Example 2:

Input : [0, 2, 1, 3]
Return : [0, 1, 2, 3]
 

------------------------------------------------------------------------

public class Solution {
	public void arrange(ArrayList<Integer> A) {
         int n = A.size();
	    for (int i = 0; i < n; i++) {
	        A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
	    }
	    for (int i = 0; i < n; i++) {
	        A.set(i, A.get(i) / n);
	    }
	}
}



    
}
