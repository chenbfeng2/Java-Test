package graph;

import java.util.ArrayList;

public class graphNode {
	private int value;
	private ArrayList<graphNode> adjList;
	private int listPos;
	public graphNode(int newValue)
	{
		this.value=newValue;
		this.listPos=0;
		this.adjList=new ArrayList<graphNode>();
	}
	
	public void add(graphNode adjNode)
	{
		this.adjList.add(adjNode);
	}
	
	public ArrayList<graphNode> adjList()
	{
		return this.adjList;
	}
	
	public void remove(graphNode adjNode)
	{
		this.listPos=this.adjList.indexOf(adjNode);
		this.adjList.remove(listPos);
	}
	
	public int getValue()
	{
		return this.value;
	}
	
}
