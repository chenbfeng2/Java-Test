import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class main {
	
	public static void main(String[] args)
	{
		String test=new String();
		File file = new File("PracticeInput.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader( new FileReader (file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String         line = null;
	    StringBuilder[]  result = new StringBuilder[2];
	    for(int i=0;i<2;i++)
	    {
	    	try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	result[i]=new StringBuilder();
	    	result[i].append(line);
	    }
	    String name1=new String();
	    String name2=new String();
	    int start1=result[0].indexOf(":");
	    int start2=result[1].indexOf(":");
	    name1=result[0].substring(0, start1);
	    name2=result[1].substring(0, start2);
	    String result1=result[0].substring(start1+1);
	    String result2=result[1].substring(start2+1);
	    int count1=0;
	    int count2=0;
	    int stepCount=0;
	    int flag=0;
	    for(int i=0; i<100000; i++)
	    {	int x=firstWin(result1.charAt(i%result1.length()),result2.charAt(i%result2.length()));
	    	if(x==1)
	    	{
	    		count1++;
	    	}
	    	else if(x==2)
	    	{
	    		count2++;
	    	}
	    	if(count1-count2>4)
	    	{	System.out.println(stepCount+"");
	    		System.out.println(name1);
	    		flag=1;
	    		break;
	    	}
	    	else if(count2-count1>4)
	    	{
	    		System.out.println(stepCount+"");
	    		System.out.println(name2);
	    		flag=1;
	    		break;
	    	}
	    	stepCount++;
	    }
	    if(flag==0)
	    {
	    	System.out.println("DRAW");
	    }
	}
	
	private static int firstWin(char a, char b)
	
	{
		if(a=='S')
		{
			if(b=='R')
				return 2;
			else if(b=='S')
				return 0;
			else if(b=='P')
				return 1;
		}
		if(a=='R')
		{
			if(b=='R')
				return 0;
			else if(b=='S')
				return 1;
			else if(b=='P')
				return 2;
		}
		if(a=='S')
		{
			if(b=='R')
				return 2;
			else if(b=='S')
				return 0;
			else if(b=='P')
				return 1;
		}
		return -1;
	}	
		private static String readFile( String file ) throws IOException {
	
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}
	
	private static void fileWriter(String result) {
		try {
			File file = new File("filename.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(result);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

