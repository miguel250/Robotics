/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package TechnoBots;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class TechnoBots extends IterativeRobot {

    RobotDrive motors;
    Joystick joystick;
    AxisCamera camera;
    Compressor comp;
    Timer timer;
    Victor buttonmotor;
    Victor topmotor;
    Solenoid s1, s2, s3, s4, s5, s6;
    DigitalInput lcenter, lright, lleft;
    Encoder rencoder;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    TechnoBots() {
        motors = new RobotDrive(1, 2, 3, 4);
        topmotor = new Victor(6);
        buttonmotor = new Victor(5);
        s1 = new Solenoid(1);                        // Solenoid port
        s2 = new Solenoid(2);
        s3 = new Solenoid(3);
        s4 = new Solenoid(4);
        s5 = new Solenoid(5);
        s6 = new Solenoid(6);
        timer = new Timer();
        lright = new DigitalInput(1);
        lcenter = new DigitalInput(2);
        lleft = new DigitalInput(3);
        comp = new Compressor(8, 8);  //Digtial I/O,Relay
       rencoder = new Encoder(13,12, false);


        // Define joysticks being used at USB port #1 and USB port #2 on the Drivers Station
        joystick = new Joystick(1);
        
    }

    public void robotInit() {
        camera = AxisCamera.getInstance();
        comp.start();
        rencoder.start();
        rencoder.reset();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Watchdog.getInstance().feed();
      
       s1.set(true);
       s2.set(false);
       s3.set(false);        
       s4.set(true);

        
        motors.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        motors.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        
        System.out.println("Encoder:" + rencoder.getDistance()); 
        
        while(rencoder.getDistance() < 2800){
        if (lcenter.get()) {
            motors.mecanumDrive_Cartesian(0.0, 0.4, 0.0, 0.0);
        } else if (lright.get()) {
            motors.mecanumDrive_Cartesian(-0.2, 0.2, 0.0, 0.0);
        } else if (lleft.get()) {
            motors.mecanumDrive_Cartesian(0.2, 0.2, 0.0, 0.0);
        }
        }
        if(rencoder.getDistance() == 2800){
            Timer.delay(3);
            buttonmotor.set(1);
            topmotor.set(1);
            Timer.delay(2);
            buttonmotor.set(0);
            topmotor.set(0);
            
        }
                    
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {

        Watchdog.getInstance().feed();
        if (joystick.getRawButton(5)) {
            buttonmotor.set(-0.9);
            topmotor.set(-0.9);

        } else if (joystick.getRawButton(6)) {
            buttonmotor.set(0.9);
            topmotor.set(0.9);
        } else if (joystick.getRawAxis(3) > 0) {
            buttonmotor.set(0.9);
            topmotor.set(-0.9);

        } else if (joystick.getRawAxis(3) < 0) {
            buttonmotor.set(-0.9);
            topmotor.set(0.9);

        } else {
            topmotor.set(0);
            buttonmotor.set(0);
        }
        if (joystick.getRawButton(1)) {
            s1.set(true);
            s2.set(false);
        } else if (joystick.getRawButton(2)) {
            s1.set(false);
            s2.set(true);
        }
        if (joystick.getRawButton(3)) {
            s3.set(true);
            s4.set(false);
        } else if (joystick.getRawButton(4)) {
            s3.set(false);
            s4.set(true);
        } else if (joystick.getRawButton(7) && joystick.getRawButton(8)) {
            s5.set(true);
            s6.set(false);
        } else {
            s5.set(false);
            s6.set(true);
        }

        double magnitude, rotation, direction;
        motors.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        motors.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        rotation = this.calcBuffer(this.joystick.getRawAxis(4));
        magnitude = this.calcBuffer(this.joystick.getMagnitude());
        direction = this.calcBuffer(this.joystick.getDirectionDegrees());

        motors.mecanumDrive_Polar(magnitude, direction, rotation);
       System.out.println("Encoder:" + rencoder.getDistance());         
    }

    private double calcBuffer(double n) {
        double buffer = 0.3;
        if (Math.abs(n) < buffer) {
            n = 0.000000000000000;
        }
        return n;
    }
}
