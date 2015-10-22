package elevatorSimulator;

public class main {
	public static void main(String arg[])
	{
		elevator test=new elevator();
		callRecorder calls=new callRecorder();
		ControlLogic eleController=new ControlLogic();
		calls.setDownrequest(4);
		calls.setDownrequest(3);
		calls.setInCall(3);
		calls.setInCall(2);
		calls.setUprequest(0);
		calls.setUprequest(1);
		int count=5;
		while(true)
		{	if(!calls.emptyCalls())
			{
				eleController.elevatorControl(test, calls);
			}
			if(count>0)
			{
				calls.addRandomCalls((int)(Math.random()*5));
				count--;
			}
		}
	}
}
