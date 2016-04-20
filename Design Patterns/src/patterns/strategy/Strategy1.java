package patterns.strategy;
interface Strategy1
{
	void doOperation(int num1 , int num2);
}
class Adunare implements Strategy1
{
	public void doOperation(int num1 , int num2)
	{
		System.out.println(this.getClass().getName() + ": " + (num1+num2));
	}
}
class Scadere implements Strategy1
{
	public void doOperation(int num1, int num2) 
	{
		System.out.println(this.getClass().getName() + ": " + (num1-num2));
	}
}
class Inmultire implements Strategy1
{
	public void doOperation(int num1, int num2) 
	{
		System.out.println(this.getClass().getName() + ": " + (num1*num2));
	}
}
interface Context
{
	void doStrategy(int num1 , int num2);
}
class Context1 implements Context
{
	private Strategy1 s;
	public Context1(Strategy1 s)
	{
		this.s = s;
	}
	public void doStrategy(int num1 , int num2)
	{
		s.doOperation(num1, num2);
	}
}
class ClientS
{
	public static void main(String[] args)
	{
		Strategy1 s1 = new Adunare();
		Strategy1 s2 = new Scadere();
		Strategy1 s3 = new Inmultire();
		Context c = new Context1(s1);
		c.doStrategy(10, 20);
		c = new Context1(s2);
		c.doStrategy(10, 20);
		c = new Context1(s3);
		c.doStrategy(10, 20);
	}
}