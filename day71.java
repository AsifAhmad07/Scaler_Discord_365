public class day71 {


    Name Of The Problem :- Substring Concatenation

    Date :- 12-march-2024

    You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].

(order does not matter).


-----------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        
        ArrayList<Integer> r = new ArrayList<>();

        Map<String, Integer> countOriginal = new HashMap<>();
        if(A.length()==0 || B.size() == 0){
            return r;
        }

        int oneWordL = B.get(0).length();
        for (String aB : B) {
            countOriginal.put(aB, countOriginal.getOrDefault(aB, 0) + 1);
        }

        int start = 0;

        while((start+oneWordL*B.size()-1)<A.length()){

            Map<String,Integer> checkMap = new HashMap<>();
            int j = 0;

            while((start + j*oneWordL + oneWordL - 1) < A.length()){

                String temp = A.substring(start + j*oneWordL, start + j*oneWordL + oneWordL);
                if(!countOriginal.containsKey(temp)){
                    break;
                }
                else{
                    int c = checkMap.getOrDefault(temp,0);
                    c++;
                    checkMap.put(temp,c);

                    if(checkMap.get(temp) > countOriginal.get(temp)){
                        break;
                    }

                    j++;
                }

                if(j == B.size()){
                    r.add(start);
                }
            }

            start++;


        }

        return r;
    }
}

    
}
