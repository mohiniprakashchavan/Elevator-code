import java.util.Scanner;

class Elevator
	{
		static int floor=1;
		void selectedFloor(int f) {
			try
			{
				if(f>1||f>10)
				{
					throw new MyException("please select a floor between 1 to 10");
				}
				if(f>floor)
				{
					System.out.println("Going up");
					while(floor<f)
					{
						Thread.sleep(1000);
						System.out.println(".."+ ++floor);
					}
					System.out.println("....Ding");
				}
				else if(f<floor)
				{
					System.out.println("Going Down");
					while(floor>f)
					{
						Thread.sleep(1000);
						System.out.println(".."+ --floor);
					}
					System.out.println("...Ding");
				}
				else
				{
					System.out.println("you are arrived at your requested floor");
				}
				Thread.sleep(1000);
			}
			catch(MyException e)
			{
				System.out.println(e.getMessage());
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();

			}
		}
		
		void fireAlarm()
		{
			try
			{
				if(floor>1)
				{
					System.out.println("going down");
				
				while(floor>1)
				{
					Thread.sleep(1000);
					System.out.println(".."+ --floor);
				}
				
			}
			System.out.println("..Ding");
			System.out.println("please exit the building by pressing 'q'");
		}
	
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		}
}

public class ElevatorDriverClass {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Elevator e=new Elevator();
		char ch;
		do
		{
			System.out.println("please select an option");
			System.out.println("(s)elect a floor,(f)ire alarmm, (q)uit");
			ch=sc.next().toLowerCase().charAt(0);
			switch(ch)
			{
			case 's':System.out.println("Enter the floor you would like to go:");
			int select=sc.nextInt();
			e.selectedFloor(select);
			break;
			case 'f':System.out.println("Danger! you must exit the building now");
			e.fireAlarm();
			break;
			case 'q':System.out.println("moving out");
			break;
			default:System.out.println("invalid Selection");
			}
			}
			while(ch!='q');
			sc.close();
		

	}


}

class MyException extends Exception
{
	MyException(String s)
	{
		super (s);
	}
}