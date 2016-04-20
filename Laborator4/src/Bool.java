public class Bool 
{
	private Boolean b1 , b2;
	public Bool(Boolean b1 , Boolean b2)
	{
		this.b1 = b1;
		this.b2 = b2;
	}
	public Boolean verifica()
	{
		return b1.equals(b2);
	}
	public static void main(String[] args)
	{
		Bool b1 = new Bool(true , true);
		Bool b2 = new Bool(true , false);
		Bool b3 = new Bool(false , true);
		Bool b4 = new Bool(false , false);
		System.out.println(b1.verifica() + " " + b2.verifica() + " " + b3.verifica() + " " + b4.verifica());
	}
}
