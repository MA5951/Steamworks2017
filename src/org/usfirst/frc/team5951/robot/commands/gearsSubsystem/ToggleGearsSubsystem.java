package org.usfirst.frc.team5951.robot.commands.gearsSubsystem;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.GearsSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToggleGearsSubsystem extends InstantCommand {

	private GearsSubsystem gearsSubsystem;
	
    public ToggleGearsSubsystem() {
    	gearsSubsystem = Robot.gearsSubsystem;
        requires(gearsSubsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	this.gearsSubsystem.toggleSolenoids();
    }
}
