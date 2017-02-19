package org.usfirst.frc5265.steamwiffle.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5265.steamwiffle.subsystems.lights;
import org.usfirst.frc5265.steamwiffle.Robot;

/**
 *
 */
public class toggleTest extends Command {

    public toggleTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lights.blinkAbort = false;
    	//Robot.lights.BLINK();
    	SmartDashboard.putString("toggleTest", "init");
    	
    	
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
    	SmartDashboard.putString("toggleTest", "end");
    	//Robot.lights.blinkAbort = true;
    }
    	

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
