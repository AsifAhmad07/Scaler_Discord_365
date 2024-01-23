public class maximumAreaOfTriangle {
    
     * Name Of The Problem - Maximum Area of Triangle!
     * Problem Description

Given a character matrix of size N x M in the form of a string array A of size N where A[i] denotes ith row.

Each character in the matrix consists any one of the following three characters {'r', 'g', 'b'} where 'r' denotes red color similarly 'g' denotes green color and 'b' denotes blue color.

You have to find the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.

NOTE:

If the area comes out to be a real number than return the ceil of that number.


Problem Constraints
2 <= N, M <= 103

A[i][j] = 'r' or A[i][j] = 'g' or A[i][j] = 'b'



Input Format
First and only argument is an string array A of size N denoting the 2D character matrix.



Output Format
Return a single integer denoting the area of the largest triangle that has one side parallel to y-axis i.e vertical and the color of all three vertices are different.

If the area comes out to be a real number than return the ceil of that number.



Example Input
Input 1:

 A = ["rrrrr", "rrrrg", "rrrrr", "bbbbb"]
Input 2:

 A = ["rrr", "rrr", "rrr", "rrr"]


Example Output
Output 1:

 10
Output 2:

 0


Example Explanation
Explanation 1:

 The maximum area of triangle is 10.
 Triangle coordinates are (0,0) containing r, (1,4) containing g, (3,0) containing b.
 
Explanation 2:

 All cells have same color so no triangle possible so we will return 0


    ---------------------------------------------------------------------------
    
    int Solution::solve(vector<string> &A) {
        int rows = A.size(),cols = A[0].size();
        map<char,int> maxRow[cols],minRow[cols],maxCol,minCol;
        
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                maxRow[j][A[i][j]] = max(maxRow[j][A[i][j]],i);
                if(minRow[j].count(A[i][j]))
                {
                    minRow[j][A[i][j]] = min(minRow[j][A[i][j]],i);
                }
                else
                {
                    minRow[j][A[i][j]] = i;
                }
                maxCol[A[i][j]] = max(maxCol[A[i][j]],j);
                if(minCol.count(A[i][j]))
                {
                    minCol[A[i][j]] = min(minCol[A[i][j]],j);
                }
                else
                {
                    minCol[A[i][j]] = j;
                }
            }
        }
        int ans = 0;
        for(int col = 0;col<cols;col++)
        {
            int maxBase,maxHeight;
            
            
            if(maxRow[col].count('r') and maxRow[col].count('g') and maxCol.count('b'))
            {
                maxBase = max(abs(maxRow[col]['r']-minRow[col]['g']),abs(minRow[col]['r']-maxRow[col]['g']))+1;
                maxHeight = max(abs(col-maxCol['b']),abs(col-minCol['b']))+1;
                ans = max(ans,maxBase*maxHeight);
            }
            
            if(maxRow[col].count('g') and maxRow[col].count('b') and maxCol.count('r'))
            {
                maxBase = max(abs(maxRow[col]['g']-minRow[col]['b']),abs(minRow[col]['g']-maxRow[col]['b']))+1;
                maxHeight = max(abs(col-maxCol['r']),abs(col-minCol['r']))+1;
                ans = max(ans,maxBase*maxHeight);
            }
    
            if(maxRow[col].count('b') and maxRow[col].count('r') and maxCol.count('g'))
            {
                maxBase = max(abs(maxRow[col]['b']-minRow[col]['r']),abs(minRow[col]['b']-maxRow[col]['r']))+1;
                maxHeight = max(abs(col-maxCol['g']),abs(col-minCol['g']))+1;
                ans = max(ans,maxBase*maxHeight);
            }
        }
        return ceil(ans/2.0);
    }
    

    
}
