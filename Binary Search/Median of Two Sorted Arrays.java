/*
4. Median of Two Sorted Arrays
Solved
Hard
Topics
Companies
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int low=0;
        int high=nums1.length+nums2.length;
       int left=0;
       int right=0;
       int arr[]=new int[high];
       while(left<nums1.length && right<nums2.length)
       {
        if( nums1[left]<nums2[right])
        {
            arr[low]=nums1[left];
            left++;
            low++;
        }
        else
        {
            arr[low]=nums2[right];
            right++;
            low++;
        }
       }
       while(left<nums1.length)
       {
        arr[low]=nums1[left];
        low++;
        left++;
       }
       while(right<nums2.length)
       {
        arr[low]=nums2[right];
        low++;
        right++;
       }

       if(high%2==0)
       {
        int mid=high/2;
        double median=arr[mid-1]+arr[mid];
        return  median/2.0;
       }
     
        return (double) arr[high/2];
       

    }
}

******************************Optimal solution***********************************
