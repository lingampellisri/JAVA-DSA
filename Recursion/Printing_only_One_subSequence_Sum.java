package Arrays;
import java.util.Scanner;
import java.util.*;
public class Recursion {
	
	public static boolean subSequencesSUM(int idx,ArrayList<Integer>arr,int s,int sum,int size,int nums[])
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
			return true ;
			
			}
			
			return false;
			
		}
		
		
		arr.add(nums[idx]);
		s=s+nums[idx];
		if(subSequencesSUM(idx+1,arr,s,sum,size,nums)==true)
			return true;
		s=s-nums[idx];
		arr.remove(arr.size()-1);
		if(subSequencesSUM(idx+1,arr,s,sum,size,nums)==true)
			return true;
		
	return false;
	}
	

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		ArrayList<Integer>ls=new ArrayList<>();
		int sum=5;
		int s=0;
		subSequencesSUM(0,ls,s,sum,arr.length,arr);
	
	

}
}
