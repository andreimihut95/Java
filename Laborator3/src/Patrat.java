public class Patrat
{
	private int latura;
	public Patrat(int latura)
	{
		this.latura = latura;
	}
	public Patrat()
	{
		this.latura = 10;
	}
	public String toString()
	{
		return "Patrat: "+latura+" Aria: "+latura*latura;
	}
	public static void main(String[] args)
	{
		Patrat p1 = new Patrat();
		Patrat p2 = new Patrat(15);
		System.out.println(p1);
		System.out.println(p2);
	}
}
