package actors;

public class Alarm {
	boolean active = false;
	
	public void setAlarm(boolean isActive)
	{
		active = isActive;
		if(active)
		{
			System.out.println("Beep! Beep!");
		}
		else
		{
			System.out.println("...........");
		}
	}
}
