public class Piramida
{
	private int n;
	public Piramida(int n)
	{
		this.n = n;
	}
	public String toString()
	{
		String pir="";
		int i , j;
		for(i = 1 ; i < n ; i++)
		{
			for(j = i ; j <= n ; j++)
			{
				pir+=i+" ";
			}
			pir+='\n';
		}
		return pir;
	}
	public static void main(String[] args)
	{
		Piramida p = new Piramida(4);
		System.out.println(p);
	}
}
