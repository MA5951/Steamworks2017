package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command {

	private ChassisArcade chassisArcade;
	private double angle;
	
    public TurnToAngle(double angle) {
        chassisArcade = Robot.chassisArcade;
        requires(chassisArcade);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.chassisArcade.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(angle < 180){
    		this.chassisArcade.setLeftPower(this.getError() * this.chassisArcade.kP_ANGLE);
    		this.chassisArcade.setRightPower(-(this.getError() * this.chassisArcade.kP_ANGLE));
    	} else {
    		this.chassisArcade.setLeftPower(-(this.getError() * this.chassisArcade.kP_ANGLE));
    		this.chassisArcade.setRightPower(this.getError() * this.chassisArcade.kP_ANGLE);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isInAllowedRange();
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.chassisArcade.stopChassis();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    /**
     * Checks if the chassis has gotten to the angle wanted.
     * @return
     */
    protected boolean isInAllowedRange(){
    	return (this.chassisArcade.getAngle() > angle - 2 && this.chassisArcade.getAngle() < angle + 2);
    }
    
    protected double getError(){
    	return this.angle - this.chassisArcade.getAngle();
    }
}
