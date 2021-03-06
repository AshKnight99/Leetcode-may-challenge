/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
Example 1:
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
*/
class Solution {
    public int countSquares(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        int [][]dp = new int[n][m];        
        for (int i=0; i < n; ++i){
            dp[i][0] = matrix[i][0] == 1? 1 : 0;
        }        
        for (int i=0; i < m; ++i){
            dp[0][i] = matrix[0][i] == 1? 1 : 0;
        }	
        for (int i = 1; i < n; ++i){
            for (int j = 1; j < m; ++j){
                if (matrix[i][j] == 1){
                    int min = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    dp[i][j] = min;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){                
                count += dp[i][j];
            } 
        }        
        return count;                
    }
}        