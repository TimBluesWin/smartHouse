package controller;

public class AirConditionerController {
	TemperatureSensor ts;
	int temperature;
	
	public AirConditionerController(int temperature)
	{
		ts = new TemperatureSensor();
		this.temperature = temperature;
	}
	
	public double setTemperature()
	{
		String setting = "";
		if(ts.getTemperature() > 30)
		{
			temperature = 24;
		}
		else if(ts.getTemperature() < 21)
		{
			temperature = 24;
		}
		return temperature;
	}
}
