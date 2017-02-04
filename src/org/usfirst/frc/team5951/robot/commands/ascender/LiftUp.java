package org.usfirst.frc.team5951.robot.commands.ascender;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Ascender;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftUp extends Command {
	Ascender ascender = Robot.ascender;
	
    public LiftUp() {
        requires(ascender);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ascender.liftUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ascender.stopAscender();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
