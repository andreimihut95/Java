package patterns.observer;
import java.util.*;
class Persoana
{
	private ArrayList<Observer2> obs = new ArrayList<Observer2>();
	private String state;
	private String nume;
	public Persoana(String nume)
	{
		this.nume = nume;
	}
	public String getNume()
	{
		return nume;
	}
	public void attachObserver2(Observer2 o)
	{
		obs.add(o);
	}
	public void dettachObserver2(Observer2 o)
	{
		obs.remove(o);
	}
	public void notifyAllObservers()
	{
		for(Observer2 o : obs)
			o.update();
	}
	public void retrageBani()
	{
		state = "a scos bani!";
		notifyAllObservers();
		
	}
	public void introduBani()
	{
		state = "a introdus bani!";
		notifyAllObservers();
	}
	public String getState()
	{
		return state;
	}
}
abstract class Observer2
{
	protected Persoana persoana;
	abstract public void update();
}
class CIA extends Observer2
{
	public CIA(Persoana persoana)
	{
		this.persoana = persoana;
		this.persoana.attachObserver2(this);
	}
	public void update()
	{
		System.out.println("CIA: " + persoana.getNume() + " "+ persoana.getState());
	}
}
class NSA extends Observer2
{
	public NSA(Persoana persoana)
	{
		this.persoana = persoana;
		this.persoana.attachObserver2(this);
	}
	public void update()
	{
		System.out.println("NSA: " + persoana.getNume() + " "+ persoana.getState());
	}
}
class ClientObs
{
	public static void main(String[] args)
	{
		Persoana Mihut = new Persoana("Mihut Andrei");
		Observer2 nsa = new NSA(Mihut);
		Observer2 cia = new CIA(Mihut);
		Mihut.introduBani();
		Mihut.retrageBani();
		Mihut.dettachObserver2(nsa);
		Mihut.introduBani();
		Mihut.dettachObserver2(cia);
		Mihut.retrageBani();
	}
}