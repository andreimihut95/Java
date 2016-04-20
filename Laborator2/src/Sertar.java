public class Sertar 
{
	private int lungime;
	private int latime;
	private int inaltime;
	public Sertar(int L , int l , int h)
	{
		lungime = L;
		latime = l;
		inaltime = h;
	}
	public void tipareste()
	{
		String s = "Sertar " + latime + " "+ lungime + " " + inaltime;
		System.out.println(s);
	}
}
class Birou
{
	private int L;
	private int l;
	private int h;
	private Sertar s1 , s2;
	public Birou(int L , int l , int h , Sertar s1 , Sertar s2)
	{
		this.L = L;
		this.l = l;
		this.h = h;
		this.s1 = s1;
		this.s2 = s2;
	}
	public void tipareste()
	{
		System.out.println("Birou:" + l + " " + L + " " + h);
		s1.tipareste();
		s2.tipareste();
	}
}
class Main
{
	public static void main(String[] args)
	{
		Sertar s1 = new Sertar(10 , 10 , 10);
		Sertar s2 = new Sertar(10 , 15 , 20);
		Birou b = new Birou(100 , 100 , 100 , s1 , s2);
		b.tipareste();
	}
}
