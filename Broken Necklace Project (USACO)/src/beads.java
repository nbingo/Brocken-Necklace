/*
ID: nringac1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

public class beads {

	public static void main (String [] args) throws IOException
	{
		Scanner read = new Scanner(new BufferedReader (new FileReader ("beads.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		
		int length = read.nextInt();
		String necklace = read.nextLine().trim();
		int maxBeads = 0;
		
		for (int i = 0; i < length; i++)
		{
			String cutNecklace = necklace.substring(i) + necklace.substring(0, i);
			String reversed = new StringBuilder(cutNecklace).reverse().toString();
			int cutNum = countBeads(cutNecklace, 'w', 0);
			int reverseNum = countBeads(reversed, 'w', 0);
			if (cutNum != reverseNum && cutNum+reverseNum > maxBeads)
				maxBeads = cutNum+reverseNum;
			else if (cutNum == reverseNum && cutNum+reverseNum > maxBeads)
				maxBeads = cutNum;
		}
		out.println(maxBeads);
		out.close();
		read.close();
		System.exit(0);
	}
	
	public static int countBeads(String necklace, char color, int bead)
	{
		if (bead >= necklace.length())
			return 0;
		char beadColor = necklace.charAt(bead);
		
		if (color == 'w' && beadColor != 'w')
			return 1 + countBeads (necklace, beadColor, bead+1);
		else if (beadColor == 'w' || beadColor == color)
			return 1 + countBeads (necklace, color, bead+1);
		else
			return 0;
	}
}
