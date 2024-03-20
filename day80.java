public class day80 {



    Name Of The Problem :- Median of Array

    Date :- 21-march-2024

    Problem Description
 
 

There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both arrays ).

The overall run time complexity should be O(log (m+n)).

NOTE: If the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 


Problem Constraints
0 <= |A| <= 106
0 <= |B| <= 106
1 <= |A| + |B| <= 2 * 106


Input Format
The first argument is an integer array A.
The second argument is an integer array B.


Output Format
Return a double value equal to the median.


Example Input
A : [1 4 5]
B : [2 3]


Example Output
3


Example Explanation
Merged A and B will be : [1, 2, 3, 4, 5]
Its median will be 3


-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        
         int n1 = a.size(), n2 = b.size();

        if (n1 > n2)
            return findMedianSortedArrays(b, a);
        
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; 
        int low = 0, high = n1;
        
        while (low <= high) {
            int mid1 = (low + high) / 2; 
            int mid2 = left - mid1; 
            
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a.get(mid1 - 1);
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b.get(mid2 - 1);
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a.get(mid1);
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b.get(mid2);
            
            if (l1 <= r2 && l2 <= r1) {
               
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
            else if (l1 > r2) {
                
                high = mid1 - 1;
            }
            else {
               
                low = mid1 + 1;
            }
        }
        
        return 0;
	}
}

    
}
