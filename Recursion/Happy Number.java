/*
Given a number N find whether its a happy number or not. 
A number is called happy if it leads to 1 after a sequence of steps wherein each step, the number is replaced by the sum of squares of its digit that is if we start with Happy Number and keep replacing it with digits square sum, we reach 1.

Example 1:

Input: 
N = 19
Output: 
1
Explanation:
19 is a Happy Number,
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
As we reached to 1, 
19 is a Happy Number.
Example 2:

Input:
N = 20
Output: 
0
Explanation: 
We can never reach to 1
by repeating the mentioned
steps.

Your Task:
You don't need to read input or print anything. Your task is to complete the function isHappy() which takes an integer N as input parameter and returns 1 if N is a happy number or 0 otherwise.
 

Expected Time Complexity: O(sqrt(N))
Expected Space Complexity: O(1)
 

Constraints:
1 <= N <= 104

*/



//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isHappy(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
    public static int sumofDigits(int num)
    {
        int sum=0;
        while(num>0)
        {
            sum+=Math.pow(num%10,2);
            num=num/10;
        }
        return sum;
    }
  
     static int isHappy(int N) { 
         //code here
         if(N==1)
         {
             return 1;
         }
         else if(N==4)
         {
             return 0;
         }
        return isHappy(sumofDigits(N));
         
     }
}
