package patterns.strategy;

interface Strategy2 
{
	void makeSound();
}
class Dog implements Strategy2
{
	public void makeSound()
	{
		System.out.println("Ham ham");
	}
}
class Cat implements Strategy2
{
	public void makeSound()
	{
		System.out.println("Miau miau");
	}
}
class Cow implements Strategy2
{
	public void makeSound()
	{
		System.out.println("Muuuuu");
	}
}
class Cactus implements Strategy2
{
	public void makeSound()
	{
		System.out.println("Dracu stie cum face un cactus");
	}
}
interface Context2
{
	void doStrategy();
}
class Camuflaj implements Context2
{
	private Strategy2 strategie;
	public Camuflaj(Strategy2 strategie)
	{
		this.strategie = strategie;
	}
	public void doStrategy()
	{
		this.strategie.makeSound();
	}
}
class MainS
{
	public static void main(String[] args)
	{
		Strategy2 strategie1 = new Dog();
		Strategy2 strategie2 = new Cat();
		Strategy2 strategie3 = new Cow();
		Strategy2 strategie4 = new Cactus();
		Context2 om = new Camuflaj(strategie1);
		om.doStrategy();
		om = new Camuflaj(strategie2);
		om.doStrategy();
		om = new Camuflaj(strategie3);
		om.doStrategy();
		om = new Camuflaj(strategie4);
		om.doStrategy();
		
	}
}