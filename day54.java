public class day54 {


    Name Of The Problem :- Search in Bitonic Array!

    Date :- 24-feb-2024

    Problem Description
 
 

Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.


Problem Constraints
3 <= N <= 105

1 <= A[i], B <= 108

Given array always contain a bitonic point.

Array A always contain distinct elements.



Input Format
First argument is an integer array A denoting the bitonic sequence.

Second argument is an integer B.



Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.



Example Input
Input 1:

 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:

 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30


Example Output
Output 1:

 3
Output 2:

 -1


Example Explanation
Explanation 1:

 B = 20 present in A at index 3
Explanation 2:

 B = 30 is not present in A

 ----------------------------------------------------------------------------------------------------------------------------------------------------




public class Solution {
  public int solve(ArrayList<Integer> A, int B) {
    int idx = findBitonicPoint(A);
    return searchBitonic(A, B, idx);
  }

  private int searchBitonic(ArrayList<Integer> A, int B, int idx) {
    if (A.get(idx) == B) {
      return idx;
    }
    int tempIdx = ascendingBS(A, B, 0, idx - 1);
    return tempIdx != -1 ? tempIdx : descendingBS(A, B, idx + 1, A.size() - 1);
  }

  private int ascendingBS(ArrayList<Integer> A, int key, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (A.get(mid) == key) {
        return mid;
      }
      else if (A.get(mid) > key) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return -1;
  }

  private int descendingBS(ArrayList<Integer> A, int key, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (A.get(mid) == key) {
        return mid;
      }
      else if (A.get(mid) < key) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return -1;
  }

  private int findBitonicPoint(ArrayList<Integer> A) {
    int start = 0;
    int end = A.size() - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (A.get(mid) > A.get(mid + 1) && A.get(mid) > A.get(mid - 1)) {
        return mid;
      }
      if (A.get(mid) > A.get(mid + 1) && A.get(mid) < A.get(mid - 1)) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return -1;
  }
}

    
}
