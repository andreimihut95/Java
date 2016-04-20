import java.io.*;

public class NumarComplex 
{
	protected int re,im;
	public NumarComplex(int re, int im) 
	{
		this.re = re;
		this.im = im;
	}
	public NumarComplex adunare(NumarComplex a)
	{
		return new NumarComplex(re + a.re, im + a.im);
	}
	public double modul() 
	{
		return Math.sqrt( re * re + im * im );	
	}
	public NumarComplex produs(NumarComplex a)
	{
		return new NumarComplex((re * a.re -im * a.im ) , (re * a.im + im * a.re));
	}
	public String toString() 
	{
		return this.re + "+" + this.im + "*i";
	}
}
class NumarReal extends NumarComplex
{
	public NumarReal(int re)
	{
		super(re , 0);
	}
	public NumarReal adunare(NumarReal nr)
	{
		return new NumarReal(re + nr.re);
	}
	public NumarReal produs(NumarReal nr)
	{
		return new NumarReal(nr.re * re);
	}
	public String toString()
	{
		return this.re+"";
	}
}
class Matrix
{
	public static NumarComplex[][] produs(NumarComplex[][] a , NumarComplex[][] b)
	{
		int i , j , k;
		NumarComplex[][] aux = new NumarComplex[a.length][b[0].length];
		for(i = 0 ; i < a.length ; i++)
			for(j = 0 ; j < b[i].length ; j++)
				aux[i][j] = new NumarComplex(0,0);
		for(i = 0 ; i < a.length ; i++)
			for(j = 0 ; j < b[i].length ; j++)
				for(k = 0 ; k < a[i].length ; k++)
					aux[i][j] = aux[i][j].adunare(a[i][k].produs(b[k][j]));
		return aux;
	}
	public static void Citeste()
	{
		try
		{	
			int la , ca , lb , cb;
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(in);
			System.out.print("Dati numarul de linii la matricea A: ");
			la = Integer.parseInt(buf.readLine());
			System.out.print("Dati numarul de coloane la matricea A: ");
			ca = lb = Integer.parseInt(buf.readLine());
			System.out.print("Dati numarul de coloane la matricea B: ");
			cb = Integer.parseInt(buf.readLine());
			System.out.println("Dati matricea A: ");
			NumarComplex[][] a = new NumarComplex[la][ca];
			NumarComplex[][] b = new NumarComplex[lb][cb];
			int i , j;
			String status;
			for(i = 0 ; i < a.length ; i++)
			{
				for(j = 0 ; j < a[i].length ; j++)
				{
					System.out.print("Numar Real sau NumarComplex(R/C): ");
					status = buf.readLine();
					if(status.equals("R"))
					{
						System.out.print("Dati numarul real: ");
						a[i][j] = new NumarReal(Integer.parseInt(buf.readLine()));
					}
					else
					{
						System.out.print("Dati partea reala si partea imaginara: ");
						a[i][j] = new NumarComplex(Integer.parseInt(buf.readLine()) , Integer.parseInt(buf.readLine()));
					}
				}
			}
			System.out.println("Dati matricea B: ");
			for(i = 0 ; i < b.length ; i++)
			{
				for(j = 0 ; j < b[i].length ; j++)
				{
					System.out.print("Numar Real sau NumarComplex(R/C): ");
					status = buf.readLine();
					if(status.equals("R"))
					{
						System.out.print("Dati numarul real: ");
						b[i][j] = new NumarReal(Integer.parseInt(buf.readLine()));
					}
					else
					{
						System.out.print("Dati partea reala si partea imaginara: ");
						b[i][j] = new NumarComplex(Integer.parseInt(buf.readLine()) , Integer.parseInt(buf.readLine()));
					}
				}
			}
			NumarComplex[][] aux  = produs(a , b);
			for(i = 0 ; i < aux.length ; i++)
			{
				for(j = 0 ; j < aux[i].length ; j++)
					System.out.print(aux[i][j] + "   ");
				System.out.println();
			}
			
		}catch(IOException e)
		{
			System.out.println(e);
			System.exit(0);
		}
	}
}
class Numere
{
	public static void main(String[] args)
	{
		Matrix.Citeste();
	}
}