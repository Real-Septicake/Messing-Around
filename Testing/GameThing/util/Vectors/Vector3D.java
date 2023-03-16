package GameThing.util.Vectors;

/**
 * A class that allows for the creation and use of 3D mathematical vectors
 * 
 * @since 1.0
 * @version 1.3 (3/13/23)
 * @author Septicake
 */
public abstract class Vector3D {

    /**
     * Defines 3D mathematical vectors with double precision
     */
    public static class Double extends Vector3D {
        /**
         * Maximum allowed {@code magnitude} of the {@code Vector3D.Double} object
         * 
         * <p>
         * 0 is the default value and does not restrict the {@code magnitude}
         * </p>
         */
        protected double maxMagnitude = 0;

        /**
         * Magnitude of the {@code Vector3D.Double} object
         */
        protected double magnitude = 0;

        /**
         * X component of the {@code Vector3D.Double} object
         */
        protected double dx = 0;

        /**
         * Y component of the {@code Vector3D.Double} object
         */
        protected double dy = 0;

        /**
         * Z component of the {@code Vector3D.Double} object
         */
        protected double dz = 0;

        /**
         * Angle on the YZ plane rising from Y
         */
        protected double theta = 0;

        /**
         * Angle on the XZ plane rising from X
         */
        protected double phi = 0;

        /**
         * Creates a {@code Vector3D.Double} with all values set to 0
         *
         * @since 1.0
         */
        public Double() {
        }

        /**
         * Creates a {@code Vector3D.Double} with specified {@code magnitude},
         * {@code theta}, and {@code phi} values
         * 
         * @param magnitude {@code magnitude} value of new {@code Vector3D.Double}
         * @param theta     {@code theta} value of new {@code Vector3D.Double}
         * @param phi       {@code phi} value of new {@code Vector3D.Double}
         * @param max       {@code maxMagnitude} value of new {@code Vector3D.Double},
         *                  where 0 means no maximum
         *
         * @since 1.0
         */
        public Double(double magnitude, double theta, double phi, double max) {
            this.magnitude = magnitude;
            this.theta = theta;
            this.phi = phi;
            maxMagnitude = max;
            updateCartesian();
        }

        /**
         * Creates a {@code Vector3D.Double} with {@code X}, {@code Y}, and {@code Z}
         * offsets
         * 
         * @param x {@code X} offset
         * @param y {@code Y} offset
         * @param z {@code Z} offset
         *
         * @since 1.0
         */
        public Double(double x, double y, double z) {
            dx = x;
            dy = y;
            dz = z;
            updateSpherical();
        }

        /**
         * Creates a {@code Vector3D.Double} with a specified {@code maxLength} value
         * 
         * @param max {@code maxMagnitude} value, where 0 means no maximum
         *
         * @since 1.0
         */
        public Double(double max) {
            maxMagnitude = max;
        }

        public Double(Vector3D.Double v) {
            dx = v.dx;
            dy = v.dy;
            dz = v.dz;
            updateSpherical();
        }

        public double calcRawLength(double x, double y, double z) {
            return Math.sqrt((x * x) + (y * y) + (z * z));
        }

        /**
         * Updates the {@code magnitude}, {@code theta}, and {@code phi} values of this
         * {@code Vector3D.Double}
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
         * {@code Vector3D.Double}
         */
        private void updateCartesian() {
            dx = magnitude * Math.sin(theta) * Math.cos(phi);
            dy = magnitude * Math.sin(theta) * Math.sin(phi);
            dz = magnitude * Math.cos(theta);
        }

        /**
         * Update this {@code Vector3D.Double} with new {@code length}, {@code theta},
         * and {@code phi} values
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
         * Update this {@code Vector3D.Double} with new {@code X}, {@code Y}, and
         * {@code Z} offets
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
         * {@inheritDocs}
         */
        public double getX() {
            updateCartesian();
            return dx;
        }

        /**
         * {@inheritDocs}
         */
        public double getY() {
            updateCartesian();
            return dy;
        }

        /**
         * {@inheritDocs}
         */
        public double getZ() {
            updateCartesian();
            return dz;
        }

        /**
         * {@inheritDocs}
         */
        public double getPhi() {
            updateSpherical();
            return phi;
        }

        /**
         * {@inheritDocs}
         */
        public double getTheta() {
            updateSpherical();
            return theta;
        }

        /**
         * {@inheritDocs}
         */
        public double getMagnitude() {
            updateCartesian();
            return magnitude;
        }

        /**
         * {@inheritDocs}
         */
        public double getMax() {
            return maxMagnitude;
        }
    }

    /**
     * Defines 3D mathematical vectors with double precision
     */
    public static class Float extends Vector3D {
        /**
         * Maximum allowed {@code magnitude} of the {@code Vector3D.Float} object
         * 
         * <p>
         * 0 is the default value and does not restrict the {@code magnitude}
         * </p>
         */
        protected float maxMagnitude = 0;

        /**
         * Magnitude of the {@code Vector3D.Float} object
         */
        protected float magnitude = 0;

        /**
         * X component of the {@code Vector3D.Float} object
         */
        protected float dx = 0;

        /**
         * Y component of the {@code Vector3D.Float} object
         */
        protected float dy = 0;

        /**
         * Z component of the {@code Vector3D.Float} object
         */
        protected float dz = 0;

        /**
         * Angle on the XZ plane rising from X
         */
        protected float theta = 0;

