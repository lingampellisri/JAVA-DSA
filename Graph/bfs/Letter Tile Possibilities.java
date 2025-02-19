/*
1079. Letter Tile Possibilities
Solved
Medium
Topics
Companies
Hint
You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1
 

Constraints:

*/




class Solution {

public static void validSeq(String s,HashSet<String>set,String tiles,boolean[] valid)
{
    set.add(s);
    for(int i=0;i<tiles.length();i++)
    {
        if(!valid[i])
        {
            valid[i]=true;
            validSeq(s+tiles.charAt(i),set,tiles,valid);
            valid[i]=false;
        }
    }
}

    public int numTilePossibilities(String tiles) {

        HashSet<String>set=new HashSet<>();
        boolean valid[]=new boolean[tiles.length()];
        // for(int i=0;i<tiles.length();i++)
        // {
               validSeq("",set,tiles,valid);
        // }
    System.out.println(set);
        return set.size()-1;
        
    }
}
