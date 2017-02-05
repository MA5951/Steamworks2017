package org.usfirst.frc.team5951.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	
	public static final Joystick k_DRIVER_JOYSTICK = new Joystick(0);
	public static final XboxController k_SYSTEMS_DRIVER_STICK = new XboxController(1);
	
	public static final JoystickButton k_TOGGLE_SHIFTERS = new JoystickButton(k_DRIVER_JOYSTICK, ButtonNumbers.k_TRIGGER.getValue());
	
	public OI(){
		
	}
	
}

enum ButtonNumbers{
	
	k_TRIGGER(1),
	k_THUMB_BUTTON(2);
	
	private int value;
	ButtonNumbers(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
