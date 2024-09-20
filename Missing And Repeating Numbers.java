/*

Problem statement
You are given an array of ‘N’ integers where each integer value is between ‘1’ and ‘N’. Each integer appears exactly once except for ‘P’, which appears exactly twice, and ‘Q’, which is missing.



Your task is to find ‘P’ and ‘Q’ and return them respectively.



Detailed explanation ( Input/output format, Notes, Images )
Constraints:
2 <= N <= 5 * 10^4
1 <= data <= N

Where ‘N’ is the size of the array and ‘data’ denotes the value of the elements of the array. 
Sample Input 1:
4
1 2 3 2
Sample Output 1:
2 4
Explanation Of Sample Input 1:
Input: ‘N’ = 4
‘A’ = [1, 2, 3, 2]
Output: {2, 4} - The integer appearing twice is ‘2’, and the integer missing is ‘4’.
Sample Input 2:
3
1 2 1
Sample Output 2:
1 3

*/



import java.util.*;
public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {
        // Write your code here
        int n=a.length;
        int sum=(n*(n+1))/2;
        for(int i=0;i<n;i++)
        {
            sum=sum-a[i];
        }

        Arrays.sort(a);
        int temp=0;
        

            int count=1;
        for(int j=1;j<n;j++)
        {
            if(a[j-1]==a[j])
                {
                    count=2;
                }
                if(count==2)
                {
                   temp=a[j]; 
                   break;
                }
        }

int arr[]=new int[2];
arr[0]=temp;
arr[1]=(sum+temp);


        return arr;





    }
}

Time complexity : O(nlogn);
space Complexity : O(1)
