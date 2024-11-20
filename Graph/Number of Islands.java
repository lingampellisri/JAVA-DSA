/*
200. Number of Islands
Solved
Medium
Topics
Companies
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/







class Solution {
  static  class Pair {
    int first;
    int second;

    // Constructor
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

    public static void bfs(int i,int j,char grid[][])
    {
         grid[i][j]=0;
            Queue<Pair>q=new LinkedList<Pair>();

            int r=grid.length;
            int c=grid[0].length;

            int[] dRow = {-1, 1, 0, 0};
            int[] dCol = {0, 0, -1, 1};

            q.offer(new Pair(i,j));
            while(!q.isEmpty())
            {
                int row=q.peek().first;
                int col=q.peek().second;
                q.remove();

                for(int ii=0;ii<4;ii++)
                {
                   
                        int nr=row+dRow[ii];
                        int nc=col+dCol[ii];

                        if(nr>=0 && nr<r && nc>=0 && nc<c && grid[nr][nc]=='1')
                        {
                            grid[nr][nc]=0;
                            q.add(new Pair(nr,nc));
                        }
                    
                }
            }




    }
    public int numIslands(char[][] grid) {

            int row=grid.length;
            int col=grid[0].length;
            int count=0;

            // int visit[][]=new int[row][col];

            for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                {
                    if(grid[i][j]=='1' )
                    {
                        count++;
                        bfs(i,j,grid);
                    }
                }
            } 
            return count;


        
    }
}
