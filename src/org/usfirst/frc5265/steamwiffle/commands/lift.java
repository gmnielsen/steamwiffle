package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.RobotMap;
import org.usfirst.frc5265.steamwiffle.subsystems.stagValues;

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
    	
    	RobotMap.brushless.set(stagValues.Liftpower);
    	
    }else RobotMap.brushless.set(-stagValues.Liftpower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(woo){
    		return !RobotMap.limiterTop.get();
    	}else return !RobotMap.limiterBottom.get();
        
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
