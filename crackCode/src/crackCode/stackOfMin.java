package crackCode;

public class stackOfMin extends stack{

	private stack minStack;
	public stackOfMin(int size) {
		super(size);
		minStack=new stack(size);
	}
	
	public void push(int newInt)
	{
		if(newInt<min())
		{
			this.minStack.push(newInt);
		}
		super.push(newInt);
	}
	
	public int pop()
	{	
		int result=(int) super.pop();
		if(result==min())
			this.minStack.pop();
		return result;
	}
	
	public int min()
	{	if(this.minStack.peek()!=-1)
			return this.minStack.peek();
	else
		return Integer.MAX_VALUE;
	}
}
	

