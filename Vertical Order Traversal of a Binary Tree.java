/*
987. Vertical Order Traversal of a Binary Tree
Solved
Hard
Topics
Companies
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
Let’s dry-run the Vertical Traversal algorithm step by step for the given binary tree:

Binary Tree:
markdown
Copy code
       1
     /   \
    2     3
   / \   / \
  4   6 5   7
Vertical Traversal Goal:
We aim to group the nodes based on their vertical columns. Nodes in the same vertical column are further sorted:

By rows (top to bottom).
By value (left to right within the same row).
Initial Setup:
TreeMap:
map to store columns (keys: x) and rows within columns (keys: y) with a priority queue to sort nodes by value.
Queue:
q for level-order traversal.
Start with (root, x=0, y=0) in the queue.
Step-by-Step Execution:
Step 1: Process Root (Node = 1, x=0, y=0)
Dequeue (1, 0, 0):
Add 1 to map[0][0]. (Column 0, Row 0).
Enqueue its left child (2, -1, 1) and right child (3, 1, 1).
map:

css
Copy code
{
    0: {0: [1]}
}
Queue: [(2, -1, 1), (3, 1, 1)]

Step 2: Process Node 2 (x=-1, y=1)
Dequeue (2, -1, 1):
Add 2 to map[-1][1]. (Column -1, Row 1).
Enqueue its left child (4, -2, 2) and right child (6, 0, 2).
map:

css
Copy code
{
    -1: {1: [2]},
     0: {0: [1]}
}
Queue: [(3, 1, 1), (4, -2, 2), (6, 0, 2)]

Step 3: Process Node 3 (x=1, y=1)
Dequeue (3, 1, 1):
Add 3 to map[1][1]. (Column 1, Row 1).
Enqueue its left child (5, 0, 2) and right child (7, 2, 2).
map:

css
Copy code
{
    -1: {1: [2]},
     0: {0: [1]},
     1: {1: [3]}
}
Queue: [(4, -2, 2), (6, 0, 2), (5, 0, 2), (7, 2, 2)]

Step 4: Process Node 4 (x=-2, y=2)
Dequeue (4, -2, 2):
Add 4 to map[-2][2]. (Column -2, Row 2).
map:

css
Copy code
{
    -2: {2: [4]},
    -1: {1: [2]},
     0: {0: [1]},
     1: {1: [3]}
}
Queue: [(6, 0, 2), (5, 0, 2), (7, 2, 2)]

Step 5: Process Node 6 (x=0, y=2)
Dequeue (6, 0, 2):
Add 6 to map[0][2]. (Column 0, Row 2).
map:

css
Copy code
{
    -2: {2: [4]},
    -1: {1: [2]},
     0: {0: [1], 2: [6]},
     1: {1: [3]}
}
Queue: [(5, 0, 2), (7, 2, 2)]

Step 6: Process Node 5 (x=0, y=2)
Dequeue (5, 0, 2):
Add 5 to map[0][2]. (Column 0, Row 2).
map:

css
Copy code
{
    -2: {2: [4]},
    -1: {1: [2]},
     0: {0: [1], 2: [5, 6]},
     1: {1: [3]}
}
Queue: [(7, 2, 2)]

Step 7: Process Node 7 (x=2, y=2)
Dequeue (7, 2, 2):
Add 7 to map[2][2]. (Column 2, Row 2).
map:

css
Copy code
{
    -2: {2: [4]},
    -1: {1: [2]},
     0: {0: [1], 2: [5, 6]},
     1: {1: [3]},
     2: {2: [7]}
}
Queue: [] (Empty, traversal complete)

Result Construction
Traverse the map column by column:
Column -2: [4]
Column -1: [2]
Column 0: [1, 5, 6]
Column 1: [3]
Column 2: [7]
Final Result:

csharp
Copy code
[
    [4],
    [2],
    [1, 5, 6],
    [3],
    [7]
]
*/



 class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node,int row,int col)
    {
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
  public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
    
      TreeNode(int val) { this.val = val; }
  }
 
class Solution {


    public List<List<Integer>> verticalTraversal(TreeNode root) {


        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>(); 
        Queue<Tuple>q=new LinkedList<>();
        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty())
        {
            Tuple tuple=q.poll();

            TreeNode node=tuple.node;
            int x=tuple.row;//col
            int y=tuple.col;//row

            map.putIfAbsent(x,new TreeMap<>());
            map.get(x).putIfAbsent(y,new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if(node.left!=null)
            {
                q.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null)
            {
                 q.offer(new Tuple(node.right,x+1,y+1));
            }

        }


        List<List<Integer>>res=new LinkedList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values())
        {
            List<Integer>vertical=new ArrayList<>();

            for(PriorityQueue<Integer>p:ys.values())
            {
               while(!p.isEmpty())
               {
                vertical.add(p.poll());
               }
            }
            res.add(vertical);
        }
        return res;



        
    }
}
