/**
2269. Find the K-Beauty of a Number
Solved
Easy
Topics
Companies
Hint
The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

It has a length of k.
It is a divisor of num.
Given integers num and k, return the k-beauty of num.

Note:

Leading zeros are allowed.
0 is not a divisor of any value.
A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: num = 240, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "24" from "240": 24 is a divisor of 240.
- "40" from "240": 40 is a divisor of 240.
Therefore, the k-beauty is 2.
Example 2:

Input: num = 430043, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "43" from "430043": 43 is a divisor of 430043.
- "30" from "430043": 30 is not a divisor of 430043.
- "00" from "430043": 0 is not a divisor of 430043.
- "04" from "430043": 4 is not a divisor of 430043.
- "43" from "430043": 43 is a divisor of 430043.
Therefore, the k-beauty is 2.
 

Constraints:

1 <= num <= 109
1 <= k <= num.length (taking num as a string)

*/


Solution 1---------------------

  
  class Solution {
    public int divisorSubstrings(int num, int k) {


            String str=Integer.toString(num);
            int n=str.length();
            // System.out.println(str);
            int count=0;

            StringBuilder sb=new StringBuilder();

            for(int i=0;i<k;i++)
            {
               sb.append(str.charAt(i));
            }
            // System.out.println(sb);
        int parse=Integer.parseInt(sb.toString());
            if(parse>0 && num%parse==0)
              count++;


                for(int i=k;i<n;i++)
                {
                    sb.deleteCharAt(0);
                    sb.append(str.charAt(i));
                    System.out.println(sb);
                     int p=Integer.parseInt(sb.toString());
                     if(p>0 && num%p==0)
                         count++;

                }

            return count;



           
        
    }
}



Solution 2-------------
class Solution {
    public int divisorSubstrings(int num, int k) {


            String str=Integer.toString(num);
            int n=str.length();
            // System.out.println(str);
            int count=0;

            StringBuilder sb=new StringBuilder();

            for(int i=0;i<k;i++)
            {
               sb.append(str.charAt(i));
            }
            // System.out.println(sb);
        
        int right=k;


              while(right<=n)
                {
                          int p=Integer.parseInt(sb.toString());
                     if(p>0 && num%p==0)
                         count++;

                if(right<n){
                    sb.deleteCharAt(0);
                    sb.append(str.charAt(right));
                    System.out.println(sb);
                }
                    right++;
                   

                }

            return count;



           
        
    }
}
  
