package org.usfirst.frc.team5951.robot.commands.gearsSubsystem;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.GearsSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenGearsSubsystem extends InstantCommand {

	GearsSubsystem gearsSubsystem;

	public OpenGearsSubsystem() {
		gearsSubsystem = Robot.gearsSubsystem;

		requires(gearsSubsystem);
	}

	// Called once when the command executes
	protected void initialize() {
		gearsSubsystem.openGearsSubsystem();
	}

	protected void interrupted() {
		gearsSubsystem.stopGearsSubsystem();
	}

}
