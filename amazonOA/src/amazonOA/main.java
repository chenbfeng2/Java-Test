package amazonOA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class main {
	/*remove vovwel*/
	
	public static void main(String[] arg)
	{	int[] test={0,1,1,0,1,0,0,0};
		int night=3;
		int[] result=changeSide(test, night);
		for(int i=0; i<test.length;i++)
		{
			System.out.println(result[i]);
		}
	}
	java.util.Hashtable<Integer, String> test;
	public class Solution {
	    public List<String> findRepeatedDnaSequences(String s) {
	        ArrayList<String> result=new ArrayList<String>();
	        HashSet<String> StringSet=new HashSet<String>();
	        for(int i=0; i<s.length()-9; i++)
	        {   
	            String temp=s.substring(i,i+10);
	            if(!StringSet.contains(temp))
	            {
	                StringSet.add(temp);
	            }
	            else
	            {
	                if(!result.contains(temp))
	                    result.add(temp);
	            }
	        }
	        return result;
	    }
	}
	static int[] changeSide(int[] origin, int night)
	{
		int[] copy=new int[origin.length+2];
		copy[0]=0;
		copy[copy.length-1]=0;
		for(int i=0; i<night; i++)
		{	for(int k=1;k<=origin.length; k++)
			{	copy[k]=origin[k-1];
			}
			for(int j=1; j<copy.length-1; j++)
			{
				if(copy[j-1]==copy[j+1])
					origin[j-1]=0;
				else
					origin[j-1]=1;
			}
		}
		return origin;
	}
	public static boolean checkP(String p)
	{
		Stack<Character> pStack=new Stack<Character>();
		HashMap<Character, Character> exp=new HashMap<Character, Character>();
		exp.put('}', '{');
		exp.put(']', '[');
		exp.put(')', '(');
		for(int i=0;i<p.length();i++)
		{
			if(exp.containsValue(p.charAt(i)))
					pStack.push(p.charAt(i));
			if(exp.containsKey(p.charAt(i)))
			{	if(pStack.isEmpty()||(pStack.peek()!=exp.get(p.charAt(i))))
					return false;
				pStack.pop();
			}
		}
		if(pStack.isEmpty())
			return true;
		return false;
	}
	public static int[][] rotateMatrix(int[][] origin, int flag)
	{
		int width=origin.length;
		int length=origin[0].length;
		return flag==1?rotateRight( origin, width, length):rotateLeft( origin, width, length);
	}
	public static int[][] rotateRight(int[][]origin, int width, int length)
	{
		int[][] copy=new int[length][width];
		
		for(int i=0;i<length;i++)
		{
			for(int j=0; j<width;j++)
			{				copy[i][j]=origin[width-j-1][i];
			}
		}
		return copy;
	}
	public static int[][] rotateLeft(int[][] origin, int width, int length)
	{	int[][] copy=new int[length][width];
	
		for(int i=0;i<length;i++)
		{
			for(int j=0; j<width;j++)
			{				copy[i][j]=origin[j][length-i-1];
			}
		}
		return copy;
		
	}
	static Node insertNode(Node head, Node newN)
	{
		Node node=head;
		if(node.getData()>newN.getData())
		{
			while(node.next()!=head)
			{
				node=node.next();
			}
			node.setNext(newN);
			newN.setNext(head);
			return newN;
		}
		while(node.next().getData()<newN.getData()&&node.next()!=head)
		{
			node=node.next();
		}
		Node temp=node.next();
		node.setNext(newN);
		newN.setNext(temp);
		return head;

	}

public static String removeV(String str)
{
	StringBuilder test=new StringBuilder();
	String vowels="aeiouAEIOU";
	for(int i=0;i<str.length();i++)
	{
		if(vowels.indexOf(str.charAt(i))==-1)
	
			test.append(str.charAt(i));
	}
	return test.toString();
}

	public static int rotate(String test1, String test2)
	{
		if(test1==null||test2==null||test1.length()!=test2.length()||test1==""||test2=="")
			return -1;
		test1=test1+test1;
		return test1.indexOf(test2)!=-1?1:-1;
	}
	public static int grayCode(byte a, byte b)
	{
		byte result=(byte) (a^b);
		int count=0;
		for(int i=0;i<7;i++)
		{
			if(((result)&(0x1))==1)
				count++;
			result=(byte) (result>>1);
		}
		
		return count==1?1:-1;
	}
	
	public boolean isSubTree(treeNode node1, treeNode node2)
	{
		if(node2==null)
		{
			return true;
		}
		if(node1==null)
		{
			return false;
		}
		if(node1.getValue()==node2.getValue())
		{
			return treeEqual(node1.getLeft(),node2.getLeft())&&treeEqual(node1.getRight(),node2.getRight());
		}
		else
			return isSubTree(node1.getLeft(), node2)||isSubTree(node1.getRight(),node2);
	}
	public boolean treeEqual(treeNode node1, treeNode node2)
	{
		if(node1==null&&node2==null)
		{
			return true;
		}
		else if(node1.getValue()==node2.getValue())
		{
			return treeEqual(node1.getLeft(),node2.getLeft())&&treeEqual(node1.getRight(),node2.getRight());
		}
		else 
			return false;
	}
	public static int subKvalue(int[] list, int k)
	{
		HashMap<Integer, Integer> posMap=new HashMap<Integer, Integer>();
		for(int i=0;i<list.length;i++)
		{
			if(posMap.containsKey(list[i]))
				if(i-posMap.get(list[i])<=k)
					return list[i];
			posMap.put(list[i], i);
		}
		return -1;
	}
	public static Node reverseHalf(Node head)
	{	
		int count=0;
		Node fast=head, slow=head;
		while(fast.next()!=null)
		{
			fast=fast.next();
			count++;
			if(count%2==0)
				slow=slow.next();
		}
		slow.setNext(reverse(slow.next()));
		return head;
	}
	public static Node reverse(Node head)
	{
		Node prev=null, next=head;
		while(next!=null)
		{
			next=head.next();
			head.setNext(prev);
			prev=head;
			head=next;
		}
		return prev;
	}
}
