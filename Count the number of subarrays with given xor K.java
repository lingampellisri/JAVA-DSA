/*

Problem statement
Given an array ‘A’ consisting of ‘N’ integers and an integer ‘B’, find the number of subarrays of array ‘A’ whose bitwise XOR( ⊕ ) of all elements is equal to ‘B’.



A subarray of an array is obtained by removing some(zero or more) elements from the front and back of the array.



Example:
Input: ‘N’ = 4 ‘B’ = 2
‘A’ = [1, 2, 3, 2]

Output: 3

Explanation: Subarrays have bitwise xor equal to ‘2’ are: [1, 2, 3, 2], [2], [2].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4 2
1 2 3 2
Sample Output 1 :
3
Explanation Of Sample Input 1:
Input: ‘N’ = 4 ‘B’ = 2
‘A’ = [1, 2, 3, 2]

Output: 3

Explanation: Subarrays have bitwise xor equal to ‘2’ are: [1, 2, 3, 2], [2], [2].
Sample Input 2:
4 3
1 2 3 3
Sample Output 2:
4
Sample Input 3:
5 6
1 3 3 3 5 
Sample Output 3:
2
Constraints:
1 <= N <= 10^3
1 <= A[i], B <= 10^9

Time Limit: 1-sec

*/
************************************************************Brute Force Solution*******************************************

  public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        int size=a.length;
        int count=0;

        for(int i=0;i<size;i++)
        {
            for(int j=i;j<size;j++)
            {
                int xor=0;
                for(int k=i;k<=j;k++)
                {
                    xor=xor^a[k];
                   
                }
                 if(xor==b)
                    count=count+1;
            }
        }
        return count;

    }
}

Time complexity : O(n^3)
Space Complexity : O(1)


*********************************************************Better solution***********************************************
  public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        int size=a.length;
        int count=0;

        for(int i=0;i<size;i++)
        {
            int xor=0;
            for(int j=i;j<size;j++)
            {
               
                xor=xor^a[j];
                 if(xor==b)
                    count=count+1;
            }
        }
        return count;

    }
}


Time complexity : O(n^2)
Space Complexity : O(1)


*********************************************************Optimal solution***********************************************
  import java.util.*;
public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
   
 int size=a.length;
    int count=0;
    Map<Integer,Integer>hm=new HashMap<>();
    hm.put(0,1);
    int xor=0;
    for(int i=0;i<size;i++)
    {
        xor=xor^a[i];
        int x=xor^b;
        if(hm.containsKey(x))
        count=count+hm.get(x);
        
        hm.put(xor,hm.getOrDefault(xor, 0)+1);
    }
    return count;
    }
}


Time complexity : O(n)
Space Complexity : O(n)

