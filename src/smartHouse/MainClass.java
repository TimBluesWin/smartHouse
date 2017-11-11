package smartHouse;

import controller.AirConditionerController;

public class MainClass {
	public static void main(String[] args)
	{
		AirConditionerController acc = new AirConditionerController(24);
		System.out.println(acc.setTemperature(100));
	}
}
