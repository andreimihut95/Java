public class Suma 
{
	public static void main(String[] args)
	{
		int i , suma = 0;
		for(i = 1 ; i <= 100 ; i++)
			if(i % 2 == 0)
				suma += i;
			else
				System.out.println(i);
		System.out.println("Suma numerelor pare este: " + suma);
	}
}
