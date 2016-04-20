import java.io.*;
public class Matrice
{
	private Double[][] a , b;
	private Double[][] produs;
	public Matrice() throws Invalid
	{
		Integer nla , nca , nlb , ncb;
		try
		{
			int i , j;
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(in);
			System.out.print("Dati numarul de linii pentru matricea a: ");
			nla = Integer.parseInt(bf.readLine());
			System.out.print("Dati numarul de coloane pentru matricea a: ");
			nca = Integer.parseInt(bf.readLine());
			System.out.print("Dati numarul de linii pentru matricea b: ");
			nlb = Integer.parseInt(bf.readLine());
			System.out.print("Dati numarul de coloane pentru matricea b: ");
			ncb = Integer.parseInt(bf.readLine());
			if(nca != nlb)
				throw new Invalid("Nu se pot inmulti!");
			a = new Double[nla][nca];
			b = new Double[nlb][ncb];
			produs = new Double[nla][ncb];
			for(i = 0 ; i < produs.length ; i++)
				for(j = 0 ; j < produs[i].length ; j++)
					produs[i][j] = new Double(0);
			System.out.println("Dati matricea a: ");
			for(i = 0  ; i < nla ; i++)
				for(j = 0 ; j < nca ; j++)
					a[i][j] =  new Double(Double.parseDouble(bf.readLine()));
			System.out.println("Dati matricea b: ");
			for(i = 0  ; i < nlb ; i++)
				for(j = 0 ; j < ncb ; j++)
					b[i][j] =  new Double(Double.parseDouble(bf.readLine()));
		}catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}
	public String toString()
	{
		String s = "";
		int i , j;
		for(i = 0 ; i < produs.length ; i++)
		{
			for(j = 0 ; j < produs[i].length ; j++)
				s += produs[i][j] + " ";
			s += "\n";
		}
		return s;
	}
	public void produs()
	{
		int i , j , k;
		for(i = 0 ; i < produs.length;  i++)
			for(j = 0 ; j < produs[i].length ; j++)
				for(k = 0 ; k < a[i].length ; k++)
				{
					produs[i][j] += a[i][k] * b[k][j];
				}
	}
	public static void main(String[] args)
	{
		try
		{
			Matrice m = new Matrice();
			m.produs();
			System.out.println(m);
		}
		catch(Invalid i)
		{
			System.out.println(i);
			System.exit(1);
		}
	}

}
