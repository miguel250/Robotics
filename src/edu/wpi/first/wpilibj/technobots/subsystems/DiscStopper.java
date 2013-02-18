/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.technobots.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.technobots.RobotMap;
import edu.wpi.first.wpilibj.technobots.commands.StopDisc;

/**
 *
 * @author miguel
 */
public class DiscStopper extends Subsystem {

    Solenoid holdDisc;

    public DiscStopper() {

        super("DiscStopper");
        holdDisc   = new Solenoid(RobotMap.holdDisc);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopDisc());
    }

    public void Stop() {
        holdDisc.set(false);

    }

    public void Release() {
        holdDisc.set(true);
    }
}
