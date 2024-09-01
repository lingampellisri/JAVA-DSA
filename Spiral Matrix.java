/*
Given an m x n matrix, return all elements of the matrix in spiral order.


Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/




class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer>ar=new ArrayList<>();
        int rows=matrix.length;
        int column=matrix[0].length;
    int left=0;
    int right=column-1;
    int bottom=rows-1;
    int top=0;

    while(left<=right && top<=bottom)
    {
        for(int i=left;i<=right;i++)
        {
            ar.add(matrix[top][i]);
            
        }
        top++;

        for(int j=top;j<=bottom;j++)
        {
            ar.add(matrix[j][right]);
        }
        right--;

        if(top<=bottom)
        {
            for(int p=right;p>=left;p--)
            {
                ar.add(matrix[bottom][p]);
            }
            bottom--;
        }

        if(left<=right)
        {
            for(int q=bottom;q>=top;q--)
            {
                ar.add(matrix[q][left]);
            }
            left++;
        }


    }
    return ar;
        
    }
}
