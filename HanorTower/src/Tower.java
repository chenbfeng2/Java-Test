import java.util.Stack;


public class Tower {
	private Stack<Integer> towerStack;
	private int towerSize;
	public Tower(int size)
	{
		this.towerStack=new Stack<Integer>();
		this.towerSize=size;
	}
	public void add(int newInt)
	{
		
		if((towerStack.isEmpty())||(towerStack.size()<towerSize&&newInt<towerStack.peek()))
		{	this.towerStack.push(newInt);
			towerSize++;
		}
		else
			System.out.println("rule violation!");
	}
	
	public void moveTop(Tower des)
	{
		int target=this.towerStack.pop();
		des.add(target);
	}
	/**
	 * 
	 * @param size
	 * @param buffer
	 * @param desti
	 */
	public void moveTower(int size, Tower buffer, Tower desti)
	{	
		if(size>1)
		{	this.moveTower(size-1, desti, buffer);
			this.moveTop(desti);
			buffer.moveTower(size-1, this, desti);
		}
		else
			this.moveTop(desti);
	}
	
	public void print()
	{
		System.out.println(this.towerStack.toString());
	}
}
