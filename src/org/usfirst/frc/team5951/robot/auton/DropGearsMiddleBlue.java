package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropGearsMiddleBlue extends CommandGroup {

    public DropGearsMiddleBlue() {
        addSequential(new DriveStraight(1));
        addSequential(new OpenCrepe());
    }
}
