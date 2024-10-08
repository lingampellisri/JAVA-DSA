public class Solution {
	public static void merge(int arr[],int low,int mid,int high)
	{
		int left=low;
		int right=mid+1;
		int temp[]=new int[high-low+1];
		int idx=0;
		while(left<=mid && right<=high)
		{
			if(arr[left]<=arr[right])
			{
				temp[idx++]=arr[left++];
				
			}
			else
			{
				
				temp[idx++]=arr[right++];
			}
		}

		while(left<=mid)
		{
			temp[idx++]=arr[left++];
		}
		while(right<=high)
		{
			temp[idx++]=arr[right++];
		}

		for(int i=0;i<temp.length;i++)
		{
		arr[low+i]=temp[i];
		}
	}
	public static void mergeSort(int arr[],int left,int right)
	{
		if(left<right){
		int mid=(left+right)/2;
		mergeSort(arr,left,mid);
		mergeSort(arr,mid+1,right);
		merge(arr,left,mid,right);

		}

	}


	public static void mergeSort(int[] arr, int n) {
		// Write your code here.
		mergeSort(arr,0,n-1);
	}
}
