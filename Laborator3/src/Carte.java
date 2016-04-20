public class Carte 
{
	private int nrpagini;
	public Carte(int nrpagini)
	{
		this.nrpagini = nrpagini;
	}
	public boolean equals(Object o)
	{
		if(o instanceof Carte)
			return ((Carte)o).nrpagini == this.nrpagini;
		return false;
	}
	public static void main(String[] args)
	{
		Carte carte1 = new Carte(100);
		Carte carte2 = new Carte(100);
		Carte carte3 = new Carte(150);
		System.out.println(carte1.equals(carte2));
		System.out.println(carte1.equals(carte3));
		System.out.println(carte1 == carte2);
	}
}
