public class Atribute
{
	private int numar;
	private String nume;
	public String afiseaza()
	{
		return "Valorile implicite sunt: "+numar+" si "+nume;
	}
	public static void main(String[] args)
	{
		Atribute at = new Atribute();
		System.out.println(at.afiseaza());
	}
}
