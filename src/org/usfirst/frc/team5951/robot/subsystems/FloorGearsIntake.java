package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FloorGearsIntake extends Subsystem {

	// Talons
	private CANTalon intakeMotor;
	private CANTalon jointMotor;

	// Encoders
	private Encoder jointEncoder;

	// PIDController
	private PIDController pidController;

	// Variables
	private final double k_JOINT_KP = 0.05;
	private final double k_JOINT_KI = 0;
	private final double k_JOINT_KD = 0;

	private final double k_JOINT_FLOOR_INTAKE_ANGLE = 23.5;
	private final double k_JOINT_GEARS_RELEASE_ANGLE = -7;

	private final double k_JOINT_ABS_TOLERANCE = 1;

	private final double k_ENCODER_DISTANCE_PER_PULSE = 1.0 / 1.0;

	public boolean isUp;

	public FloorGearsIntake() {
		intakeMotor = new CANTalon(RobotMap.k_GEARS_INTAKE_MOTOR);
		this.intakeMotor.changeControlMode(TalonControlMode.PercentVbus);

		jointMotor = new CANTalon(RobotMap.k_GEARS_INTAKE_JOINT);
		this.jointMotor.changeControlMode(TalonControlMode.PercentVbus);

		this.jointEncoder = new Encoder(RobotMap.k_FLOOR_GEARS_INTAKE_ENCODER_A,
				RobotMap.k_FLOOR_GEARS_INTAKE_ENCODER_B);
		this.jointEncoder.setDistancePerPulse(k_ENCODER_DISTANCE_PER_PULSE);
		this.jointEncoder.setReverseDirection(true);
		this.jointEncoder.reset();

		this.pidController = new PIDController(k_JOINT_KP, k_JOINT_KI, k_JOINT_KD, jointEncoder, jointMotor);
		this.pidController.setSetpoint(k_JOINT_GEARS_RELEASE_ANGLE);
		this.pidController.setAbsoluteTolerance(this.k_JOINT_ABS_TOLERANCE);
		this.pidController.setOutputRange(-1, 0.3);
		this.pidController.enable();

		isUp = true;
	}

	/**
	 * Gets the joint to a position fitted to intake the gear from the floor
	 */
	public void getToFloorIntakePosition() {
		this.pidController.setSetpoint(k_JOINT_FLOOR_INTAKE_ANGLE);
		this.isUp = false;
	}

	/**
	 * Gets the joint to a position fitted to intake the gear from the floor
	 */
	public void getToGearReleasePosition() {
		this.pidController.setSetpoint(k_JOINT_GEARS_RELEASE_ANGLE);

		this.isUp = true;
	}

	/**
	 * Starts to intake the gears
	 */
	public void intakeGears() {
		this.getToFloorIntakePosition();
		this.intakeMotor.set(0.8);
	}

	public void stopIntake() {
		this.intakeMotor.set(0);
	}
	
	public double getEncoderDistance(){
		return this.jointEncoder.getDistance();
	}
	
	public void manualRaise(){
		this.pidController.disable();
		this.jointMotor.set(-0.95);
		this.jointEncoder.reset();
		this.isUp = true;
	}
	
	public void reEnablePID(){
		this.jointMotor.set(0);
		this.pidController.enable();
		this.pidController.setSetpoint(k_JOINT_GEARS_RELEASE_ANGLE);
	}

	public void initDefaultCommand() {

	}

}
