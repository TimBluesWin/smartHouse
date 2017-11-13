package actors;

public class Blinds {
	boolean closed = false;
	
	public void closedBlinds(boolean closedBlinds)
	{
		closed = closedBlinds;
		if(closed)
		{
			System.out.println("Blinds are closed!");
		}
		else
		{
			System.out.println("Blinds are opened!");
		}
	}
}
