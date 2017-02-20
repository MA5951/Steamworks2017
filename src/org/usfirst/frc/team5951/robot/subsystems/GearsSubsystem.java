package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearsSubsystem extends Subsystem {

	// Motors
	private CANTalon gearsMotor;

	// Sensors
	private Encoder gearsEncoder;

	// Controllers
	private PIDController gearsController;

	// Other variables
	// TODO Find real number when able
	// Encoder variables
	private final double k_ENCODERS_DISTANCE_PER_PULSE = 1.0 / 360;

	// Controller variables
	private final double k_GEARS_KP = 0.3;
	private final double k_GEARS_KI = 0;
	private final double k_GEARS_KD = 0;

	private final double k_SETPOINT_OPEN = 2;
	private final double k_SETPOINT_CLOSE = 0;

	public boolean isOpen;

	public GearsSubsystem() {
		this.gearsMotor = new CANTalon(RobotMap.k_GEARS_SUBSYSTEM_TALON);
		this.gearsMotor.setPIDSourceType(PIDSourceType.kDisplacement);

		this.gearsEncoder = new Encoder(RobotMap.k_GEARS_SUBSYSTEM_ENCODER_A, RobotMap.k_GEARS_SUBSYSTEM_ENCODER_B);
		this.gearsEncoder.setDistancePerPulse(k_ENCODERS_DISTANCE_PER_PULSE);
		this.gearsEncoder.setPIDSourceType(PIDSourceType.kDisplacement);

		this.gearsController = new PIDController(k_GEARS_KP, k_GEARS_KI, k_GEARS_KD, gearsEncoder, gearsMotor);
		this.gearsController.setSetpoint(k_SETPOINT_CLOSE);
		this.gearsController.enable();
	}

	/**
	 * Resets the encoder
	 */
	public void resetEncoder() {
		this.gearsEncoder.reset();
	}

	/**
	 * Closes the subsystems
	 */
	public void closeGearsSubsystem() {
		this.gearsController.setSetpoint(this.k_SETPOINT_CLOSE);
		this.gearsController.enable();
	}

	/**
	 * Opens the subsystem
	 */
	public void openGearsSubsystem() {
		this.gearsController.setSetpoint(this.k_SETPOINT_OPEN);
		this.gearsController.enable();
	}
	
	public void toggleIsOpen(){
		isOpen = !isOpen;
	}
	
	public void stopGearsSubsystem(){
		this.gearsController.disable();
	}

	public void initDefaultCommand() {
		
	}
}
