package patterns.observer;
import java.util.*;

interface Subiect
{
	void notifyAllObservers();
}
abstract class Revista implements Subiect
{
	private ArrayList<Observer4> obs = new ArrayList<Observer4>();
	protected String nume , description , stiri;
	public void notifyAllObservers()
	{
		for(Observer4 o : obs)
			o.update(this);
	}
	public void attachObserver(Observer4 o)
	{
		obs.add(o);
	}
	public void dettachObserver(Observer4 o)
	{
		obs.remove(o);
	}
	public void setStates(String s)
	{
		this.stiri = s;
		notifyAllObservers();
	}
	public String getNume()
	{
		return nume;
	}
	public String getDescription()
	{
		return description;
	}
	public String getStiri()
	{
		return stiri;
	}
}
class Protv extends Revista
{
	private Protv()
	{
		this.nume = "ProTV";
		this.description = "Suntem pe primul loc!";
	}
	private static Protv rv;
	public static Protv getInstance()
	{
		if(rv == null)
			rv = new Protv();
		return rv;
	}
}
class Primatv extends Revista
{
	private Primatv()
	{
		this.nume = "PrimaTV";
		this.description = "Avem foarte multe de spus!";
	}
	private static Primatv rv;
	public static Primatv getInstance()
	{
		if(rv == null)
			rv = new Primatv();
		return rv;
	}
}
class Antena1 extends Revista
{
	private Antena1()
	{
		this.nume = "Antena1";
		this.description = "Suntem pe cale de disparitie!";
	}
	private static Antena1 rv;
	public static Antena1 getInstance()
	{
		if(rv == null)
			rv = new Antena1();
		return rv;
	}
}
interface Observer4
{
	void update(Revista r);
}
class Persoana1 implements Observer4
{
	private String nume;
	private ArrayList<Subiect> reviste = new ArrayList<Subiect>();
	public Persoana1(String nume)
	{
		this.nume = nume;
	}
	public void attachRevista(Revista r)
	{
		reviste.add(r);
		r.attachObserver(this);
	}
	public void update(Revista r)
	{
		System.out.println("Domnule " + nume +" sunteti abonat la revista " + r.getNume() + "\nDescriere: " + r.getDescription() + "\nStiri:  " + r.getStiri());
	}
}
class MainObs4
{
	public static void main(String[] args)
	{
		Revista revista1 = Protv.getInstance();
		Revista revista2 = Primatv.getInstance();
		Revista revista3 = Antena1.getInstance();
		Persoana1 mihut = new Persoana1("Mihut");
		Persoana1 andrei = new Persoana1("Andrei");
		Persoana1 alex = new Persoana1("Alex");
		mihut.attachRevista(revista1);
		mihut.attachRevista(revista2);
		mihut.attachRevista(revista3);
		andrei.attachRevista(revista1);
		alex.attachRevista(revista1);
		revista1.setStates("Astazi de la ora 16, 40 de oameni au murit!");
		revista2.setStates("Buna ziua, maine intre orele 16 si 18 va vine apocalipsa!");
		revista3.setStates("Va rugam sa ne ajutati ca sa nu mai fim pe cale de disparitie!");
	}
}