/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.technobots.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.technobots.RobotMap;
import edu.wpi.first.wpilibj.technobots.commands.StopBall;

/**
 *
 * @author miguel
 */
public class BallStopper extends Subsystem {

    Solenoid up;
    Solenoid down;

    public BallStopper() {

        super("BallStopper");

        up   = new Solenoid(RobotMap.ballStopper1Up);
        down = new Solenoid(RobotMap.ballStopper1Down);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopBall());
    }

    public void Stop() {

        down.set(false);
        up.set(true);

    }

    public void Release() {
        up.set(false);
        down.set(true);
    }
}
