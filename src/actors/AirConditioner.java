package actors;

public class AirConditioner {
	int currentTemperature;
	
	public void setACTemperature(int temperature)
	{
		currentTemperature = temperature;
		System.out.println("Current Temperature is " + currentTemperature);
	}
}
