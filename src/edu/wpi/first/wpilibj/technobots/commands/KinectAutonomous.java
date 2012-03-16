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
public class KinectAutonomous extends CommandGroup {

    public KinectAutonomous() {

        addParallel(new DriveWithKinect());
        addParallel(new ReleaseBallWithKinect());
        addParallel(new ShootKinect());
        addParallel(new SweeperKinect());
        // Put all commands together, add sequence and parallels
    }
}
