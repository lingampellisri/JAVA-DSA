/*
Problem statement
You are given a binary tree having 'n' nodes.



The boundary nodes of a binary tree include the nodes from the left and right boundaries and the leaf nodes, each node considered once.



Figure out the boundary nodes of this binary tree in an Anti-Clockwise direction starting from the root node.



Example :
Input: Consider the binary tree A as shown in the figure:

Output: [10, 5, 3, 7, 18, 25, 20]

Explanation: As shown in the figure

The nodes on the left boundary are [10, 5, 3]

The nodes on the right boundary are [10, 20, 25]

The leaf nodes are [3, 7, 18, 25].

Please note that nodes 3 and 25 appear in two places but are considered once.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
10 5 20 3 8 18 25 -1 -1 7 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
10 5 3 7 18 25 20
Explanation of Sample Input 1:
The nodes on the left boundary are [10, 5, 3]

The nodes on the right boundary are [10, 20, 25]

The leaf nodes are [3, 7, 18, 25].

Please note that nodes 3 and 25 appear in two places but are considered once.
Sample Input 2:
100 50 150 25 75 140 200 -1 30 70 80 -1 -1 -1 -1 -1 35 -1 -1 -1 -1 -1 -1
Sample Output 2:
100 50 25 30 35 70 80 140 200 150
Constraints:
1 <= n <= 10000

Where 'n' is the total number of nodes in the binary tree.

Time Limit: 1 sec

*/


/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.*;

public class Solution {
public static void leftBoundary(TreeNode root,ArrayList<Integer> res)
{
    TreeNode curr=root.left;
    while(curr!=null)
    {
        if(curr.left!=null || curr.right!=null)
        {
            res.add(curr.data);

        }
        if(curr.left!=null)
        {
            curr=curr.left;
        }
        else {
            curr=curr.right;
        }
    }
}

public static void rightBoundary(TreeNode root,ArrayList<Integer>res)
{
    TreeNode curr=root.right;
    ArrayList<Integer>temp=new ArrayList<>();

    while(curr!=null)
    {
         if(curr.left!=null || curr.right!=null)
        {
            temp.add(curr.data);

        }
        if(curr.right!=null)
        {
            curr=curr.right;
        }
        else{
            curr=curr.left;
        }

    }

    for(int i=temp.size()-1;i>=0;i--)
    {
        res.add(temp.get(i));
    }
}


public static void addLeaf(TreeNode root,ArrayList<Integer> res)
{
    if(root.left==null && root.right==null)
    {
        res.add((root.data));
        return ;
    }
    if(root.left!=null)
    {
        addLeaf(root.left, res);
    }
    if(root.right!=null)
    {
        addLeaf(root.right, res); 
    }
}


    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.

        ArrayList<Integer>ans=new ArrayList<>();
        if(root.left!=null || root.right!=null)
        {
            ans.add(root.data);
        }

        leftBoundary(root, ans);
         addLeaf(root, ans);
        rightBoundary(root, ans);
       

return ans;

    }
}

