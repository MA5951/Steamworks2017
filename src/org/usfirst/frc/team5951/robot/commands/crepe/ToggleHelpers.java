package org.usfirst.frc.team5951.robot.commands.crepe;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Crepe;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleHelpers extends Command {

	private Crepe crepe;

	public ToggleHelpers() {
		crepe = Robot.crepe;

		setTimeout(0.135);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (this.crepe.isHelpersOpen) {
			this.crepe.closeHelpers();
			return;
		} else {
			this.crepe.openHelpers();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		this.crepe.stopHelpers();
		this.crepe.toggleIsHelpersOpen();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
