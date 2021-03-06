
package edu.wpi.first.wpilibj.technobots.commands;

/**
 *
 * @author Kim
 */
public class SweeperOn extends CommandBase {

    public SweeperOn() {
        // Use requires() 9here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(sweeper);
        this.setTimeout(.6);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        sweeper.goForward();
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
