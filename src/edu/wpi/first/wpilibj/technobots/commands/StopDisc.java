/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.technobots.commands;

import edu.wpi.first.wpilibj.technobots.subsystems.DiscStopper;

/**
 *
 * @author miguel
 */
public class StopDisc extends CommandBase {

    public StopDisc() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(discStopper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        discStopper.Stop();
        this.setTimeout(1);
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
