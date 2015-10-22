package elevatorSimulator;

import elevatorSimulator.elevator.status;

public class ControlLogic {
	
	//move down the elevator by one level and handle the possible calls.
	public void moveDown(elevator ele, callRecorder calls)
	{
		int floorNum=ele.getCurFloor();
		if(floorNum>calls.getDownMostCall(ele))
		{

			if(calls.getInCalls(floorNum)==1||calls.getDownRequest(floorNum)==1)
			{
				ele.doorOpen();
				calls.resetInCall(floorNum);
				calls.downHandled(floorNum);
			}
			ele.moveDown();
			floorNum=ele.getCurFloor();
		}
		if(calls.getInCalls(floorNum)==1||calls.getDownRequest(floorNum)==1)
		{
			ele.doorOpen();
			calls.resetInCall(floorNum);
			calls.downHandled(floorNum);
		}
		this.statusUpdate(ele, calls);
	}
	
	//move up the elevator by one level and handle the possible calls
	public void moveUp(elevator ele, callRecorder calls)
	{
		int floorNum=ele.getCurFloor();
		if(floorNum<calls.getUpMostCall(ele))
		{

			if(calls.getInCalls(floorNum)==1||calls.getUpRequest(floorNum)==1)
			{
				ele.doorOpen();
				calls.resetInCall(floorNum);
				calls.UpHandled(floorNum);
			}
			ele.moveUp();
			floorNum=ele.getCurFloor();
		}
		if(calls.getInCalls(floorNum)==1||calls.getUpRequest(floorNum)==1)
		{
			ele.doorOpen();
			calls.resetInCall(floorNum);
			calls.UpHandled(floorNum);
		}
		this.statusUpdate(ele, calls);
	}
	
	//Update the up or down status according to the current pending calls
	public void statusUpdate(elevator ele, callRecorder calls)
	{
		if(ele.getStatus()==status.UP)
		{
			if(calls.getDownMostCall(ele)!=-1&&calls.getUpMostCall(ele)==-1)
			{
				ele.setStatus(status.DOWN);
			}
			else if(calls.getUpMostCall(ele)==-1)
				ele.setStatus(status.IDLE);
		}
		else if(ele.getStatus()==status.DOWN)
		{
			if(calls.getUpMostCall(ele)!=6&&calls.getDownMostCall(ele)==6)
			{
				ele.setStatus(status.UP);
			}
			else if(calls.getDownMostCall(ele)==6)
				ele.setStatus(status.IDLE);
		}
	}
	
	// The main logic control that determines the movement of the elevator.
	public void elevatorControl(elevator ele,callRecorder calls)
	{
		if(!calls.emptyCalls())
		{	calls.curRequestQueue();
			if(ele.getStatus()==status.IDLE)
			{
				if(calls.getUpMostCall(ele)!=-1)
				{	
					ele.setStatus(status.UP);
					this.moveUp(ele, calls);
				}
				else if(calls.getDownMostCall(ele)!=6)
				{
					ele.setStatus(status.DOWN);
					this.moveDown(ele, calls);
				}
				else 
				{	ele.doorOpen();
					calls.downHandled(ele.getCurFloor());
					calls.UpHandled(ele.getCurFloor());
					calls.resetInCall(ele.getCurFloor());
				}
				
			}
			else if(ele.getStatus()==status.UP)
			{
				this.moveUp(ele, calls);
			}
			else if(ele.getStatus()==status.DOWN)
			{
				this.moveDown(ele, calls);
			}
			
		}
		ele.setStatus(status.IDLE);
	}
	

}
