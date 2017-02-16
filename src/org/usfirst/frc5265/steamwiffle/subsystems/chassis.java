// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5265.steamwiffle.subsystems;

import org.usfirst.frc5265.steamwiffle.Robot;
import org.usfirst.frc5265.steamwiffle.RobotMap;
import org.usfirst.frc5265.steamwiffle.commands.*;
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class chassis extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController speedController0 = RobotMap.chassisSpeedController0; // Front Left
    private final SpeedController speedController1 = RobotMap.chassisSpeedController1; // Front Right
    private final SpeedController speedController2 = RobotMap.chassisSpeedController2; // Rear Right
    private final SpeedController speedController3 = RobotMap.chassisSpeedController3; // Rear Left
    private final RobotDrive mover = RobotMap.chassismover;
    private final AnalogGyro analogGyro1 = RobotMap.chassisAnalogGyro1;
    private final PowerDistributionPanel powerDistributionPanel1 = RobotMap.chassisPowerDistributionPanel1;
    private final AnalogAccelerometer analogAccelerometer1 = RobotMap.chassisAnalogAccelerometer1;
  
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public int angleOrient = 0;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    // driving the individual wheels. If a certain motor begins to not supply sufficient umph, we can modify it here
    public void driveFrontLeft(double speed) {
        speedController0.set(speed);
    }
    public void driveFrontRight(double speed) {
        speedController1.set(speed);
    }
    public void driveRearRight(double speed) {
        speedController2.set(speed);
    }
    public void driveRearLeft(double speed) {
        speedController3.set(speed);
    }
    public double [] rotateAngle (double x, double y, int angle) {
    	double cosA = Math.cos(angle * (3.14159 / 180.0));
    	double sinA = Math.sin(angle * (3.14159 / 180.0));
    	double [] out = new double [2];
    	out [0] = x * cosA - y * sinA;
    	out [1] = x * sinA + y * cosA;
    	return out;
    }
    // main driving program, using simple addition to get the robot moving in the appropriate direction
   
    public void driveChassisSteering(double x_speed, double y_speed, double twist) {
<<<<<<< HEAD
    	/*if (angleOrient != 0) {
=======
    	double FL, FR, RL, RR;
    	double maxXYT;
    	
    	if (angleOrient != 0) {
>>>>>>> master
    		double [] xy_speed = rotateAngle (x_speed, y_speed, angleOrient);
    		 x_speed = xy_speed [0];
    		 y_speed = xy_speed [1];
    	}
<<<<<<< HEAD
    	*/
//   	x_speed = x_speed;
//  	twist = twist;
//	twist = 0;
//   	y_speed = y_speed;
    	driveFrontLeft(-y_speed + x_speed + twist);
    	driveFrontRight(y_speed + x_speed + twist);
    	driveRearLeft(-y_speed - x_speed + twist);
    	driveRearRight(y_speed - x_speed + twist);
    	
	
=======
    	
    	FL = -y_speed + x_speed + twist;
    	FR = y_speed + x_speed + twist;
    	RL = -y_speed - x_speed + twist;
    	RR = y_speed - x_speed + twist;
    	
    	// NORMALIZE max FL, FR, RR and RL to 1
    	maxXYT = Math.max(Math.abs(FL), Math.abs(FR));
    	maxXYT = Math.max(maxXYT, Math.abs(RL));
    	maxXYT = Math.max(maxXYT, Math.abs(RR));
    	if (maxXYT > 1) {
    		FR = FR / maxXYT;
    		FL = FL / maxXYT;
    		RR = RR / maxXYT;
    		RL = RL / maxXYT;
    	}
    		
    	driveFrontLeft(FL);
    	driveFrontRight(FR);
    	driveRearLeft(RL);
    	driveRearRight(RR);
    	
    	// EVALUATION TEST
		SmartDashboard.putNumber("DB/Slider 0", FL);
		SmartDashboard.putNumber("DB/Slider 1", FR);
		SmartDashboard.putNumber("DB/Slider 2", RL);
		SmartDashboard.putNumber("DB/Slider 3", RR);
    	
>>>>>>> master
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	
    	// calls the command to get the joystick position for driving
    	setDefaultCommand(new driveCommandSteer());
    }
}

