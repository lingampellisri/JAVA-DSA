/*

695. Max Area of Island
Solved
Medium
Topics
Companies
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.

*/


// ----------------------Brute force----------------------


class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }


    public int bfs(int i,int j,int visit[][],int grid[][])
    {
        int area=1;
        visit[i][j]=1;
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair>q=new LinkedList<Pair>();

        q.offer(new Pair(i,j));
        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,-1,1};

            while(!q.isEmpty())
            {
                int row=q.peek().first;
                int col=q.peek().second;
                q.poll();

                for(int k=0;k<4;k++)
                {
                    int nrow=row+delRow[k];
                    int ncol=col+delCol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&( visit[nrow][ncol]==0) && (grid[nrow][ncol]==1))
                    {
                        visit[nrow][ncol]=1;
                        area++;
                        q.offer(new Pair(nrow,ncol));
                    }
                }



            }
            return area;


    }
    public int maxAreaOfIsland(int[][] grid) {

            int max=0;

            int r=grid.length;
            int c=grid[0].length;

            int visit[][]=new int[r][c];


            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                        if((visit[i][j]==0 )&& (grid[i][j]==1))
                        {
                            max=Math.max(bfs(i,j,visit,grid),max);
                        }
                }
            }

            return max;



        
    }
}

// Time complexity : O(nxm);
// space complexity : O(nxm);
// **************************************************optimal solution*************************************************


class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }


    public int bfs(int i,int j,int grid[][])
    {
        int area=1;
        grid[i][j]=0;
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair>q=new LinkedList<Pair>();

        q.offer(new Pair(i,j));
        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,-1,1};

            while(!q.isEmpty())
            {
                int row=q.peek().first;
                int col=q.peek().second;
                q.poll();

                for(int k=0;k<4;k++)
                {
                    int nrow=row+delRow[k];
                    int ncol=col+delCol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m  && (grid[nrow][ncol]==1))
                    {
                        grid[nrow][ncol]=0;
                        area++;
                        q.offer(new Pair(nrow,ncol));
                    }
                }



            }
            return area;


    }
    public int maxAreaOfIsland(int[][] grid) {

            int max=0;

            int r=grid.length;
            int c=grid[0].length;



            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                        if((grid[i][j]==1))
                        {
                            max=Math.max(bfs(i,j,grid),max);
                        }
                }
            }

            return max;



        
    }
}



// Time complexity : O(nxm);
// space complexity : O(1);
