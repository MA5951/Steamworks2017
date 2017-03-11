package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class HPGearsSubsystem extends Subsystem {

	// Solenoids
	private DoubleSolenoid gearsSubsystemSolenoid;
	private DoubleSolenoid gearsPusher;
	
	// Variables
	private boolean isGearsOpen;
	private boolean isPushersOpen;

	public HPGearsSubsystem() {
		this.gearsSubsystemSolenoid = new DoubleSolenoid(RobotMap.k_PCM, RobotMap.k_GEARS_SUBSYSTEM_SOLENOID_OPEN,
				RobotMap.k_GEARS_SUBSYSTEM_SOLENOID_CLOSED);
		
		this.gearsPusher = new DoubleSolenoid(RobotMap.k_PCM, RobotMap.k_GEARS_PUSHER_SOLENOID_OPEN, RobotMap.k_GEARS_PUSHER_SOLENOID_CLOSE);

		this.gearsSubsystemSolenoid.set(Value.kReverse);
		
		this.gearsPusher.set(Value.kReverse);

	}

	/**
	 * Closes the subsystems
	 */
	public void closeGearsSubsystem() {
		this.gearsSubsystemSolenoid.set(Value.kReverse);
		this.isGearsOpen = false;
		SmartDashboard.putString("Gears position: ", "Closed");
	}

	/**
	 * Opens the subsystem
	 */
	public void openGearsSubsystem() {
		this.gearsSubsystemSolenoid.set(Value.kForward);
		this.isGearsOpen = true;
		SmartDashboard.putString("Gears position: ", "Opened");
	}

	/**
	 * Toggles between the open value of the solenoid or the wrong one.
	 */
	public void toggleSolenoids() {
		if(this.isGearsOpen){
			this.closeGearsSubsystem();
		} else {
			this.openGearsSubsystem();
		}
	}
	
	/**
	 * Closes the pushers
	 */
	public void closePushers() {
		this.gearsPusher.set(Value.kReverse);
		this.isPushersOpen = false;
		SmartDashboard.putString("Gears position: ", "Closed");
	}

	/**
	 * Opens the pushers
	 */
	public void openPushers() {
		this.gearsPusher.set(Value.kForward);
		this.isPushersOpen = true;
		SmartDashboard.putString("Gears position: ", "Opened");
	}
	
	/**
	 * Toggles the pushers
	 */
	public void togglePushers(){
		if(this.isPushersOpen){
			this.closeGearsSubsystem();
		} else {
			this.openGearsSubsystem();
		}
	}

	public boolean getIsPushersOpen(){
		return this.isPushersOpen;
	}
	
	public boolean getIsGearsOpen(){
		return this.isGearsOpen;
	}
	
	public void initDefaultCommand() {
		
	}
}