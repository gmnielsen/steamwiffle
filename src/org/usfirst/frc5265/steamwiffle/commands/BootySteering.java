package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 *
 */
public class BootySteering extends Command {
	public double dis;
	Command drive;
	public double x,y,t,time;
	public BootySteering() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.ultrab);
    	requires(Robot.chassis);
    	
    	
    	dis = SmartDashboard.getNumber("Distance", dis);
    	drive = new DriveByTime(x,y,t,time);
    	
    	if (dis > 10) {
    		y = 0.75;
    	}else if (dis < 10) {
    		y = 0.5;
    	}else if (dis == 2) {
    		y = 0.0;
    	}
    	//x = Robot.oi.getXSteer();
    	//t = Robot.oi.getTwistSteer();
    	time = 0.1;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.start();
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
    	end();
    }
}
