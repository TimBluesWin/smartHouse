package actors;

public class AirConditioner {
	double currentTemperature;
	
	public String setACTemperature(double temperature)
	{
		currentTemperature = temperature;
		String announcement = "Air Conditioner: Current Temperature is " + currentTemperature;
		System.out.println(announcement);
		return announcement;
	}
}
