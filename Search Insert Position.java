/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
*/

class Solution {
    public int searchInsert(int[] nums, int target) {

        int n=nums.length;
        if(target>nums[n-1])
        {
            return n;
        }
        for(int i=0;i<n;i++)
        {
            if(target==nums[i])
            {
                return i;
            } 
            else if(i<n-1 && target>nums[i]&&target<nums[i+1])
            {
                return i+1;
            }
        }
         
         return 0;
    }
}

Time complexity :O(n)
Space complexity :O(1)

********************************optimal**************************


  class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(target<nums[mid])
            {
                right=mid-1;
                
            }
            else
            {
                left=mid+1;
            }


        }
        return left;
        
    }
}

Time complexity :O(log n)
Space Complexity : O(1)
