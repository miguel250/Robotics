/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.technobots.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author miguel
 */
public class NormalAutonomous extends CommandGroup {

    public NormalAutonomous() {

        //Release first disc;
        addParallel(new ShooterOn(-1));
        addSequential(new StopDisc());
        addSequential(new SweeperDoNothing());
        addSequential(new SweeperOn());
        addSequential(new SweeperDoNothing());
        addSequential(new ReleaseDisc());
        addSequential(new StopDisc());
        
        //Release second disc
        addSequential(new SweeperOn());
        addSequential(new SweeperDoNothing());
        addSequential(new ReleaseDisc());
        addSequential(new StopDisc());
        
        //Release last disc;
        addSequential(new SweeperOn());
        addSequential(new SweeperDoNothing());
        addSequential(new ReleaseDisc());
        addSequential(new StopDisc());
    }
}
