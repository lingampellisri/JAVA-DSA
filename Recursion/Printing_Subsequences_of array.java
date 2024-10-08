package Arrays;
import java.util.Scanner;
import java.util.*;
public class Recursion {
	
	public static void subSequences(int idx,ArrayList<Integer>arr,int size,int nums[])
	{
		if(idx==size)
		{
			if(arr.size()==0)
			{
				System.out.println("{}");
			}
		
			for(int i:arr)
			{
				System.out.print(i+" ");
			}
			System.out.println();
			
			return ;
		}
		
		arr.add(nums[idx]);
		subSequences(idx+1,arr,size,nums);
		arr.remove(arr.size()-1);
		subSequences(idx+1,arr,size,nums);
		
	}
	

	public static void main(String[] args) {
		int arr[]= {3,1,2};
		ArrayList<Integer>ls=new ArrayList<>();
		subSequences(0,ls,arr.length,arr);
	
	

}
}
