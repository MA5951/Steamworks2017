package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command {

	private ChassisArcade chassisArcade;
	private double setpoint;

	public DriveStraight(double setpoint) {
		this.chassisArcade = Robot.chassisArcade;
		requires(chassisArcade);

		this.setpoint = setpoint;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.chassisArcade.switchToStrongGear();
		this.chassisArcade.resetGyro();
		this.chassisArcade.resetEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		this.chassisArcade.arcadeDrive(this.chassisArcade.kP_DISTANCE * this.getDistanceError(), this.chassisArcade.kP_ANGLE * this.chassisArcade.getAngle());
		SmartDashboard.putNumber("left encoder value: ", this.chassisArcade.getLeftEncoderValue());
		SmartDashboard.putNumber("right encoder value: ", this.chassisArcade.getRightEncoderValue());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isInAllowedRange();
	}

	// Called once after isFinished returns true
	protected void end() {
		SmartDashboard.putString("Finished", "Finished");
		this.chassisArcade.stopChassis();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		SmartDashboard.getString("Interrupted", "interrupted");
		end();
	}

	protected double getDistanceError() {
		double error = setpoint - this.chassisArcade.getAvgEncoderValue();
		
		return -error;
	}

	protected boolean isInAllowedRange() {
		return (Math.abs(this.chassisArcade.getAngle()) < 2 && Math.abs(getDistanceError()) < 0.15);
	}
}
