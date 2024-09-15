/*
238. Product of Array Except Self
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/

************************************************************************************Brute Force Solution******************************************************************

  class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];

        for(int i=0;i<n;i++)
        {
            int product=1;
            for(int j=0;j<n;j++)
            {
                 if(i!=j){
                    product*=nums[j];
                 }
            }
            ans[i]=product;
        }
        return ans;
        
    }
}


Time complexity : O(n^2)
Space Complexity :O(1)



************************************************************************************Optimal Solution******************************************************************



  class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        int ans[]=new int[n];
        prefix[0]=1;
        suffix[n-1]=1;



        for(int i=1;i<n;i++)
        {
          prefix[i]=prefix[i-1]*nums[i-1];
        }

        for(int j=n-2;j>=0;j--)
        {
            suffix[j]=suffix[j+1]*nums[j+1];
        }
        // System.out.println(prefix);
        for(int k=0;k<n;k++)
        {
            ans[k]=prefix[k]*suffix[k];
        }
        return ans;
        
    }
}


Time complexity : O(n)
Space Complexity :O(n)
