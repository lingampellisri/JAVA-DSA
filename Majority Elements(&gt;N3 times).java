/*
Problem statement
Given an array ‘A’ of ‘N’ integers, find the majority elements of the array.

A majority element in an array ‘A’ of size ‘N’ is an element that appears more than floor(N / 3) times.

Note: The floor function returns the number rounded down to the nearest integer.

Note: Return the array of majority elements in sorted order.

Example:
Input: ‘N’ = 9 ‘A’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]

Output: 1

Explanation: The frequency of ‘1’ is 5, which is greater than floor(N / 3), hence ‘1’ is the majority element.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 1e3
-1e9 <= A[i] <= 1e9

Time Limit: 1-sec
Sample Input 1:
6
1 1 1 2 2 2
Sample Output 1:
1 2
Explanation Of Sample Input 1:
Input: ‘N’ = 6, ‘A’ = [1, 1, 1, 2, 2, 2]

Output: [1, 2]

Explanation: The frequency of ‘1’ and ‘2’ is 3, which is greater than floor(N / 3), hence ‘1’ & ‘2’ are the majority elements.
Sample Input 2:
1
4
Sample Output 2:
4


*/


**********************************************************************Brute force*****************************************************************************
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer>arr=new ArrayList<>();
        int n=nums.length/3;
        int size=nums.length;

        for(int i=0;i<size;i++)
        {
            int count=0;
            for(int j=i;j<size;j++)
            {
                if(nums[i]==nums[j])
                {
                    count=count+1;
                }
            }
            if(count>n && !arr.contains(nums[i]))
            {
                arr.add(nums[i]);
            }

        }
        return arr;

        
    }
}



Time complexity : O(n^2)
Space complexity : O(n)



  **********************************************************************Better Solution*****************************************************************************

  class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length / 3;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);

        }
        // System.out.println(hm);
        Set<Integer>s=hm.keySet();
        for(int k:s)
        {
            if(hm.get(k)>n)
            {
                arr.add(k);
            }
        }
        return arr;

    }
}


Time complexity : O(n)
Space Complexity : O(n)





**********************************************************************Optimal Solution*****************************************************************************


  
