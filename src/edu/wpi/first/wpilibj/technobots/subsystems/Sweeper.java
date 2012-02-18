
package edu.wpi.first.wpilibj.technobots.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.technobots.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 */
public class Sweeper extends Subsystem {

    AnalogChannel motor;

    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public Sweeper() {
	super("Sweeper");
        motor = new AnalogChannel(1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void goForward(){


        System.out.println(motor.getValue());
    }
    public void doNothing() {

        
    }
}

