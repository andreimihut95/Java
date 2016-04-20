package patterns.visitor;
interface ComputerPart
{
	void accept(Visitor1 v);
}
class Mouse implements ComputerPart
{
	public void accept(Visitor1 v)
	{
		v.visit(this);
	}
}
class KeyBoard implements ComputerPart
{
	public void accept(Visitor1 v)
	{
		v.visit(this);
	}
}
class Monitor implements ComputerPart
{
	public void accept(Visitor1 v)
	{
		v.visit(this);
	}
}
class Computer implements ComputerPart
{
	private ComputerPart[] parts = new ComputerPart[3];
   	public Computer()
   	{
   		parts[0] = new Mouse();
   		parts[1] = new KeyBoard();
   		parts[2] = new Monitor();
   	}
	public void accept(Visitor1 v)
	{
		for(ComputerPart c : parts)
			c.accept(v);
		v.visit(this);
	}
}
interface Visitor1
{
	void visit(Computer c);
	void visit(KeyBoard c);
	void visit(Mouse c);
	void visit(Monitor c);
}
class ComputerVisitor implements Visitor1
{
	public void visit(Computer c)
	{
		System.out.println("Sunt un Calculator!");
	}
	public void visit(KeyBoard c)
	{
		System.out.println("Sunt o Tastatura!");
	}
	public void visit(Mouse c)
	{
		System.out.println("Sunt un Mouse!");
	}
	public void visit(Monitor c)
	{
		System.out.println("Sunt un Monitor!");
	}
}
class Client2
{
	public static void main(String[] args)
	{
		ComputerPart c = new Computer();
		Visitor1 v = new ComputerVisitor();
		c.accept(v);
	}
}