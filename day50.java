public class day50 {

    Name Of The zProblem :- Triplets with Sum between given range

    Date :- 20-feb-2024

    Problem Description
 
 

Given an array of real numbers greater than zero in form of strings. Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2. Return 1 for true or 0 for false.
O(n) solution is expected.
Note: You can assume the numbers in strings don't overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.


Problem Constraints
1 <= |A| <= 106


Input Format
The first argument is an array of strings A.


Output Format
Return an integer, 1 for true or 0 for false.


Example Input
A = ["0.6", "0.7", "0.8", "1.2", "0.4"]


Example Output
1


Example Explanation
Given [0.6, 0.7, 0.8, 1.2, 0.4],
You should return 1
as
0.6+0.7+0.4=1.7
1<1.7<2

Hence, the output is 1.




-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int solve(ArrayList<String> A) {
         Set<Double> set = new TreeSet<>();
        for (String num : A) {
            set.add(Double.parseDouble(num));
        }
        double lowerRange = 0.67;

        // Getting the three ranges
        List<Double> lowerRangeList = new ArrayList<>();
        for (Double d : set) {
            if (d < lowerRange) {
                lowerRangeList.add(d);
            }
        }

        List<Double> middleRangeList = new ArrayList<>();
        for (Double d : set) {
            if (d >= lowerRange && d <= 1) {
                middleRangeList.add(d);
            }
        }

        List<Double> upperRangeList = new ArrayList<>();
        for (Double d : set) {
            if (d > 1 && d < 2) {
                upperRangeList.add(d);
            }
        }

        // Checking for a possible triplet
        double sum;
        int lowerSetSize = lowerRangeList.size();
        int middleSetSize = middleRangeList.size();
        int upperSetSize = upperRangeList.size();

        // Case 1
        if (lowerSetSize >= 3) {
            sum = lowerRangeList.get(lowerSetSize-1) + lowerRangeList.get(lowerSetSize-2) + lowerRangeList.get(lowerSetSize-3);
            if (sum > 1 && sum < 2) {
                return 1;
            }
        }

        // Case 2
        if (upperSetSize > 0 && lowerSetSize >= 2) {
            sum = upperRangeList.get(0) + lowerRangeList.get(0) + lowerRangeList.get(1);
            if (sum > 1 && sum < 2) {
                return 1;
            }
        }

        // Case 3
        if (lowerSetSize > 0 && middleSetSize > 0 && upperSetSize > 0) {
            sum = lowerRangeList.get(0) + middleRangeList.get(0) + upperRangeList.get(0);
            if (sum > 1 && sum < 2) {
                return 1;
            }
        }

        // Case 4
        if (lowerSetSize > 0 && middleSetSize > 1) {
            sum = lowerRangeList.get(0) + middleRangeList.get(0) + middleRangeList.get(1);
            if (sum > 1 && sum < 2) {
                return 1;
            }
        }

        // Case 5
        if (lowerSetSize > 1 && middleSetSize > 0) {
            sum = lowerRangeList.get(lowerSetSize-1) + lowerRangeList.get(lowerSetSize-2) + middleRangeList.get(middleSetSize-1);
            if (sum > 1 && sum < 2) {
                return 1;
            }
        }

        // Case 6
        List<Double> lowerFirst = new ArrayList<>();
        List<Double> lowerSec = new ArrayList<>();

        for (Double d : lowerRangeList) {
            if (d < 0.5) {
                lowerFirst.add(d);
            }
            else {
                lowerSec.add(d);
            }
        }

        if (!lowerFirst.isEmpty() && !lowerSec.isEmpty() && !middleRangeList.isEmpty()) {
            sum = lowerFirst.get(0) + lowerSec.get(0) + middleRangeList.get(0);
            if (sum > 1 && sum < 2) {
                return 1;
            }
        }

        if (lowerSec.size() > 1 && !middleRangeList.isEmpty()) {
            sum = lowerSec.get(0) + lowerSec.get(1) + middleRangeList.get(0);
            if (sum > 1 && sum < 2) {
                return 1;
            }
        }

        if (!lowerFirst.isEmpty() && !lowerSec.isEmpty() && !middleRangeList.isEmpty()) {
            sum = lowerFirst.get(lowerFirst.size()-1) + lowerSec.get(lowerSec.size()-1) + middleRangeList.get(middleSetSize-1);
            if (sum > 1 && sum < 2) {
                return 1;
            }
        }

        return 0;
    }
}

    
}
