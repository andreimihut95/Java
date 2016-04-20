import java.io.*;
public class Fisier 
{
	public static void main(String[] args)
	{
		try
		{
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buf = new BufferedReader(in);
			System.out.print("Date textul: ");
			String ales = buf.readLine();
			System.out.print("Dati numele fisierului: ");
			String fisier = buf.readLine();
			buf.close();
			in.close();
			FileInputStream file = new FileInputStream(fisier);
			in = new InputStreamReader(file);
			buf = new BufferedReader(in);
			int numar = 0;
			String temporar;
			while((temporar = buf.readLine()) != null)
			{
				if(temporar.equals(ales))
					numar++;
			}
			PrintStream p = new PrintStream(System.out);
			p.println("Numarul este : " + numar);
			p.close();
			buf.close();
			in.close();
			file.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
	}
}
