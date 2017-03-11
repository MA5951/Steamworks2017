package org.usfirst.frc.team5951.robot;

public class RobotMap {
	// TWEEK Find real ports.

	/*
	 * Talons
	 */
	// Chassis
	// Robot B ports
	public static final int k_CHASSIS_RIGHT_FRONT_TALON = 3;
	public static final int k_CHASSIS_RIGHT_REAR_TALON = 4;
	public static final int k_CHASSIS_LEFT_FRONT_TALON = 1;
	public static final int k_CHASSIS_LEFT_REAR_TALON = 2;
	/*
	public static final int k_CHASSIS_RIGHT_FRONT_TALON = 1;
	public static final int k_CHASSIS_RIGHT_REAR_TALON = 2;
	public static final int k_CHASSIS_LEFT_FRONT_TALON = 4;
	public static final int k_CHASSIS_LEFT_REAR_TALON = 3; 
	*/
	
	// Floor gears subsystem
	public static final int k_GEARS_INTAKE_JOINT = 5;
	public static final int k_GEARS_INTAKE_MOTOR = 6;
	
	// Ascender ports
	public static final int k_ASCENDER_TALON = 7;

	/*
	 * Pneumatics
	 */
	// General
	public static final int k_PCM = 0;

	// Gears subsystem ports
	public static final int k_GEARS_SUBSYSTEM_SOLENOID_OPEN = 3;
	public static final int k_GEARS_SUBSYSTEM_SOLENOID_CLOSED = 2; 	//TODO In robot B they're 0 and 1
	
	public static final int k_GEARS_PUSHER_SOLENOID_OPEN = 4;
	public static final int k_GEARS_PUSHER_SOLENOID_CLOSE = 5;


	// Chassis
	public static final int k_CHASSIS_SHIFTERS_OPEN = 3;
	public static final int k_CHASSIS_SHIFTERS_CLOSE = 2; 	//TODO In robot B they're 2 and 3

	

	
	/*
	 * Sensors
	 */
	// Chassis Encoders	
	public static final int k_CHASSIS_ENCODER_LEFT_A = 4;
	public static final int k_CHASSIS_ENCODER_LEFT_B = 5;
	public static final int k_CHASSIS_ENCODER_RIGHT_A = 6;
	public static final int k_CHASSIS_ENCODER_RIGHT_B = 7;
	
	//Floor gears intake
	public static final int k_FLOOR_GEARS_INTAKE_ENCODER_A = 2;
	public static final int k_FLOOR_GEARS_INTAKE_ENCODER_B = 3;
	
	//Ultrasonic
	public static final int k_ULTRASONIC = 1; 
}
