package GameThing.util;

import java.awt.Dimension;

/**
 * A class that allows for the creation and use of vectors
 * <p><b><i> MAX LENGTH DOES WORK AS OF 3/3/23</b></i>
 * 
 * @since 2/28/23
 * @version 0.1.2 (3/3/23)
 */
//TODO: Create better methods for updating vector state, might be worth taking it directly from Greenfoot
//TODO: Might be worth trying to differentiate 2d vectors and 3d vectors in the future, probably thinking too far ahead
public class Vector {
    double maxLength = 0;
    public double length;
    double dy;
    double dx;
    double angle;

    /**
     * Creates an empty Vector
     */
    public Vector(){
    }

    /**
     * Creates a Vector with specified x and y offsets
     * 
     * @param x X Offset
     * @param y Y Offset
     */
    public Vector(Dimension xy){
        dx = xy.getWidth();
        dy = xy.getHeight();
    }

    /**
     * Creates a Vector with a specified maximum length
     * @param max Max Length of Vector
     */
    public Vector(double max){
        maxLength = max;
    }

    private void calcLength(){
        //TODO: Fix vector length clamping
        if(maxLength != 0){
            length = Math.min(calcRawLength(dx, dy), maxLength);
        }else{
            length = calcRawLength(dx, dy);
        }  
    }

    private double calcRawLength(double x, double y){
        return Math.sqrt((x * x) + (y * y));
    }

    private void calcAngle(){
        angle = Math.atan2(dy, dx);
    }

    /**
     * Update Vector with new x and y offsets
     * 
     * @param x New X Offset
     * @param y New y Offset
     */
    public void updateCoord(double x, double y){
        dx = x;
        dy = y;
        updatePolar();
    }

    public void updateAngle(double angle, double length){
        this.angle = angle;
        this.length = Math.min(length, maxLength);
        updateCartesian();

    }

    /**
     * @return The current value of the X component of the Vector 
     */
    public double getX(){
        return dx;
    }

    /**
     * @return The current value of the Y component of the Vector
     */
    public double getY(){
        return dy;
    }

    private void updatePolar(){
        this.angle = Math.atan2(dy, dx);
        if(maxLength != 0){
            length = Math.min(calcRawLength(dx, dy), maxLength);
        }else{
            length = calcRawLength(dx, dy);
        }
    }

    private void updateCartesian(){
        this.dx = length * Math.cos(angle);
        this.dy = length * Math.sin(angle);
    }
}
