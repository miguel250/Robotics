/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.technobots;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Kinect;
import edu.wpi.first.wpilibj.Skeleton;

/**
 *
 * @author Shakira
 */
public class KinectGestures {

    Kinect kinect;
    static final int LEG_FORWARD = -110;
    static final int HEAD_LEFT = 98;
    static final int HEAD_RIGHT = 82;

    public KinectGestures() {
        double headAngle;

        kinect = Kinect.getInstance();
    }

    public boolean[] Kinecthead() {
        double headAngle;
        boolean[] buttons = new boolean[2];

        headAngle = AngleXY(kinect.getSkeleton().GetShoulderCenter(), kinect.getSkeleton().GetHead(), false);
        buttons[0] = headAngle > HEAD_LEFT;
        buttons[1] = headAngle < HEAD_RIGHT;

        return buttons;
    }

    public boolean[] Kinectleg() {
        double leftLegYZ;
        boolean[] buttons = new boolean[1];

        leftLegYZ = AngleYZ(kinect.getSkeleton().GetHipLeft(), kinect.getSkeleton().GetAnkleLeft(), false);


        buttons[6] = leftLegYZ < LEG_FORWARD;
        return buttons; 
    }

    private double AngleXY(Skeleton.Joint origin, Skeleton.Joint measured, boolean mirrored) {
        return Math.toDegrees(MathUtils.atan2(measured.getY() - origin.getY(),
                (mirrored) ? (origin.getX() - measured.getX()) : (measured.getX() - origin.getX())));
    }

    private double AngleYZ(Skeleton.Joint origin, Skeleton.Joint measured, boolean mirrored) {
        return Math.toDegrees(MathUtils.atan2(measured.getY() - origin.getY(),
                (mirrored) ? (origin.getZ() - measured.getZ()) : (measured.getZ() - origin.getZ())));
    }
}
