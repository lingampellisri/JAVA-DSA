/**
395. Longest Substring with At Least K Repeating Characters
Attempted
Medium
Topics
Companies
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

if no such substring exists, return 0.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105
*/
--------------------------Brute force solution---------------------------
  class Solution {
    public int longestSubstring(String s, int k) {

        int max=Integer.MIN_VALUE;

        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(valid(s,i,j,k))
                {
                    
                     max=Math.max(max,j-i+1);
                }
               
               
            }
        }
        return max==Integer.MIN_VALUE ?0 :max;
        
    }

    public static boolean valid(String str,int start,int end,int  k)
    {
        HashMap<Character,Integer>hm=new HashMap<>();

        for(int i=start;i<=end;i++)
        {
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
        }

        for( int val:hm.values())
        {
            if(val<k)
            return false;
        }
        return true;
    }
}

-------------------Optimal Solution------------------------

  /**
Optimal Algorithm (Divide and Conquer)
Base Case: If the string is empty or its length is less than k, return 0.
Build a Frequency Map of all characters.
Find the first character with frequency < k (let’s call it splitChar).
Split the string at splitChar and recursively call the function on both parts.
Return the maximum length of valid substrings found.

  */

class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s,0,s.length(),k);
        

    }

    public static int helper(String s,int start,int end,int k)
    {
        if(end-start<k)
        return 0;

        HashMap<Character,Integer>hm=new HashMap<>();

        for(int i=start;i<end;i++)
        {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=start;i<end;i++)
        {
            if(hm.get(s.charAt(i))<k)
            {
                int left=helper(s,start,i,k);
                int right=helper(s,i+1,end,k);

                return Math.max(left,right);
            }
        }
        return end-start;
    }
}
