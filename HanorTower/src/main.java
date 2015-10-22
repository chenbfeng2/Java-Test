import java.util.ArrayList;
import java.util.List;


public class main {
	
	public static void main(String[] arg)
	{
		ArrayList<Tower> testTower=new ArrayList<Tower>();
		for(int i=0;i<3;i++)
		{
			testTower.add(new Tower(5));
		}
		for(int j=0;j<5;j++)
		{
			testTower.get(0).add(10-j);
		}
		for(int k=0;k<3;k++)
		{
			testTower.get(k).print();		
		}
		testTower.get(0).moveTower(5, testTower.get(1), testTower.get(2));
		for(int k=0;k<3;k++)
		{
			testTower.get(k).print();		
		}
		List<Integer> test=new List<Integer>();
		
	}
}
