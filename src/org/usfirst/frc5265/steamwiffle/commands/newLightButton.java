package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class newLightButton extends Command {
	public boolean switchState;
	
    public newLightButton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	switchState = SmartDashboard.getBoolean("lightToggle", switchState);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (switchState) {
      	  	Robot.lights.blinker.set(.5);
      	  	SmartDashboard.putString("in loop", "yes");
            Timer.delay(3);
            SmartDashboard.putString("in loop", "yes, we still are");
            Robot.lights.blinker.set(0);
            Timer.delay(3);
            SmartDashboard.putString("in loop", "last bit");
            switchState = SmartDashboard.getBoolean("lightToggle", switchState);
            Timer.delay(3);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lights.blinker.set(0);
    	SmartDashboard.putBoolean("blinkerState1", switchState);
      	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
