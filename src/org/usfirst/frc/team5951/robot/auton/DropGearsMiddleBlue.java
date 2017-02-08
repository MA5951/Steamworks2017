package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropGearsMiddleBlue extends CommandGroup {

    public DropGearsMiddleBlue() {
        addSequential(new DriveStraight(2)); //goes to gear unload station
        addSequential(new OpenCrepe()); //drops the crepe
        addSequential(new DriveStraight(-1)); //goes behind the white obstacle
        addSequential(new TurnToAngle(45)); //turn right
        addSequential(new DriveStraight(2)); //line up with the loading station
        addSequential(new TurnToAngle(0)); //turn back to face the loading station
        addSequential(new DriveStraight(20)); //drive to the loading station but don't do crime.
    }
}
