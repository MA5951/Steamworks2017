package org.usfirst.frc.team5951.robot.commands.gears.hpGearsSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;
import util.WaitCommand;

/**
 *
 */
public class ReleaseGearsHP extends CommandGroup {

    public ReleaseGearsHP() {
        addSequential(new OpenGearsHP());
        addSequential(new WaitCommand(), 0.3);
        addSequential(new OpenPushersHP());
    }
}
