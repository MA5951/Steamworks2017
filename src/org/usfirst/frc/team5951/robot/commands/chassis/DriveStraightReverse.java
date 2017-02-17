package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightReverse extends Command {
	private ChassisArcade chassisArcade;
	private double setpoint;
	
    public DriveStraightReverse(double setpoint) {
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
    	SmartDashboard.putNumber("left encoder value: ", this.chassisArcade.getLeftEncoderValue());
    	SmartDashboard.putNumber("right encoder value: ", this.chassisArcade.getRightEncoderValue());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isInAllowedRange();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    protected double getDistanceError(){
    	return this.chassisArcade.getLeftEncoderValue() - this.setpoint;
    }
    
    protected boolean isInAllowedRange(){
    	return ((this.chassisArcade.getAngle() > -2 && this.chassisArcade.getAngle() < 2) && (this.chassisArcade.getLeftEncoderValue() > setpoint - 0.05 && this.setpoint < setpoint + 0.05));
    }
}
