package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterAllianceAutonomous extends Command {
	Command autoMiddle;

    public CenterAllianceAutonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	autoMiddle = new CenterAlliance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 autoMiddle.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
