package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearsSubsystem extends Subsystem {

	// Solenoids
	private DoubleSolenoid gearsSubsystemSolenoid;

	private boolean isOpen;

	public GearsSubsystem() {
		this.gearsSubsystemSolenoid = new DoubleSolenoid(RobotMap.k_PCM, RobotMap.k_GEARS_SUBSYSTEM_SOLENOID_OPEN,
				RobotMap.k_GEARS_SUBSYSTEM_SOLENOID_CLOSED);
		
		this.gearsSubsystemSolenoid.set(Value.kReverse);
		
		this.isOpen = false;
	}

	/**
	 * Closes the subsystems
	 */
	public void closeGearsSubsystem() {
		this.gearsSubsystemSolenoid.set(Value.kReverse);
		this.isOpen = false;
	}

	/**
	 * Opens the subsystem
	 */
	public void openGearsSubsystem() {
		this.gearsSubsystemSolenoid.set(Value.kReverse);
		this.isOpen = !this.isOpen;
	}

	/**
	 * Toggles between the open value of the solenoid or the wrong one.
	 */
	public void toggleSolenoids() {
		this.gearsSubsystemSolenoid.set(isOpen ? Value.kReverse : Value.kForward);
	}

	public void initDefaultCommand() {

	}
}
