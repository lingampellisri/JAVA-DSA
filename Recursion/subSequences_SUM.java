package Arrays;
import java.util.Scanner;
import java.util.*;
public class Recursion {
	
	public static void subSequencesSUM(int idx,ArrayList<Integer>arr,int s,int sum,int size,int nums[])
	{
		if(idx==size)
		{
			if(s==sum)
			{
		
			for(int i:arr)
			{
				System.out.print(i+" ");
			}
			System.out.println();
			}
			
			return ;
			
		}
		
		
		arr.add(nums[idx]);
		s=s+nums[idx];
		subSequencesSUM(idx+1,arr,s,sum,size,nums);
		s=s-nums[idx];
		arr.remove(arr.size()-1);
		subSequencesSUM(idx+1,arr,s,sum,size,nums);
		
		
	}
	

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		ArrayList<Integer>ls=new ArrayList<>();
		int sum=12;
		int s=0;
		subSequencesSUM(0,ls,s,sum,arr.length,arr);
	
	

}
}
