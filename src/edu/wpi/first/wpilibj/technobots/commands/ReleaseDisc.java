/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.technobots.commands;

/**
 *
 * @author miguel
 */
public class ReleaseDisc extends CommandBase {

    public ReleaseDisc() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(discStopper);
        this.setTimeout(.6);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        discStopper.Release();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
