/*
87. Repeated DNA Sequences
Solved
Medium
Topics
Companies
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.
*/

-----------------------------Brute force solution---------------------------------

  class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String>res=new LinkedList<>();

        // if(s.length()==10)
        // {
            
        //     res.add(s);
        //     return res;
       
        // }
        // else
        {

            HashSet<String>set=new HashSet<>();
             HashSet<String>set1=new HashSet<>();
            for(int i=0;i<=s.length()-10;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=i;j<(i+10);j++)
                {
                   
                            sb.append(s.charAt(j));
                //    System.out.println(sb);
                }
                if(set.contains(sb.toString()))
                {
                    set1.add(sb.toString());
                }
                set.add(sb.toString());
                // System.out.println(set);
            }
            System.out.println(set1);
            res.addAll(set1);
            return res;

        }

            
        
    }
}


---------------------------Optimal Solution--------------------
  class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String>res=new LinkedList<>();
            HashSet<String>set=new HashSet<>();
             HashSet<String>set1=new HashSet<>();
            for(int i=0;i<=s.length()-10;i++)
            {
               String sb=s.substring(i,i+10);
                if(set.contains(sb.toString()))
                {
                    set1.add(sb.toString());
                }
                set.add(sb.toString());
                // System.out.println(set);
            }
            System.out.println(set1);
            res.addAll(set1);
            return res;

        }

            
        
    
}
