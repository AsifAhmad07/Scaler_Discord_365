import java.util.List;

public class day55 {

    Name Of The Problem :- Rotated Sorted Array Search

    Date :- 25-feb-2024

    Problem Description
 
 

Given an array of integers A of size N and an integer B.
array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
You are given a target value B to search. If found in the array, return its index, otherwise, return -1.
You may assume no duplicate exists in the array.

NOTE:- Array A was sorted in non-decreasing order before rotation.

Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?



Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 10^9
1 <= B <= 10^9
all elements in A are distinct.



Input Format
The first argument given is the integer array A.

The second argment given is the integer B.



Output Format
Return index of B in array A, otherwise return -1



Example Input
Input 1: 

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4 
Input 2: 

A = [5, 17, 100, 3]
B = 6


Example Output
Output 1: 

 0 
Output 2: 

 -1


Example Explanation
Explanation 1:

Target 4 is found at index 0 in A. 
Explanation 2:

Target 6 is found not found in the array A = [5, 17, 100, 3].



-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
	// DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
	    return binarySearch(a, 0, a.size()-1, b);
	}
	
	public int binarySearch(List<Integer> a, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end)/2;
            if (a.get(mid) == target) {
                return mid;
            }
            else if (a.get(start) <= a.get(mid)) {
                if (target >= a.get(start) && a.get(mid) >= target) {
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            else {
                if (a.get(mid+1) <= target && a.get(end) >= target) {
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
    
}
