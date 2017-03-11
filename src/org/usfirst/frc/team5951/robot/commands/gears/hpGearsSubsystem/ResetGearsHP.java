package org.usfirst.frc.team5951.robot.commands.gears.hpGearsSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class ResetGearsHP extends CommandGroup {

    public ResetGearsHP() {
        addSequential(new ClosePushersHP());
        addSequential(new WaitCommand(), 0.3);
        addSequential(new CloseGearsHP());
    }
}
