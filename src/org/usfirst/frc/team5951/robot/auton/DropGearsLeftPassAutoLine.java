package org.usfirst.frc.team5951.robot.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Omer Libai
 *a command group that assumes you start at the left side, drops a gear and goes forward
 */
public class DropGearsLeftPassAutoLine extends CommandGroup {

    public DropGearsLeftPassAutoLine() {
    	
    	/*//Exactly like the right version except angles are the opposite. Needs testing.
    	addSequential(new ShiftToStrongGear());
    	addSequential(new DriveStraight(1.825)); //Go forward a bit
    	addSequential(new TurnToAngle(48.5)); //Turn to tower
    	addSequential(new WaitCommand(), 0.2);
    	addSequential(new DriveStraight(0.93)); //Go to tower 
    	addParallel(new OpenGearsSubsystem()); //Drop the Crepe
    	addSequential(new WaitCommand(), 0.35);
    	addSequential(new DriveStraight(-1.53)); //go behind white obstacle
    	addParallel(new CloseGearsSubsystem()); //Closes the Crepe
    	addSequential(new TurnToAngle(-48.5)); // turn straight
    	addSequential(new WaitCommand(), 0.2);
    	addSequential(new DriveStraight(5)); //straight ahead!
    	addSequential(new ShiftToStrongGear());*/
    }
}
