package GameThing.util;

import java.awt.Dimension;

/**
 * A class that allows for the creation and use of mathematical vectors
 * 
 * @since 2/28/23
 * @version 0.1.4 (3/6/23)
 */
//TODO: Create better methods for updating vector state, might be worth taking it directly from Greenfoot
//TODO: Might be worth trying to differentiate 2d vectors and 3d vectors in the future, probably thinking too far ahead
public class Vector2D {
    private double maxLength = 0;
    private double length = 0;
    private double dy = 0;
    private double dx = 0;
    private double angle = 0;

    /**
     * Creates an empty {@code Vector2D}
     */
    public Vector2D(){
    }

    /**
     * Creates a {@code Vector2D} with specified x and y offsets
     * 
     * @param x X Offset
     * @param y Y Offset
     */
    public Vector2D(Dimension xy){
        dx = xy.getWidth();
        dy = xy.getHeight();
        updatePolar();
    }

    /**
     * Creates a {@code Vector2D} with a specified maximum length
     * @param max Max Length of {@code Vector2D} (Pass in 0 for no maximum)
     */
    public Vector2D(double max){
        maxLength = max;
    }

    /**
     * Create a {@code Vector2D} with specified angle and length
     * @param angle Angle of new {@code Vector2D}
     * @param length Length of new {@code Vector2D}
     */
    public Vector2D(double angle, double length){
        this.length = length;
        this.angle = angle;
        updateCartesian();
    }

    /**
     * Create a {@code Vector2D} with the same values as the specified {@code Vector2D}
     * @param v {@code Vector2D} to copy the values from
     */
    public Vector2D(Vector2D v){
        this.dx = v.getX();
        this.dy = v.getY();
        this.maxLength = v.getMax();
        updatePolar();
    }

    private double calcRawLength(double x, double y){
        return Math.sqrt((x * x) + (y * y));
    }

    /**
     * Update this {@code Vector2D} with new x and y offsets
     * 
     * @param x New X Offset
     * @param y New y Offset
     */
    public void updateCoord(double x, double y){
        dx = x;
        dy = y;
        updatePolar();
    }

    /**
     * Update this {@code Vector2D} with new angle and length values
     * 
     * @param angle New angle value
     * @param length New length value
     */
    public void updateAngle(double angle, double length){
        this.angle = angle;
        this.length = Math.min(length, maxLength);
        updateCartesian();

    }

    /**
     * @return The current value of the X component of this {@code Vector2D} 
     */
    public double getX(){
        updateCartesian();
        return dx;
    }

    /**
     * @return The current value of the Y component of this {@code Vector2D}
     */
    public double getY(){
        updateCartesian();
        return dy;
    }

    /**
     * @return The current length of this {@code Vector2D}
     */
    public double getLength(){
        updatePolar();
        return length;
    }

    /**
     * @return The current angle of this {@code Vector2D} 
     */
    public double getAngle(){
        updatePolar();
        return angle;
    }

    /**
     * @return The max length of this {@code Vector2D}
     */
    public double getMax(){
        return maxLength;
    }

    /**
     * Updates the angle and length of this {@code Vector2D}
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
     * Updates X and Y offsets of {@code Vector2D}
     */
    private void updateCartesian(){
        this.dx = length * Math.cos(angle);
        this.dy = length * Math.sin(angle);
    }
}
