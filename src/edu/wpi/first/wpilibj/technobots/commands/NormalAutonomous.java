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

        //addSequential(new StopBall());
        addParallel(new ShooterOn(-.4));
        addSequential(new ReleaseBall());
        addSequential(new StopBall());


    }
}
