import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class day23 {
    /*
     * Name Of The Problem :- Anti Diagonals
     * Day :- 23
     * Problem Description

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
Example:

Input:

1 2 3
4 5 6
7 8 9
Return the following:
[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input: 
1 2
3 4
Return the following: 
[
  [1],
  [2, 3],
  [4]
]

     */
    public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
         Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i=0; i<A.size(); i++) {
            for (int j=0; j<A.get(i).size(); j++) {
                ArrayList<Integer> arrayList;
                if (map.containsKey(i+j)) {
                    arrayList = map.get(i+j);
                }
                else {
                    arrayList = new ArrayList<>();
                }

                arrayList.add(A.get(i).get(j));
                map.put(i+j, arrayList);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int key : map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;
    }
}

    
}
