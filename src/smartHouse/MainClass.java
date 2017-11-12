package smartHouse;

import controller.AirConditionerController;

public class MainClass {
	public static void main(String[] args)
	{
		AirConditionerController acc = new AirConditionerController(24);
		System.out.println("Temperature is now " + acc.setTemperature(100));
		System.out.println("Temperature is now " + acc.setTemperature(15));
		System.out.println("Temperature is now " + acc.setTemperature(22));
	}
}
