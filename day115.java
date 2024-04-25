public class day115 {


    Name Of The Problem :- Merge Two Sorted Lists II

    Date :- 25-April-2024

    Problem Description
 
 

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result.

If the number of elements initialized in A and B is m and n respectively, the resulting size of array A after your code is executed should be m + n


Problem Constraints
1 <= |A|, |B| <= 105


Input Format
The first argument is an integer array A.
The second argument is an integer array B.


Output Format
Update the array A.


Example Input
A : [1 5 8]
B : [6 9]


Example Output
Modified A : [1 5 6 8 9]


*****************************************************************************************************************************************************

public class Solution {
	public void merge(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        int m = A.size(), n = B.size();
        for (int k = 0; k < n; k++)
            A.add(0);
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A.get(i) > B.get(j))
                A.set(i + j + 1, A.get(i--));
            else
                A.set(i + j + 1, B.get(j--));
        }
        while (j >= 0)
            A.set(j, B.get(j--));
	}
}

    
}
