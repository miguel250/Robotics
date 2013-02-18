/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.technobots.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.technobots.RobotMap;
import edu.wpi.first.wpilibj.technobots.commands.ClimbDown;

/**
 *
 * @author miguel
 */
public class Climber extends Subsystem {

    Solenoid side;
    Solenoid climb;

    public Climber() {

        super("Climber");
        side   = new Solenoid(RobotMap.moveGrabber);
        climb = new Solenoid(RobotMap.grabber);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClimbDown());
    }

    public void Up() {
        side.set(true);
        climb.set(true);

    }

    public void Down() {
        side.set(false);
        climb.set(false);
    }
}
