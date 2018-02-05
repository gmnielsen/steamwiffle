package org.usfirst.frc5265.steamwiffle.commands;


import org.usfirst.frc5265.steamwiffle.RobotMap;


import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class servoTest extends Command {
	
	
    public servoTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.servme.set(.5);
    	RobotMap.servme.setAngle(75);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	RobotMap.servme.set(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
