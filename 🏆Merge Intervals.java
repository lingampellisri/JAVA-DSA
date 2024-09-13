/*
56. Merge Intervals
Solved
Medium
Topics
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

*******************************************************************************Brute force solution*****************************************************************

  import java.util.*;

public class Solution {
    public static List< List< Integer > > mergeOverlappingIntervals(int [][]intervals){
        // Write your code here.

         int n=intervals.length;
         if(n==0)
         {
             new ArrayList<>();
         }
        
         Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });


     List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            int start=intervals[i][0];
            int end=intervals[i][1];

                while(i<n-1 && end>=intervals[i+1][0])
                {
                 end=Math.max(end,intervals[i+1][1]);
                 i++;
                }
           
            ans.add(Arrays.asList(start,end));
        }
        return ans;

    }
}


Time complexity : O(nlogn)+O(n^2)
Space Complexity : O(1)




*******************************************************************************Optimal solution*****************************************************************


  class Solution {
    public int[][] merge(int[][] intervals) {

        int n=intervals.length;
        System.out.println(n);
         Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
         });

        if(n==0)
        {
          return  new int [][]{};
        }

        List<int[] >ans=new ArrayList<>();

        int [] currinterval=intervals[0];
        ans.add(currinterval);
        
        for(int i=1;i<n;i++)
        {
                int currstart=currinterval[0];
                int currend=currinterval[1];
                int nextstart=intervals[i][0];
                int nextend=intervals[i][1];


                if(currend>=nextstart)
                {
                    currinterval[1]=Math.max(currend,nextend);
                }        
                else
                {
                    currinterval=intervals[i];
                    ans.add(currinterval);
                }

                
        }
        return ans.toArray(new int[ans.size()][]);



    }
}



Time complexity : O(nlogn)+O(n)
Space Complexity : O(1)
