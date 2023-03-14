package GameThing.util;

/**
 * A class that allows for the creation and use of 3D mathematical vectors
 * 
 * @since 1.0
 * @version 1.3 (3/13/23)
 * @author Septicake
 */
// TODO: Seperate Double and Float precision
public class Vector3D {

    /**
     * Maximum allowed {@code magnitude} of the {@code Vector3D} object
     * 
     * <p>
     * 0 is the default value and does not restrict the {@code magnitude}
     * </p>
     */
    private double maxMagnitude = 0;

    /**
     * Magnitude of the {@code Vector3D} object
     */
    private double magnitude = 0;

    /**
     * X component of the {@code Vector3D} object
     */
    private double dx = 0;

    /**
     * Y component of the {@code Vector3D} object
     */
    private double dy = 0;

    /**
     * Z component of the {@code Vector3D} object
     */
    private double dz = 0;

    /**
     * Angle on the XZ plane rising from X
     */
    private double theta = 0;

    /**
     * Angle on the YZ plane rising from Z
     */
    private double phi = 0;

    /**
     * Creates a {@code Vector3D} with all values set to 0
     *
     * @since 1.0
     */
    public Vector3D() {
    }

    /**
     * Creates a {@code Vector3D} with specified {@code magnitude}, {@code theta},
     * and {@code phi} values
     * 
     * @param magnitude {@code magnitude} value of new {@code Vector3D}
     * @param theta     {@code theta} value of new {@code Vector3D}
     * @param phi       {@code phi} value of new {@code Vector3D}
     * @param max       {@code maxMagnitude} value of new {@code Vector3D}, where 0
     *                  means no maximum
     *
     * @since 1.0
     */
    public Vector3D(double magnitude, double theta, double phi, double max) {
        this.magnitude = magnitude;
        this.theta = theta;
        this.phi = phi;
        maxMagnitude = max;
        updateCartesian();
    }

    /**
     * Creates a {@code Vector3D} with {@code X}, {@code Y}, and {@code Z} offsets
     * 
     * @param x {@code X} offset
     * @param y {@code Y} offset
     * @param z {@code Z} offset
     *
     * @since 1.0
     */
    public Vector3D(double x, double y, double z) {
        dx = x;
        dy = y;
        dz = z;
        updateSpherical();
    }

    /**
     * Creates a {@code Vector3D} with a specified {@code maxLength} value
     * 
     * @param max {@code maxMagnitude} value, where 0 means no maximum
     *
     * @since 1.0
     */
    public Vector3D(double max) {
        maxMagnitude = max;
    }

    public Vector3D(Vector3D v) {
        dx = v.getX();
        dy = v.getY();
        dz = v.getZ();
        updateSpherical();
    }

    public double calcRawLength(double x, double y, double z) {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    /**
     * Updates the {@code magnitude}, {@code theta}, and {@code phi} values of this
     * {@code Vector3D}
     */
    private void updateSpherical() {
        if (maxMagnitude != 0) {
            magnitude = Math.min(calcRawLength(dx, dy, dz), maxMagnitude);
        } else {
            magnitude = calcRawLength(dx, dy, dz);
        }
        theta = Math.acos(dz / (Math.sqrt((dx * dx) + (dy * dy) + (dz * dz))));
        phi = Math.signum(dy) * Math.acos(dx / Math.sqrt((dx * dx) + (dy * dy)));
    }

    /**
     * Updates the {@code X}, {@code Y}, and {@code Z} offsets of this
     * {@code Vector3D}
     */
    private void updateCartesian() {
        dx = magnitude * Math.sin(theta) * Math.cos(phi);
        dy = magnitude * Math.sin(theta) * Math.sin(phi);
        dz = magnitude * Math.cos(theta);
    }

    /**
     * Update this {@code Vector3D} with new {@code length}, {@code theta}, and
     * {@code phi} values
     * 
     * @param magnitude New {@code magnitude} value
     * @param theta     New {@code theta} value
     * @param phi       New {@code phi} value
     */
    public void updateSphericalCoords(double magnitude, double theta, double phi) {
        if (maxMagnitude != 0) {
            this.magnitude = Math.min(magnitude, maxMagnitude);
        } else {
            this.magnitude = magnitude;
        }
        this.theta = theta;
        this.phi = phi;
        updateCartesian();
    }

    /**
     * Update this {@code Vector3D} with new {@code X}, {@code Y}, and {@code Z}
     * offets
     * 
     * @param x New {@code X} offset
     * @param y New {@code Y} offset
     * @param z New {@code Z} offset
     */
    public void updateCartesianCoords(double x, double y, double z) {
        dx = x;
        dy = y;
        dz = z;
        updateSpherical();
    }

    /**
     * @return The current value of this {@code Vector3D}'s X component
     */
    public double getX() {
        updateCartesian();
        return dx;
    }

    /**
     * @return The current value of this {@code Vector3D}'s Y component
     */
    public double getY() {
        updateCartesian();
        return dy;
    }

    /**
     * @return The current value of this {@code Vector3D}'s Z component
     */
    public double getZ() {
        updateCartesian();
        return dz;
    }

    /**
     * {@code Phi} is the angle on the YZ plane rising from Z
     * 
     * @return The current value of this {@code Vector3D}'s {@code phi} angle
     */
    public double getPhi() {
        updateSpherical();
        return phi;
    }

    /**
     * {@code Theta} is the angle on the XZ plane rising from X
     * 
     * @return The current value of this {@code Vector3D}'s {@code theta} angle
     */
    public double getTheta() {
        updateSpherical();
        return theta;
    }

    /**
     * @return The current {@code magnitude} of this {@code Vector3D}
     */
    public double getMagnitude() {
        updateCartesian();
        return magnitude;
    }

    /**
     * @return The {@code maxMagnitude} of this {@code Vector3D}
     */
    public double getMax() {
        return maxMagnitude;
    }
}
