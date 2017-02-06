package org.usfirst.frc.team5951.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static final Joystick k_DRIVER_JOYSTICK = new Joystick(0);
	public static final XboxController k_SYSTEMS_DRIVER_STICK = new XboxController(1);

	public static final JoystickButton k_TOGGLE_SHIFTERS = new JoystickButton(k_DRIVER_JOYSTICK, ButtonNumbers.TRIGGER.getValue());

	public OI() {

	}

}

enum ButtonNumbers {

	// XBOX Buttons
	// TODO Check if numbers are correct.
	X(1), 
	A(2), 
	B(3), 
	Y(4), 
	BUMPER_LEFT(5), 
	BUMPER_RIGHT(7),
	LB(5),
	RB(7),
	BACK(9), 
	START(10), 
	LEFT_STICK_BUTTON(11), 
	RIGHT_STICK_BUTTON(12), 
	XBOX_BUTTON(13),
	
	//Logitech Extreme 3D Buttons
	TRIGGER(1),
	THUMB_BUTTON(2),
	BOTTOM_LEFT(3),
	BUTTOM_RIGHT(4),
	TOP_LEFT(5),
	TOP_RIGHT(6);

	private int value;

	private ButtonNumbers(int value) {
			this.value = value;
		}

	public int get() {
		return value;
	}
}
