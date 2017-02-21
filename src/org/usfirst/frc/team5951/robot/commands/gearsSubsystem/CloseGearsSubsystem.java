package org.usfirst.frc.team5951.robot.commands.gearsSubsystem;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.GearsSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CloseGearsSubsystem extends InstantCommand {

	public GearsSubsystem gearsSubsystem;
	
    public CloseGearsSubsystem() {
        gearsSubsystem = Robot.gearsSubsystem;
        
        requires(gearsSubsystem);
    }

    // Called once when the command executes
    protected void initialize() {
    	this.gearsSubsystem.closeGearsSubsystem();
    }
}
