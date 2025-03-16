/**

1456. Maximum Number of Vowels in a Substring of Given Length
Attempted
Medium
Topics
Companies
Hint
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length

*/

***************************************Brute Force Solution*******************************

class Solution {
    public int maxVowels(String s, int k) {

        int n=s.length();

        Set<Character>vowel=new HashSet<>();

            vowel.add('a');
             vowel.add('e');
              vowel.add('i');
               vowel.add('o');
                vowel.add('u');

                int max=0;
                
                for(int i=0;i<=n-k;i++)
                {
                    int count=0;

                    for(int j=i;j<i+k;j++)
                    {
                        if(vowel.contains(s.charAt(j)))
                        {
                            count++;
                        }
                    }

                    max=Math.max(max,count);
                }

                return max;

        
    }
}



****************************************Optimal Solutionnn********************************


  class Solution {
    public int maxVowels(String s, int k) {

        int n=s.length();

    

                int max=0;
                int count=0;


                for(int i=0;i<k;i++)
                {
                    if(isVowel(s.charAt(i)))
                    count++;
                }

                max=count;
                for(int right=k;right<n;right++)
                {
                   
                  
                       if (isVowel(s.charAt(right - k)))
                        count--;
                  
                        if(isVowel(s.charAt(right)))
                        {
                            count++;

                        }
                  
                  max=Math.max(max,count);
                   
                   
                }

                return max;

        
    }


    public static boolean isVowel(char c)
    {
        return c=='a' || c=='e'|| c=='i'||c=='o'||c=='u';
    }
}


  
