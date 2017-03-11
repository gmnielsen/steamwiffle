// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5265.steamwiffle;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	public static SpeedController chassisSpeedController0; // Front Left
    public static SpeedController chassisSpeedController1; // Front Right
    public static SpeedController chassisSpeedController2; // Rear Right
    public static SpeedController chassisSpeedController3; // Rear Left
    public static SpeedController shooterMotor;
    public static RobotDrive chassismover;
    public static AnalogGyro chassisAnalogGyro1;
    public static PowerDistributionPanel chassisPowerDistributionPanel1;
    public static AnalogAccelerometer chassisAnalogAccelerometer1;
    public static SpeedController fuelspinnies;
    public static SpeedController agitator;
    public static SpeedController brush;
    public static SpeedController witch;
    public static DigitalInput fuelLimitSwitch1;
    public static Ultrasonic gearUltrasonic1;
    //public static Solenoid gearSolenoid1;
    //public static Compressor airCompressor1;
    //public static Solenoid airSolenoid1;
    //public static Relay airRelaySolenoid1;
    //public static DoubleSolenoid airDoubleSolenoid1;
    //public static Servo pIDSubsystem1Servo1;
    //public static Servo pIDSubsystem1Servo2;
    //public static AnalogPotentiometer pIDSubsystem1AnalogPotentiometer1;
    //public static Solenoid pIDSubsystem1Solenoid1;
    //public static SpeedController pIDSubsystem1SpeedController1;

    
    public static void init() {
        // declare our Victors, in a clockwise direction across the front and then the back,
    	// as if you were sitting in the center of the robot
    	// 0 intake 1
    	// x xxxxxx x
    	// x xxxxxx x
    	// 3 xgearx 2
    	chassisSpeedController0 = new Victor(0); // Front Left
        LiveWindow.addActuator("chassis", "Speed Controller 0", (Victor) chassisSpeedController0);
        
        chassisSpeedController1 = new Victor(1); // Front Right
        LiveWindow.addActuator("chassis", "Speed Controller 1", (Victor) chassisSpeedController1);
        
        chassisSpeedController2 = new Victor(2); // Rear Right
        LiveWindow.addActuator("chassis", "Speed Controller 2", (Victor) chassisSpeedController2);
        
        chassisSpeedController3 = new Victor(3); // Rear Left
        LiveWindow.addActuator("chassis", "Speed Controller 3", (Victor) chassisSpeedController3);
        
        // REMOVED - RobotDrive gives errors and lots of lost packets
        //chassismover = new RobotDrive(chassisSpeedController0, chassisSpeedController1,
        //      chassisSpeedController2, chassisSpeedController3);
        
        //chassismover.setSafetyEnabled(true);
        //chassismover.setExpiration(0.1);
        //chassismover.setSensitivity(0.5);
        //chassismover.setMaxOutput(1.0);

        chassisAnalogGyro1 = new AnalogGyro(0);
        LiveWindow.addSensor("chassis", "AnalogGyro 1", chassisAnalogGyro1);
        chassisAnalogGyro1.setSensitivity(0.007);
        chassisPowerDistributionPanel1 = new PowerDistributionPanel(0);
        LiveWindow.addSensor("chassis", "PowerDistributionPanel 1", chassisPowerDistributionPanel1);
        
        chassisAnalogAccelerometer1 = new AnalogAccelerometer(1);
        LiveWindow.addSensor("chassis", "AnalogAccelerometer 1", chassisAnalogAccelerometer1);
        chassisAnalogAccelerometer1.setSensitivity(0.0);
        chassisAnalogAccelerometer1.setZero(2.5);
        
        fuelspinnies = new Victor(4);
        LiveWindow.addActuator("fuel", "spinnies", (Victor) fuelspinnies);
        
        shooterMotor = new Victor(5);
        LiveWindow.addActuator("shoot", "shoot motor", (Victor) shooterMotor);
        
        agitator = new Victor(7);
        LiveWindow.addActuator("agitate", "agitate motor", (Victor) agitator);
        
        brush = new Victor (8);
        LiveWindow.addActuator("brush", "brush motor", (Victor) brush);
        
        witch = new Victor (6);
        LiveWindow.addActuator("witch", "witch motor", (Victor) witch);
       
        fuelLimitSwitch1 = new DigitalInput(2);
        LiveWindow.addSensor("fuel", "Limit Switch 1", fuelLimitSwitch1);
        
        gearUltrasonic1 = new Ultrasonic(0, 1);
        LiveWindow.addSensor("gear", "Ultrasonic 1", gearUltrasonic1);
        
        //airCompressor1 = new Compressor(0);
        
        //airSolenoid1 = new Solenoid(0, 0);
        //LiveWindow.addActuator("air", "Solenoid 1", airSolenoid1);
        
        //airRelaySolenoid1 = new Relay(0);
        //LiveWindow.addActuator("air", "Relay Solenoid 1", airRelaySolenoid1);
        
        //airDoubleSolenoid1 = new DoubleSolenoid(0, 1, 2);
        //LiveWindow.addActuator("air", "Double Solenoid 1", airDoubleSolenoid1);
        //gearSolenoid1 = new Solenoid(0, 3);
        //LiveWindow.addActuator("gear", "Solenoid 1", gearSolenoid1);
        
        //pIDSubsystem1Servo1 = new Servo(5);
        //LiveWindow.addActuator("PID Subsystem 1", "Servo 1", pIDSubsystem1Servo1);
        
        //pIDSubsystem1Servo2 = new Servo(6);
        //LiveWindow.addActuator("PID Subsystem 1", "Servo 2", pIDSubsystem1Servo2);
        
        //pIDSubsystem1AnalogPotentiometer1 = new AnalogPotentiometer(2, 1.0, 0.0);
        //LiveWindow.addSensor("PID Subsystem 1", "Analog Potentiometer 1", pIDSubsystem1AnalogPotentiometer1);
        
        //pIDSubsystem1Solenoid1 = new Solenoid(0, 4);
        //LiveWindow.addActuator("PID Subsystem 1", "Solenoid 1", pIDSubsystem1Solenoid1);
        
        //pIDSubsystem1SpeedController1 = new Talon(7);
        //LiveWindow.addActuator("PID Subsystem 1", "Speed Controller 1", (Talon) pIDSubsystem1SpeedController1);
        

    }
}
