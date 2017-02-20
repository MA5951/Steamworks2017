package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropGearsMiddleRed extends CommandGroup {
	public DropGearsMiddleRed() {
		//untested
		addSequential(new DriveStraight(1.48)); //goto middle gear unload station
//		addSequential(new OpenCrepe()); //drop the crepe into the crack
		addSequential(new DriveStraight(-0.9)); //go behind white obstacle
		addSequential(new TurnToAngle(-60)); //turn left
		addSequential(new DriveStraight(2.2)); // lines up with the loading station
		addSequential(new TurnToAngle(60)); //turns back to face the loading station
		addSequential(new DriveStraight(2.5)); //goto loading station (don't cross the forbidden line)
	}
}
