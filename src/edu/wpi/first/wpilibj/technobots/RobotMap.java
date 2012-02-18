package edu.wpi.first.wpilibj.technobots;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //Jugars
    public static final int lowerRight = 1,
                            lowerLeft  = 2,
                            upperRight = 3,
                            upperLeft  = 4;

    //Victors
    public static final int shooterRight = 5,
                            shooterLeft  = 6,
                            sweeper      = 7;
    //Sensors
    public static final int pot         = 1,
                            rangeFinder = 2;
}
