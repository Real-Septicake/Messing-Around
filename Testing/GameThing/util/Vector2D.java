package GameThing.util;

import java.awt.Dimension;

/**
 * A class that allows for the creation and use of 2D mathematical vectors
 * 
 * @since 2/28/23
 * @version 1.0 (3/10/23)
 */
public class Vector2D {
    private double maxLength = 0;
    private double length = 0;
    private double dy = 0;
    private double dx = 0;
    private double angle = 0;

    /**
     * Creates a {@code Vector2D} with all values set to 0
     */
    public Vector2D(){
    }

    /**
     * Creates a {@code Vector2D} with {@code X}, and {@code Y} offsets specified by the {@code Dimension}
     */
    public Vector2D(Dimension xy){
        dx = xy.getWidth();
        dy = xy.getHeight();
        updatePolar();
    }

    /**
     * Creates a {@code Vector2D} with a specified {@code maxLength} value
     * @param max {@code maxLength} value
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
     * Update this {@code Vector2D} with new {@code X} and {@code Y} offsets
     * 
     * @param x New {@code X} offset
     * @param y New {@code Y} offset
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
     */
    public void updatePolarCoords(double angle, double length){
        this.angle = angle;
        this.length = Math.min(length, maxLength);
        updateCartesian();

    }

    /**
     * @return The current value of the {@code X} component of this {@code Vector2D} 
     */
    public double getX(){
        updateCartesian();
        return dx;
    }

    /**
     * @return The current value of the {@code Y} component of this {@code Vector2D}
     */
    public double getY(){
        updateCartesian();
        return dy;
    }

    /**
     * @return The current {@code length} of this {@code Vector2D}
     */
    public double getLength(){
        updatePolar();
        return length;
    }

    /**
     * @return The current {@code angle} of this {@code Vector2D} 
     */
    public double getAngle(){
        updatePolar();
        return angle;
    }

    /**
     * @return The {@code maxLength} of this {@code Vector2D}
     */
    public double getMax(){
        return maxLength;
    }

    /**
     * Updates the {@code angle} and {@code length} of this {@code Vector2D}
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
     */
    private void updateCartesian(){
        this.dx = length * Math.cos(angle);
        this.dy = length * Math.sin(angle);
    }
}
