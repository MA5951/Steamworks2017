package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.ShiftToStrongGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PassAutoLine extends CommandGroup {

    public PassAutoLine() {
    	addSequential(new ShiftToStrongGear());
    	addSequential(new DriveStraight(5));
    	addSequential(new ShiftToStrongGear());
    }
}
