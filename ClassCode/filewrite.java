import java.io.*;
import java.util.*;

class filewrite
{
	public static void main(String [] args) throws IOException
	{
		String filename="file.txt";
		PrintWriter f=new PrintWriter(new FileWriter(filename));
		f.println("Poop!");
		f.println(45+" "+3);
		f.close();
	}
}
