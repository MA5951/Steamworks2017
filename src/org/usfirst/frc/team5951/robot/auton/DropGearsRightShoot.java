package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.ShiftToFastGear;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.CloseGearsSubsystem;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.OpenGearsSubsystem;
import org.usfirst.frc.team5951.robot.commands.intakeAndShooter.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class DropGearsRightShoot extends CommandGroup {

	public DropGearsRightShoot() {
		// TODO Finish
		addSequential(new CloseGearsSubsystem());
		addSequential(new DriveStraight(1.974)); // Go forward a bit
		addSequential(new TurnToAngle(-49.75)); // Turn to airship
		addSequential(new WaitCommand(), .19);
		addSequential(new DriveStraight(0.57));
		addSequential(new WaitCommand(), 0.3);
		addSequential(new OpenGearsSubsystem()); // Drop the Crepe
		addSequential(new WaitCommand(), .9);
		addSequential(new DriveStraight(-0.75)); // go behind white obstacle
		addSequential(new CloseGearsSubsystem());
		addSequential(new WaitCommand(), 0.5);
		addSequential(new TurnToAngle(13));
		addSequential(new WaitCommand(), 0.5);
		addSequential(new DriveStraight(-2));
		addSequential(new TurnToAngle(-14.25));
		addSequential(new DriveStraight(-0.5));
		addSequential(new Shoot(), 10);
		addSequential(new ShiftToFastGear());
	}
}



