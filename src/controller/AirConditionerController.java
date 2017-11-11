package controller;

public class AirConditionerController {
	//TemperatureSensor ts;
	int temperature;
	
	public AirConditionerController(int temperature)
	{
		this.temperature = temperature;
	}
	
	public String setTemperature(int temperature)
	{
		String settings = "";
		if(temperature > 30)
		{
			settings = "Making the wind from air conditioner weaker.";
		}
		else if(temperature < 21)
		{
			settings = "Making the wind from air conditioner stronger.";
		}
		return settings;
	}
}
