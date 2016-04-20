public class Punct 
{
	private int x;
	private int y;
	public Punct(int x , int y)
	{
		this.x = x;
		this.y = y;
	}
	public String toString()
	{
		return "Coordonatele sunt: " + x + " " +y;
	}
}
class PunctColorat extends Punct
{
	private int c;
	public PunctColorat(int x , int y , int c)
	{
		super(x,y);
		this.c = c;
	}
	public String toString()
	{
		return super.toString() + " si culoarea " + c;
	}
}
class Main
{
	public static void main(String[] args)
	{
		Punct p1 = new Punct(10,10);
		System.out.println(p1);
		PunctColorat p2 = new PunctColorat(10,10,15);
		System.out.println(p2);
	}
}