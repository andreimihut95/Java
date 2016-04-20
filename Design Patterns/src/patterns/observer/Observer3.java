package patterns.observer;
import java.util.*;
class StatieMeteo
{
	private ArrayList<Observer3> obs = new ArrayList<Observer3>();
	private double temperatura , umiditate;
	public void attachObserver(Observer3 o)
	{
		obs.add(o);
	}
	public void dettachObserver(Observer3 o)
	{
		obs.remove(o);
	}
	public void notifyAllObservers(double t,double u)
	{
		for(Observer3 o : obs)
			o.update(t,u);
	}
	public void setStates(double t , double u)
	{
		this.temperatura = t;
		this.umiditate = u;
		notifyAllObservers(t,u);
	}
	public double getTemperature()
	{
		return temperatura;
	}
	public double getUmiditate()
	{
		return umiditate;
	}
}
abstract class Observer3
{
	protected StatieMeteo m;
	abstract public void update(double t , double u);
}
class Celsius extends Observer3
{
	public Celsius(StatieMeteo m)
	{
		this.m = m;
		this.m.attachObserver(this);
	}
	public void update(double t , double u)
	{
		System.out.println("Sunt " + t + " grade Celsius si " + u + "% umiditate");
	}
}
class Kelvin extends Observer3
{
	public Kelvin(StatieMeteo m)
	{
		this.m = m;
		this.m.attachObserver(this);
	}
	public void update(double t , double u)
	{
		System.out.println("Sunt " + (t + 273.15) + " grade Kelvin si " + u + "% umiditate");
	}
}
class Fahrenheit extends Observer3
{
	public Fahrenheit(StatieMeteo m)
	{
		this.m = m;
		this.m.attachObserver(this);
	}
	public void update(double t , double u)
	{
		System.out.println("Sunt " + (t * 1.8 + 32) + " grade Fahrenheit si " + u + "% umiditate");
	}
}
class MainObs3
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		StatieMeteo statie = new StatieMeteo();
		Observer3 obs1 = new Celsius(statie);
		Observer3 obs2 = new Kelvin(statie);
		Observer3 obs3 = new Fahrenheit(statie);
		statie.setStates(20, 45.50);
		statie.setStates(-30.15, 0);
	}
}