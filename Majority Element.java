/*
Problem statement
You are given an array 'a' of 'n' integers.

A majority element in the array ‘a’ is an element that appears more than 'n' / 2 times.

Find the majority element of the array.


It is guaranteed that the array 'a' always has a majority element.

Example:
Input: ‘n’ = 9, ‘a’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]

Output: 1

Explanation: The frequency of ‘1’ is 5, which is greater than 9 / 2.
Hence ‘1’ is the majority element.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
9
2 2 1 3 1 1 3 1 1


Sample Output 1:
1


Explanation Of Sample Input 1:
Input: ‘n’ = 9, ‘a’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]

Output: 1

Explanation: The frequency of ‘1’ is 5, which is greater than 9 / 2.
Hence ‘1’ is the majority element.


Sample Input 2:
1
4


Sample Output 2:
4


Sample Input 3:
5
-53 75 56 56 56 


Sample Output 3:
56


Expected time complexity :
The expected time complexity is O(n).



Constraints :
1 <= 'n' <= 10000
0 <= 'arr[i]' <= 10^9

Time limit: 1 second
  */

****************************************************************** Brute force solution******************************************************************


  public class Solution {
    public static int majorityElement(int []v) {
    
    for(int i=0;i<v.length;i++)
    {
        int count=0;
        for(int j=0;j<v.length;j++)
        {
            if(v[i]==v[j])
            {
                count++;
            }
        }
         if(count>(v.length/2))

         {
            return v[i];
         }
    }
   
   
    return -1;


    }
}


Time Complexity : O(n^2)
Space Complexity : O(1)


  
****************************************************************** Better solution******************************************************************




  import java.util.*;
public class Solution {
    public static int majorityElement(int []v) {
    
    HashMap<Integer,Integer>hm=new HashMap<>();
    for(int i=0;i<v.length;i++)
    {
        if(hm.containsKey(v[i]))
        {
            hm.put(v[i],(hm.get(v[i])+1));
        }
        else{
            hm.put(v[i],1);
        }
    }
  
Set<Integer>s=hm.keySet();

for(int key:s)
{
    if(hm.get(key)>(v.length/2))
    {
        return key;
    }
}
return -1;

    }
}


Time Complexity : O(n)
Space Complexity : O(n)


  
******************************************************************Optimal solution******************************************************************

  
  class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length/2;
      
Arrays.sort(nums);
int count=0;
if(nums.length==1)
{
    return nums[0];
}

for(int i=1;i<nums.length;i++)
{
    if(nums[i-1]==nums[i])
    {
    count++;
    }
    else
    {
        count=0;
    }
    if((count+1)>n)
    {
        return nums[i];
    }
}
return -1;
        
    }
}


Time Complexity : O(nlogn)
Space Complexity : O(1)

  
