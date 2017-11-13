package controllers;

public class AirConditionerController {
	private int initialTemperature;
	
	public AirConditionerController(int initialTemperature)
	{
		this.initialTemperature = initialTemperature;
	}
	
	
	public double setTemperature(int temperature)
	{
		String settings = "";
		double temperatureNow = (temperature + initialTemperature)/2;
		double returnedTemperature = temperature;
		if(temperatureNow > 30)
		{
			settings = "Making the wind from air conditioner weaker.";
			returnedTemperature = 24;
		}
		else if(temperature < 21)
		{
			settings = "Making the wind from air conditioner stronger.";
			returnedTemperature = 24;
		}
		else
		{
			settings = "No Changes";
		}
		System.out.println(settings);
		return returnedTemperature;
			
		
	}
}
