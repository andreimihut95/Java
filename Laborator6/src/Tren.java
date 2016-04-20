public class Tren 
{
	private final Vagon[] vag = new Vagon[15];
	public Tren(Vagon[] vag)
	{
		for(int i = 0 ; i < 15 ; i++)
				this.vag[i] = vag[i];
	}
	public int getNumarColete()
	{
		int suma = 0;
		for(Vagon v : vag)
		{
			suma += v.getColete();
		}
		return suma;
	}
	public boolean equals(Object o)
	{
		if(o instanceof Tren)
		{
			return ((Tren)o).getNumarColete() == this.getNumarColete();
		}
		return false;
	}
	public String toString()
	{
		String v = "";
		for(Vagon vagon : vag)
		{
			v += vagon;
		}
		return "Tren: \n" + v;
	}
}
abstract class Vagon
{
	private int colete;
	public Vagon(int colete)
	{
		this.colete = colete;
	}
	public int getColete()
	{
		return colete;
	}
	public String toString()
	{
		return this.getClass().getName()+ ":" +  "Colete " + this.colete + "\n";
	}
}
abstract class Calatori extends Vagon
{
	private int pasageri;
	public Calatori(int pasageri , int colete)
	{
		super(colete);
		this.pasageri = pasageri;
		
	}
	public void deschideUsi()
	{
		System.out.println("Se deschid usile!");
	}
	public void inchideUsi()
	{
		System.out.println("Se inchid usile!");
	}
	public String toString()
	{
		return super.toString() +"          "+ "Pasageri: " + this.pasageri + "\n"; 
	}
}
class CalatoriA extends Calatori
{
	public CalatoriA()
	{
		super(40 , 300);
	}
}
class CalatoriB extends Calatori
{
	public CalatoriB()
	{
		super(50 , 400);
	}
	public void blocheazaGeam()
	{
		System.out.println("Se inchid geamurile!");
	}
}
class Marfa extends Vagon
{
	public Marfa()
	{
		super(400);
	}
}
class Meniu
{
	public static void main(String[] args)
	{
		Vagon v[] = new Vagon[20];
		v[0] = new CalatoriA();
		v[1] = new CalatoriB();
		v[2] = new CalatoriA();
		v[3] = new CalatoriB();
		v[4] = new CalatoriA();
		v[5] = new CalatoriB();
		v[6] = new CalatoriA();
		v[7] = new CalatoriB();
		v[8] = new CalatoriA();
		v[9] = new CalatoriB();
		v[10] = new CalatoriA();
		v[11] = new CalatoriB();
		v[12] = new CalatoriA();
		v[13] = new CalatoriB();
		v[14] = new CalatoriA();
		v[15] = new Marfa();
		v[16] = new Marfa();
		
		Vagon w[] = new Vagon[20];
		w[0] = new CalatoriA();
		w[1] = new CalatoriA();
		w[2] = new CalatoriB();
		w[3] = new CalatoriB();
		w[4] = new CalatoriA();
		w[5] = new CalatoriA();
		w[6] = new CalatoriB();
		w[7] = new CalatoriB();
		w[8] = new CalatoriA();
		w[9] = new CalatoriB();
		w[10] = new CalatoriA();
		w[11] = new CalatoriB();
		w[12] = new CalatoriA();
		w[13] = new CalatoriB();
		w[14] = new CalatoriA();
		
		Tren t1 = new Tren(v);
		Tren t2 = new Tren(w);
		System.out.println(t1 == t2);
		System.out.println(t1.equals(t2));
		//System.out.println(t1);
	}
}