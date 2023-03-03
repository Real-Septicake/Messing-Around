package GameThing.util;

/**
 * A class that allows for the creation and use of vectors
 * <p><b><i> MAX LENGTH DOES WORK AS OF 3/3/23 </b>
 * 
 * @since 2/28/23
 * @version 0.1.2
 */
//TODO: Create better methods for updating vector state, might be worth taking it directly from Greenfoot
//TODO: Might be worth trying to differentiate 2d vectors and 3d vectors in the future, probably thinking too far ahead
public class Vector {
    private double maxLength = 0;
    private double length;
    private double dy;
    private double dx;
    private double angle;

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
    public Vector(double x, double y){
        dx = x;
        dy = y;
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
        // if(maxLength > 0){
        //     length = Math.min(calcRawLength(dx, dy), maxLength);
        //     return;
        // }
        length = calcRawLength(dx, dy);
        return;
    }

    private double calcRawLength(double x, double y){
        return Math.sqrt((x * x) + (y * y));
    }

    private void calcAngle(){
        angle = Math.atan2(dy, dx);
    }

    private void mainCalc(){
        calcLength();
        calcAngle();
        calcX();
        calcY();
    }

    /**
     * Update Vector with new x and y offsets
     * 
     * @param x New X Offset
     * @param y New y Offset
     */
    public void update(double x, double y){
        dx = x;
        dy = y;
        mainCalc();
    }

    private void calcX(){
        calcLength();
        calcAngle();
        dx = length * Math.cos(angle);
    }

    public double getX(){
        calcX();
        return dx;
    }

    private double calcY(){
        calcLength();
        calcAngle();
        return length * Math.sin(angle);
    }

    public double getY(){
        calcY();
        return dy;
    }
}
