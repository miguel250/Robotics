package edu.wpi.first.wpilibj.technobots;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.technobots.commands.ReleaseBall;
import edu.wpi.first.wpilibj.technobots.commands.SetElbowSetPoint;
import edu.wpi.first.wpilibj.technobots.commands.ShooterOn;
import edu.wpi.first.wpilibj.technobots.commands.SweeperOn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick xbox;
    Button button1, button2, button3, button5;
    ShooterOn shooter;
    ReleaseBall releaseBall;

    public OI() {

        xbox = new Joystick(1);
        button1 = new JoystickButton(xbox, 1);
        button2 = new JoystickButton(xbox, 2);
        button3 = new JoystickButton(xbox, 3);
        button5 = new JoystickButton(xbox, 5);

        button1.whenPressed(new SetElbowSetPoint(4));
        button2.whenPressed(new SetElbowSetPoint(2));
        button3.whenPressed(new SetElbowSetPoint(0));

        button5.whenPressed(new SweeperOn());

        if (Buffer(xbox.getRawAxis(3)) > 0) {

            shooter = new ShooterOn();

        }

        if (Buffer(xbox.getRawAxis(3)) < 0) {

            releaseBall = new ReleaseBall();

        }
    }

    public double getMagnitude() {

        return Buffer(xbox.getMagnitude());
    }

    public double getDirection() {

        return Buffer(xbox.getDirectionDegrees());
    }

    public double getRotation() {

        return Buffer(xbox.getRawAxis(4));
    }

    private double Buffer(double n) {

        double buffers = 0.3;

        if (Math.abs(n) < buffers) {

            return n;
        }

        return n;
    }
}