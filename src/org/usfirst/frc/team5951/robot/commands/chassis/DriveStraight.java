package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

	private ChassisArcade chassisArcade;
	private double setpoint;
	
    public DriveStraight(double setpoint) {
        this.chassisArcade = Robot.chassisArcade;
        requires(chassisArcade);
        
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.chassisArcade.switchToStrongGear();
    	this.chassisArcade.resetGyro();
    	this.chassisArcade.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.chassisArcade.arcadeDrive(this.chassisArcade.kP_DISTANCE * this.getDistanceError(), this.chassisArcade.kP_ANGLE * this.chassisArcade.getAngle());
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
    
    protected double getDistanceError(){
    	return this.chassisArcade.getEncoderValue() - this.setpoint;
    }
    
    protected boolean isInAllowedRange(){
    	return ((this.chassisArcade.getAngle() > -2 && this.chassisArcade.getAngle() < 2) && (this.chassisArcade.getEncoderValue() > setpoint - 2 && this.setpoint < setpoint + 2));
    }
}
