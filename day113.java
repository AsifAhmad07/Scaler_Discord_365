import java.util.jar.Attributes.Name;

public class day113 {


    Name Of The Problem :- Subarrays with distinct integers!


    Date :- 23-April-2024


    Problem Description

Given an array A of positive integers,call a (contiguous,not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly B.

(For example: [1, 2, 3, 1, 2] has 3 different integers 1, 2 and 3)

Return the number of good subarrays of A.



Problem Constraints
1 <= |A| <= 40000

1 <= A[i] <= |A|

1 <= B <= |A|



Input Format
The first argument given is the integer array A.

The second argument given is an integer B.



Output Format
Return an integer denoting the number of good subarrays of A.



Example Input
Input 1:

 A = [1, 2, 1, 2, 3]
 B = 2
Input 2:

 A = [1, 2, 1, 3, 4]
 B = 3


Example Output
Output 1:

 7
Output 2:

 3


Example Explanation
Explanation 1:

  Subarrays formed with exactly 2 different integers: [1, 2], [2, 1], [1, 2], [2, 3], [1, 2, 1], [2, 1, 2], [1, 2, 1, 2].
Explanation 2:

  Subarrays formed with exactly 3 different integers: [1, 2, 1, 3], [2, 1, 3], [1, 3, 4].


*****************************************************************************************************************************************************

public class Solution {
    public int solve(int[] A, int B) {
        return atMostB(A, B) - atMostB(A, B - 1);
    }
    private static int atMostB(int[] A, int B) {
        int n = A.length;
        int start = 0, end = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (end < n) {
            map.put(A[end], map.getOrDefault(A[end], 0) + 1);
            while (map.size() > B) {
                int freq = map.get(A[start]) - 1;
                if (freq == 0)
                    map.remove(A[start]);
                else
                    map.put(A[start], freq);

                start++;
            }
            res += end - start + 1;
            end++;
        }

        return res;
    }

}

    
}
