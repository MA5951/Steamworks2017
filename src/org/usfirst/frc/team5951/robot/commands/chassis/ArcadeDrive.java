package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.OI;
import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.ChassisArcade;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDrive extends Command {

	private ChassisArcade chassisArcade;
	
    public ArcadeDrive() {
        chassisArcade = Robot.chassisArcade;
        requires(chassisArcade);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassisArcade.arcadeDrive(getYPower(), getXPower());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    /**
     * Calculates power to send to Y value, if under the deadband, sends 0. else, sends the power from the joystick after
     * compensation on the lost power values from the deadband.
     * @return Y value - value to send to the robot on the Y axis
     */
    protected double getYPower(){
    	double joystickY = OI.k_DRIVER_JOYSTICK.getY();
    	if(Math.abs(joystickY) < ChassisArcade.k_JOYSTICK_DEADBAND)
    		return 0;
    	return joystickY * (1 / ChassisArcade.k_JOYSTICK_DEADBAND);
    }
    
    /**
     * Calculates power to send to X value, if under the deadband, sends 0. else, sends the power from the joystick after
     * compensation on the lost power values from the deadband.
     * @return X value - value to send to the robot on the x axis
     */
    protected double getXPower(){
    	double joystickX = OI.k_DRIVER_JOYSTICK.getX();
    	
    	if(Math.abs(joystickX) < ChassisArcade.k_JOYSTICK_DEADBAND)
    		return 0;
    	return joystickX * (1 / ChassisArcade.k_JOYSTICK_DEADBAND);
    }
}
