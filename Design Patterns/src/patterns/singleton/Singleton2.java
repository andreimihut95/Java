package patterns.singleton;
public class Singleton2 
{
	private static Singleton2 s;
	private Singleton2(){}
	public synchronized static Singleton2 getInstance()
	{
		if(s == null)
			s = new Singleton2();
		return s;
	}
}

