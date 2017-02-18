package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.crepe.CloseCrepe;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Omer Libai
 *a command group that assumes you start at the left side, drops a gear and goes forward
 */
public class DropGearsLeftPassAutoLine extends CommandGroup {

    public DropGearsLeftPassAutoLine() {
    	addSequential(new DriveStraight(242)); //Go forward a bit (needs to be fixed)
    	addSequential(new TurnToAngle(-120)); //Turn to tower
    	addSequential(new DriveStraight(98)); //Go to tower (needs to be fixed)
    	addSequential(new OpenCrepe()); //Drop the Crepe
    	addSequential(new DriveStraight(-103)); //go behid white obstacle
    	addParallel(new CloseCrepe()); //Closes the Crepe 
    	addSequential(new TurnToAngle(0));
    	addSequential(new DriveStraight(707)); // go forward
    }
}
