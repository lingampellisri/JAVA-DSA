/*
Problem statement
You are given an array ‘ARR’ containing ‘N’ integers.



Return all the unique triplets [ARR[i], ARR[j], ARR[k]] such that i != j, j != k and k != i and their sum is equal to zero.



Example:
Input: ‘N’ = 5 
'ARR' =  [-1, -1, 2, 0, 1] 

Output: 
-1 -1 2
-1 0 1

Explanation:
(-1 -1 +2) = (-1 +0 +1) = 0.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5 
-1 -1 2 0 1
Sample Output 1 :
-1 -1 2
-1 0 1
Explanation Of Sample Input 1:
(-1 -1 +2) = (-1 +0 +1) = 0.
Sample Input 2:
4 
0 0 0 0
Sample Output 2 :
0 0 0
Constraints:
1  <= N <= 1000
1 <= ARR[i] <= 1000
Time Limit: 1 sec
*/

***************************************************************************Brute force solution***********************************************************************
  class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

  
   
     int n=nums.length;
     Set<List<Integer>> s=new HashSet<>();
     
    
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                          ArrayList<Integer>ar=new ArrayList<>();
                          ar.add(nums[i]);
                          ar.add(nums[j]);
                          ar.add(nums[k]);
                          Collections.sort(ar);
                          s.add(ar);

                }
            }
        }
    }

  List<List<Integer>> res=new ArrayList<>(s);
        return res;

    }
}


Time complexity :O(n^3)
Space Complexity :O(n)


***************************************************************************Better solution***********************************************************************
  class Solution {
    public List<List<Integer>> threeSum(int[] nums) {


     int n=nums.length;
     
     Set<List<Integer>> s=new HashSet<>();
    
    for(int i=0;i<n;i++)
    {
         Set<Integer> s2=new HashSet<>();
        for(int j=i+1;j<n;j++)
        {
             int k=-(nums[i]+nums[j]);
             if(s2.contains(k))
             {
                List<Integer>l=new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                l.add(k);
            Collections.sort(l);
            s.add(l);
             }
             s2.add(nums[j]);
            
        }
    }

  List<List<Integer>> res=new ArrayList<>(s);
        return res;

    }
}

Time complexity :O(n^2)
Space Complexity :O(n)



  ***************************************************************************Optimal solution***********************************************************************
  
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();

        Arrays.sort(nums);
        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            
            int j=i+1;
            int k=n-1;

            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }

            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0)
                {
                    j++;
                }
                else if(sum>0)
                {
                    k--;
                }
                else
                {
                    List<Integer>ls=new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    res.add(ls);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])
                    {
                        j++;
                    }
                    while(j<k && nums[k]==nums[k+1])
                    {
                        k--;
                    }
                }
            }
        }

        return res;
        
        
    }
}
