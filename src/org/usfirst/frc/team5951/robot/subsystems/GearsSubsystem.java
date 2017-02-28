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


	public GearsSubsystem() {
		this.gearsSubsystemSolenoid = new DoubleSolenoid(RobotMap.k_PCM, RobotMap.k_GEARS_SUBSYSTEM_SOLENOID_OPEN,
				RobotMap.k_GEARS_SUBSYSTEM_SOLENOID_CLOSED);
		
		this.gearsSubsystemSolenoid.set(Value.kReverse);
		
	}

	/**
	 * Closes the subsystems
	 */
	public void closeGearsSubsystem() {
		this.gearsSubsystemSolenoid.set(Value.kReverse);
	}

	/**
	 * Opens the subsystem
	 */
	public void openGearsSubsystem() {
		this.gearsSubsystemSolenoid.set(Value.kForward);
	}

	/**
	 * Toggles between the open value of the solenoid or the wrong one.
	 */
	public void toggleSolenoids() {
		if(this.gearsSubsystemSolenoid.get().equals(Value.kForward)){
			this.gearsSubsystemSolenoid.set(Value.kReverse);
		} else {
			this.gearsSubsystemSolenoid.set(Value.kForward);
		}
		
	}

	public void initDefaultCommand() {

	}
}