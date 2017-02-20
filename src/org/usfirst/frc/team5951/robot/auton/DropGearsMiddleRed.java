package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.CloseGearsSubsystem;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.OpenGearsSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class DropGearsMiddleRed extends CommandGroup {

	public DropGearsMiddleRed() {
		addSequential(new DriveStraight(1.48));
		addSequential(new OpenGearsSubsystem());
		addSequential(new WaitCommand(), 0.25);
		addSequential(new DriveStraight(-0.9));
		addParallel(new CloseGearsSubsystem());
		addSequential(new TurnToAngle(-60));
		addSequential(new DriveStraight(2.2));
		addSequential(new TurnToAngle(60));
		addSequential(new DriveStraight(2.5));
	}

}
