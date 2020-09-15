public class Dino extends Fish
{
    //int horns; Use fins variable
    
    public Dino(String n, String s, String c, int h)
    {
        super(n,s,c,h);
    }

    public int getHorns() { return fins;}
    public int getFins() { return 0;}

    public String toString()
    {
        return super.toString()+" # of horns="+fins;
    }
}