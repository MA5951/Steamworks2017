package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ascender extends Subsystem {
	private CANTalon ascenderTalon;

	public Ascender() {
		ascenderTalon = new CANTalon(RobotMap.k_ASCENDER_TALON);
		ascenderTalon.changeControlMode(TalonControlMode.PercentVbus);
	}

	/**
	 * Lifts the robot up the rope
	 */
	public void liftUp() {
		ascenderTalon.set(1);
	}

	/**
	 * Lifts the robot down the rope
	 */
	public void liftDown() {
		ascenderTalon.set(-1);
	}

	/**
	 * Stops the robot in it's place.
	 */
	public void stopAscender() {
		ascenderTalon.set(0);
	}
	
	/**
	 * Sets the power to the ascender motors.
	 * @param power
	 */
	public void setPower(double power){
		this.ascenderTalon.set(power);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
