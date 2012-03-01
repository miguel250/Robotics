package edu.wpi.first.wpilibj.technobots.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.technobots.RobotMap;

/**
 *
 * @author Kim
 */
public class Elbow extends PIDSubsystem {

    private static final double Kp = .2;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    public static final double START = 0.02;
    AnalogChannel pot;
    SpeedController motor;

    // Initialize your subsystem here
    public Elbow() {
        super("Elbow", Kp, Ki, Kd);

        motor = new Victor(RobotMap.elbow);

        pot = new AnalogChannel(RobotMap.pot);

        setSetpoint(START);
        enable();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        return pot.getAverageVoltage();
    }

    protected void usePIDOutput(double output) {

        if (output >= 1.0) {
            output = 1;
        }
        if (output <= -1.0) {
            output = -1;
        }
        motor.set(output);
    }
}
