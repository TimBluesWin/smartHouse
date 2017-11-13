package controllers;

public class BlindsController {

	
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
		System.out.println(settings);
		return closedBlinds;
	}
}
