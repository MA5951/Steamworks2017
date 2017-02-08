package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

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
	boolean isCrepeOpen;
	/**
	 * crepe constructor
	 */
	public Crepe() {
		crepeSolenoid = new DoubleSolenoid(RobotMap.k_CREPE_PISTON_FORWARD, RobotMap.k_CREPE_PISTON_REVERSE);
		isCrepeOpen = false;
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

	protected void initDefaultCommand() {
		
	}

}
