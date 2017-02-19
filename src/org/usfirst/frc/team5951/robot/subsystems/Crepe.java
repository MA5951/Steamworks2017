package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;


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
	boolean isCrepeOpen;
	/*CANTalon crepeLeftTalon;
	CANTalon crepeRightTalon;
	might add this
	 */	
	/**
	 * crepe constructor
	 */
	public Crepe() {
		crepeSolenoid = new DoubleSolenoid(RobotMap.k_CREPE_PISTON_FORWARD, RobotMap.k_CREPE_PISTON_REVERSE);
		isCrepeOpen = false;
		/*crepeLeftTalon = new CANTalon(RobotMap.k_LEFT_CREPE_TALON);
		crepeRightTalon = new CANTalon(RobotMap.k_RIGHT_CREPE_TALON);
		might add this
		*/
		
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
	}/*
	public void crepeTalonsForward(){
		 crepeLeftTalon.set(1);
		 crepeRightTalon.set(1);
	}
	public void crepeTalonsBack(){
	crepeRightTalon.set(-1);
	crepeLeftTalon.set(1);
	}
	
	COMMANDS NEED TO BE MADE IF WE WANT TO USE THIS
	
	*/
	protected void initDefaultCommand() {
		
	}

}
