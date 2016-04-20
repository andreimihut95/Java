package patterns.strategy;
import java.util.*;

interface Strategy3 
{
	void sortMe();
}
abstract class Sortare implements Strategy3
{
	protected ArrayList<Integer> numere = new ArrayList<Integer>();
	abstract public void sortMe();
	public Sortare(ArrayList<Integer> numere)
	{
		this.numere = numere;
	}
	public String toString()
	{
		String s = "";
		for(Integer i : numere)
			s+=" "+i;
		String f = this.getClass().getSimpleName()+":" + s;
		return f;
	}
}
class BubbleSort extends Sortare
{
	public BubbleSort(ArrayList<Integer> numere)
	{
		super(numere);
	}
	public void sortMe()
	{
		Integer aux = new Integer(0);
		int i , j;
		for(i = 0 ;  i < numere.size() -1 ; i++)
			for(j = i + 1 ; j < numere.size(); j++)
				if(numere.get(i) > numere.get(j))
				{
					aux = numere.get(i);
					numere.set(i, numere.get(j));
					numere.set(j, aux);
				}
	}
}
class SelectionSort extends Sortare
{
	public SelectionSort(ArrayList<Integer> numere)
	{
		super(numere);
	}
	public void sortMe()
	{
		int i , j , min , tmp;
		for(i = 0 ; i < numere.size() ; i++)
		{
			min = i;
			for(j = i + 1 ; j < numere.size() ; j++)
				if(numere.get(j) < numere.get(min))
					min = j;
			if(min != i)
			{
				tmp = numere.get(i);
				numere.set(i, numere.get(min));
				numere.set(min, tmp);
			}
		}
	}
}
class InsertionSort extends Sortare
{
	public InsertionSort(ArrayList<Integer> numere)
	{
		super(numere);
	}
	public void sortMe()
	{
		int i , temp , j;
		for(i = 1; i < numere.size() ; i++)
		{
			temp = numere.get(i);
			j = i - 1;
			while(j >= 0 && temp < numere.get(j))
			{
				numere.set(j + 1, numere.get(j));
				--j;
			}
			numere.set(j + 1, temp);
		}
	}
}
interface Context3
{
	void doStrategy();
}
class Om implements Context3
{
	private Strategy3 strategie;
	public Om(Strategy3 strategie)
	{
		this.strategie = strategie;
	}
	public void doStrategy()
	{
		strategie.sortMe();
	}
}
class MainS3
{
	public static void main(String[] args)
	{
		ArrayList<Integer> numere1 = new ArrayList<Integer>();
		numere1.add(10);
		numere1.add(5);
		numere1.add(6);
		numere1.add(3);
		numere1.add(15);
		numere1.add(23);
		ArrayList<Integer> numere2 = new ArrayList<Integer>();
		numere2.add(15);
		numere2.add(3);
		numere2.add(4);
		numere2.add(152);
		numere2.add(155);
		numere2.add(24);
		ArrayList<Integer> numere3 = new ArrayList<Integer>();
		numere3.add(4);
		numere3.add(5);
		numere3.add(1);
		numere3.add(1);
		numere3.add(3);
		numere3.add(2);
		
		Strategy3 strategie1 = new InsertionSort(numere1);
		Strategy3 strategy2 = new BubbleSort(numere2);
		Strategy3 strategy3 = new SelectionSort(numere3);
		Context3 om = new Om(strategie1);
		om.doStrategy();
		System.out.println(strategie1);
		om = new Om(strategy2);
		om.doStrategy();
		System.out.println(strategy2);
		om = new Om(strategy3);
		om.doStrategy();
		System.out.println(strategy3);
	}
}