/*
Problem statement
You are given an integer array 'arr' of size 'N' and an integer 'K'.

Your task is to find the total number of subarrays of the given array whose sum of elements is equal to k.

A subarray is defined as a contiguous block of elements in the array.

Example:
Input: ‘N’ = 4, ‘arr’ = [3, 1, 2, 4], 'K' = 6

Output: 2

Explanation: The subarrays that sum up to '6' are: [3, 1, 2], and [2, 4].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2
4 6
3 1 2 4

3 3
1 2 3
Sample output 1:
2
2
Explanation:
Test Case 1:

Input: ‘N’ = 4, ‘arr’ = [3, 1, 2, 4], 'K' = 6

Output: 2

Explanation: The subarrays that sum up to '6' are: [3, 1, 2], and [2, 4].

Test Case 2:

Input: ‘N’ = 3, ‘arr’ = [1, 2, 3], 'K' = 3

Output: 2

Explanation: The subarrays that sum up to '7' are: [1, 2], and [3].
Sample Input 2:
2
3 7
1 2 3

4 9
6 3 5 2
Sample output 2:
0
1
*/


***************************************************************************Better solution*****************************************************************


  import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // Write your code here.    

            int count=0;
            for(int i=0;i<arr.length;i++)
            {
                int sum=0;
                for(int j=i;j<arr.length;j++)
                {
                        sum=sum+arr[j];

                        if(sum==s)
                        {
                            count=count+1;
                        }
                }
            }
            return count;


    }
}


Time Complexity : O(n^2)
Space Complexity : O(1)
***************************************************************************Optimal solution*****************************************************************

  import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // Write your code here.    

            int count=0;
            Map<Integer,Integer>hm=new HashMap<>();
            hm.put(0,1);
            int presum=0;
            for(int i=0;i<arr.length;i++)
            {
                presum=presum+arr[i];
                
                int remove=presum-s;

                count=count+hm.getOrDefault(remove, 0);
                hm.put(presum,hm.getOrDefault(presum,0)+1);
               

            }
            return count;


    }
}


Time Complexity : O(n)
Space Complexity : O(n)
