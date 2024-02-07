public class day37 {
    

    Name Of The Problem :- Find Duplicate in Array

    Date :- 07-jan-2024



    Problem Description
 
 

Given a read-only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
If there are multiple possible answers ( like in the sample case ), output any one, if there is no duplicate, output -1



Problem Constraints
1 <= |A| <= 105
1 <= Ai <= |A|


Input Format
The first argument is an integer array A.


Output Format
Return the integer that repeats in array A


Example Input
Input 1:
A = [3, 4, 1, 4, 2]
Input 2:
A = [1, 2, 3]
Input 3:
A = [3, 4, 1, 4, 1]


Example Output
Output 1:
4
Output 2:
-1
Output 3:
1


Example Explanation
Explanation 1:
4 repeats itself in the array [3, 4, 1, 4, 2]
Explanation 2:
No number repeats itself in the array [1, 2, 3]
Explanation 3:
1 and 4 repeats itself in the array [3, 4, 1, 4, 1], we can return 1 or 4


-----------------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        
    int tortoise = A.get(0);
    int hare = A.get(0);
    while (true) {
      tortoise = A.get(tortoise);
      hare = A.get(A.get(hare));
      if (tortoise == hare) {
        break;
      }
    }
    int p1 = A.get(0);
    int p2 = tortoise;
    while (p1 != p2) {
      p1 = A.get(p1);
      p2 = A.get(p2);
    }
    return p1;
    }
}

}
