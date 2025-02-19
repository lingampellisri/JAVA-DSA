/*
You are given a positive integer n. 
Your task is to determine the longest distance between any two adjacent 1s in its binary representation.

Definitions:
Two 1s are considered adjacent if there are only 0’s separating them (possibly no 0’s).
The distance between two adjacent 1’s is the absolute difference between their bit positions.
If there are no two adjacent 1's, return 0.

For example, the two 1's in "1001" have a distance of 3.

Input Format:
-------------
Line-1: An integer number

Output Format:
--------------
Line-1: An integer number

Sample Input-1:
---------------
22

Sample Output-1:
----------------
2

Explanation:
------------
Binary representation of 22 is "10110".
Adjacent 1s appear at positions: (1,3) and (3,4)
Distances: 3 - 1 = 2, 4 - 3 = 1
Maximum distance is 2.

Sample Input-2:
---------------
8

Sample Output-2: 
----------------
0

Explanation:
-------------
Binary representation of 8 is "1000".
There is only one 1, so no adjacent pairs exist.
Output is 0.
*/

-------------------------------brute force-----------------------


import java.util.*;
class BinaryGap{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        String str=Integer.toBinaryString(n);
        
        int left=0;
        int mid=0;
        int max=0;
        
        // while(mid<str.length())
        // {
        //     // if(str.charAt(mid)=='1'){
        //     // left=mid;
        //     // mid++
        //     // }
            
        //      if(str.charAt(left)=='1' && str.charAt(mid)=='1')
        //      {
        //          max=Math.max(((mid+1)-(left+1)),max);
        //          mid++;
        //          left++;
        //      }
        //      else if(str.charAt(mid)=='1')
        //      {
        //          left=mid;
        //          mid++;
        //      }
            
        // }
        // System.out.print(max);
        
        
        for(int  i=0;i<str.length();i++)
        {
            for(int j=i+1;j<str.length();j++)
            {
                if(str.charAt(i)=='1' && str.charAt(j)=='1'){
                max=Math.max(max,j-i);
                break;
                }
                
                
            }
        }
        
        System.out.println(max);
    }
}


------------------------optimal solution-------------------------
    import java.util.*;
class BinaryGap{
    
    public static int bGap(String str)
    {
        int max=0;
        int prev=-1;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='1')
            {
                if(prev!=-1 )
                {
                    max=Math.max(max,i-prev);
                }
                prev=i;
            }
         

        }
        return max;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
    
        
        String str=Integer.toBinaryString(n);
        
      
        
        System.out.println(bGap(str));
    }
}
