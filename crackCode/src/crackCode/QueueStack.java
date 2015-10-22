package crackCode;

import java.util.LinkedList;

public class QueueStack {
	private LinkedList<Integer> mStackQ;
	public QueueStack()
	{
		this.mStackQ=new LinkedList<Integer>();
	}
	public void push(int element)
	{
		LinkedList<Integer> tempQ=new LinkedList<Integer>();
		tempQ.add(element);
		tempQ.addAll(mStackQ);
		this.mStackQ=tempQ;
	}
	public int pop()
	{
		return this.mStackQ.remove();
	}
	
	public int peek()
	{
		return this.mStackQ.peek();
	}
}
