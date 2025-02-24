/**

643. Maximum Average Subarray I
Attempted
Easy
Topics
Companies
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 

Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        //  max=Integer.MIN_VALUE;?
        double max=0.0;
        if(nums.length==1)
        return nums[0];
        

        for(int i=0;i<=(nums.length-k);i++)
        {
            double avg=0.0;

            for(int j=i;j<i+k;j++)
            {
                        
                   
                    avg=avg+nums[j];
            }
            max=Math.max((avg/k),max);
            System.out.println(avg);
        }
        return max;
        
    }
}



---------------optimal solution-----------------------------


  /**
Optimized Approach (Sliding Window, O(N))
The brute force approach recalculates the sum for every subarray from scratch. Instead, we can use the Sliding Window technique to update the sum in constant time.

Algorithm Steps:
Compute the initial sum of the first k elements.

This represents the sum of the first window.
Slide the window across the array.

Start a loop from index k to nums.length - 1.
For each step:
Remove the first element of the previous window (nums[i - k]).
Add the new element to the current window (nums[i]).
Update the max sum.
Return the maximum average found.


  */


  class Solution {
    public double findMaxAverage(int[] nums, int k) {

      
        
        if(nums.length==1)
        return nums[0];
        
        double sum=0;

        for(int i=0;i<k;i++)
        {
            sum=sum+nums[i];
        }

       double max=sum;

       for(int right=k;right<nums.length;right++)
       {
        sum=sum-nums[right-k]+nums[right];
        max=Math.max(sum,max);
       }
       return max/k;
    }
}
