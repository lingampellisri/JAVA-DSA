import java.util.* ;
import java.io.*; 
public class Solution {

    public static int partition(List<Integer> arr,int lb,int ub)
    {
        int pivot=arr.get(lb);
        int start=lb;
        int end=ub;

        while(start<end)
        {
            while( start<=ub && arr.get(start)<=pivot)
            {
                start++;
            }
             while(arr.get(end)>pivot)
            {
                end--;
            }

            if(start<end)
            {
                int temp=arr.get(start);
                arr.set(start,arr.get(end));
                arr.set(end,temp);
                
            }

        }
                 int temp=arr.get(lb);
                arr.set(lb,arr.get(end));
                arr.set(end,temp);
                return end;


    }

    public static void quick(List<Integer> arr,int lb,int ub)
    {
        if(lb<ub)
        {
            int loc=partition(arr,lb,ub);
            quick(arr,lb,loc-1);
            quick(arr,loc+1,ub);
        }
    }



    public static List<Integer> quickSort(List<Integer> arr){
        // Write your code here.
        quick(arr,0,arr.size()-1);
        return arr;

    }
}
