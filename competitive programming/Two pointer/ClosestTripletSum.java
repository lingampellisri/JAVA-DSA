/*
You are given three sorted integer arrays A[], B[], and C[], and an integer target.

Your task is to find one element from each array (A[i], B[j], and C[k]) such that the sum of these three elements is equal to target.

If there is no exact match, return the triplet with the minimum absolute difference to the target.

Input Format:
-------------
Line 1: An integer N, the size of the first array.
Line 2: N space-separated integers representing elements of array A.
Line 3: An integer M, the size of the second array.
Line 4: M space-separated integers representing elements of array B.
Line 5: An integer P, the size of the third array.
Line 6: P space-separated integers representing elements of array C.
Line 7: An integer target, the required sum.

Output Format:
--------------
Line-1: Print the triplet (A[i], B[j], C[k]) that either matches the target or has the closest sum to the target.

Constraints:
------------
Time Complexity: O(N + M + P)
Space Complexity: O(1)

Sample Input-1:
---------------
4
5 10 20 30
4
1 3 7 10
4
2 5 8 12
25

Sample Output-1:
----------------
10 3 12

Explanation:
-------------
The sum 10 + 7 + 8 = 25, which exactly matches target.


Sample Input-2:
---------------
3
1 5 10
3
3 6 9
3
4 7 8
30

Sample Output-2:
----------------
10 9 8

Explanation:
------------
The sum 10 + 9 + 8 = 27, which is the closest sum to 30 (minimum absolute difference |30 - 27| = 3).
*/


---------------------Brute force----------------------------------

import java.util.*;

class ClosestTripletSum
{
    
    public static void closestTriplet(int arr1[],int arr2[],int arr3[],int target)
    {
        int min=Integer.MAX_VALUE;
        int l1=0,l2=0,l3=0;
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2.length;j++)
            {
                for(int k=0;k<arr3.length;k++)
                {
                    if((arr1[i]+arr2[j]+arr3[k])==target)
                    {
                        System.out.println(arr1[i]+" "+arr2[j]+" "+arr3[k]);
                        return ;
                    }
                    else
                    {
                        int diff=Math.abs(target-(arr1[i]+arr2[j]+arr3[k]));
                        if(diff<min)
                        {
                            min=diff;
                        l1=arr1[i];
                        l2=arr2[j];
                        l3=arr3[k];
                        }
                    }
                }
            }
        }
        System.out.println(l1+" "+l2+" "+l3);
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        
        for(int i=0;i<n1;i++)
        {
            arr1[i]=sc.nextInt();
        }
        
        int n2=sc.nextInt();
        int arr2[]=new int[n2];
        for(int j=0;j<n2;j++)
        {
            arr2[j]=sc.nextInt();
        }
        int n3=sc.nextInt();
        int arr3[]=new int[n3];
        for(int k=0;k<n3;k++)
        {
            arr3[k]=sc.nextInt();
        }
        int target=sc.nextInt();
        
       closestTriplet(arr1,arr2,arr3,target);
        sc.close();
        
        
    }
}



-------------------------------optimal solution-----------------------------------

  import java.util.*;

class ClosestTripletSum
{
    
    public static void closestTriplet(int arr1[],int arr2[],int arr3[],int target)
    {
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        int min=Integer.MAX_VALUE;
        int l1=0,l2=0,l3=0;
 
        for(int i=0;i<arr1.length;i++)
        {
           int left=0;
           int right=arr3.length-1;
           
           while(left<arr2.length &&right>=0)
           {
               int sum=arr1[i]+arr2[left]+arr3[right];
               int diff=Math.abs(target-sum);
               if(target==sum)
               {
                   System.out.println(arr1[i]+" "+arr2[left]+" "+arr3[right]);
                   return;
               }
               if(diff<min)
               {
                   min=diff;
                   l1=arr1[i];
                   l2=arr2[left];
                   l3=arr3[right];
               }
               if(sum<target)
               {
                   left++;
               }
               else
               {
                   right--;
               }
           }
        }
        System.out.println(l1+" "+l2+" "+l3);
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        
        for(int i=0;i<n1;i++)
        {
            arr1[i]=sc.nextInt();
        }
        
        int n2=sc.nextInt();
        int arr2[]=new int[n2];
        for(int j=0;j<n2;j++)
        {
            arr2[j]=sc.nextInt();
        }
        int n3=sc.nextInt();
        int arr3[]=new int[n3];
        for(int k=0;k<n3;k++)
        {
            arr3[k]=sc.nextInt();
        }
        int target=sc.nextInt();
        
       closestTriplet(arr1,arr2,arr3,target);
        sc.close();
        
        
    }
}
