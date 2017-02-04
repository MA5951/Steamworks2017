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

	public void liftUp() {
		ascenderTalon.set(1);
	}

	public void liftDown() {
		ascenderTalon.set(-1);
	}

	public void stopAscender() {
		ascenderTalon.set(0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
