package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.chassis.InvertChassis;
import org.usfirst.frc.team5951.robot.commands.chassis.ToggleShifters;
import org.usfirst.frc.team5951.robot.commands.gears.floorGearsIntake.IntakeGears;
import org.usfirst.frc.team5951.robot.commands.gears.floorGearsIntake.ToggleFloorIntakePosition;
import org.usfirst.frc.team5951.robot.commands.gears.hpGearsSubsystem.OpenGearsHP;
import org.usfirst.frc.team5951.robot.commands.gears.hpGearsSubsystem.ToggleGearsHP;
import org.usfirst.frc.team5951.robot.triggers.StartLift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//Joysticks
	public static final Joystick k_DRIVER_JOYSTICK = new Joystick(0);
	public static final XboxController k_SYSTEMS_DRIVER_STICK = new XboxController(1);

	//Yair buttons
	public static final JoystickButton k_TOGGLE_SHIFTERS = new JoystickButton(k_DRIVER_JOYSTICK, ButtonNumbers.TRIGGER.get());
	public static final JoystickButton k_INVERT_CHASSIS = new JoystickButton(k_DRIVER_JOYSTICK, ButtonNumbers.THUMB_BUTTON.get());
	
	//Yaniv buttons
	//HP Gears subsystem
	public static final JoystickButton k_TOGGLE_GEARS = new JoystickButton(k_SYSTEMS_DRIVER_STICK, ButtonNumbers.A.get());
	public static final JoystickButton k_OPEN_GEARS = new JoystickButton(k_SYSTEMS_DRIVER_STICK, ButtonNumbers.Y.get());
	
	//Floor gears intake
	public static final JoystickButton k_TOGGLE_FLOOR_INTAKE_POSITION = new JoystickButton(k_SYSTEMS_DRIVER_STICK, ButtonNumbers.B.get());
	public static final JoystickButton k_FLOOR_GEARS_INTAKE = new JoystickButton(k_SYSTEMS_DRIVER_STICK, ButtonNumbers.LB.get());

	//Lift
	public static final StartLift k_LIFT = new StartLift();

	public OI() {
		//Chassis buttons
		k_TOGGLE_SHIFTERS.whenPressed(new ToggleShifters());
		k_INVERT_CHASSIS.whenPressed(new InvertChassis());
		
		//Floor gears subsystem
		k_TOGGLE_FLOOR_INTAKE_POSITION.whenPressed(new ToggleFloorIntakePosition());
		k_FLOOR_GEARS_INTAKE.whileHeld(new IntakeGears());
		
		//Gears subsystem
		k_TOGGLE_GEARS.whenPressed(new ToggleGearsHP());
		k_OPEN_GEARS.whenPressed(new OpenGearsHP());
	}

}

enum ButtonNumbers {

	// XBOX Buttons
	A(1), 
	B(2),
	X(3),
	Y(4), 
	BUMPER_LEFT(5), 
	BUMPER_RIGHT(6),
	LB(5),
	RB(6),
	BACK(7), 
	START(8), 
	LEFT_STICK_BUTTON(9), 
	RIGHT_STICK_BUTTON(10), 
	XBOX_BUTTON(11),
	
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
