/*
34. Find First and Last Position of Element in Sorted Array
Solved
Medium
Topics
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int arr[]=new int[2];
        int idx=0;
        arr[0]=-1;
        arr[1]=-1;

        for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
            {
                    arr[idx]=i;
                    idx++;
                    break;
            }
        }

        for(int j=n-1;j>=0;j--)
        {
            if(nums[j]==target)
            {
                arr[idx]=j;
                break;
            }
        }
        return arr;
    }
}

Time Complexity : O(n)
Space complexity : O(1)


  **********************************************************optimal Solution*********************************************
  class Solution {

    public static int lower(int arr[],int target)
    {
        int n=arr.length;
        int left=0;
        int right=n-1;
        int first=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(arr[mid]==target)
            {
                right=mid-1;
                first=mid;
            }
            else if(arr[mid]>target)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return first;
    }

    public static int upper(int arr[],int target)
    {
        int n=arr.length;
        int left=0;
        int right=n-1;
        int secound=-1;

       
            while(left<=right)
        {
            int mid=(left+right)/2;
            if(arr[mid]==target)
            {
                left=mid+1;
                secound=mid;
            }
            else if(arr[mid]>target)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return secound;
    }

    public int[] searchRange(int[] nums, int target) {

        int arr[]=new int[2];
        arr[0]=lower(nums,target);
        arr[1]=upper(nums,target);
        return arr;
    
    }
}

      Time complexity : O(log n)
      Space complexity : O(1)
