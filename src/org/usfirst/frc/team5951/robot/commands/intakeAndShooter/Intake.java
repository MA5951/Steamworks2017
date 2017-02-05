package org.usfirst.frc.team5951.robot.commands.intakeAndShooter;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.IntakeAndShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {
	private IntakeAndShooter intakeAndShooter;

	public Intake() {
		intakeAndShooter = Robot.intakeAndShooter;
		requires(intakeAndShooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		intakeAndShooter.intake();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}