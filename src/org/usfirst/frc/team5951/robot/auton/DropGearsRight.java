package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.crepe.CloseCrepe;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Omer Libai
 *a command group that assumes you start at the right side, drops a gear and goes forward
 */
public class DropGearsRight extends CommandGroup {

    public DropGearsRight() {
    	addSequential(new DriveStraight(1080)); //Go forward a bit (needs to be fixed)
    	addSequential(new TurnToAngle(-45)); //Turn to tower (needs to be fixed)
    	addSequential(new DriveStraight(420)); //Go to tower (needs to be fixed)
    	addSequential(new OpenCrepe()); //Drop the Crepe
    	addSequential(new DriveStraight(-100)); //needs to be fixed
    	addParallel(new CloseCrepe()); //Closes the Crepe 
    	addSequential(new TurnToAngle(0));
    	addSequential(new DriveStraight(60)); // go Sforward
    
    }
}
