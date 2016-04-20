public class Complex 
{
	private int real;
	private int imaginar;
	private static int nr;
	public Complex(int real , int imaginar)
	{
		this.real = real;
		this.imaginar = imaginar;
	}
	public double calculeazaModul()
	{
		return Math.sqrt(real * real + imaginar * imaginar);
	}
	public void afiseaza()
	{
		nr++;
		System.out.println(real + "+i*" + imaginar);
	}
	public Complex aduna(Complex c)
	{
		Complex aux = new Complex(c.real + real , c.imaginar + imaginar);
		return aux;
	}
	public static int numara()
	{
		return nr;
	}
}
class ClientComplex
{
	public static void main(String[] args)
	{
		Complex z1 = new Complex(10 , 10);
		Complex z2 = new Complex(5 , 10);
		z1.afiseaza();
		z2.afiseaza();
		System.out.println(z1.calculeazaModul());
		Complex z3 = z1.aduna(z2);
		z3.afiseaza();
		System.out.println(Complex.numara());
	}
}