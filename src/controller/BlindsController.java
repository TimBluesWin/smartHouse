package controller;

public class BlindsController {
	double windSpeed;
	
	public BlindsController(double windSpeed)
	{
		this.windSpeed = windSpeed;
	}
	
	public boolean setBlinds(double windSpeed)
	{
		String settings = "";
		boolean closedBlinds = false;
		if(windSpeed > 70)
		{
			settings = "Closing blinds for safety";
			closedBlinds = true;
		}
		else if(windSpeed < 20)
		{
			settings = "Opening blinds";
			closedBlinds = false;
		}
		
		return closedBlinds;
	}
}
