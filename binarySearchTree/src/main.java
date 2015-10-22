import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;





public class main {
	public static void main(String[] arg)
	{	
		treeNode root=new treeNode(5);
		root.append(new treeNode(2));
		root.append(new treeNode(1));
		root.append(new treeNode(8));
		treeNode a=new treeNode(10);
		treeNode b=new treeNode(0);
		root.append(new treeNode(6));
		root.append(new treeNode(3));
		root.append(new treeNode(4));
		root.append(new treeNode(7));
		root.append(a);
		root.append(b);
		printPath(a, b, root);
	}
	
	public static void printPath(treeNode a, treeNode b, treeNode root)
	{
		if(a.getValue()<b.getValue())
		{
			treeNode temp=a;
			a=b;
			b=temp;
		}
		while(root!=null)
		{
			if(a.getValue()>root.getValue()&&b.getValue()<root.getValue())
				break;
			else if(b.getValue()>root.getValue())
				root=root.getRight();
			else if(a.getValue()<root.getValue())
				root=root.getLeft();
		}
		String output=new String();
		treeNode temp=root;
		while(root.getValue()!=b.getValue())
		{	//output=root.getValue()+"->"+output;
			if(b.getValue()<root.getValue())
				root=root.getLeft();
			else if(b.getValue()>root.getValue())
				root=root.getRight();
			output=root.getValue()+"->"+output;
		}
		root=temp;
		output=output+root.getValue();
		while(root.getValue()!=a.getValue())
		{	//output=output+"->"+root.getValue();
			if(a.getValue()<root.getValue())
				root=root.getLeft();
			else if(a.getValue()>root.getValue())
				root=root.getRight();
			output=output+"->"+root.getValue();
		}
		System.out.println(output);
		
	}
	
	
	public static treeNode binarySearchNode(int[] sortList)
	{
		if(sortList.length>0)
		{	
			int value=sortList[sortList.length/2];
			treeNode tempNode=new treeNode(value);
			int[] lhList=Arrays.copyOfRange(sortList, 0, sortList.length/2);
			int[] rhList=Arrays.copyOfRange(sortList, sortList.length/2+1, sortList.length);
			if(lhList.length>0)
				tempNode.append(binarySearchNode(lhList));
			if(rhList.length>0)
				tempNode.append(binarySearchNode(rhList));
			return tempNode;
		}
		return null;
		
	}
	public static int maxDepth(treeNode node)
	{
		if(node==null)
			return 0;
		else
			return Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight()));
	}
	public static int minDepth(treeNode node)
	{
		if(node==null)
			return 0;
		else
			return Math.min(minDepth(node.getLeft()), minDepth(node.getRight()));
	}
	public static void checkBalance(treeNode node)
	{
		if(maxDepth(node)-minDepth(node)>2)
		{
			System.out.println("this tree is unbalanced!");
			
		}
		else
			System.out.println("this tree is balanced!");
	}

	
	public static ArrayList<LinkedList<treeNode>> ListArray(treeNode root)
	{	
		 ArrayList<LinkedList<treeNode>> treeList;
		 Stack<treeNode> tempQ=new Stack<treeNode>();
		treeList=new ArrayList<LinkedList<treeNode>>();
		tempQ.add(root);
		while(true)
		{	Stack<treeNode> temp=new Stack<treeNode>();
			LinkedList<treeNode> tempList=new LinkedList<treeNode>();
			while(!tempQ.isEmpty())
			{ 	treeNode tempNode=tempQ.pop();
				if(tempNode.getLeft()!=null)
					temp.add(tempNode.getLeft());
				if(tempNode.getRight()!=null)
					temp.add(tempNode.getRight());	
				tempList.add(tempNode);
			}
			treeList.add(tempList);
			if(temp.empty())
				break;
			else
				tempQ=temp;
		}
		return treeList;
	}
	public static treeNode nextInOrder(treeNode node)
	{
		if(node.getParent()==null||node.getRight()!=null)
			return getLeftMostNode(node.getRight());
		else 
		{	while(node.getParent().getLeft()!=node)
			{
				node=node.getParent();
			}
			return node.getParent();
		}
	}
	public static treeNode getLeftMostNode(treeNode node)
	{
		while(node.getLeft()!=null)
		{
			node=node.getLeft();
		}
		return node;
	}
	
	public static boolean isSubtree(treeNode root1, treeNode root2)
	{
		if(root2==null)
			return true;
		if(root1==null)
			return false;
		if(isIdentical(root1,root2))
		{
			return true;
		}
		return(isSubtree(root1.getLeft(),root2)||isSubtree(root1.getRight(),root2));
	}
	public static boolean isIdentical(treeNode node1, treeNode node2)
	{
		if(node1.getValue()==node2.getValue()&&isIdentical(node1.getLeft(),node2.getLeft())
				&&isIdentical(node1.getRight(), node2.getRight()))
			return true;
		return false;
	}
	public static ArrayList<int[]> BFS(treeNode node, int level, ArrayList<int[]> result)
	{
		if(node==null)
			return null;
		if(level>result.size())
		{
			int[] newInt=
			result.add(e)
		}
	}
}
