package GameThing.util;

import java.awt.Dimension;

/**
 * A class that allows for the creation and use of vectors
 * <p><b><i> MAX LENGTH DOES WORK AS OF 3/3/23</b></i>
 * 
 * @since 2/28/23
 * @version 0.1.3.1 (3/6/23)
 */
//TODO: Create better methods for updating vector state, might be worth taking it directly from Greenfoot
//TODO: Might be worth trying to differentiate 2d vectors and 3d vectors in the future, probably thinking too far ahead
public class Vector {
    private double maxLength = 0;
    private double length = 0;
    private double dy = 0;
    private double dx = 0;
    private double angle = 0;

    /**
     * Creates an empty {@code Vector}
     */
    public Vector(){
    }

    /**
     * Creates a {@code Vector} with specified x and y offsets
     * 
     * @param x X Offset
     * @param y Y Offset
     */
    public Vector(Dimension xy){
        dx = xy.getWidth();
        dy = xy.getHeight();
        updatePolar();
    }

    /**
     * Creates a {@code Vector} with a specified maximum length
     * @param max Max Length of {@code Vector} (Pass in 0 for no maximum)
     */
    public Vector(double max){
        maxLength = max;
    }

    public Vector(double angle, double length){
        this.length = length;
        this.angle = angle;
        updateCartesian();
    }

    private double calcRawLength(double x, double y){
        return Math.sqrt((x * x) + (y * y));
    }

    /**
     * Update {@code Vector} with new x and y offsets
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
     * @return The current value of the X component of the {@code Vector} 
     */
    public double getX(){
        updateCartesian();
        return dx;
    }

    /**
     * @return The current value of the Y component of the {@code Vector}
     */
    public double getY(){
        updateCartesian();
        return dy;
    }

    /**
     * @return The current length of the {@code Vector}
     */
    public double getLength(){
        updatePolar();
        return length;
    }

    /**
     * @return The current angle of the {@code Vector} 
     */
    public double getAngle(){
        updatePolar();
        return angle;
    }

    /**
     * @return The max length of the {@code Vector}
     */
    public double getMax(){
        return maxLength;
    }

    /**
     * Updates angle and length of {@code Vector}
     */
    private void updatePolar(){
        this.angle = Math.atan2(dy, dx);
        if(maxLength != 0){
            length = Math.min(calcRawLength(dx, dy), maxLength);
        }else{
            length = calcRawLength(dx, dy);
        }
    }

    /**
     * Updates X and Y offsets of {@code Vector}
     */
    private void updateCartesian(){
        this.dx = length * Math.cos(angle);
        this.dy = length * Math.sin(angle);
    }
}
