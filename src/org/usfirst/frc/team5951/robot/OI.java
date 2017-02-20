package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.ascender.Lift;
import org.usfirst.frc.team5951.robot.commands.chassis.ToggleShifters;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.ToggleGearsSubsystem;
import org.usfirst.frc.team5951.robot.commands.intakeAndShooter.Intake;
import org.usfirst.frc.team5951.robot.commands.intakeAndShooter.Outtake;
import org.usfirst.frc.team5951.robot.commands.intakeAndShooter.Shoot;
import org.usfirst.frc.team5951.robot.triggers.StartLift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//Variables
	public static boolean isHelpersOpen = false;
	
	//Joysticks
	public static final Joystick k_DRIVER_JOYSTICK = new Joystick(0);
	public static final XboxController k_SYSTEMS_DRIVER_STICK = new XboxController(1);

	//Yair buttons
	public static final JoystickButton k_TOGGLE_SHIFTERS = new JoystickButton(k_DRIVER_JOYSTICK, ButtonNumbers.TRIGGER.get());
	
	//Yaniv buttons
	//Gears subsystem
	public static final JoystickButton k_TOGGLE_GEARS_SUBSYSTEM = new JoystickButton(k_SYSTEMS_DRIVER_STICK, ButtonNumbers.A.get());
	
	//Intake and shooter
	public static final JoystickButton k_INTAKE = new JoystickButton(k_SYSTEMS_DRIVER_STICK, ButtonNumbers.BUMPER_LEFT.get());
	public static final JoystickButton k_SHOOT = new JoystickButton(k_SYSTEMS_DRIVER_STICK, ButtonNumbers.BUMPER_RIGHT.get());
	public static final JoystickButton k_OUTTAKE = new JoystickButton(k_SYSTEMS_DRIVER_STICK, ButtonNumbers.B.get());
	
	public static final StartLift k_LIFT = new StartLift();

	public OI() {
		//Chassis buttons
		k_TOGGLE_SHIFTERS.whenPressed(new ToggleShifters());
		
		//Gears subsystem
		k_TOGGLE_GEARS_SUBSYSTEM.whenActive(new ToggleGearsSubsystem());
		
		//Intake and shooter buttons
		k_INTAKE.whileHeld(new Intake());
		k_SHOOT.whileHeld(new Shoot());
		k_OUTTAKE.whileHeld(new Outtake());
		
		k_LIFT.whenActive(new Lift());
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
