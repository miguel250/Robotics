
package edu.wpi.first.wpilibj.technobots.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.technobots.RobotMap;
import edu.wpi.first.wpilibj.technobots.commands.ShooterDoNothing;

/**
 *
 * @author Kim
 */
public class Shooter extends Subsystem {

    Victor motor;
    Victor motor2;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Shooter() {
        super("Shooter");
        motor  = new Victor(RobotMap.shooterRight);
        motor2 = new Victor(RobotMap.shooterLeft);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

        setDefaultCommand(new ShooterDoNothing());
    }

    public void goForward(){

        motor.set(-1);
        motor2.set(-1);
    }

    public void doNothing() {

        motor.set(0);
        motor2.set(0);
    }

}



