/**
Odd or Even
Difficulty: BasicAccuracy: 60.6%Submissions: 131K+Points: 1Average Time: 5m
Given a positive integer n, determine whether it is odd or even. Return true if the number is even and false if the number is odd.

Examples:

Input: n = 15
Output: false
Explanation: The number is not divisible by 2
Input: n = 44
Output: true
Explanation: The number is divisible by 2
*/



// User function Template for Java
class Solution {
    static boolean isEven(int n) {
        // code here
     if((n&1)==0)
     {
         return true;
     }
     else
     {
         return false;
     }
    }
}
