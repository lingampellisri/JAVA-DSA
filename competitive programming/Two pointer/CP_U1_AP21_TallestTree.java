/*
In a forest, There are N redwoord trees in a row.
You are given the heights of the trees as heights[],

You are task is to find the longest tree arrangement as follows:
	- Minimum size of the tree arrangement is 3.
	- And there exist a Tree-'i' with heights[i], where 0 < i < N-1.
		- heights[0] < heights[1] < heights[2] <...< heights[i] and
		-  heights[i] > heights[i+1] > heights[i+2] >...>heights[N-1] 

And return the length of the longest tree arrangement.
If there is no such arrangement, return 0.

Input Format:
-------------
Line-1: An integer N, number of elements.
Line-2: N space separated integers, value of the elements.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
8
4 2 5 7 4 2 3 6

Sample Output-1:
----------------
5

Explanation:
------------
The longest tree arrangement is : 2 5 7 4 2


Sample Input-2:
---------------
4
2 4 5 7

Sample Output-2:
----------------
0
*/

import java.util.*;
class TallestTree
{
    
    public static int tallTree(int height[])
    {
        int n=height.length;
        if(n<3)
        {
            return 0;
        }
        int maxlen=0;
        for(int i=1;i<n-1;i++)
        {
            if(height[i-1]<height[i] && height[i]>height[i+1])
            {
                int left=i;
                int right=i;
                
                while(left>0 && height[left-1]<height[left])
                {
                    left--;
                }
                while(right<n-1 && height[right]>height[right+1])
                {
                    right++;
                }
            
            int len=right-left+1;
            maxlen=Math.max(maxlen,len);
            }
        }
        return maxlen;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        
        System.out.println(tallTree(arr));
    }
}
