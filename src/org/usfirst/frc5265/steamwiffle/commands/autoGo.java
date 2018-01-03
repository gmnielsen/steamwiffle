package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;
import org.usfirst.frc5265.steamwiffle.subsystems.chassis;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.*;

/**
 *
 */
public class autoGo extends Command {
	//NetworkTable Raspberry;
    public autoGo() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		
    	double xNet[] = Robot.Raspberry.getNumberArray("x");
    	double timer = SmartDashboard.getDouble("Timer Delay");
        double power = SmartDashboard.getDouble("Power");	
        	
        		 
        		 SmartDashboard.putNumber("new Xnet", xNet[0]);
        		if(xNet[0]<300){
        			chassis.driveChassisSteering(-power,0);
        			setTimeout(timer);
        			Robot.chassis.driveChassisSteering(0, 0);
        		}
        		if(xNet[0]>340){
        			chassis.driveChassisSteering(power,0);
        			setTimeout(timer);
        			Robot.chassis.driveChassisSteering(0, 0);
        		}
        		
        	}
        	
        
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.driveChassisSteering(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
