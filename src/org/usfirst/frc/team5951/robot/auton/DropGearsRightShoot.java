package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.crepe.CloseCrepe;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;


import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class DropGearsRightShoot extends CommandGroup {

    public DropGearsRightShoot() {
    	//not done
    addSequential(new DriveStraight(2.0)); //Go forward a bit
	addSequential(new TurnToAngle(-48.5)); //Turn to tower
	addSequential(new util.WaitCommand(), 0.3);
	addSequential(new DriveStraight(0.545)); //Go to tower
	addSequential(new OpenCrepe()); //Drop the Crepe
	addSequential(new DriveStraight(-1.3)); // go back (needs to be fixed)
	addParallel(new CloseCrepe());
	addSequential(new TurnToAngle(20));// turn around (needs to be fixed)
	addSequential(new WaitCommand(), 0.3);
	addSequential(new DriveStraight(-1.2) ); // go to boiler (needs to be fixed)
	
	
	//needs actual shooting into the boiler
    }
}
