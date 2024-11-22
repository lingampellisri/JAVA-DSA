import java.util.* ;
import java.io.*; 
/****************************************************
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*****************************************************/
public class Solution 
{
	public static int findMaxDepth(BinaryTreeNode<Integer> root) 
	{
		// WRITE YOUR CODE HERE 

		Queue<BinaryTreeNode<Integer>>q=new LinkedList<>();
		q.offer(root);
		int depth=0;
		while(!q.isEmpty())
		{
			int size=q.size();

			for(int i=0;i<size;i++){

				BinaryTreeNode<Integer> node=q.poll();

			if(node.left!=null)
			{
				q.offer(node.left);

			}

			if(node.right!=null)
			{
				q.offer(node.right);

			}
			}
			depth++;
		
		}
		return depth;



	}
}
