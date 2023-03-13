package GameThing.util;

import java.awt.Dimension;

/**
 * A class that allows for the creation and use of 2D mathematical vectors
 * 
 * @since 1.0
 * @version 1.1 (3/13/23)
 */
//TODO: Seperate Double and Float precision
public class Vector2D {

    /**
     * Maximum allowed {@code length} of the {@code Vector2D} object
     * 
     * <p>0 is the default value and does not restrict the {@code length}</p>
     */
    private double maxLength = 0;

    /**
     * Magnitude of the {@code Vector2D} object
     */
    private double length = 0;

    /**
     * X component of the {@code Vector2D} object
     */
    private double dx = 0;

    /**
     * Y component of the {@code Vector2D} object
     */
    private double dy = 0;

    /**
     * Angle of the {@code Vector2D} object
     */
    private double angle = 0;

    /**
     * Creates a {@code Vector2D} with all values set to 0
     * 
     * @since 1.0
     */
    public Vector2D(){
    }

    /**
     * Creates a {@code Vector2D} with {@code X}, and {@code Y} offsets specified by the {@code Dimension}
     * 
     * @since 1.0
     */
    //TODO: Find a way to avoid the use of a Dimension object
    public Vector2D(Dimension xy){
        dx = xy.getWidth();
        dy = xy.getHeight();
        updatePolar();
    }

    /**
     * Creates a {@code Vector2D} with a specified {@code maxLength} value
     * @param max {@code maxLength} value
     *
     * @since 1.0
     */
    public Vector2D(double max){
        maxLength = max;
    }

    /**
     * Create a {@code Vector2D} with specified angle and length
     * @param angle Angle of new {@code Vector2D}
     * @param length Length of new {@code Vector2D}
     *
     * @since 1.0
     */
    public Vector2D(double angle, double length){
        this.length = length;
        this.angle = angle;
        updateCartesian();
    }

    /**
     * Create a {@code Vector2D} with the same values as the specified {@code Vector2D}
     * @param v {@code Vector2D} to copy the values from
     *
     * @since 1.0
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
     * Update this {@code Vector2D} with new {@code X} and {@code Y} offsets
     * 
     * @param x New {@code X} offset
     * @param y New {@code Y} offset
     *
     * @since 1.0
     */
    public void updateCartesianCoords(double x, double y){
        dx = x;
        dy = y;
        updatePolar();
    }

    /**
     * Update this {@code Vector2D} with new {@code angle} and {@code length} values
     * 
     * @param angle New {@code angle} value
     * @param length New {@code length} value
     *
     * @since 1.0
     */
    public void updatePolarCoords(double angle, double length){
        this.angle = angle;
        this.length = Math.min(length, maxLength);
        updateCartesian();

    }

    /**
     * @return The current value of the {@code X} component of this {@code Vector2D} 
     *
     * @since 1.0
     */
    public double getX(){
        updateCartesian();
        return dx;
    }

    /**
     * @return The current value of the {@code Y} component of this {@code Vector2D}
     *
     * @since 1.0
     */
    public double getY(){
        updateCartesian();
        return dy;
    }

    /**
     * @return The current {@code length} of this {@code Vector2D}
     *
     * @since 1.0
     */
    public double getLength(){
        updatePolar();
        return length;
    }

    /**
     * @return The current {@code angle} of this {@code Vector2D} 
     *
     * @since 1.0
     */
    public double getAngle(){
        updatePolar();
        return angle;
    }

    /**
     * @return The {@code maxLength} of this {@code Vector2D}
     *
     * @since 1.0
     */
    public double getMax(){
        return maxLength;
    }

    /**
     * Updates the {@code angle} and {@code length} of this {@code Vector2D}
     *
     * @since 1.0
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
     * Updates {@code X} and {@code Y} offsets of {@code Vector2D}
     *
     * @since 1.0
     */
    private void updateCartesian(){
        this.dx = length * Math.cos(angle);
        this.dy = length * Math.sin(angle);
    }
}
