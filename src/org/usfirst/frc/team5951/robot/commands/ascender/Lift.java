package org.usfirst.frc.team5951.robot.commands.ascender;

import org.usfirst.frc.team5951.robot.OI;
import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Ascender;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lift extends Command {

	private Ascender ascender;
	
    public Lift() {
        ascender = Robot.ascender;
        requires(ascender);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ascender.setPower(OI.k_SYSTEMS_DRIVER_STICK.getTriggerAxis(Hand.kRight) - OI.k_SYSTEMS_DRIVER_STICK.getTriggerAxis(Hand.kLeft));
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
