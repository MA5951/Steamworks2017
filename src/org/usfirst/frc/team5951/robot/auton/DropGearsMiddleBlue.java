package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class DropGearsMiddleBlue extends CommandGroup {

    public DropGearsMiddleBlue() {
        addSequential(new DriveStraight(1.48));
        addSequential(new OpenCrepe());
        addSequential(new WaitCommand(), 0.3);
        addSequential(new DriveStraight(-0.9));
        addSequential(new TurnToAngle(60));
        addSequential(new DriveStraight(2.2));
        addSequential(new TurnToAngle(-60));
        addSequential(new DriveStraight(2.5));
    }
}
