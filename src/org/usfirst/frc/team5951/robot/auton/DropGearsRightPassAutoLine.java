package org.usfirst.frc.team5951.robot.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.TurnToAngle;
import org.usfirst.frc.team5951.robot.commands.crepe.CloseCrepe;
import org.usfirst.frc.team5951.robot.commands.crepe.OpenCrepe;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *@author Omer Libai
 *a command group that assumes you start at the right side, drops a gear and goes forward
 */
public class DropGearsRightPassAutoLine extends CommandGroup {

    public DropGearsRightPassAutoLine() {
    	addSequential(new DriveStraight(2.085)); //Go forward a bit (needs to be fixed)
    	addSequential(new TurnToAngle(-46)); //Turn to tower
    	addSequential(new util.WaitCommand(), 0.3);
    	addSequential(new DriveStraight(0.6)); //Go to tower (needs to be fixed)
    	addSequential(new OpenCrepe()); //Drop the Crepe
    	addSequential(new DriveStraight(-1.03)); //go behid white obstacle
    	addParallel(new CloseCrepe()); //Closes the Crepe 
    	/*addSequential(new TurnToAngle(0));
    	addSequential(new DriveStraight(707)); // go forward
*/    }
}
