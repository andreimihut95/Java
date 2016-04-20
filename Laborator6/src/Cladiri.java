class Persoana
{
	private String nume;
	public Proprietate[] p;
	public Persoana(String nume , Proprietate[] p)
	{
		this.nume = nume;
		this.p = p;
	}
	public int getSumaTotala()
	{
		int suma = 0;
		for(Proprietate p1 : p)
		{
			suma += p1.getSuma();
		}
		return suma;
	}
	public String toString()
	{
		String pr = "";
		for(Proprietate p1 : p)
		{
			pr += p1.toString();
		}
		return "Contribuabil: " + nume + "\n\n" + "Proprietati:\n" + pr  +
		       "Suma totala: " + this.getSumaTotala();
	}
}
abstract class Proprietate
{
	private String adresa;
	private int suprafata;
	public Proprietate(String adresa , int suprafata)
	{
		this.adresa = adresa;
		this.suprafata = suprafata;
	}
	public String toString()
	{
		String s1 = "";
		s1 += this.getClass().getName() + ": " + this.getAdresa() + "\n" +
			  "Suprafata: " + this.getSuprafata() + "\n" +
			   "Cost: " + this.getSuma() + "\n\n";
		return s1;
	}
	public String getAdresa()
	{
		return adresa;
	}
	public int getSuprafata()
	{
		return suprafata;
	}
	abstract public int getSuma();
}
class Cladire extends Proprietate
{
	public Cladire(String adresa, int suprafata)
	{
		super(adresa, suprafata);
	}
	public int getSuma()
	{
		return 500 * getSuprafata();
	}
}
class Teren extends Proprietate
{
	private int rang;
	public Teren(String adresa , int suprafata , int rang)
	{
		super(adresa , suprafata);
		this.rang = rang;
	}
	public int getSuma()
	{
		return (350 * getSuprafata())/rang;
	}
}
class Main
{
	public static void main(String[] args)
	{
		Proprietate[] p = new Proprietate[3];
		p[0] = new Cladire("Strada V Parvan Nr.2" , 20);
		p[1] = new Teren("Strada V Parvan Nr.2" , 10 , 1);
		p[2] = new Cladire("Strada Lugoj Nr.4" , 25);
		Persoana p1 = new Persoana("Mihut Andrei", p);
		System.out.println(p1);
	}
}