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

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5265.steamwiffle.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc5265.steamwiffle.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	// necessary for autonomous
    Command autonomousCommand;
    SendableChooser <Command> autoChooser;


    // each subsystem must be declared
    public static OI oi;
    public static chassis chassis;
    public static air air;
    public static fuel fuel;
    public static gear gear;
    public static PIDSubsystem1 pIDSubsystem1;
    public static stagValues stagValues;
    public static camera camera;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// start the RobotMap subsystem
    	RobotMap.init();
        // start each subsystem
    	chassis = new chassis();
        air = new air();
        fuel = new fuel();
        gear = new gear();
        pIDSubsystem1 = new PIDSubsystem1();
        stagValues = new stagValues();
        camera = new camera();

    


        
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        
        //autonomousCommand = new AutonomousCommand();
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Default Does Nothing", new AutonomousCommand());
        autoChooser.addObject("Center Alliance", new CenterAllianceAutonomous());
        autoChooser.addObject("Right Alliance", new RightAllianceAutonomous());
        autoChooser.addObject("Left Alliance", new LeftAllianceAutonomous());
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        

        autonomousCommand = new CenterAllianceAutonomous();

   

    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)

    	autonomousCommand = autoChooser.getSelected();

        if (autonomousCommand != null) autonomousCommand.start();
        }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
