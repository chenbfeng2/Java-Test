


/**
 * 
 * @author chenbfeng2
 *
 */
public class treeNode {
	private int value;
	private treeNode parent;
	private treeNode leftChild;
	private treeNode rightChild;
	private queue BFSqueue;
	public treeNode(int newV)
	{
		this.value=newV;
	}
	
	public treeNode getParent() {
		return parent;
	}
	public void setParent(treeNode pNode)
	{	this.parent=pNode;
	}
	
	public int getValue()
	{	return this.value;
	}
	
	public treeNode getLeft()
	{	
		return this.leftChild;
		
	}
	
	public treeNode getRight()
	{
		return this.rightChild;
		
	}
	
	public void append(treeNode newNode)
	{
		if(newNode.getValue()>this.value)
		{	if(this.rightChild==null)
			{	this.rightChild=newNode;
				newNode.setParent(this);
			}
			else
				this.rightChild.append(newNode);
		}
		else
		{	if(this.leftChild==null)
			{	this.leftChild=newNode;
				newNode.setParent(this);
			}
			else
				this.leftChild.append(newNode);
		}
	}
	
	public void accept(nodeVisitor newVisitor)
	{
		newVisitor.visit(this);
	}
	

		/**
		 * 
		 */
		public void  BFSsearch()
		{	treeNode node=this;
			BFSqueue=new queue(20);
			//System.out.println(this.getValue());
			while(!BFSqueue.isEmpty()||node!=null)
			{	
				System.out.println(node.getValue());	
				if(node.getLeft()!=null)
				BFSqueue.add(node.getLeft());
				if(node.getRight()!=null)
				BFSqueue.add(node.getRight());
				node=BFSqueue.remove();
			}	
		}
	 

	public class queue {
		private int size;
		private treeNode[] nodeArray;
		private int pos;
		private int read;
		public queue(int size)
		{
			this.pos=0;
			this.size=size;
			this.nodeArray=new treeNode[size];
		}
		
		public boolean isEmpty()
		{
			return read>=pos;
		}
		public void add(treeNode Node)
		{
			this.nodeArray[pos]=Node;
			this.pos++;
		}
		
		public treeNode remove()
		{
			if(!this.isEmpty())
				return this.nodeArray[read++];
			else 
				return null;
		}
		
		

}
	
	
}
