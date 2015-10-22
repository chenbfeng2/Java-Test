package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class main {
	public  static void main(String[] arg)
	{
		String test=convert("ABCDEF", 3);
		System.out.println(test);
		
	}
	    public static int climbStairs(int n) {
	        if(n<=1)
	            return 1;
	        if(n==2)
	            return 2;
	        return climbStairs(n-1)+climbStairs(n-2);
	    }
	    
	public static int compareVersion(String version1, String version2) {
        int[] v1=new int[Math.max(version1.length(),version2.length())];
        int[] v2=new int[Math.max(version1.length(),version2.length())];
        if(version1.indexOf(".")!=-1)
        {   String[] part1=version1.split(".");
            for(int i=0;i<part1.length;i++)
            {	
            	System.out.println(part1[i]);
                v1[i]=Integer.parseInt(part1[i]);
            }
        }
        else
            v1[0]=Integer.parseInt(version1);
        if(version2.indexOf(".")!=-1)
        {   String[] part2=version2.split(".");
            for(int i=0;i<part2.length;i++)
            {
                v2[i]=Integer.parseInt(part2[i]);
            }
        }
        else
            v2[0]=Integer.parseInt(version2);
        for(int j=0; j<v1.length;j++){
            if(v1[j]>v2[j])
                return 1;
            else if(v1[j]<v2[j])
                return -1;
        }
        if(v1.length>v2.length)
            return 1;
        else if(v1.length<v2.length)
            return -1;
        else
            return 0;
    } 
	    public static String convert(String s, int numRows) {
	        String[] result=new String[numRows];
	        int flag=0;
	        int count=0;
	        String finalResult=new String();
	        if(numRows==1)
	        {
	            return s;
	        }
	        for(int i=0; i<result.length; i++)
	        {
	            result[i]="";
	        }
	        for(int i=0; i<s.length(); i++)
	        {
	            if(flag==0)
	            {
	                result[count++]+=s.charAt(i);
	                if(count==numRows-1);
	                    flag=1;
	            }
	            else if(flag==1)
	            {
	                result[count--]+=s.charAt(i);
	                if(count==0)
	                    flag=0;
	            }
	        }
	        for(int j=0; j<numRows; j++)
	        {
	            finalResult+=result[j];
	        }
	        return finalResult;
	    }
	
    }