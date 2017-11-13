package smartHouse;

import actors.AirConditioner;
import actors.Alarm;
import actors.Blinds;
import controllers.AirConditionerController;
import controllers.AlarmController;
import controllers.BlindsController;
import sensor.Clock;
import sensor.Thermometer;
import sensor.WindSensor;

public class MainClass {
	public static void main(String[] args)
	{
		int time, windSpeed; 
		int temperature;
		
		Clock clock = new Clock();
		Thermometer thermometer = new Thermometer();
		WindSensor windSensor = new WindSensor();
		AirConditionerController ACCont = new AirConditionerController(18);
		AlarmController alCont = new AlarmController();
		BlindsController bCont = new BlindsController();
		AirConditioner AC = new AirConditioner();
		Alarm alarm = new Alarm();
		Blinds blinds = new Blinds();
		
		time = clock.setTime(1300);
		temperature = thermometer.setTemperature(32);
		windSpeed = windSensor.setWindSpeed(100);
		
		AC.setACTemperature(ACCont.setTemperature(temperature));
		alarm.setAlarm(alCont.setAlarm(windSpeed));
		blinds.closedBlinds(bCont.setBlinds(windSpeed));
		
	}
}
