package amazonOA;

public class treeNode {
	private treeNode right;
	private treeNode left;
	private int val;
	public treeNode(int value)
	{
		this.val=value;
	}
	public void setRight(treeNode right)
	{
		this.right=right;
	}
	public void setLeft(treeNode left)
	{
		this.left=left;
	}
	public treeNode getRight()
	{
		return this.right;
	}
	public treeNode getLeft()
	{
		return this.left;
	}
	
	public int getValue()
	{
		return this.val;
	}
}
