import java.io.*;
public class Intervale 
{
	private Double a;
	private Double b;
	private int nrtestate;
	private int nrtestin;
	public Intervale(Double a , Double b)
	{
		this.a = a;
		this.b = b;
	}
	public Boolean verifica(Double d)
	{
		nrtestate++;
		if(d >= a && d <= b)
		{
			nrtestin++;
			return true;
		}
		return false;
	}
	public void printeaza(PrintStream p)
	{
		double numere = (double)nrtestin/nrtestate*100;
		p.println("Intervalul [ " + a +" : " + b + " ] are " + numere + " % numere");
	}
	public static void main(String[] args)
	{
		try 
		{
			PrintStream p = null;
			switch (args.length)
			{
				case 1: {p = new PrintStream(new FileOutputStream(args[0]));break;}
				case 0: {p = new PrintStream(System.out);break;}
				default: System.exit(1);
			}
			BufferedReader dat = new BufferedReader(
								 new InputStreamReader(
								 new FileInputStream("intervale.dat")));
			int nr = 0;
			while(dat.readLine() != null)
				nr++;
			dat.close();
			if(nr % 2 == 1)
			{
				System.out.println("Eroare in fisierul de intervale!");
				System.exit(1);
			}
			dat = new BufferedReader(
					 new InputStreamReader(
					 new FileInputStream("intervale.dat")));
			Intervale[] intern = new Intervale[nr/2];
			int i;
			for(i = 0 ; i < (nr / 2) ; i++)
				intern[i] = new Intervale(Double.parseDouble(dat.readLine()) , 
						          Double.parseDouble(dat.readLine()));
			dat.close();
			dat = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Dati numarul de fisiere: ");
			int nrfisiere = Integer.parseInt(dat.readLine());
			BufferedReader buf = null;
			String numefisier , fisieraux ="";
			int j;
			for(i = 0 ; i < nrfisiere ; i++)
			{
				String numar;
				System.out.print("Dati numele fisierului: ");
				if((numefisier = dat.readLine()).equals(fisieraux) == true)
				{
					System.out.println("Nu ai voie un fisier de 2 ori!");
					i--;
					continue;
				}
				fisieraux = numefisier;
				buf = new BufferedReader(new InputStreamReader(new FileInputStream(numefisier)));
				while((numar = buf.readLine()) != null)
				{
					for(j = 0 ; j < intern.length ; j++)
						intern[j].verifica(Double.parseDouble(numar));
				}
			}
			for(i = 0 ; i < intern.length ; i++)
				intern[i].printeaza(p);
			buf.close();
		}catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}
}
