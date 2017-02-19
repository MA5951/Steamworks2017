package org.usfirst.frc.team5951.robot;

public class RobotMap {
	//TWEEK Find real ports.
	
	//Talons
	//Chassis
	public static final int k_CHASSIS_RIGHT_FRONT_TALON = 2;
	public static final int k_CHASSIS_RIGHT_REAR_TALON = 4;
	public static final int k_CHASSIS_LEFT_FRONT_TALON = 1;
	public static final int k_CHASSIS_LEFT_REAR_TALON = 3;
	

	//Intake talons
	public static final int k_INTAKE_FRONT_TALON=5;
	public static final int k_INTAKE_REAR_TALON=6;
	
	//Ascender ports
	public static final int k_ASCENDER_TALON = 7;
	
	//Pneumatics
	public static final int k_PCM = 0;
	
	//Crepe ports
	public static final int k_CREPE_PISTON_FORWARD = 0;
	public static final int k_CREPE_PISTON_REVERSE = 1;
	/*
	public static final int k_LEFT_CREPE_TALON  = 720; // Needs to be fixed.
	public static final int k_RIGHT_CREPE_TALON = 1080; //Needs to be fixed.
	this is for talons we might use for the crepe
	
		COMMANDS NEED TO BE MADE IF WE WANT TO USE THIS
	*/
	//Chassis
	public static final int k_CHASSIS_SHIFTERS_OPEN = 2;
	public static final int k_CHASSIS_SHIFTERS_CLOSE = 3;
	
	
	//Sensors
	//Chassis Encoders
	public static final int k_CHASSIS_ENCODER_LEFT_A = 4;
	public static final int k_CHASSIS_ENCODER_LEFT_B = 5;
	public static final int k_CHASSIS_ENCODER_RIGHT_A = 6;
	public static final int k_CHASSIS_ENCODER_RIGHT_B = 7;
}
