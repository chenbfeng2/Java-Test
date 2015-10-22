package elevatorSimulator;

import java.util.concurrent.TimeUnit;

public class elevator {
	//the elevator object that can store the current floor and the moving status.
	private int curFloor;
	enum status {
		IDLE(0),
		UP(1),
		DOWN(2);
		private int status;
		private status(int value)
		{
			status=value;
		}
	}
	
	private status curStatus;
	
	//initialize the elevator object.
	public elevator() {
		this.curStatus=status.IDLE;
		this.curFloor=0;
	}
	//set up the current status.
	public void setStatus(status newStatus)
	{
		this.curStatus=newStatus;
	}
	
	//Simulate the door open process.
	public void doorOpen()
	{
		System.out.println("the elevator Door is opening.\n");
		System.out.println("the elevator Door is closing\n");
	}
	
	//move up one floor.
	public void moveUp()
	{
		this.curFloor++;
		System.out.println("The elevator is at Floor "+this.curFloor+"\n");
	}
	
	//move down one floor.
	public void moveDown()
	{
		this.curFloor--;
		System.out.println("The elevator is at Floor "+this.curFloor+"\n");
	}
	
	//return the current status of the elevator.
	public status getStatus(){
		return this.curStatus;
	}
	
	//return the current floor.
	public int getCurFloor() {
		return this.curFloor;
	}
}
