package crackCode;

import java.util.ArrayList;
import java.util.Hashtable;

public class Node {
		private int data;
		private Node next;
		Node(int i)
		{
			this.data=i;
		}
		public Node next()
		{
			return this.next;
		}
		public int getData()
		{
			return this.data;
		}
		public void setNext(Node n)
		{
			this.next=n;
		}
		public void setData(int i)
		{
			this.data=i;
		}
		public void add(int i)
		{
			Node currentN=this;
			Node end=new Node(i);
			while(currentN.next!=null)
			{
				currentN=currentN.next;
			}
			currentN.next=end;
		}
		public Node remove(Node head, int d)
		{	
			Node n=head;
			if(head.data==d)
				return head.next;
			while(n.next!=null)
			{	if(n.data==d)
				{	n.next=n.next.next;
					return head;
				}
				n=n.next;
			}
			return head;
		}
		
		public void removeDup()
		{
			Node curNode=this;
			Node previous=null;
			
			Hashtable<Integer,Boolean> DupChecker=new Hashtable<Integer, Boolean>();
			while(curNode!=null)
			{
				if(DupChecker.containsKey(curNode.data))
				{
					previous.next=curNode.next;
				}
				else
				{	previous=curNode;
					DupChecker.put(curNode.data, true);
				}
				curNode=curNode.next;
			}
		}
		public Node findN(int n)
		{
			Node curN=this;
			Node start=this;
			for(int i=0;i<n;i++)
			{
				if(curN==null)
					return null;
				curN=curN.next;
			}
			while(curN!=null)
			{
				curN=curN.next;
				start=start.next;
			}
			return start;
		}
		
		public Node deleteN(Node n)
		{
			Node newN=n.next;
			//int buffer;
			n.data=n.next.data;
			n.next=n.next.next;
			return newN;
		}
		
		public String toString()
		{	ArrayList<Integer> result=new ArrayList<Integer>();
			Node curNode=this;
			while(curNode!=null)
			{
				result.add(curNode.data);
				curNode=curNode.next;
			}
			return result.toString();
		}
		public Node loopChecker()
		{	ArrayList<Node> nodeList=new ArrayList<Node>();
			Node curN=this;
			while(curN.next!=null)
			{	for(int i=0;i<nodeList.size();i++)
				{
					if(nodeList.get(i)==curN)
						return curN;
				}
				nodeList.add(curN);
				curN=curN.next;
			}
			return null;
		}
	}
