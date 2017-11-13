package controllers;

public class AlarmController {
	boolean alarm = false;
	
	public AlarmController(boolean alarm)
	{
		this.alarm = alarm;
	}
	
	public boolean setAlarm(double windSpeed)
	{
		String settings = "";
		boolean alarm = false;
		if(windSpeed > 70)
		{
			settings = "Sounding alarm";
			alarm = true;
		}
		else if(windSpeed < 20)
		{
			settings = "Turning off alarm";
			alarm = false;
		}
		
		return alarm;
	}
}
