import java.util.function.Function;

public class day61 {

    Name Of The Problem :- Implement Power Function

    Date :- 02-march-2024


    Problem Description
 
 

Implement pow(x, n) % d.
In other words, given x, n and d,
Find (xn % d)
Note that remainders on division cannot be negative. In other words, make sure the answer you return is non-negative integer.


Problem Constraints
-109 <= x <= 109
0 <= n <= 109
1 <= d <= 109


Example Input
Input 1:
x = 2
n = 3
d = 3
Input 2:
x = 5
n = 2
d = 6


Example Output
Output 1:
2
Output 2:
1


Example Explanation
Explanation 1:
23 % 3 = 8 % 3 = 2.
Explanation 2:
52 % 6 = 25 % 6 = 1.


-----------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
	public int pow(int x, int n, int d) {
    if(x == 0){
      return 0;
    }
    if(n == 0){
      return 1;
    }
    int check = 0;
    if(x < 0){
      x = Math.abs(x);
      check = n % 2 != 0 ? 1 : 0;
    }
    long rem = 1;
    long temp = x % d;
    while(n != 0){
      rem = n % 2 != 0 ? (rem * temp) % d : rem;
      temp = temp * temp;
      temp = temp % d;
      n /= 2;
      rem = rem % d;
    }
    return check == 1 ? d - (int)rem : (int)rem;
        
        
	}
}

    
}
