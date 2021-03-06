package smartHouse;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import actors.AirConditioner;
import actors.Alarm;
import actors.Blinds;
import controllers.AirConditionerController;
import controllers.AlarmController;
import controllers.BlindsController;
import sensor.Clock;
import sensor.Thermometer;
import sensor.WindSensor;

public class SmartGUI extends Frame {
	
	public int temperature;
	public int windSpeed;
	//public String [] hour = new String[24];
	//public String [] minute = new String[60];
	public int time;
	static Clock clock = new Clock();
	static Thermometer thermometer = new Thermometer();
	static WindSensor windSensor = new WindSensor();
	static AirConditionerController ACCont = new AirConditionerController(18);
	static AlarmController alCont = new AlarmController();
	static BlindsController bCont = new BlindsController();
	static AirConditioner AC = new AirConditioner();
	static Alarm alarm = new Alarm();
	static Blinds blinds = new Blinds();
	static JFrame frame;
	static JPanel panel;
	static Label tempLabel;
	static Label windLabel;
	static Label timeLabel;
	static Label resultLabel;
	static Label hourLabel;
	static Label minuteLabel;
	static JSlider temper;
	static JSlider wind;
	static JTextField hourList;
	static JTextField minuteList;
	static JTextArea result;
	static Random rng = new Random();
	static Random rng2 = new Random();
	
	
	public SmartGUI(){
		
		//setLayout(new BorderLayout());
		frame = new JFrame("smartGUI");
		panel = new JPanel();
		//Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		
		 tempLabel = new Label("temperature");
		 windLabel = new Label("wind speed");
		 timeLabel = new Label ("time");
		 resultLabel = new Label ("results");
		 hourLabel = new Label("hour");
		 minuteLabel = new Label("minute");
		 
		 
		 Font font = new Font("Serif", Font.ITALIC, 15);
		 
		 temper = new JSlider(JSlider.HORIZONTAL,0,100, 35);
		 
		 	temper.setMinorTickSpacing(2);
		    temper.setMajorTickSpacing(10);
		    temper.setPaintTicks(true);
		    temper.setPaintLabels(true);
		    temper.setFont(font);
		    temper.setEnabled(false);
		    
		 wind = new JSlider(JSlider.HORIZONTAL,0,100, 65);
			 
		 	wind.setMinorTickSpacing(2);
		    wind.setMajorTickSpacing(10);
		    wind.setPaintTicks(true);
		    wind.setPaintLabels(true);
		    wind.setFont(font);
		    wind.setEnabled(false);
		    
		 hourList = new JTextField("18");
		 //frame.add(hourList);
		 minuteList = new JTextField("45");
		 //frame.add(minuteList);
		 hourList.setEditable(false);
		 minuteList.setEditable(false);
		 result = new JTextArea(15, 40);
		 result.setEditable(false);
		 result.setLineWrap(true);
		 result.setWrapStyleWord(false);
		 JScrollPane scrollPane = new JScrollPane(result);
		 add(scrollPane);
		 //frame.add(result);
		 panel.add(windLabel);
		 panel.add(wind);
		 panel.add(tempLabel);
		 panel.add(temper);
		 panel.add(timeLabel);
		 panel.add(hourLabel);
		 panel.add(hourList);
		 panel.add(minuteLabel);
		 panel.add(minuteList);
		 panel.add(resultLabel);
		 panel.add(result);
		 frame.add(panel);
		 frame.setVisible(true);
		 /**temper.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
							// TODO Auto-generated method stub
								int currentTemperature;
								JSlider temper = (JSlider) e.getSource();
								
								temperature = temper.getValue();
								currentTemperature = thermometer.setTemperature(temperature);
								String announcement = AC.setACTemperature(ACCont.setTemperature(currentTemperature));
								result.append(announcement + "\n");
								//temper
						}
		 });*/
	}
	
	public static void main (String[] args){
		
		SmartGUI app = new SmartGUI();
		int max = 3;
		int min = -3;
		int currentWindSpeed, currentTemperature, currentHour, currentMinute;
		int maxHour = 24;
		int maxMinute = 59;
		while(true)
		{
			int randomModifier = rng.nextInt(max + 1 -min) + min;
			int tempRandomModifier = rng2.nextInt(max + 1 - min) + min;
			currentWindSpeed = wind.getValue();
			currentWindSpeed += randomModifier;
			currentTemperature = temper.getValue();
			currentTemperature += tempRandomModifier;
			currentHour = Integer.parseInt(hourList.getText());
			currentMinute = Integer.parseInt(minuteList.getText());
			if(currentMinute + 1 > maxMinute)
			{
				if(currentHour + 1 > maxHour)
				{
					currentHour = 0;
					currentMinute = 0;
				}
				else
				{
				currentHour += 1;
				currentMinute = 0;
				}
			}
			else
			{
				currentMinute += 1;
			}
			if(currentMinute < 10)
			{
				minuteList.setText("0" + Integer.toString(currentMinute));
			}
			else
			{
				minuteList.setText(Integer.toString(currentMinute));
			}
			hourList.setText(Integer.toString(currentHour));
			//System.out.println(currentWindSpeed);
			wind.setValue(currentWindSpeed);
			temper.setValue(currentTemperature);
			currentWindSpeed = windSensor.setWindSpeed(currentWindSpeed);
			currentTemperature = thermometer.setTemperature(currentTemperature);
			alarm.setAlarm(alCont.setAlarm(currentWindSpeed));
			blinds.closedBlinds(bCont.setBlinds(currentWindSpeed));
			AC.setACTemperature(ACCont.setTemperature(currentTemperature));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

		
}
