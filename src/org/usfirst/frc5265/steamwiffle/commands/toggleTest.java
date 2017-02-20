package org.usfirst.frc5265.steamwiffle.commands;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5265.steamwiffle.subsystems.lights;
import org.usfirst.frc5265.steamwiffle.Robot;

/**
 *
 */
public class toggleTest extends Command {
	
	public boolean toggleState;
    
    public toggleTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lights);
    	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	// is this is on, then make it off, or vice versa
    	toggleState = Robot.lights.lightToggle();
    	// test toggleState and write true or false to the smartdashboard
    	if (toggleState){
    		SmartDashboard.putString("toggle", "it is true");
    		//Robot.lights.blinkAbort = true;
    	} else {
    		SmartDashboard.putString("toggle", "it is false");
    		//Robot.lights.blinkAbort = false;
    	}
    	//System.out.println("Toggle State " + toggleState);
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.lights.blinkAbort = true;
    }
    	

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
