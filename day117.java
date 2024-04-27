import java.util.ArrayList;

public class day117 {


    Name Of The Problem :- Remove Duplicates from Sorted Array II

    Date :- 27-April-2024

    Problem Description
 
 

Remove Duplicates from the Sorted Array
Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
Note that even though we want you to return the new length, make sure to change the original array as well in place


Problem Constraints
1 <= |A| <= 106
1 <= Ai <= 2 * 109


Input Format
The first argument is an integer array A.


Output Format
Update the array and return the length of the updated array


Example Input
A = [1,1,1,2]


Example Output
3


Example Explanation
For example, Given input array A = [1,1,1,2],
Your function should return length = 3, and A is now [1,1,2].


*****************************************************************************************************************************************************

public class Solution {
	public int removeDuplicates(ArrayList<Integer> A) {
         int n = A.size(), pos = 2;
        if (pos >= n)
            return n;
        for (int i = 2; i < n; i++) {
            if (!A.get(i).equals(A.get(pos - 2)))
                A.set(pos++, A.get(i));
        }
        return pos;
	}
}

    
}
