package crackCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;


public class test {

	public static void main(String[] args){
		int[] l1={1,2,3,4,5,6};
		int[] l2={2,4,6,8,10};
		int[] l3={1,3, 5, 7, 9};
		int[] l4={10, 11, 12,13,14};
		List<int[]> test=new ArrayList<int[]>();
		test.add(l1);
		test.add(l2);
		test.add(l3);
		test.add(l4);
		ArrayList<Integer> result=mergeNList(test);
		for(int i:result)
		{
			//System.out.println(i+",");
		}
		int test1=123312;
		int test2=421412;
		test1=(int)(Math.pow(2, 3));
		System.out.println(test1);
	}
	public static ArrayList<Integer> mergeNList(List<int[]> lists)
	{
	int[] ptr=new int[lists.size()];
	boolean end=false;
	ArrayList<Integer> result=new ArrayList<Integer>();
	while(!end)
	{	int min=Integer.MAX_VALUE;
		int arrayNum=-1;
		for(int i=0; i<lists.size(); i++)
		{
			if(lists.get(i).length!=ptr[i])
			{
				if(min>lists.get(i)[ptr[i]])
				{	min=lists.get(i)[ptr[i]];
					arrayNum=i;
				}

			}
		}
		if(min==Integer.MAX_VALUE&&arrayNum==-1)
			end=true;
		else
		{	result.add(min);
			ptr[arrayNum]++;
		}
	}
	return result;
	}
}
	



