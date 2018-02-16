package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class lift extends Command {
	boolean woo;
    public lift(boolean boo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	woo = boo;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    if (woo){
    	
    	RobotMap.brushless.set(.5);
    	
    }else RobotMap.brushless.set(-.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !RobotMap.limiterBottom.get() || !RobotMap.limiterTop.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.brushless.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.brushless.set(0);
    }
}
