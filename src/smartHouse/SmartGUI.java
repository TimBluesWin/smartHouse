package smartHouse;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	
	
	
	public SmartGUI(){
		
		setLayout(new BorderLayout());
		JFrame frame = new JFrame("smartGUI");
		Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(800, 600);
		
		 Label tempLabel = new Label("temperature");
		 Label windLabel = new Label("wind speed");
		 Label timeLabel = new Label ("time");
		 Label resultLabel = new Label ("results");
		 Label hourLabel = new Label("hour");
		 Label minuteLabel = new Label("minute");
		 
		 c.add(tempLabel);
		 c.add(windLabel);
		 c.add(timeLabel);
		 c.add(resultLabel);
		 c.add(hourLabel);
		 c.add(minuteLabel);
		 
		 Font font = new Font("Serif", Font.ITALIC, 15);
		 
		 JSlider temper = new JSlider(JSlider.HORIZONTAL,0,100, 24);
		 c.add(temper);
		 
		 	temper.setMinorTickSpacing(2);
		    temper.setMajorTickSpacing(10);
		    temper.setPaintTicks(true);
		    temper.setPaintLabels(true);
		    temper.setFont(font);
		    
		 JSlider wind = new JSlider(JSlider.HORIZONTAL,0,100, 50);
		 c.add(wind);
			 
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
		 c.add(hourList);
		 JComboBox minuteList = new JComboBox(minute);
		 c.add(minuteList);
		 
		 JTextField result = new JTextField();
		 
	}
	
	public static void main (String[] args){
		
		SmartGUI app = new SmartGUI();
	}
	
	
	class TemperatureListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
					
					JSlider temper = (JSlider) e.getSource();
					//temper
			}
	    }
		
}
