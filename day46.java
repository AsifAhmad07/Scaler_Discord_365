public class day46 {



    Name Of The Problem :- Maximum Unsorted Subarray


    Date :- 16-feb-2024



    Problem Description
 
 

Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted.
If A is already sorted, output -1.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 1000000



Input Format
First and only argument is an array of non-negative integers of size N.



Output Format
Return an array of length two where the first element denotes the starting index(0-based) and the second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.



Example Input
Input 1:

A = [1, 3, 2, 4, 5]
Input 2:

A = [1, 2, 3, 4, 5]


Example Output
Output 1:

[1, 2]
Output 2:

[-1]


Example Explanation
Explanation 1:

If we sort the sub-array A1, A2, then the whole array A gets sorted.
Explanation 2:

A is already sorted.


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
         int start = -1;
        int end = -1;
        int i = 0;
        int n = A.size();
        ArrayList<Integer> arr = new ArrayList<>();

        while (i < n-1) {
            if (A.get(i) > A.get(i+1)) {
                start = i;
                end = n-1;

                while (end > start) {
                    if (A.get(end) < A.get(end-1)) {
                        while (end < n-1) {
                            if (!A.get(end).equals(A.get(end + 1))) break;
                            end++;
                        }
                        break;
                    }
                    end--;
                }
                break;
            }
            i++;
        }

        if (start == -1 && end == -1) {
            arr.add(-1);
            return arr;
        }
        
        int min = A.get(start);
        int max = A.get(end);
        int minIdx = start;
        
        while (minIdx <= end) {
            min = Math.min(min, A.get(minIdx));
            max = Math.max(max, A.get(minIdx));
            minIdx++;
        }

        for (i=0;i<start; i++) {
            if (A.get(i) > min) {
                start = i;
                break;
            }
        }

        for (i=n-1; i > end; i--) {
            if (A.get(i) < max) {
                end = i;
                break;
            }
        }

        arr.add(start);
        arr.add(end);
        return arr;
    }
}




    
}
