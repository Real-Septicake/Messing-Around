package GameThing.util;

/**
 * A class that allows for the creation and use of 3D mathematical vectors
 * 
 * @since 1.0
 * @version 1.1 (3/13/23)
 */
// TODO: Seperate Double and Float precision
public class Vector3D {

    /**
     * Maximum allowed {@code length} of the {@code Vector3D} object
     * 
     * <p>
     * 0 is the default value and does not restrict the {@code length}
     * </p>
     */
    private double maxLength = 0;

    /**
     * Magnitude of the {@code Vector3D} object
     */
    private double length = 0;

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
     * Creates a {@code Vector3D} with specified {@code length}, {@code theta}, and
     * {@code phi} values
     * 
     * @param length {@code length} value
     * @param theta  {@code theta} vlue
     * @param phi    {@code phi} value
     *
     * @since 1.0
     */
    public Vector3D(int length, double theta, double phi) {
        this.length = length;
        this.theta = theta;
        this.phi = phi;
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
     * @param max {@code maxLength} value
     *
     * @since 1.0
     */
    public Vector3D(double max) {
        maxLength = max;
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
     * Updates the {@code length}, {@code theta}, and {@code phi} values of this
     * {@code Vector3D}
     */
    private void updateSpherical() {
        if (maxLength != 0) {
            length = Math.min(calcRawLength(dx, dy, dz), maxLength);
        } else {
            length = calcRawLength(dx, dy, dz);
        }
        theta = Math.acos(dz / (Math.sqrt((dx * dx) + (dy * dy) + (dz * dz))));
        phi = Math.signum(dy) * Math.acos(dx / Math.sqrt((dx * dx) + (dy * dy)));
    }

    /**
     * Updates the {@code X}, {@code Y}, and {@code Z} offsets of this
     * {@code Vector3D}
     */
    private void updateCartesian() {
        dx = length * Math.sin(theta) * Math.cos(phi);
        dy = length * Math.sin(theta) * Math.sin(phi);
        dz = length * Math.cos(theta);
    }

    /**
     * Update this {@code Vector3D} with new {@code length}, {@code theta}, and
     * {@code phi} values
     * 
     * @param length New {@code length} value
     * @param theta  New {@code theta} value
     * @param phi    New {@code phi} value
     */
    public void updateSphericalCoords(double length, double theta, double phi) {
        if (maxLength != 0) {
            this.length = Math.min(length, maxLength);
        } else {
            this.length = length;
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
     * @return The current value of this {@code Vector3D}'s {@code Phi} angle
     */
    public double getPhi() {
        updateSpherical();
        return phi;
    }

    /**
     * {@code Theta} is the angle on the XZ plane rising from X
     * 
     * @return The current value of this {@code Vector3D}'s {@code Theta} angle
     */
    public double getTheta() {
        updateSpherical();
        return theta;
    }

    /**
     * @return The current length of this {@code Vector3D}
     */
    public double getLength() {
        updateCartesian();
        return length;
    }

    /**
     * @return The maximum length of this {@code Vector3D}
     */
    public double getMax() {
        return maxLength;
    }
}
