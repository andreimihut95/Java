public abstract class Avion 
{
	private String planeID;
	private int totalEnginePower;
	public Avion(String s , int i)
	{
		planeID = s;
		totalEnginePower = i;
	}
	public String getPlaneID()
	{
		return planeID;
	}
	public void takeOff()
	{
		System.out.println(this.getPlaneID());
		System.out.println("Initiating takeoff procedure - Starting engines - Accelerating down the runway - Taking off - Retracting gear - Takeoff complete");
	}
	public void land()
	{
		System.out.println(this.getPlaneID());
		System.out.println("Initiating landing procedure - Enabling airbrakes - Lowering gear - Contacting runway - Decelerating - Stopping engines - Landing complete.");
		
	}
	public void fly()
	{
		System.out.println(this.getPlaneID());
		System.out.println("Flying");
	}
	public int getTotalEnginePower()
	{
		System.out.println(this.getPlaneID());
		return totalEnginePower;
	}
}
abstract class AvionCalatori extends Avion
{
	private int maxPassangers;
	public AvionCalatori(String s , int i , int max)
	{
		super(s , i);
		maxPassangers = max;
	}
	public int getMaxPassangers()
	{
		return maxPassangers;
	}
}
abstract class AvionLupta extends Avion
{
	public AvionLupta(String s , int i)
	{
		super(s,i);
	}
	public void launchMissile()
	{
		System.out.println(this.getPlaneID());
		System.out.println("Initiating missile launch procedure - Acquiring target - Launching missile - Breaking away - Missile launch complete");
		
	}
}
class Boeing extends AvionCalatori
{

	public Boeing(String s, int i, int max) {
		super(s, i, max);
		// TODO Auto-generated constructor stub
	}
	
}
class Concorde extends AvionCalatori
{
	public Concorde(String s, int i, int max) {
		super(s, i, max);
		// TODO Auto-generated constructor stub
	}
	public void goSuperSonic()
	{
		System.out.println(this.getPlaneID());
		System.out.println("Supersonic activated!");
	}
	public void goSubSonic()
	{
		System.out.println(this.getPlaneID());
		System.out.println("Supersonic deactivated!");
	}
}
class Mig extends AvionLupta
{
	public Mig(String s, int i) {
		super(s, i);
		// TODO Auto-generated constructor stub
	}
	public void highSpeedGeometry()
	{
		System.out.println(this.getPlaneID());
		System.out.println("High speed geometry!");
	}
	public void normalGeometry()
	{
		System.out.println(this.getPlaneID());
		System.out.println("Normal speed geometry!");
	}
}
class TomCat extends AvionLupta
{
	public TomCat(String s, int i) {
		super(s, i);
		// TODO Auto-generated constructor stub
	}

	public void refuel()
	{
		System.out.println(this.getPlaneID());
		System.out.println("Initiating refueling procedure - Locating refueller - Catching up - Refueling - Refueling complete");
	}
}
class Client2
{
	public static void main(String[] args)
	{
		Avion av1 = new TomCat("Tomcat1" , 100);
		((TomCat)av1).refuel();
		Concorde av2 = new Concorde("Concorde1" , 100 ,1000);
		av2.takeOff();
		AvionLupta av3 = new TomCat("Tomcat1" , 1000);
		av3.land();
		av3.launchMissile();
		av3.fly();
		((TomCat)av3).refuel();
	}
}