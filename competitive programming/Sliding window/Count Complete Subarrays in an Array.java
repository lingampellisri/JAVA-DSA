/**

2799. Count Complete Subarrays in an Array
Solved
Medium
Topics
Companies
Hint
You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.

 

Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
Example 2:

Input: nums = [5,5,5,5]
Output: 10
Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2000

*/

----------------------------brute force solution-----------------------------


  class Solution {
    public int countCompleteSubarrays(int[] nums) {
            int n=nums.length;

            HashSet<Integer>hs=new HashSet<>();

            for(int i=0;i<n;i++)
            {
                hs.add(nums[i]);
            }
            int count=0;

            HashSet<Integer> set=new HashSet<>();

            for(int i=0;i<n;i++)
            {
                set.clear();

                for(int j=i;j<n;j++)
                {
                     set.add(nums[j]);
                    if(set.size()>=hs.size())
                    {
                        // System.out.println(set+","+i+","+j);
                        count++;
                    }
                   
                }
            }

            return count;
        
    }
}

---------------------------optimal solution----------------------------

class Solution {
    public int countCompleteSubarrays(int[] nums) {
            int n=nums.length;

            HashSet<Integer>hs=new HashSet<>();

            for(int i=0;i<n;i++)
            {
                hs.add(nums[i]);
            }
           
           int count=0;
        int right=0;
        int left=0;
        HashMap<Integer,Integer>hm=new HashMap<>();

        while(right<n)
        {
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);

            while(hm.size()==hs.size())
            {
                 count+=n-right;
                hm.put(nums[left],hm.get(nums[left])-1);
                if(hm.get(nums[left])==0)
                {
                   
                    hm.remove(nums[left]);
            
                }
                  left++;
            }
            right++;
        }

        return count;
        
    }
}
