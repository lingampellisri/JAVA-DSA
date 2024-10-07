package Arrays;
import java.util.Scanner;
public class Recursion {
	public static void reverse(int arr[],int left,int right)
	{
		if(left<right)
		{
	int temp=arr[left];
	arr[left]=arr[right];
	arr[right]=temp;
	left++;
	right--;
	reverse(arr,left,right);
	
		}
		else
			return ;
		
	}

	public static void main(String[] args) {
	
	System.out.print("Enter the n value : ");
	Scanner sc=new Scanner(System.in);
//	int n=sc.nextInt();
	int arr[]= {1,2,3,4,5,6,7,8,9};
	reverse(arr,0,arr.length-1);
	
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]+",");
	}

	}

}
