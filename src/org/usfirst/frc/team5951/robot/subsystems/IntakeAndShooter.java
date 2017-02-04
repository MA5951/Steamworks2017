package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;
import org.usfirst.frc.team5951.robot.commands.IntakeAndShooter.StopIntake;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeAndShooter extends Subsystem {
	private CANTalon intakeFront;
	private CANTalon intakeRear;

	public IntakeAndShooter() {
		this.intakeFront = new CANTalon(RobotMap.k_INTAKE_FRONT_TALON);
		this.intakeRear = new CANTalon(RobotMap.k_INTAKE_REAR_TALON);

		this.intakeFront.changeControlMode(TalonControlMode.PercentVbus);
		this.intakeRear.changeControlMode(TalonControlMode.PercentVbus);
	}

	// This function intakes the balls into the container.
	public void intake() {
		intakeFront.set(-1);
		intakeRear.set(-1);
	}

	/**
	 * This function outtakes the balls from the container
	 */
	public void outtake() {
		intakeFront.set(1);
		intakeRear.set(1);
	}

	/**
	 * This function shoots the balls to the low boiler
	 */
	public void shoot() {
		intakeFront.set(-1);
		intakeRear.set(1);
	}

	/**
	 * This function stops all motors of the subsystem
	 */
	public void stop() {
		intakeRear.set(0);
		intakeFront.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new StopIntake());
	}
}
