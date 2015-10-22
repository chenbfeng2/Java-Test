package graph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class main {
	
	public static void main(String[] arg)
	{
	graphNode no0=new graphNode(0);
	graphNode no1=new graphNode(1);
	graphNode no2=new graphNode(2);
	graphNode no3=new graphNode(3);
	graphNode no4=new graphNode(4);
	graphNode no5=new graphNode(5);
	graphNode no6=new graphNode(6);
	graphNode no7=new graphNode(7);
	graphNode no8=new graphNode(8);
	graphNode no9=new graphNode(9);
	no0.add(no3);
	no0.add(no5);
	no1.add(no0);
	no1.add(no2);
	no1.add(no5);
	no2.add(no5);
	no3.add(no4);
	no4.add(no2);
	no4.add(no8);
	no6.add(no4);
	no7.add(no9);
	no8.add(no7);
	no8.add(no6);
	no9.add(no1);
	no9.add(no4);
	if(searchPath(no5,no0))
	{
		System.out.println("this is a way!");
		
	}
	else
		System.out.println("No Way!");
	
	}
	public static boolean searchPath(graphNode start, graphNode end)
	{
		Hashtable<graphNode,Integer> visited=new Hashtable<graphNode,Integer>();
		graphNode tempNode=start;
		Stack<graphNode> dfsStack=new Stack<graphNode>();
		dfsStack.add(start);
		while(!dfsStack.empty())
		{	for(graphNode temp:tempNode.adjList())
			{
				if(!visited.containsKey(temp))
				{
					dfsStack.add(temp);
					if(temp==end)
					{	return true;
					}
				}
			}
			visited.put(tempNode, 1);
			tempNode=dfsStack.pop();
		}
		return false;
	}
	
	/*
	public class graph{
		private ArrayList<graphNode> graphList;
		public graph()
		{
			this.graphList=new ArrayList<graphNode>();
			
		}
		
		public void add(graphNode node)
		{
			
		}
		
	}
	*/


}
