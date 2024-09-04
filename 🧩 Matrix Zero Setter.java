/*
Problem statement
You are given a matrix 'MATRIX' of dimension 'N' x 'M'. Your task is to make all the elements of row 'i' and column 'j' equal to 0 if any element in the ith row or jth column of the matrix is 0.

Note:

1) The number of rows should be at least 1.

2) The number of columns should be at least 1.

3) For example, refer to the below matrix illustration: 

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 100
1 <= M <= 100
-10^9 <= MATRIX[i][j] <= 10^9

Where 'MATRIX[i][j]' denotes the matrix element.
Follow Up:

Can you solve it with the space complexity of O(1)?

Time limit: 1 sec


Sample Input 1:
2 3
2 4 3
1 0 0
Sample Output 1:
2 0 0 
0 0 0 
Sample Input 2:
1 1 
5
Sample Output 2:
5 
*/

**************************************************************************Better solution************************************************************

  class Solution {
    public void setZeroes(int[][] matrix) {
        int rows[]=new int[matrix.length];
        int column[]=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                    if(matrix[i][j]==0)
                    {
                        rows[i]=1;
                        column[j]=1;
                    }
            }
        }

         for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                 if(rows[i]!=0 || column[j]!=0)
                 {
                    matrix[i][j]=0;
                 }
            }
        }


        
    }
}


The time complexity is 𝑂(𝑛^2)+𝑂(𝑛^2)

The space complexity is 𝑂(𝑚+𝑛)










  
