/*
152. Maximum Product Subarray
Solved
Medium
Topics
Companies
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
*/


**********************************************************************Brute Force Solution *********************************************************************

  class Solution {
    public int maxProduct(int[] nums) {

        int n=nums.length;
        if(n==1)
        {
            if(nums[0]<0)
            {
                return nums[0];
            }
            else
            {
                return nums[0];
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            int mul=1;
            for(int j=i;j<n;j++)
            {
                   mul=mul*nums[j];
                   max=Math.max(max,mul);
            }
           //  max=Math.max(max,mul);
             
        }
        return max;
        
    }
}


Time Complexity : O(n^3)
Space Complexity : O(1)




  
**********************************************************************Better Solution *********************************************************************



  class Solution {
    public int maxProduct(int[] nums) {

        int n=nums.length;
        if(n==1)
        {
            if(nums[0]<0)
            {
                return nums[0];
            }
            else
            {
                return nums[0];
            }
        }
        int max=Integer.MIN_VALUE;;
        for(int i=0;i<n;i++)
        {
            int mul=1;
            for(int j=i;j<n;j++)
            {
                   mul=mul*nums[j];
                   max=Math.max(max,mul);
            }
          
             
        }
        return max;
        
    }
}




Time Complexity : O(n^2)
Space Complexity : O(1)

  
**********************************************************************Optimal Solution *********************************************************************
  class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int prefix=1;
        int suffix=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(prefix==0)
            prefix=1;
            else if(suffix==0)
            suffix=1;

            prefix=prefix*nums[i];
            suffix=suffix*nums[n-i-1];

            max=Math.max(max,Math.max(suffix,prefix));
        }
        return max;
        
    }
}




Time Complexity : O(n)
Space Complexity : O(1)
