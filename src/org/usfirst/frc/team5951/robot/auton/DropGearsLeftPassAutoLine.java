package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.CloseGearsSubsystem;
import org.usfirst.frc.team5951.robot.commands.gearsSubsystem.OpenGearsSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *@author Omer Libai
 *a command group that assumes you start at the left side, drops a gear and goes forward
 */
public class DropGearsLeftPassAutoLine extends CommandGroup {

    public DropGearsLeftPassAutoLine() {
    	
    	//Exactly like the right version except angles are the opposite. Needs testing.
    	addSequential(new DriveStraight(1.925)); //Go forward a bit
    	addSequential(new TurnToAngle(48.5)); //Turn to tower
    	addSequential(new WaitCommand(), 0.2);
    	addSequential(new DriveStraight(0.67)); //Go to tower 
    	addSequential(new OpenGearsSubsystem()); //Drop the Crepe
    	addSequential(new WaitCommand(), 0.15);
    	addSequential(new DriveStraight(-1.03)); //go behind white obstacle
    	addParallel(new CloseGearsSubsystem()); //Closes the Crepe
    	addSequential(new TurnToAngle(-48.5)); // turn straight
    	addSequential(new WaitCommand(), 0.2);
    	addSequential(new DriveStraight(5)); //straight ahead! 
    }
}
