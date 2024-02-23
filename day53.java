import java.text.Format;
import java.util.ArrayList;

public class day53 {



    Name Of The Problem :- Matrix Median


    Date :- 23-feb-2024



    Problem Description
 
 

Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Input Format
The first and only argument given is the integer matrix A.



Output Format
Return the overall median of matrix A.



Example Input
Input 1: 

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ] 
Input 2: 

A = [   [5, 17, 100]    ]


Example Output
Output 1: 

 5 
Output 2: 

 17


Example Explanation
Explanation 1: 

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5. 
Explanation 2:

Median is 17.



-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
	    int n = A.size();
	    if(n == 0) return -1;
	    int m = A.get(0).size();
	    int lo = 0;
	    int hi = Integer.MAX_VALUE;
	    int x = 1;
	    while(lo <= hi) {
	        int mid = (lo+hi)/2;
	        if(isLessThanHalf(A, mid)) {
	            lo = mid+1;
	        } else {
	            x = mid;
	            hi = mid-1;
	        }
	    }
	    return x;
	}

	boolean isLessThanHalf(ArrayList<ArrayList<Integer>> a, int num) {
	    int N = a.size();
	    int M = a.get(0).size();
	    int count = 0;
	      
	    for(int i = 0; i < N; i++) {
	        count += getCount(a.get(i), num);
	    }
	    return count < (N*M)/2 + 1;
	}

	int getCount(ArrayList<Integer> a, int n) {
	    int lo = 0;
	    int hi = a.size()-1;
	    while(lo <= hi) {
	        int mid = (lo+hi)/2;
	        if(a.get(mid) > n) hi = mid-1;
	        else lo = mid+1;
	    }
	    return lo;
	}
}


    
}
