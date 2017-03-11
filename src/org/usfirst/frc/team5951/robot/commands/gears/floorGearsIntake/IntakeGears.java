package org.usfirst.frc.team5951.robot.commands.gears.floorGearsIntake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.FloorGearsIntake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeGears extends Command {

	private FloorGearsIntake floorGearsIntake;
	
    public IntakeGears() {
    	this.floorGearsIntake = Robot.floorGearsIntake;
    	requires(this.floorGearsIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.floorGearsIntake.getToFloorIntakePosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.floorGearsIntake.intakeGears();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.floorGearsIntake.stopIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}