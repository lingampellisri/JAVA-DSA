/*
875. Koko Eating Bananas
Attempted
Medium
Topics
Companies
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
*/

***************************************Brute force *******************************
  class Solution {

    public static int eatingRate(int piles[],int r)
    {
        int rate=0;

        for(int i=0;i<piles.length;i++){
        rate=rate+(int)Math.ceil((double)(piles[i])/(double)(r));
        }
        return rate;
    }


    public int minEatingSpeed(int[] piles, int h) {

        int max=Integer.MIN_VALUE;
        int n=piles.length;
        for(int i=0;i<n;i++)
        {
            if(piles[i]>max)
            {
                max=piles[i];
            }
        }
       


        for(int i=1;i<=max;i++)
        {
            int total=0;
            total=eatingRate(piles,i);
                if(total<=h)
                {
                    return i;
                }

        }
        return -1;
        
    }
}


*********************************optimal solution****************************

  class Solution {
    public static int max(int piles[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]>max)
            {
                max=piles[i];
            }


        }
        return max;
    }

    public static long eatingrate(int piles[],int rate)
    {
        long minhours=0;
        for(int i=0;i<piles.length;i++)
        {
            minhours=minhours+(long)Math.ceil((double)(piles[i])/(double)(rate));

        }
        return minhours;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int left=1;
        int right=max(piles);
        int ans=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            long totalRate=eatingrate(piles,mid);
            if(totalRate<=h)
            {
                ans=mid;
                right=mid-1;

            }
            else {
                left=mid+1;
            }
        }
        return ans;

        
    }
}
  
