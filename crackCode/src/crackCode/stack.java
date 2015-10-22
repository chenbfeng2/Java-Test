package crackCode;

public class stack {
	int[] stackList;
	int tail;
	int capacity;
	public stack(int size)
	{	stackList=new int[size];
		tail=0;
		capacity=size;
	}
	
	public void push(int newOb)
	{
		if(tail+1<capacity)
			stackList[tail++]=newOb;
		else
			System.out.println("Stack overflow");
	}
	
	public int pop()
	{
		if(tail>0)
			return stackList[--tail];
		else
		{	System.out.println("stack is empty");
			return -1;
		}
	}
	public boolean isEmpty()
	{	return tail==0;
	}
	
	public int peek()
	{	if(tail!=0)
			return this.stackList[tail-1];
		else
			return -1;
	}
	public stack sortStack()
	{
		stack tempStk=new stack(this.capacity);
		
		while(!this.isEmpty())
		{	int temp=this.pop();
			while(!tempStk.isEmpty()&&temp>tempStk.peek())
			{
				this.push(tempStk.pop());
			}
			tempStk.push(temp);
		}
		return tempStk;
	}
	
	public String printString()
	{
		StringBuilder str=new StringBuilder();
		for(int i=0;i<this.capacity;i++)
		{
			str.append(this.stackList[i]+",");
		}
		return str.toString();
	}
}
