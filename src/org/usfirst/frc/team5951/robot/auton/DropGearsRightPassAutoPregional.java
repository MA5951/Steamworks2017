package org.usfirst.frc.team5951.robot.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropGearsRightPassAutoPregional extends CommandGroup {

	public DropGearsRightPassAutoPregional() {
		// worked before, needs more testing
		/*addSequential(new ShiftToStrongGear());
		addSequential(new DriveStraight(1.6)); // Go forward a bit
		addSequential(new TurnToAngle(-49)); // Turn to tower
		addSequential(new util.WaitCommand(), 0.15);
		addSequential(new DriveStraight(0.55)); // Go to tower
		addSequential(new OpenGearsSubsystem()); // Drop the Crepe
		addSequential(new WaitCommand(), 0.45);
		addSequential(new DriveStraight(-1.53)); // go behind white obstacle
		addParallel(new CloseGearsSubsystem()); // Closes the Crepe
		addSequential(new TurnToAngle(48.5)); // turn straight
		addSequential(new WaitCommand(), 0.2);
		addSequential(new DriveStraight(3.5)); // straight ahead!
		addSequential(new ShiftToStrongGear());*/
	}
}
