/*
Problem statement
You have been given an array/list 'arr' consisting of 'n' elements.



Each element in the array is either 0, 1 or 2.



Sort this array/list in increasing order.



Do not make a new array/list. Make changes in the given array/list.



Example :
Input: 'arr' = [2, 2, 2, 2, 0, 0, 1, 0]

Output: Final 'arr' = [0, 0, 0, 1, 2, 2, 2, 2]

Explanation: The array is sorted in increasing order.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8
2 2 2 2 0 0 1 0


Sample Output 1:
0 0 0 1 2 2 2 2


Explanation of sample input 1 :
The initial array 'arr' is [2, 2, 2, 2, 0, 0, 1, 0].

After sorting the array in increasing order, 'arr' is equal to:
[0, 0, 0, 1, 2, 2, 2, 2]


Sample Input 2:
5
1 1 1 1 1


Sample Output 2:
1 1 1 1 1


Expected time complexity :
The expected time complexity is O(n).


Constraints:
1 <= 'n' <= 10 ^ 4
0 <= 'arr[i]' <= 2

Time limit: 1 second

*/

// ************************************************************************************* Brute Force Solution *********************************************************************************

import java.util.* ;
import java.io.*; 
public class Solution {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        // Write your code here.
        Collections.sort(arr);

    }
}


Time complexity : O(nlogn)
Space complexity :O(n)


  
// ************************************************************************************* Better Solution *********************************************************************************

  import java.util.* ;
import java.io.*; 
public class Solution {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int zero=0;
        int one=0;
        int two=0;
    

     for(int i=0;i<arr.size();i++)
     {
if(arr.get(i)==0)
{
    zero++;
}
else if(arr.get(i)==1)
{
    one++;
}
else if(arr.get(i)==2)
{
    two++;
}

     }
 
for(int i=0;i<zero;i++){
arr.set(i,0);

}
for(int i=zero;i<one+zero;i++){
arr.set(i,1);

}

for(int i=one+zero;i<arr.size();i++){
arr.set(i,2);

}

    }
}



Time complexity : O(2n)
Space complexity :O(1)




  // ************************************************************************************* Optimal Solution *********************************************************************************


