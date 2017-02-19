package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;

//import com.ctre.CANTalon;
//for crepe talons if we use them

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * 
 * @author Omer Libai
 *
 */
public class Crepe extends Subsystem {

	public DoubleSolenoid crepeSolenoid;
	
	public CANTalon crepeHelperLeft;
	public CANTalon crepeHelperRight;
	
	public boolean isCrepeOpen;
	
	public boolean isHelpersOpen;
	
	/**
	 * crepe constructor
	 */
	public Crepe() {
		crepeSolenoid = new DoubleSolenoid(RobotMap.k_CREPE_PISTON_FORWARD, RobotMap.k_CREPE_PISTON_REVERSE);
		
		isCrepeOpen = false;
		
		crepeHelperLeft = new CANTalon(RobotMap.k_CREPE_HELPER_LEFT_TALON);
		crepeHelperRight = new CANTalon(RobotMap.k_CREPE_HELPER_RIGHT_TALON);
		
		crepeHelperRight.setInverted(true);
		
		isHelpersOpen = false;
	}

	/**
	 * open's the crepe
	 */
	public void openCrepe() {
		crepeSolenoid.set(Value.kForward);
		isCrepeOpen = true;
	}

	/**
	 * close's the crepe.
	 */
	public void closeCrepe() {
		crepeSolenoid.set(Value.kReverse);
		isCrepeOpen = false;
	}

	/**
	 * if the crepe is open, it closes. if it's closed, it opens it.
	 */
	public void toggleCrepe() {
		if (isCrepeOpen) {
			this.closeCrepe();
			return;
		}

		this.openCrepe();
	}
	
	/**
	 * Opens the "Helpers"
	 */
	public void openHelpers(){
		this.crepeHelperLeft.set(0.5);
		this.crepeHelperRight.set(0.5);
	}
	
	/**
	 * Closes the "Helpers"
	 */
	public void closeHelpers(){
		this.crepeHelperLeft.set(-0.5);
		this.crepeHelperRight.set(-0.5);		
	}
	
	/**
	 * Stops the "Helpers"
	 */
	public void stopHelpers(){
		this.crepeHelperLeft.set(0);
		this.crepeHelperRight.set(0);
	}
	
	public void toggleIsHelpersOpen(){
		this.isHelpersOpen = !this.isHelpersOpen;
	}
	
	protected void initDefaultCommand() {
		
	}

}
