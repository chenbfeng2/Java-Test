package crackCode;

public class queue {
	Node head;
	Node tail;
	
	public queue(int newOb)
	{	head=new Node(newOb);
		tail=head;
	}
	
	public void enqueue(int newOb)
	{
		tail.setNext(new Node(newOb));
		tail=tail.next();
	}
	
	public int dequeue()
	{	
		
		int target=0;;
		if(head!=null)
		{	target=head.getData();
		}
		if(head.next()!=null)
			head=head.next();
		else
		{	this.clean();
		}
		return target;
	}
	
	public void clean()
	{
		head=null;
		tail=null;
		
	}

}
