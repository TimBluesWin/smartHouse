package controllers;

public class AirConditionerController {
	
	public int setTemperature(int temperature)
	{
		String settings = "";
		if(temperature > 30)
		{
			settings = "Making the wind from air conditioner weaker.";
			temperature = 24;
		}
		else if(temperature < 21)
		{
			settings = "Making the wind from air conditioner stronger.";
			temperature = 24;
		}
		else
		{
			settings = "No Changes";
		}
		return temperature;
			
		
	}
}
