public class Suma 
{
	public static int suma(int a , int b)
	{
		return a + b;
	}
	public static int suma(int a , int b , int c)
	{
		return suma(a , b) + c;
	}
	public static int suma(int a , int b , int c , int d)
	{
		return suma(a,b) + suma(c,d);
	}
	public static void main(String[] args)
	{
		System.out.println(suma(10 , 10));
		System.out.println(suma(10 , 10 , 10));
		System.out.println(suma(10 , 10 , 10 , 10));
	}
}
