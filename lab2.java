// lab2.java


import java.util.Scanner;
import java.io.*;
public class lab2 
{
	private static String punctuate(String str)
    {
		String nonChar = " !@#$%^&*()_+-=[]\\{}|;':`~,./<>?\""; //string of all punctuations
		char[] nonCh = nonChar.toCharArray();
    	str = str.toLowerCase();
    	char[] s = str.toCharArray();
    	
    	for (int i=0; i<str.length(); i++) // make all the punctuations from the front into empty character
    	{
    		int counter = 0;
    		for(int j=0; j<nonCh.length; j++)
    		{
    			if (s[i] == nonCh[j])
    			{
    				s[i] = ' ';
    				counter++;
    			}	
    		}	
    		if (counter==0)
    			break;
    	}
    	
    	for (int i=str.length()-1; i>=0; i--) // make all the punctuations from the back into empty character
    	{
    		int counter = 0;
    		for(int j=0; j<nonCh.length; j++)
    		{
    			if (s[i] == nonCh[j])
    			{
    				s[i] = ' ';
    				counter++;
    			}
    		}	
    		if (counter==0)
    			break;
    	}
    	str = String.copyValueOf(s);
    	str = str.trim(); // trim all the empty spaces
    	return str;
    }
	
	public static void main(String[] args) throws FileNotFoundException
	{
		double runTime[] = new double[6];
		
		ListInterface[] Lists = new ListInterface[6]; // make a list array of 4
		
			Lists[0] = new List1();
			Lists[1] = new List2();
			Lists[2] = new List2a();
			Lists[3] = new List3();
			Lists[4] = new List4();
			Lists[5] = new SkipList();
			
			File file = new File(args[0]);
			
			Scanner pass = new Scanner(file);
			
			// First Pass
			while (pass.hasNext())
			{
				String word = pass.next();
			}
			pass.close();
			
			// Second Pass
			double time0;
			pass = new Scanner(file);
			long timeStart0 = System.currentTimeMillis(); // starts time 
			while (pass.hasNext())
			{
				String word = punctuate(pass.next());
			}
			time0 = System.currentTimeMillis() - timeStart0; // find the end time minus start time
			System.out.println(time0/1000);
			pass.close();
			
			// Pass (Lists)
			for (int i = 0; i<6; i++) // loop the passes 4 times 
			{
				pass = new Scanner(file);
				double time;
				long timeStart = System.currentTimeMillis(); // find the start time
				while (pass.hasNext())
				{
					String word = punctuate(pass.next());
					Lists[i].add(word);

				}
				time = System.currentTimeMillis() - timeStart; // find the end time minus start time
				runTime[i] = time/1000;
				pass.close();
				
			}
			// Prints out the Lists name, run time, vocabulary, total words, key composition, reference changes and height 
			String format = "%2s %-17s %-8.3f %-10d %-11d %-12d %-11d %3s\n"; // format for printing
			String[] ListNames = {"Unsorted", "Sorted", "Sorted(a)", "Self-Adj (Front)","Self-Adj (By One)", "SkipList"};
			
	        System.out.println(" #" + "    " +"List Name" + "      "+"Run Time"+" "+ "Vocabulary"+" " + "Total Words"+ "   " +"Key Comp" +"\t    "+ "Ref Chgs" + "    "  + "h");
			System.out.println("-- ----------------- -------- ---------- ----------- ------------ ------------ ---");
			for (int i = 0; i<6; i++)
				System.out.printf(format,i+1,ListNames[i],runTime[i],Lists[i].getDistinctWords(),Lists[i].getTotalWords(),Lists[i].getKeyCompare(),Lists[i].getRefChanges(),Lists[i].getH());
			System.out.println("");
			
	}	
}


