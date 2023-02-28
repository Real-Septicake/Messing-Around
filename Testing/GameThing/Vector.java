package GameThing;

public class Vector {
    double maxLength;
    double length;
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
        if(maxLength <= 0 && maxLength != (Double) null){
            length = Math.min(calcRawLength(dx, dy), maxLength);
            return;
        }
        length = calcRawLength(dx, dy);
        return;
    }

    private double calcRawLength(double x, double y){
        return Math.sqrt((y * y) + (x * x));
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
