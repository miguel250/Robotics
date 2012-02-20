
package edu.wpi.first.wpilibj.technobots.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.technobots.RobotMap;

/**
 *
 * @author Kim
 */
public class Sweeper extends Subsystem {

    Victor motor;

    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public Sweeper() {
	super("Sweeper");
        motor = new Victor(RobotMap.sweeper);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void goForward(){

        motor.set(-.5);
    }
    public void doNothing() {

        motor.set(0);
    }
}

