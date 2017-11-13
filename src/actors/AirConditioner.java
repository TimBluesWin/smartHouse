package actors;

public class AirConditioner {
	double currentTemperature;
	
	public void setACTemperature(double temperature)
	{
		currentTemperature = temperature;
		System.out.println("Current Temperature is " + currentTemperature);
	}
}
