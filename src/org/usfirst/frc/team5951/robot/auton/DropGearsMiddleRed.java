package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropGearsMiddleRed extends CommandGroup {
	public DropGearsMiddleRed() {
		addSequential(new DriveStraight(220.5)); //goto middle gear unload station
		addSequential(new OpenCrepe()); //drop the crepe into the crack
		addSequential(new DriveStraight(-110.5)); //go behind white obstacle
		addSequential(new TurnToAngle(-45)); //turn left
		addSequential(new DriveStraight(470.5)); // lines up with the loading station
		addSequential(new TurnToAngle(0)); //turns back to face the loading station
		addSequential(new DriveStraight(640.5)); //goto loading station (don't cross the forbidden line)
	}
}