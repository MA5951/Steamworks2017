package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.ShiftToStrongGear;
import org.usfirst.frc.team5951.robot.commands.gears.hpGearsSubsystem.ReleaseGearsHP;
import org.usfirst.frc.team5951.robot.commands.gears.hpGearsSubsystem.ResetGearsHP;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class DropGearsMiddleReturn extends CommandGroup {

    public DropGearsMiddleReturn() {
    	addSequential(new ShiftToStrongGear());
		addSequential(new DriveStraight(1.845));
		addSequential(new ReleaseGearsHP());
		addSequential(new WaitCommand(), 0.25);
		addSequential(new DriveStraight(-0.5));
		addParallel(new ResetGearsHP());
    	addSequential(new ShiftToStrongGear());
    }
}