        /**
         * Angle on the YZ plane rising from Z
         */
        protected float phi = 0;

        /**
         * Creates a {@code Vector3D.Float} with all values set to 0
         *
         * @since 1.0
         */
        public Float() {
        }

        /**
         * Creates a {@code Vector3D.Float} with specified {@code magnitude},
         * {@code theta}, and {@code phi} values
         * 
         * @param magnitude {@code magnitude} value of new {@code Vector3D.Float}
         * @param theta     {@code theta} value of new {@code Vector3D.Float}
         * @param phi       {@code phi} value of new {@code Vector3D.Float}
         * @param max       {@code maxMagnitude} value of new {@code Vector3D.Float},
         *                  where 0 means no maximum
         *
         * @since 1.0
         */
        public Float(float magnitude, float theta, float phi, float max) {
            this.magnitude = magnitude;
            this.theta = theta;
            this.phi = phi;
            maxMagnitude = max;
            updateCartesian();
        }

        /**
         * Creates a {@code Vector3D.Float} with {@code X}, {@code Y}, and {@code Z}
         * offsets
         * 
         * @param x {@code X} offset
         * @param y {@code Y} offset
         * @param z {@code Z} offset
         *
         * @since 1.0
         */
        public Float(float x, float y, float z) {
            dx = x;
            dy = y;
            dz = z;
            updateSpherical();
        }

        /**
         * Creates a {@code Vector3D.Float} with a specified {@code maxLength} value
         * 
         * @param max {@code maxMagnitude} value, where 0 means no maximum
         *
         * @since 1.0
         */
        public Float(float max) {
            maxMagnitude = max;
        }

        public Float(Vector3D.Float v) {
            dx = v.dx;
            dy = v.dy;
            dz = v.dz;
            updateSpherical();
        }

        public float calcRawLength(float x, float y, float z) {
            return (float) Math.sqrt((x * x) + (y * y) + (z * z));
        }

        /**
         * Updates the {@code magnitude}, {@code theta}, and {@code phi} values of this
         * {@code Vector3D.Float}
         */
        private void updateSpherical() {
            if (maxMagnitude != 0) {
                magnitude = Math.min(calcRawLength(dx, dy, dz), maxMagnitude);
            } else {
                magnitude = calcRawLength(dx, dy, dz);
            }
            theta = (float) Math.acos(dz / (Math.sqrt((dx * dx) + (dy * dy) + (dz * dz))));
            phi = (float) (Math.signum(dy) * Math.acos(dx / Math.sqrt((dx * dx) + (dy * dy))));
        }

        /**
         * Updates the {@code X}, {@code Y}, and {@code Z} offsets of this
         * {@code Vector3D.Float}
         */
        private void updateCartesian() {
            dx = magnitude * (float) (Math.sin(theta) * Math.cos(phi));
            dy = magnitude * (float) (Math.sin(theta) * Math.sin(phi));
            dz = magnitude * (float) Math.cos(theta);
        }

        /**
         * Update this {@code Vector3D.Float} with new {@code length}, {@code theta},
         * and {@code phi} values
         * 
         * @param magnitude New {@code magnitude} value
         * @param theta     New {@code theta} value
         * @param phi       New {@code phi} value
         */
        public void updateSphericalCoords(float magnitude, float theta, float phi) {
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
         * Update this {@code Vector3D.Float} with new {@code X}, {@code Y}, and
         * {@code Z} offets
         * 
         * @param x New {@code X} offset
         * @param y New {@code Y} offset
         * @param z New {@code Z} offset
         */
        public void updateCartesianCoords(float x, float y, float z) {
            dx = x;
            dy = y;
            dz = z;
            updateSpherical();
        }

        /**
         * {@inheritDocs}
         */
        public double getX() {
            updateCartesian();
            return (double) dx;
        }

        /**
         * {@inheritDocs}
         */
        public double getY() {
            updateCartesian();
            return (double) dy;
        }

        /**
         * {@inheritDocs}
         */
        public double getZ() {
            updateCartesian();
            return (double) dz;
        }

        /**
         * {@inheritDocs}
         */
        public double getPhi() {
            updateSpherical();
            return (double) phi;
        }

        /**
         * {@inheritDocs}
         */
        public double getTheta() {
            updateSpherical();
            return (double) theta;
        }

        /**
         * {@inheritDocs}
         */
        public double getMagnitude() {
            updateCartesian();
            return (double) magnitude;
        }

        /**
         * {@inheritDocs}
         */
        public double getMax() {
            return (double) maxMagnitude;
        }
    }

    abstract double getX();

    /**
     * @return The current value of this {@code Vector3D}'s Y component
     */
    abstract double getY();

    /**
     * @return The current value of this {@code Vector3D}'s Z component
     */
    abstract double getZ();

    /**
     * {@code Phi} is the angle on the YZ plane rising from Z
     * 
     * @return The current value of this {@code Vector3D}'s {@code phi} angle
     */
    abstract double getPhi();

    /**
     * {@code Theta} is the angle on the XZ plane rising from X
     * 
     * @return The current value of this {@code Vector3D}'s {@code theta} angle
     */
    abstract double getTheta();

    /**
     * @return The current {@code magnitude} of this {@code Vector3D}
     */
    abstract double getMagnitude();

    /**
     * @return The {@code maxMagnitude} of this {@code Vector3D}
     */
    abstract double getMax();
}
