/*

Left Sum and Right Sum 
Given an array A of size N. Construct an array B, such that B[i] is calculated as follows:

Find leftSum => sum of elements to the left of index i in array A; if none, use 0.
Find rightSum => sum of elements to the right of index i in array A; if none, use 0.
B[i] = | leftSum - rightSum |
Your task is to simply print the B array.



Input Format

The first line of input contains the N - size of the array. The next line contains N integers - the elements of array A.



Output Format

Print the elements of the B array separated by space.



Constraints

1 <= N <= 103

0 <= arr[i] <= 100000



Example

Input

3

6 7 7



Output

14 1 13



Explanation



At index 0:

LeftSum = 0, RightSum = 14

B[0] = | LeftSum - RightSum | = 14.



At index 1:

LeftSum = 6, RightSum = 7

B[1] = | LeftSum - RightSum | = 1.



At index 2:

LeftSum = 13, RightSum = 0

B[2] = | LeftSum - RightSum | = 13.
*/


import java.io.*;
import java.util.*;

public class Main {

        public static int leftSum(int []a,int start)
        {
            int leftsum=0;
            for(int i=0;i<start;i++)
            {
                leftsum=leftsum+a[i];
            }
            return leftsum;
        }


         public static int rightSum(int []a,int start)
        {
            int rightsum=0;
            for(int i=start+1;i<a.length;i++)
            {
                rightsum=rightsum+a[i];
            }
            return rightsum;
        }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */

        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();

        int a[]=new int[size];
        int B[]=new int[size];

        for(int i=0;i<size;i++)
        {
            a[i]=sc.nextInt();
        }

        for(int j=0;j<size;j++){
        int leftsum=leftSum(a,j);
        int rightsum=rightSum(a,j);
        B[j]=Math.abs(leftsum-rightsum);
        }

        for(int k=0;k<size;k++)
        {
            System.out.print(B[k]+" ");
        }



    }
}



Time Complexity : O(n)
Space Complexity : O(n)
