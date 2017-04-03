package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.*;

/**
 *
 */
public class CameraDirections extends Command {
	NetworkTable Pi;
	Command workPlease;
	public double x,y,t,time;
	

    public CameraDirections() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	Pi = NetworkTable.getTable("Raspberry");
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	workPlease = new DriveByTime( x, y, t, time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double DistanceToPeg = Pi.getNumber("DistanceToPeg", 0);
    	double LateralToPeg = Pi.getNumber("LateralToPeg", 0);
    	double TwistToPeg = Pi.getNumber("TwistToPeg", 0);
    	double TimeThisTakes = Pi.getNumber("TimeThisTakes", 0);
    	
    	x = DistanceToPeg;
    	y = LateralToPeg;
    	t = TwistToPeg;
    	time = TimeThisTakes;
    	
    	workPlease.start();
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
