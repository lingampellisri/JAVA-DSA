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
	
		@SuppressWarnings("unchecked")
		ArrayList<Integer> newArr=ts.twoSum(arr,target);
		System.out.println(newArr);
		
		
		}

	

}
