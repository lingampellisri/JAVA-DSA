/*
Problem statement
You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.



You are also given an integer 'k' which denotes the number of aggressive cows.



You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.



Print the maximum possible minimum distance.



Example:
Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}

Output: 2

Explanation: The maximum possible minimum distance will be 2 when 2 cows are placed at positions {1, 3}. Here distance between cows is 2.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 4
0 3 4 7 10 9


Sample Output 1 :
3


Explanation to Sample Input 1 :
The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here distance between cows are 3, 4 and 3 respectively.


Sample Input 2 :
5 2
4 2 1 3 6


Sample Output 2 :
5


Expected time complexity:
Can you solve this in O(n * log(n)) time complexity?


Constraints :
2 <= 'n' <= 10 ^ 5
2 <= 'k' <= n
0 <= 'arr[i]' <= 10 ^ 9
Time Limit: 1 sec.
*/


******************************************Brute Force **********************************
  import java.util.*;
public class Solution {
   public static   boolean cowStalls(int arr[],int dist,int cows)
    {
        int countCows=1;
        int lastCow=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-lastCow>=dist)
            {
                countCows++;
                lastCow=arr[i];
            }
            if(countCows>=cows)
            {
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
    int size=stalls.length;
        Arrays.sort(stalls);
        // int min=-1;
        int limit=stalls[size-1]-stalls[0];

        for(int i=1;i<=limit;i++)
        {
            // System.out.println("Hy");

            if(cowStalls(stalls,i,k)==false)
            {
                return i-1;
            }
           

        }
            //    System.out.println("off");
        return limit;
    }
}



Time complexity :  O((max-min)*n)
Space Complexity : O(1)


  ******************************************Optimal Solution **********************************

  import java.util.*;
public class Solution {
   public static   boolean cowStalls(int arr[],int dist,int cows)
    {
        int countCows=1;
        int lastCow=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-lastCow>=dist)
            {
                countCows++;
                lastCow=arr[i];
            }
            if(countCows>=cows)
            {
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
    int size=stalls.length;
        Arrays.sort(stalls);
        // int min=-1;
        int limit=stalls[size-1]-stalls[0];
    int left=1;
    int ans=-1;
    int right=limit;
    while(left<=right)
    {
        int mid=(left+right)/2;
        if(cowStalls(stalls,mid,k)==true)
        {
            ans=mid;
             left=mid+1;
            
        }
        else{
           right=mid-1;
        }
    }
    return ans;

    }
}


Time complexity : O(log n)
Space Complexity : O(1)
