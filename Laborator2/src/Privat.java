public class Privat 
{
	private int numar;
	private Privat(int numar)
	{
		this.numar = numar;
	}
	public int getNumar()
	{
		return this.numar;
	}
	public static void main(String[] args)
	{
		Privat om  = new Privat(10);
		System.out.println("Numarul este: " + om.getNumar());
	}
}
class Utilizator
{
	public static void main(String[] args)
	{
		//Privat om = new Privat(10); -> Eroare, constructor private
	}
}
