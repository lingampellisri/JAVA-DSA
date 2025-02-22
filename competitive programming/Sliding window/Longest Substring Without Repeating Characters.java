/*
3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
Companies
Hint
Given a string s, find the length of the longest 
substring
 without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


*/

------------------------------brute force solution-----------------------------
  class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0)
        {
            return 0;
        }
        HashSet<Character>set=new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++)
        {
                set.clear();

            for(int j=i;j<s.length();j++)
            {
                if(set.contains(s.charAt(j)))
                {
                     System.out.println(set +" breaked");
                   break;
                
                }
                 set.add(s.charAt(j));
                 
                 max=Math.max(max,j-i+1);

                  System.out.println(set);
                
            }
        }
        System.out.println(max);
       return max;
    }
}



----------------------------optimal solution-------------------------

  /*
Step-by-Step Explanation
Step 1: Use Two Pointers (Sliding Window)
We use two pointers, left and right, which define a window containing unique characters.

right expands the window by adding new characters.
left shrinks the window when a duplicate character is found.
Step 2: Use a HashSet to Track Unique Characters
A HashSet stores the characters in the current window.
If a character exists in the set, it means we found a duplicate, and we remove characters from the left until the duplicate is gone.
Step 3: Update Maximum Length
Each time we expand the window with a new unique character, we update maxLength with right - left + 1.


  */


  class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0)
        {
            return 0;
        }
        else
        {
            int max=Integer.MIN_VALUE;
            HashSet<Character>set=new HashSet<>();
            int left=0;
          

            for(int right=0;right<s.length();right++)
            {
                    while(set.contains(s.charAt(right)))
                    {
                        set.remove(s.charAt(left));
                        left++;
                    }

                    set.add(s.charAt(right));
                    max=Math.max(max,right-left+1);
            }

    return max;

        }

        
        
    }
}

  
