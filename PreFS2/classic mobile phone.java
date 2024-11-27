/*

Given a classic mobile phone, and the key pad of the phone looks like below.
	1		2		3
           abc	   def
		 
	4		5		6
    ghi    jkl     mno
  
	7		8		9
    pqrs    tuv     wxyz
	
	*		0		#


You are given a string S contains digits between [2-9] only, 
For example: S = "2", then the possible words are "a", "b", "c".

Now your task is to find all possible words that the string S could represent.
and print them in a lexicographical order. 

Input Format:
-------------
A string S, consist of digits [2-9]

Output Format:
--------------
Print the list of words in lexicographical order.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[a, b, c]


Sample Input-2:
---------------
24

Sample Output-2:
----------------
[ag, ah, ai, bg, bh, bi, cg, ch, ci]

*/


import java.util.*;
class Solution{
    
    
    public static void BackTrack(String digits,int index,StringBuilder sb,List<String> res,String keyPad[])
    {
        if(index==digits.length())
        {
            res.add(sb.toString());
            return;
        }
        
        int digit=digits.charAt(index)-'2';
        String letters=keyPad[digit];
        
        for(char letter:letters.toCharArray())
        {
            sb.append(letter);
            BackTrack(digits,index+1,sb,res,keyPad);
            sb.deleteCharAt(sb.length()-1);
        }
        
        
    }
    
    public static void letterComb(String digits)
    {
        if(digits.isEmpty() || digits==null)
        {
            return ;
        }
        
        String KeyPad[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String >res=new ArrayList<>();
        BackTrack(digits,0,new StringBuilder(),res,KeyPad);
        
        System.out.println(res);
        
        
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String digits=sc.next();
        
        letterComb(digits);
        
        
    }
}
