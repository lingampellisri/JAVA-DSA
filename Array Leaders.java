/*
Problem statement
There is an integer array ‘a’ of size ‘n’.



An element is called a Superior Element if it is greater than all the elements present to its right.



You must return an array all Superior Elements in the array ‘a’.



Note:

The last element of the array is always a Superior Element. 


Example

Input: a = [1, 2, 3, 2], n = 4

Output: 2 3

Explanation: 
a[ 2 ] = 3 is greater than a[ 3 ]. Hence it is a Superior Element. 
a[ 3 ] = 2 is the last element. Hence it is a Superior Element.
The final answer is in sorted order.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4 
1 2 2 1


Sample Output 1:
1 2


Explanation of Sample Input 1:
Element present at the last index is '1' and is a superior element since there are no integers to the right of it.
Element present at index 2 (0-indexed) is '2' and is greater than all the elements to the right of it.
There are no other superior elements present in the array.
Hence the final answer is [1,2].


Sample Input 2:
3
5 4 3


Sample Output 2:
3 4 5 


Expected Time Complexity:
Try to solve this in O(n).


Constraints:
1 <= n <=10^5 
1 <= a[i] <= 10^9
Time Limit: 1 sec
*/


*********************************************************************Brute force solution*************************************************************************

import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        int size=a.length;
        
        ArrayList<Integer>ar=new ArrayList<>();
        ar.add(a[size-1]);
        for(int i=0;i<size-1;i++)
        {
            int flag=0;
            for(int j=i+1;j<size;j++)
            {
                if((a[i]>a[j]))
                {
                  
                }
                else
                {
                    flag=1;
                    break;
                }
               
            }
            if(flag==0)
            {
                ar.add(a[i]);

            }
        }
            Collections.sort(ar);
        return ar;
     
    }
}


Time complexity : O(n^2)+nlogn
Space complexity : O(n)



********************************************************************Optimal solution*************************************************************************

 import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        int size=a.length;
        int max=a[size-1];
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(max);
        for(int i=size-2;i>=0;i--)
        {
            if(a[i]>max)
            {
                arr.add(a[i]);
                max=a[i];
            }
        }
        return arr;
    }
}



Time complexity : O(n)
Space complexity : O(n)
