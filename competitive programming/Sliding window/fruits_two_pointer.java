/*
You are visiting a farm that has a single row of fruit trees arranged from left to right.

The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. 

However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. 
There is no limit on the amount of fruit each basket can hold.

Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
while moving to the right. The picked fruits must fit in one of your baskets.

Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Sample Input-1:
---------------
3
1 2 1

Sample Output-1: 
----------------
3

Explanation: We can pick from all 3 trees.

Sample Input-2:
--------------- 
4
0 1 2 2 

Sample Output-2: 
----------------
3

Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

Sample Input-3: 
---------------- 
5
1 2 3 2 2

Sample Output-4: 
----------------
4

Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
*/

// -------------------------------brute force solution------------------------------

import java.util.*;
class Fruit
{
    public static int maxFruits(int arr[])
    {
        int size=arr.length;
        int max=0;
        for(int i=0;i<size;i++)
        {
            HashSet<Integer>set=new HashSet<>();
            int count=0;
            
            for(int j=i;j<size;j++)
            {
                set.add(arr[j]);
                if(set.size()>2)
                {
                    break;
                }
                count++;
                max=Math.max(count,max);
            }
        }
        return max;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(maxFruits(arr));
    }
}



//----------------------------optimal solution---------------------------------


import java.util.*;
class Fruit
{
    public static int maxFruits(int arr[])
    {
        int size=arr.length;
        int max=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        int left=0;
        for(int i=0;i<size;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            
            if(hm.size()>2)
            {
                hm.put(arr[left],hm.get(arr[left])-1);
                if(hm.get(arr[left])==0)
                {
                    hm.remove(arr[left]);
                    
                }
                left++;
            
            }
            max=Math.max(max,i-left+1);
            
            
        }
       return max;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(maxFruits(arr));
    }
}
