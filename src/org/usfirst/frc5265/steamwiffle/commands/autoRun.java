package org.usfirst.frc5265.steamwiffle.commands;

import org.usfirst.frc5265.steamwiffle.Robot;
import org.usfirst.frc5265.steamwiffle.RobotMap;
//import org.usfirst.frc5265.steamwiffle.RobotMap;
import org.usfirst.frc5265.steamwiffle.subsystems.stagValues;

import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoRun extends CommandGroup {
	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	String[] game = new String[3];
	
	
    public autoRun(String auto) {
    	requires(Robot.stagValues);
    game = gameData.split("");
	double c1x = stagValues.c1x, c1y = stagValues.c1y, c1t = stagValues.c1t;
    double c2x = stagValues.c2x, c2y = stagValues.c2y, c2t = stagValues.c2t;
	double c3x = stagValues.c3x, c3y = stagValues.c3y, c3t = stagValues.c3t;
	double c4x = stagValues.c4x, c4y = stagValues.c4y, c4t = stagValues.c4t;
	double c5x = stagValues.c5x, c5y = stagValues.c5y, c5t = stagValues.c5t;
	double c6x = stagValues.c6x, c6y = stagValues.c6y, c6t = stagValues.c6t;
    	
	 double l1x = stagValues.l1x, l1y = stagValues.l1y, l1t = stagValues.l1t;
	//2nd stage for no scale "n"
     double l1nx = stagValues.l1nx, l1ny = stagValues.l1ny, l1nt = stagValues.l1nt;
	 double l2x = stagValues.l2x, l2y = stagValues.l2y, l2t = stagValues.l2t;
//	 double l3x = stagValues.l3x, l3y = stagValues.l3y, l3t = stagValues.l3t;
    	//CENTER AUTO
	 
	 // arm powers and time
	 double allUpT = stagValues.allUpT, allUpP = stagValues.allUpP, halfUpT = stagValues.halfUpP, halfUpP = stagValues.halfUpT;
	 
	 // make sure its reverse everytime
	 RobotMap.airDoubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
    	if(auto == "center") {
    		
    		//turn toward L or R
    		if(game[1].equals("R")) {
    			addSequential(new DriveByTime(c1x, c1y, c1t));
    		}else {
    			addSequential(new DriveByTime(-c1x, c1y, c1t));
    		}
    		   		
        	//go forward towards goal
    		addSequential(new DriveByTime(-c2x, c2y, c2t));
    		
    		//turn back towards goal
    		if(game[1].equals("R")) {
    			addSequential(new DriveByTime(c3x, c3y, c3t));
    		}else {
    			addSequential(new DriveByTime(-c3x, c3y, c3t));
    		}
    		//lift up
    		addSequential(new timeLift(halfUpP, halfUpT));
    		  	
    	    // drop cube
		addSequential(new grab(true));
		
		//lift down
		addSequential(new timeLift(-halfUpP, halfUpT));
		
		//back up
	    addSequential(new DriveByTime(c4x, c4y, c4t));
	    
	    //turn away 
	    if(game[1].equals("R")) {
			addSequential(new DriveByTime(c5x, c5y, c5t));
		}else {
			addSequential(new DriveByTime(-c5x, c5y, c5t));
		}
	    
	    //go forward over the line
		addSequential(new DriveByTime(c6x, c6y, c6t));

   
    		}
    	
    	
    	//RIGHT AUTO
    	else if(auto == "right") {
    		if(game[2].equals("R")) {
    			//forward
    			addSequential( new DriveByTime(l1x, l1y, l1t));
    			//twist
    			addSequential( new DriveByTime(l2x, l2y, l2t));
    			//lift up
    			addSequential(new timeLift(allUpP,allUpT));
        		//drop cube
        		addSequential(new grab(true));
        		//lift down
        		addSequential(new timeLift(-halfUpP, halfUpT));

    		}else if(game[1].equals("R")) {
    			//forward
    			addSequential( new DriveByTime(l1nx, l1ny, l1nt));
    			//twist
    			addSequential( new DriveByTime(l2x, l2y, l2t));
    			//lift up
    			addSequential(new timeLift(halfUpP, halfUpT));
    			//drop cube
        		addSequential(new grab(true));
        		//lift down
        		addSequential(new timeLift(-halfUpP, halfUpT));
    		}else {
    			addSequential( new DriveByTime(l1nx, l1ny, l1nt));
    		}
    		
    		
    		
    		
    	//RIGHT NO SCALE	
    	}else if(auto == "rightNoScale") {
    		if(game[1].equals("R")) {
    			//forward
    			addSequential( new DriveByTime(l1nx, l1ny, l1nt));
    			//twist
    			addSequential( new DriveByTime(l2x, l2y, l2t));
    			//lift up
    			addParallel(new timeLift(halfUpP, halfUpT));
    			//drop cube
    			addParallel(new grab(true));
    			//lift down
    			addSequential(new timeLift(-halfUpP, halfUpT));
    		}else if(game[2].equals("R")){
    			addSequential( new DriveByTime(l1x, l1y, l1t));
    			//twist
    			addSequential( new DriveByTime(l2x, l2y, l2t));
    			//lift up
    			addSequential(new timeLift(allUpP,allUpT));
        		//drop cube
        		addSequential(new grab(true));
        		//lift down
        		addSequential(new timeLift(-allUpP, halfUpT));
    		}else {
    			addSequential( new DriveByTime(l1nx, l1ny, l1nt));
    		}
    	
    	
    	
    	}
    	
    	//LEFT AUTO
    	else if(auto == "left") {
    		// figure out where they are and move accordingly 
    		if(game[2].equals("L")) {
    			//forward
    			addSequential( new DriveByTime(l1x, l1y, l1t));
    			//twist
    			addSequential( new DriveByTime(-l2x, l2y, l2t));
    			//lift up
    			addSequential(new timeLift(allUpP,allUpT));
        		//drop cube
        		addSequential(new grab(true));
        		//lift down
        		addSequential(new timeLift(-allUpP, halfUpT));

    		}else if(game[1].equals("L")) {
    			//forward
    			addSequential( new DriveByTime(l1nx, l1ny, l1nt));
    			//twist
    			addSequential( new DriveByTime(-l2x, l2y, l2t));
    			//lift up
    			addParallel(new timeLift(halfUpP, halfUpT));
    			//drop cube
        		addSequential(new grab(true));
        		//lift down
        		addSequential(new timeLift(-halfUpP, halfUpT));

    		}else {
    			addSequential( new DriveByTime(l1nx, l1ny, l1nt));
    		}
    		
    		
    		//twist
    		
    		
    			
    	//LEFT NO SCALE
    	} else if(auto == "leftNoScale") {
    		if(game[1].equals("L")) {
    			//forward
    			addSequential( new DriveByTime(l1nx, l1ny, l1nt));
    			//twist
    			addSequential( new DriveByTime(-l2x, l2y, l2t));
    			//lift up
    			addSequential(new timeLift(halfUpP, halfUpT));
    			//drop cube
        		addSequential(new grab(true));
        		//lift down
        		addSequential(new timeLift(-halfUpP, halfUpT));

    		}else if(game[2].equals("L")){
    			//forward
    			addSequential( new DriveByTime(l1x, l1y, l1t));
    			//twist
    			addSequential( new DriveByTime(-l2x, l2y, l2t));
    			//lift up
    			addSequential(new timeLift(allUpP,allUpT));
        		//drop cube
    			addSequential(new grab(true));
    			//lift down
    			addSequential(new timeLift(-allUpP, halfUpT));
    		}else {
    			addSequential( new DriveByTime(l1nx, l1ny, l1nt));
    		}
    		
    		
    		
    		
    		
    		
    	}
    	
    	//addSequential(new DriveByTime(caa2dx, caa2dy, caa2dt, caa2dtime));
    	//addSequential(new DriveByTime(caa3dx, caa3dy, caa3dt, caa3dtime));
    	//addSequential(new IntakeCommand(0.5));
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}