package elevatorSimulator;

public class callRecorder {
	
	//private arrays that contains the pending request.
	private int[] downRequest;
	private int[] upRequest;
	private int[] inCalls;
	
	//initialize the recorder.
	public callRecorder()
	{
		upRequest=new int[6];
		downRequest=new int[6];
		inCalls=new int[6];
	}
	
	//set up the ExUpCall
	public void setUprequest(int i)
	{
		if(i>0&&i<5)
		{
			upRequest[i]=1;
		}
	}
	
	//set up the ExDownCall
	public void setDownrequest(int i)
	{
		if(i>1&&i<6)
		{
			downRequest[i]=1;
		}
	}
	
	//return the ExUpCall of the current floor.
	public int getUpRequest(int floor)
	{
		return upRequest[floor];
	}
	
	//Handle the ExUpCall of the current floor.
	public void UpHandled(int floor)
	{
		this.upRequest[floor]=0;
	}
	
	//return the ExDownCall of the current floor.
	public int getDownRequest(int floor)
	{
		return downRequest[floor];
	}
	
	//Handle the ExDownCall of the current floor.
	public void downHandled(int floor)
	{
		this.downRequest[floor]=0;
	}
	
	//set up the InCalls 
	public void setInCall(int floor)
	{
		if(floor>0&&floor<6)
		{
			this.inCalls[floor]=1;
		}
	}
	
	//handle the InCalls of the current floor.
	public void resetInCall(int floor)
	{
		this.inCalls[floor]=0;
	}
	
	//print out the pending calls that is not handled yet.
	public void curRequestQueue()
	{
		System.out.println("the current pending EXCALL is\n UP:\n");
		for(int i=0; i<5; i++)
		{
			if(upRequest[i]==1) {
				System.out.println(i);
			}
		}
		System.out.println("\n DOWN: \n");
		for(int i=0; i<5; i++)
		{
			if(downRequest[i]==1) {
				System.out.println(i);
			}
		}
		System.out.println("\n");
		System.out.println("the current pending InCall is\n ");
		for(int i=0; i<5; i++)
		{
			if(this.inCalls[i]==1) {
				System.out.println(i);
			}
		}
		System.out.println("\n");
	}
	
	// calculate floor number of highest requested floor.
	public int getUpMostCall(elevator ele)
	{
		int result=-1;
		for(int i=4; i>ele.getCurFloor(); i--)
		{
			if((this.getUpRequest(i)==1)||(this.getDownRequest(i)==1))
			{
				result=i;
				break;
			}
			
		}
		for(int i=4; i>ele.getCurFloor()&&i>result; i--)
		{
			if(this.getInCalls(i)==1)
			{
				result=i;
				break;
			}
		}
		return result;
	}
	
	//calculate the lowest floor that have pending request.
	public int getDownMostCall(elevator ele)
	{
		int result=6;
		for(int i=0; i<ele.getCurFloor(); i++)
		{
			if(this.getDownRequest(i)==1||this.getUpRequest(i)==1)
			{
				result=i;
				break;
			}
			
		}
		for(int i=0; i<ele.getCurFloor()&&i<result; i++)
		{
			if(this.getInCalls(i)==1)
			{
				result=i;
				break;
			}
		}
		return result;
	}
	
	//return the InCall status of the current floor.
	public int getInCalls(int floorNum) {
		return this.inCalls[floorNum];
	}
	
	//check if there is no more pending request.
	public boolean emptyCalls()
	{
		for(int i=0; i<5; i++)
		{
			if(this.inCalls[i]==1||this.upRequest[i]==1||this.downRequest[i]==1)
				return false;
		}
		
		return true;
	}
	
	//Add i random calls to the system.
	public void addRandomCalls(int i)
	{
		for(int j=0; j<i;j++)
		{
			int rdNum=(int) Math.floor(Math.random()*4);
			if(rdNum==0)
			{
				this.setDownrequest((int) Math.floor(Math.random()*6));
			}
			
			else if(rdNum==1)
			{
				this.setUprequest((int) Math.floor(Math.random()*6));
			}
			else if(rdNum==3)
			{
				this.setInCall((int) Math.floor(Math.random()*6));
			}
		}
	}
}
