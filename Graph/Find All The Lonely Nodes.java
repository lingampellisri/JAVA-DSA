/*

Nodes without a Sibling
Difficulty: EasyAccuracy: 18.01%Submissions: 176K+Points: 2
Given a Binary Tree, find all the nodes that don't have any siblings. You need to return a list of integers containing all the nodes that don't have a sibling in sorted order (Increasing). Two nodes are said to be siblings if they are present at the same level, and their parents are the same.

Note: The root node can not have a sibling so it cannot be included in our answer. If there are no nodes that do not have a sibling then add-1 in the list.

Examples:

Input :
       37
      /   
    20
    /     
  113 

Output: [20, 113]
Explanation: Nodes 20 and 113 dont have any siblings.
Input :
       1
      / \
     2   3
    /
     4

Output: [4]
Explanation: Node 4 does not have a sibling.
Input :
       37
      /   
    40
    /     
  13 

Output: [40, 13]
Explanation: Nodes 20 and 13 dont have any siblings.
Constraints:
1 ≤ number of nodes ≤ 104
1 ≤ node->data ≤ 104
*/

//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> ans = g.noSibling(root);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

/*  A Binary Tree nodea
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Tree
{
    
    public static void bfs(Node n,ArrayList<Integer>arr)
    {
        // if(n==null)
        // {
        //     arr.add(-1);
        //     return;
        // }
    
    Queue<Node>q=new LinkedList<Node>();
    q.offer(n);
    while(!q.isEmpty())
    {
        
        Node curr=q.peek();
        if(curr.left!=null && curr.right==null)
        {
            arr.add((curr.left.data));
        }
         if(curr.right!=null && curr.left==null)
        {
            arr.add((curr.right.data));
        }
        
        if(q.peek().left!=null)
        {
            q.add(q.peek().left);
            
        }
        if(q.peek().right!=null)
        {
            q.add(q.peek().right);
        }
        q.poll();
    }
        
    }
    
    
    ArrayList<Integer> noSibling(Node node)
    {
          ArrayList<Integer>arr=new ArrayList<>();
        // code here
         if(node==null)
        {
            arr.add(-1);
            return arr;
        }
      
        
        bfs(node,arr);
        if(arr.isEmpty())
        {
            arr.add(-1);
            return arr;
        }
        
        Collections.sort(arr);
        return arr;
        
        
        
        
    }
}


