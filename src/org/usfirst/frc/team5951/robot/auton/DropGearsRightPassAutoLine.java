package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.ShiftToStrongGear;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.CloseGearsSubsystem;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.OpenGearsSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 * @author Omer Libai 
 * a command group that assumes you start at the right side, drops a gear and goes forward
 */
public class DropGearsRightPassAutoLine extends CommandGroup {

	public DropGearsRightPassAutoLine() {
		// worked before, needs more testing
		addSequential(new ShiftToStrongGear());
		addSequential(new DriveStraight(2.0)); // Go forward a bit
		addSequential(new TurnToAngle(-49)); // Turn to tower
		addSequential(new util.WaitCommand(), 0.3);
		addSequential(new DriveStraight(0.53)); // Go to tower
		addSequential(new OpenGearsSubsystem()); // Drop the Crepe
		addSequential(new WaitCommand(), 0.45);
		addSequential(new DriveStraight(-1.03)); // go behind white obstacle
		addParallel(new CloseGearsSubsystem()); // Closes the Crepe
		addSequential(new TurnToAngle(48.5)); // turn straight
		addSequential(new WaitCommand(), 0.2);
		addSequential(new DriveStraight(3.5)); // straight ahead!
	}
}
