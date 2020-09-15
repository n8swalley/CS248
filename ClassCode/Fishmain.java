import java.io.*;

class Fishmain
{
	public static void main(String [] args)
	{
		Fish f,g;
		f=new Fish("Nemo","orange","clownfish",7);
		System.out.println("count="+Fish.count);
		g=new Fish("Angela","blue","angelfish",7);
		Fish s=new Fish("Spongebob","yellow","sponge",0);
		
		System.out.println("count="+Fish.count);
		f.print();
		System.out.println(f.getSpecies());
		f.sharkAttack();
		g.sharkAttack();
		s.sharkAttack();
		System.out.println("Oh no, a shark!");
		f.print();
		g.print();
		s.print();
	}
}