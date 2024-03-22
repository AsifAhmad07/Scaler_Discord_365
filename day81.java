public class day81 {


    Name Of The Problem :- Count Element Occurence

    DATE :- 22-march-2024

    Given a sorted array of integers, find the number of occurrences of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return 0

**Example : **

Given [5, 7, 7, 8, 8, 10] and target value 8,

return 2.

PROBLEM APPROACH :

For complete solution, look at the hint.

-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int findCount(final int[] A, int B) {
        int start = findFirstOccurrence(A, B);
        if (start == -1)
            return 0;
        int end = findLastOccurrence(A, B);

        return end - start + 1;
    }
     private static int findFirstOccurrence(int[] A, int x) {
        int l = 0, r = A.length - 1, res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == x) {
                res = mid;
                r = mid - 1;
            } else if (A[mid] < x) { 
                l = mid + 1;
            } else { 
                r = mid - 1;
            }
        }

        return res;
    }
    private static int findLastOccurrence(int[] A, int x) {
        int l = 0, r = A.length - 1, res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == x) {
                res = mid;
                l = mid + 1;
            } else if (A[mid] < x) { 
                l = mid + 1;
            } else { 
                r = mid - 1;
            }
        }

        return res;
    }
} 
}
