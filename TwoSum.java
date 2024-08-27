/*
1. Two Sum

Easy

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists


*/

//************************************* Brute force solution ( ScrollDown for Better and opitmal solutions********************************************************

package Arrays;
import java.util.*;

public class TwoSum {
	
	
	public ArrayList twoSum(int a[],int sum)
	{
		ArrayList<Integer>arr=new ArrayList<>();
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(i==j)
					continue;
				else if(a[i]+a[j]==sum)
				{
					arr.add(i);
					arr.add(j);
					return arr;
				
				}
			}
		}
		return arr;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {8,6,5,8,11,2};
		int target=8;
		TwoSum ts=new TwoSum();
	
		
		ArrayList<Integer> newArr=ts.twoSum(arr,target);
		System.out.println(newArr);
		
		
		}

	

}


// Time complexity : O(n^2)
// Space complexity : O(1)
NOTE :  For above solution try by updating the j pointer as j=i+1; so j looks forward from i pointer 
	

// ***********************************************************Better solution ******************************************************************
							      Hashing Technique 
	


package Arrays;
import java.util.*;

public class TwoSum {
	
	public static int[] better_TwoSum(int arr[],int sum)
	{
		int data[]=new int[2];
		HashMap<Integer,Integer>hm=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			if(hm.containsKey(sum-arr[i]))
			{
				data[0]=i;
				data[1]=hm.get(sum-arr[i]);
				System.out.println("Yes");
				break;
			
			}
			else
			{
				hm.put(arr[i],i);
			}
		}
		return data;
	}

	public static void main(String[] args) {
		int arr[]= {8,6,5,8,11,4};
		int target=15;
		TwoSum ts=new TwoSum();
		
	int a[]= ts.better_TwoSum(arr, target);
	System.out.println(a[0]+","+a[1]);
		
		}

	

}


// Time complexity : O(n)
// Space complexity : O(n)

// Hashing Uses the Additional space for storing the previous Covered Data



// *********************************************************** Optimal solution *************************************************************** 

							      Two Pointer Approach

								      
// It will print "Yes" if the Two Sum present in the array if not Then it prints "No" -----> Hasing is best and optimal for returning TwoSum indexes

package Arrays;
import java.util.*;

public class TwoSum {
	
	public static String optimalTwoSum(int arr[],int sum)
	{
		
		Arrays.sort(arr);
		int left=0;
		int right=arr.length-1;
		
		while(left<right)
		{
			if(arr[left]+arr[right]==sum)
			{
				return "Yes";
				
			}
			else if(arr[left]+arr[right]>sum)
			{
				right--;
			}
			else
			{
				left++;
			}
		}
		
			return "No";
	}

	public static void main(String[] args) {
		
		int arr[]= {8,6,5,8,11,4};
		int target=5;
		TwoSum ts=new TwoSum();
		
	String result= ts.optimalTwoSum(arr, target);
	System.out.println(result);
	
		
		}

	

}

	
// Time complexity : O(n)+O(nlogn)  ->O(nlogn) for Sorting the Array
// Space complexity : O(n)


	




