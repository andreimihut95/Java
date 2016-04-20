package patterns.observer;
import java.util.*;
class Subject 
{
	private int state;
	private ArrayList<Observer1> obs = new ArrayList<Observer1>();
	public int getState()
	{
		return state;
	}
	public void setState(int state)
	{
		this.state = state;
		notifyAllObservers();
	}
	public void attachObserver(Observer1 o)
	{
		obs.add(o);
	}
	public void notifyAllObservers()
	{
		for(Observer1 o : obs)
		{
			o.update();
		}
	}
	
}
abstract class Observer1
{
	public abstract void update();
	protected Subject subject;
}
class BinaryObserver extends Observer1
{
	public BinaryObserver(Subject subject)
	{
		this.subject = subject;
		this.subject.attachObserver(this);
	}
	public void update()
	{
		System.out.println("Binary String: " + Integer.toBinaryString((this.subject.getState())));
	}
}
class OctalObserver extends Observer1
{
	public OctalObserver(Subject subject)
	{
		this.subject = subject;
		this.subject.attachObserver(this);
	}
	public void update()
	{
		System.out.println("Octal String: " + Integer.toOctalString(((this.subject.getState()))));
	}
}
class Main
{
	public static void main(String[] args)
	{
		Subject s = new Subject();
		new BinaryObserver(s);
		new OctalObserver(s);
		s.setState(10);
		s.setState(1);
	}
}