package org.usfirst.frc.team5951.robot.commands.gears.hpGearsSubsystem;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.HPGearsSubsystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class IntakeGearsHP extends InstantCommand {

	HPGearsSubsystem hpGearsSubsystem;
	
    public IntakeGearsHP() {
        hpGearsSubsystem = Robot.hpGearsSubsystem;
    }

    // Called once when the command executes
    protected void initialize() {
    	new ClosePushersHP().start();
    	new OpenGearsHP().start();
    }

}