/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.technobots.commands;

/**
 *
 * @author miguel
 */
public class SetElbowSetPoint extends CommandBase {

    private double setPoint;

    public SetElbowSetPoint(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(elbow);
        this.setPoint = setPoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        elbow.setSetpoint(setPoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        return Math.abs(elbow.getPosition() - setPoint) < .08;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
