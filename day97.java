public class day97 {


    Name Of The Problem :- Highest Score

    Date :- 07-April-2024

    Problem Description
 
 

You are given a 2D string array A of dimensions N x 2,

where each row consists of two strings: first is the name of the student, second is their marks.

You have to find the maximum average mark. If it is a floating point, round it down to the nearest integer less than or equal to the number.



Problem Constraints
1 <= N <= 105


Input Format
The first argument is a 2D string array A.


Output Format
Return a single integer which is the highest average mark.


Example Input
Input 1:
A = [["Bob", "80"], ["Bob", "90"], ["Alice", "90"]]
Input 2:

A = [["Bob", "80"], ["Bob", "90"], ["Alice", "90"], ["Alice", "10"]]


Example Output
Output 1:
90
Output 2:

85


Example Explanation
Explanation 1:
Alice has the highest average with 90 marks.
Explanation 2:

Bob has the highest average with 85 marks.



-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int highestScore(String[][] A) {
        
         Map<String, int[]> map = new HashMap<>();

        for (String[] student : A) {
            String name = student[0];
            int marks = Integer.parseInt(student[1]);
            if (map.containsKey(name)) {
                int[] result = map.get(name);
                result[0] += marks;
                result[1]++;
            } else {
                map.put(name, new int[]{marks, 1});
            }
        }
        float maxAvg = 0;
        for (int[] result : map.values()) {
            float avg = result[0] / (float) result[1];
            maxAvg = Math.max(maxAvg, avg);
        }

        return (int) maxAvg;
    }
}

    
}
