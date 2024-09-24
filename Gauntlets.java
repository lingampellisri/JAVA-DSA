/*
Gauntlets 
You have a collection of N gauntlets, each with a specific color represented by A[i]. Your goal is to maximize the number of pairs by repeatedly pairing up gauntlets of the same color. Determine the maximum number of pairs that can be formed.



Input Format

The first line of input contains an integer N. The second line of input contains an array of size N.



Output Format

For the given input, print a single line representing the answer.



Constraints

1 ≤ N ≤ 102

1 ≤ Ai ≤ 103



Example

Input

6

4 1 7 4 1 4



Output

2



Explanation



You can do the operation twice as follows.



Choose two gauntlets with the color 1 and pair them.
Choose two gauntlets with the color 4 and pair them.
Then, you will be left with one sock with the color 4 and another with the color 7, so you can no longer do the operation. There is no way to do the operation three or more times, so you should print 2.
*/
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
    
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]=new int[size];
        Map<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }

        for(int k :arr)
        {
                hm.put(k,hm.getOrDefault(k,0)+1);
        }

        int gun=0;
        for(int v:hm.values())
        {
            gun=gun+v/2;
        }
    System.out.println(gun);

    }
}


Time complexity : O(n)
Space Complexity : O(n)
