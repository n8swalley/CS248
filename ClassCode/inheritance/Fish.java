public class Fish extends Animal
{
    int fins;

    public Fish(String n, String s, String c, int f)
    {
        super(n,s,c);
        fins=f;

    }

    public int getFins() { return fins; }

    public String toString()
    {
        return super.toString()+ " # of fins="+fins;

    }

}