package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.ShiftToStrongGear;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.crepe.CloseCrepe;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;
import org.usfirst.frc.team5951.robot.commands.intakeAndShooter.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class DropGearsRightShoot extends CommandGroup {

	public DropGearsRightShoot() {
		// TODO Finish
		addSequential(new ShiftToStrongGear());
		addSequential(new DriveStraight(1.975)); // Go forward a bit
		addSequential(new TurnToAngle(-48.75)); // Turn to tower
		addSequential(new util.WaitCommand(), 0.15);
		addSequential(new DriveStraight(0.575)); // Go to tower
		addSequential(new OpenCrepe()); // Drop the Crepe
		addSequential(new WaitCommand(), 0.5);
		addSequential(new DriveStraight(-0.75)); // go behind white obstacle
		addSequential(new CloseCrepe());
		addSequential(new WaitCommand(), 0.5);
		addSequential(new TurnToAngle(13));
		addSequential(new WaitCommand(), 0.5);
		addSequential(new DriveStraight(-2));
		addSequential(new TurnToAngle(-14.25));
		addSequential(new DriveStraight(-0.5));
		addSequential(new Shoot(), 10);

		// needs actual shooting into the boiler
	}
}
