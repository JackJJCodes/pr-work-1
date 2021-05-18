import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIAirConditioner implements ActionListener 
{
	// Declaring in this scope so that any method can use it:
	private static int currentTemp = 24;
	private static JLabel label;
	private static JLabel labelSetTimer;
	private static JLabel labelSmartMode;
	private static JLabel labelSmartModeOutput;
	
	private static JFrame frame;
	
	private static JPanel panel;
	
	private static JButton buttonIncreaseTemp;
	private static JButton buttonDecreaseTemp;
	private static JButton buttonSetTimer;
	private static JButton heaterButton;
	private static JButton coolerButton;
	private static JButton smartModeButton;
	
	public GUIAirConditioner()
	{
		frame = new JFrame();  // Creating an instance of JFrame
		
		// Buttons:
		
		// 1: Increase temperature button:
		buttonIncreaseTemp = new JButton("Increase");
		buttonIncreaseTemp.addActionListener(this);
		
		// 2: Decrease temperature button:
		buttonDecreaseTemp = new JButton("Decrease");
		buttonDecreaseTemp.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						currentTemp--;
						label.setText("The current temperature is " + currentTemp + "°C");
					}
				});
		
		// 3: Set-Timer button:
		// Setting up the userText for Timer:
		JTextField userInput = new JTextField(20);
		// userInput.setBounds(50, 20, 165, 25);
		buttonSetTimer = new JButton("Set Timer");
		// buttonSetTimer.setBounds(10, 80, 80, 25);
		buttonSetTimer.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int hours = Integer.parseInt(userInput.getText());
						label.setText("Timer has been set for " + hours + " hours.");
					}
				});

		// 3: Set-Timer components:
		
		// Setting up Label for Timer:
		labelSetTimer = new JLabel("Set Timer:");
		// labelSetTimer.setBounds(10, 20, 80, 25);
		
		
		
		
		// 4: Smart Mode:
		
		labelSmartMode = new JLabel("Smart Mode: Enter the current temp");
		// labelSmartMode.setBounds(10, 20, 80, 25);
		JTextField smartModeInput = new JTextField(20);
		// smartModeInput.setBounds(50, 80, 165, 25);
		smartModeButton = new JButton("Show best temperature");
		// buttonSetTimer.setBounds(10, 80, 80, 25);
		smartModeButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int tempSmartMode = Integer.parseInt(smartModeInput.getText());
						int finalSMTemp = 0;
						
						//  Logic:
						if (tempSmartMode >= 40 && tempSmartMode <= 50)
						{
							finalSMTemp = 20;
							label.setText("You should set the temp at " + finalSMTemp + "°C");
						}
						else if (tempSmartMode >= 30 && tempSmartMode <= 40)
						{
							finalSMTemp = 24;
							label.setText("You should set the temp at " + finalSMTemp + "°C");
						}
						else
						{
							finalSMTemp = 16;
							label.setText("You should set the temp at " + finalSMTemp + "°C");
						}
						
						
					}
				});
		
		
		
		
		// 5: Heater mode:
		heaterButton = new JButton("Heater mode");
		// heaterButton.setBounds(10, 50, 80, 25);
		heaterButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						currentTemp = 30;
					}
				});
		
		
		// 6: Cooler mode:
		coolerButton = new JButton("Cooler mode");
		// coolerButton.setBounds(20, 50, 50, 25);
		coolerButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						currentTemp = 16;
					}
				});
		
		
		// Displaying current temperature:
		label = new JLabel("The current temperature is 24°C");
		
		
		// Panel set-up:
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 20, 60));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(buttonIncreaseTemp);
		panel.add(buttonDecreaseTemp);
		panel.add(labelSetTimer);
		panel.add(userInput);		
		panel.add(buttonSetTimer);
		panel.add(heaterButton);
		panel.add(coolerButton);
		panel.add(labelSmartMode);
		panel.add(smartModeInput);
		panel.add(smartModeButton);
		
		
		// Frame Set-Up:
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("AC Remote");
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		currentTemp++;
		label.setText("The current temperature is " + currentTemp + "°C");
	}
	
	
	
	
	
	public static void main(String args[])
	{
		new GUIAirConditioner();
	}




	
}
