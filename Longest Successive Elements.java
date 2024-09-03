/*
Problem statement
There is an integer array ‘A’ of size ‘N’.

A sequence is successive when the adjacent elements of the sequence have a difference of 1.

You must return the length of the longest successive sequence.

Note:

You can reorder the array to form a sequence. 
For example,

Input:
A = [5, 8, 3, 2, 1, 4], N = 6
Output:
5
Explanation: 
The resultant sequence can be 1, 2, 3, 4, 5.    
The length of the sequence is 5.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
1 <= A[i] <= 10^9
Time Limit: 1 sec
*/

*************************************************************************Better solution****************************************************************

  import java.util.*;
public class Solution {
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        int size=a.length;
        Arrays.sort(a);
        int longest=1;
        int count=0;
        int prev_min=Integer.MIN_VALUE;

        for(int i=0;i<size;i++)
        {
            if(a[i]-1==prev_min)
            {
                count=count+1;
                prev_min=a[i];
            }
            else if(a[i]!=prev_min)
            {
                count=1;
                prev_min=a[i];
            }
            longest=Math.max(count,longest);
            // count=0;

        }
        return longest;
    }
}



Time Complexity : O(n)+nlogn
Space Complexity : O(1)



  
*************************************************************************Optimal solution****************************************************************



  import java.util.*;
public class Solution {
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        int longest=1;
        
            Set<Integer>s=new HashSet<>();
            for(int i :a)
            {
                s.add(i);
            }

            for(int j:a)
            {
                if(!s.contains(j-1))
                {
                    int count=1;
                    int x=j;
                    while(s.contains(x+1))
                    {
                        count=count+1;
                        x++;
                    }
                    longest=Math.max(longest,count);
                }
            }
            return longest;
    }
}



Time Complexity : O(3n)
Space Complexity : O(n)
  

  
