/*
852. Peak Index in a Mountain Array
Solved
Medium
Topics
Companies
You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.

 

Example 1:

Input: arr = [0,1,0]

Output: 1

Example 2:

Input: arr = [0,2,1,0]

Output: 1

Example 3:

Input: arr = [0,10,5,2]

Output: 1

 

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.

*/

*********************************Brute Force****************************
  class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int max=Integer.MIN_VALUE;
        int idx=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
                idx=i;
            }
        }
        return idx;
    }
} 

Time complexity : O(n)
Space complexity : O(1)




*********************************Optimal Solution****************************

  class Solution {
    public int peakIndexInMountainArray(int[] arr) {

    int size=arr.length;

    if(size==1)
    {
        return 0;
    }
    if(arr[0]>arr[1])
    {
        return 0;
    }
    if(arr[size-1]>arr[size-2])
    {
        return size-1;
    }

    int left=1;
    int right=size-2;

    while(left<=right)
    {
        int mid=(left+right)/2;

        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
        {
            return mid;
        }
        else if(arr[mid]>arr[mid-1])
        {
            left=mid+1;;
        }
        else
        {
                right=mid-1;
        }
    }
    return -1;
        
    }
}


Time complexity : O(log n)
Space complexity : O(1)
