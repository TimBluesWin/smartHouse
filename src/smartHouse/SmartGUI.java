package smartHouse;

import java.awt.*;
import java.awt.event.*;
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
	public String [] hour = new String[24];
	public String [] minute = new String[60];
	public int time;
	Clock clock = new Clock();
	Thermometer thermometer = new Thermometer();
	WindSensor windSensor = new WindSensor();
	AirConditionerController ACCont = new AirConditionerController(18);
	AlarmController alCont = new AlarmController();
	BlindsController bCont = new BlindsController();
	AirConditioner AC = new AirConditioner();
	Alarm alarm = new Alarm();
	Blinds blinds = new Blinds();
	
	
	
	public SmartGUI(){
		
		//setLayout(new BorderLayout());
		JFrame frame = new JFrame("smartGUI");
		JPanel panel = new JPanel();
		//Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		
		 Label tempLabel = new Label("temperature");
		 Label windLabel = new Label("wind speed");
		 Label timeLabel = new Label ("time");
		 Label resultLabel = new Label ("results");
		 Label hourLabel = new Label("hour");
		 Label minuteLabel = new Label("minute");
		 
		 
		 Font font = new Font("Serif", Font.ITALIC, 15);
		 
		 JSlider temper = new JSlider(JSlider.HORIZONTAL,0,100, 24);
		 
		 	temper.setMinorTickSpacing(2);
		    temper.setMajorTickSpacing(10);
		    temper.setPaintTicks(true);
		    temper.setPaintLabels(true);
		    temper.setFont(font);
		    
		 JSlider wind = new JSlider(JSlider.HORIZONTAL,0,100, 50);
			 
		 	wind.setMinorTickSpacing(2);
		    wind.setMajorTickSpacing(10);
		    wind.setPaintTicks(true);
		    wind.setPaintLabels(true);
		    wind.setFont(font);
		    
		    for (int i=0; i<24; i++)
			{
				hour[i]=Integer.toString(i);
			}
		    
		    for (int i=0; i<59; i++)
			{
				minute [i]=Integer.toString(i);
			}
		    
		 JComboBox hourList = new JComboBox(hour);
		 //frame.add(hourList);
		 JComboBox minuteList = new JComboBox(minute);
		 //frame.add(minuteList);
		 
		 JTextArea result = new JTextArea();
		 result.setColumns(20);
		 result.setRows(5);
		 result.setEditable(false);
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
		 temper.addChangeListener(new TemperatureListener());
	}
	
	public static void main (String[] args){
		
		SmartGUI app = new SmartGUI();
	}
	
	
	class TemperatureListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
					int currentTemperature;
					JSlider temper = (JSlider) e.getSource();
					temperature = temper.getValue();
					currentTemperature = thermometer.setTemperature(temperature);
					AC.setACTemperature(ACCont.setTemperature(currentTemperature));
					//temper
			}
	    }
		
}
