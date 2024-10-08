package Arrays;
import java.util.Scanner;
import java.util.*;
public class Recursion {
	
	public static int subSequencesSUM(int idx,ArrayList<Integer>arr,int s,int sum,int size,int nums[])
	{
		if(idx==size)
		{
			if(s==sum)
			{
		
			return 1;
			}
			else
			return 0;
			
		}
		
		
		arr.add(nums[idx]);
		s=s+nums[idx];
		int left=subSequencesSUM(idx+1,arr,s,sum,size,nums);
		s=s-nums[idx];
		arr.remove(arr.size()-1);
		int right=subSequencesSUM(idx+1,arr,s,sum,size,nums);
		
		return left+right;
		
		
	}
	

	public static void main(String[] args) {
		int arr[]= {1,2,1};
		ArrayList<Integer>ls=new ArrayList<>();
		int sum=2;
		int s=0;
		System.out.println(subSequencesSUM(0,ls,s,sum,arr.length,arr));
	
	

}
}
