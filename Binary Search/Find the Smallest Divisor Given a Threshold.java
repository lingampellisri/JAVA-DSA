/*
1283. Find the Smallest Divisor Given a Threshold
Attempted
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

 

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
 

Constraints:

1 <= nums.length <= 5 * 104
1 <= nums[i] <= 106
nums.length <= threshold <= 106
*/
*********************************Better Solution**************************
  class Solution {

    public static int divisor(int arr[], int value) {
        int count = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            // Correct the division to use floating-point for accurate ceil calculation
            count = count + (int) Math.ceil((double) arr[i] / value);
        }
        return count;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int min = 1
        int max = Integer.MIN_VALUE;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
          
            max = Math.max(nums[i], max);
        }
        // System.out.println(min);
        // System.out.println(max);

        for (int i =1; i <= max; i++) {
            int rvalue = divisor(nums, i);
            if (rvalue <= threshold) {
                System.out.println(rvalue);
                return i;
            }
        }
        return -1;
    }
}


 Time complexity  : O(n*max)  ->Time limit Exceeded
Space Complexity :O(1)


  *********************************Optimal Solution**************************


   
   class Solution {

    public static int divisor(int arr[], int value) {
        int count = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {

            count = count + (int) Math.ceil((double) arr[i] / value);
        }
        return count;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int min = 1;
        int max = Integer.MIN_VALUE;
        int size = nums.length;
        int ans=-1;
         for (int i = 0; i < size; i++) {
          
            max = Math.max(nums[i], max);
        }

        int left=1;
        int right=max;
        while(left<=right)
        {
          
            int mid=(left+right)/2;
            int rvalue=divisor(nums,mid);
            if(rvalue<=threshold)
            {
                    ans=mid;
                    right=mid-1;
                    
                
            }
            else
            {
                left=mid+1;
            }

        }
        return ans;
    }
}


   
 Time complexity  : O(n*log(n))
Space Complexity :O(1)
