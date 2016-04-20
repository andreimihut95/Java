public abstract class Greutate
{
	abstract public int capacitate();
}
class GreutateSimpla extends Greutate
{
	public int capacitate;
	public GreutateSimpla(int capacitate)
	{
		this.capacitate = capacitate;
	}
	public int capacitate()
	{
		return this.capacitate;
	}
}
class  GreutateDubla extends Greutate
{
	private Greutate g1 , g2;
	public GreutateDubla(Greutate g1 , Greutate g2)
	{
		this.g1 = g1;
		this.g2 = g2;
	}
	public int capacitate()
	{
		return g1.capacitate() + g2.capacitate();
	}
}
class GreutateMultipla extends Greutate
{
	Greutate[] g;
	public GreutateMultipla(Greutate[] g)
	{
		this.g = g;
	}
	public int capacitate()
	{
		int suma = 0;
		for(Greutate g1 : g)
			suma += g1.capacitate();
		return suma;
	}
}
class ColectieGreutati
{
	private final Greutate[] greutati;
	private int nr;
	public ColectieGreutati(int maxim)
	{
		greutati = new Greutate[maxim];
	}
	public void adauga(Greutate g)
	{
		if(nr < greutati.length)
			greutati[nr++] = g;
		else
			System.out.println("Gata! Tabloul este plin!");
	}
	public int capacitate()
	{
		int suma = 0;
		for(int i = 0 ; i < nr ; i++)
			suma += greutati[i].capacitate();
		return suma;
	}
	public double medie()
	{
		return (double)(this.capacitate())/nr;
	}
}
class Meniu2
{
	public static void main(String[] args)
	{
		Greutate gs1 = new GreutateSimpla(10);
		Greutate gs2 = new GreutateSimpla(20);
		Greutate gs3 = new GreutateSimpla(30);
		Greutate gd1 = new GreutateDubla(gs1, gs2);
		Greutate gd2 = new GreutateDubla(gs1, gs3);
		Greutate gd3 = new GreutateDubla(gs3, gs2);
		Greutate[] s = {gs1 ,gs2 , gs3 , gd1 , gd2 , gd3};
		
		Greutate gm1 = new GreutateMultipla(s);
		System.out.println(gm1.capacitate());
		
		ColectieGreutati cl = new ColectieGreutati(5);
		cl.adauga(gs1);
		cl.adauga(gs2);
		cl.adauga(gs3);
		cl.adauga(gs1);
		cl.adauga(gm1);
		//cl.adauga(gd1);
		System.out.println(cl.capacitate());
		System.out.println(cl.medie());
	}
}