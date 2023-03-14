package GameThing.util;

/**
 * A class that allows for the creation and use of 2D mathematical vectors
 * 
 * @since 1.0
 * @version 1.2 (3/13/23)
 */
// TODO: Seperate Double and Float precision
public class Vector2D {

    /**
     * Maximum allowed {@code magnitude} of the {@code Vector2D} object
     * 
     * <p>
     * 0 is the default value and does not restrict the {@code magnitude}
     * </p>
     */
    private double maxMagnitude = 0;

    /**
     * Magnitude of the {@code Vector2D} object
     */
    private double magnitude = 0;

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
    public Vector2D() {
    }

    /**
     * Create a {@code Vector2D} with specified {@code angle}, {@code magnitude},
     * and {@code maxMagnitude}
     * 
     * @param angle     {@code angle} of new {@code Vector2D}
     * @param magniture {@code magnitude} of new {@code Vector2D}
     * @param max       {@code maxMagnitude} of new {@code Vector2D}, where 0 means
     *                  no maximum
     *
     * @since 1.0
     */
    public Vector2D(double magnitude, double angle, double max) {
        this.magnitude = magnitude;
        this.angle = angle;
        maxMagnitude = max;
        updateCartesian();
    }

    /**
     * Creates a {@code Vector2D} with {@code X}, and {@code Y} offsets
     * 
     * @param x {@code X} offset
     * @param y {@code Y} offset
     * 
     * @since 1.0
     */
    public Vector2D(double x, double y) {
        dx = x;
        dy = y;
        updatePolar();
    }

    /**
     * Creates a {@code Vector2D} with a specified {@code maxLength} value
     * 
     * @param max {@code maxMagnitude} of new {@code Vector2D}, where 0 means no
     *            maximum
     *
     * @since 1.0
     */
    public Vector2D(double max) {
        maxMagnitude = max;
    }

    /**
     * Create a {@code Vector2D} with the same values as the specified
     * {@code Vector2D}
     * 
     * @param v {@code Vector2D} to copy the values from
     *
     * @since 1.0
     */
    public Vector2D(Vector2D v) {
        dx = v.getX();
        dy = v.getY();
        maxMagnitude = v.getMax();
        updatePolar();
    }

    private double calcRawMagnitude(double x, double y) {
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
    public void updateCartesianCoords(double x, double y) {
        dx = x;
        dy = y;
        updatePolar();
    }

    /**
     * Update this {@code Vector2D} with new {@code angle} and {@code magnitude}
     * values
     * 
     * @param angle  New {@code angle} value
     * @param length New {@code length} value
     *
     * @since 1.0
     */
    public void updatePolarCoords(double angle, double magnitude) {
        this.angle = angle;
        magnitude = Math.min(magnitude, maxMagnitude);
        updateCartesian();

    }

    /**
     * @return The current value of the {@code X} component of this {@code Vector2D}
     *
     * @since 1.0
     */
    public double getX() {
        updateCartesian();
        return dx;
    }

    /**
     * @return The current value of the {@code Y} component of this {@code Vector2D}
     *
     * @since 1.0
     */
    public double getY() {
        updateCartesian();
        return dy;
    }

    /**
     * @return The current {@code magnitude} of this {@code Vector2D}
     *
     * @since 1.0
     */
    public double getMagnitude() {
        updatePolar();
        return magnitude;
    }

    /**
     * @return The current {@code angle} of this {@code Vector2D}
     *
     * @since 1.0
     */
    public double getAngle() {
        updatePolar();
        return angle;
    }

    /**
     * @return The {@code maxMagnitude} of this {@code Vector2D}
     *
     * @since 1.0
     */
    public double getMax() {
        return maxMagnitude;
    }

    /**
     * Updates the {@code angle} and {@code magnitude} of this {@code Vector2D}
     *
     * @since 1.0
     */
    private void updatePolar() {
        this.angle = Math.atan2(dy, dx);
        if (maxMagnitude != 0) {
            magnitude = Math.min(calcRawMagnitude(dx, dy), maxMagnitude);
        } else {
            magnitude = calcRawMagnitude(dx, dy);
        }
    }

    /**
     * Updates {@code X} and {@code Y} offsets of {@code Vector2D}
     *
     * @since 1.0
     */
    private void updateCartesian() {
        this.dx = magnitude * Math.cos(angle);
        this.dy = magnitude * Math.sin(angle);
    }
}
