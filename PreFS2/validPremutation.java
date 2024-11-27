/*
Ganesh is working on numbers, He is given a list of integers 1,2,3,...,N 
and the list is indexed from 1 to N.

Now he can shuffle the list in whatever way he want. Shuffled list is said 
to be valid, if one of the following is true for i-th position in the list.
	- The integer at the i-th position is divisible by i.
	- 'i' is divisible by the integer at the i-th position.

Your task is to find out, How many valid shuffles can Ganesh do?

Input Format:
-------------
An integer N, where N<=20.

Output Format:
--------------
Print an integer, number of ways ganesh can shuffle.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
1

Explanation:
------------
The only shuffled list is [1]


Sample Input-2:
---------------
2

Sample Output-2:
----------------
2

Explanation:
------------
The first shuffled list is [1, 2]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second shuffled list is [2, 1]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.


Sample Input-3:
---------------
3

Sample Output-3:
----------------
3

Explanation:
------------
The first shuffled list is [1, 2, 3]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
Integer at the 3rd position (i=3) is 3, and 3 is divisible by i (i=3).

The second shuffled list is [3, 2, 1]:
Integer at the 1st position (i=1) is 3, and 3 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
Integer at the 3rd position (i=3) is 1, and i is divisible by 1 (i=3).

The third shuffled list is [2, 1, 3]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i is divisible by 1 (i=2).
Integer at the 3rd position (i=3) is 3, and 3 is divisible by i (i=3).

*/


import java.util.*;
class Solution{
    
    public static void generatePrem(List<Integer>curr,boolean[]visit,int N,List<List<Integer>> res)
    {
        if(N==curr.size())
        {
            res.add(new ArrayList<>(curr));
            return ;
        }
        
        for(int i=1;i<=N;i++)
        {
            if(!visit[i])
            {
                visit[i]=true;
                curr.add(i);
                generatePrem(curr,visit,N,res);
                curr.remove(curr.size()-1);
                visit[i]=false;
            }
        }
    }
    
    public static boolean validPrem(List<Integer> arr)
    {
        for(int i=0;i<arr.size();i++)
        {
            int number=arr.get(i);
            int position=i+1;
            if(number%position==0 && position%number==0)
            {
                return false;
            }
        }
        return true;
    }
    
    
    public static int countValidPrem(int N)
    {
        List<List<Integer>>res=new ArrayList<>();
        generatePrem(new ArrayList<Integer>(),new boolean [N+1],N,res);
        int validCount=0;
        for(List<Integer>prem:res)
        {
            if(validPrem(prem))
            {
                validCount++;
            }
        }
        return validCount;
    }
    
    public static void main(String args[])
    {
        
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
      System.out.println(countValidPrem(N));
        
    }
}
