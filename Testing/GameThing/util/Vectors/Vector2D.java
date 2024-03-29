package GameThing.util.Vectors;

/**
 * A class that allows for the creation and use of 2D mathematical vectors
 *
 * @author Septicake
 * @version 1.3 (3/14/23)
 * @since 1.0
 */
public abstract class Vector2D {

    /**
     * Defines 2D mathematical vectors with double precision
     */
    public static class Double extends Vector2D {
        /**
         * Maximum allowed {@code magnitude} of the {@code Vector2D.Double} object
         *
         * <p>
         * 0 is the default value and does not restrict the {@code magnitude}
         * </p>
         */
        protected double maxMagnitude = 0;

        /**
         * Magnitude of the {@code Vector2D.Double} object
         */
        protected double magnitude = 0;

        /**
         * X component of the {@code Vector2D.Double} object
         */
        protected double dx = 0;

        /**
         * Y component of the {@code Vector2D.Double} object
         */
        protected double dy = 0;

        /**
         * Angle of the {@code Vector2D.Double} object in radians
         */
        protected double angle = 0;

        /**
         * Creates a {@code Vector2D.Double} with all values set to 0
         *
         * @since 1.0
         */
        public Double() {
        }

        /**
         * Create a {@code Vector2D.Double} with specified {@code angle}, {@code magnitude},
         * and {@code maxMagnitude}
         *
         * @param angle     {@code angle} value of new {@code Vector2D} in radians
         * @param magnitude {@code magnitude} value of new {@code Vector2D}
         * @param max       {@code maxMagnitude} value of new {@code Vector2D}, where 0 means no maximum
         * @since 1.0
         */
        public Double(double magnitude, double angle, double max) {
            this.magnitude = magnitude;
            this.angle = angle;
            maxMagnitude = max;
            updateCartesian();
        }

        /**
         * Creates a {@code Vector2D.Double} with {@code X}, and {@code Y} offsets
         *
         * @param x {@code X} offset
         * @param y {@code Y} offset
         * @since 1.0
         */
        public Double(double x, double y) {
            dx = x;
            dy = y;
            updatePolar();
        }

        /**
         * Creates a {@code Vector2D.Double} with a specified {@code maxLength} value
         *
         * @param max {@code maxMagnitude} of new {@code Vector2D.Double}, where 0 means no
         *            maximum
         * @since 1.0
         */
        public Double(double max) {
            maxMagnitude = max;
        }

        /**
         * Create a {@code Vector2D.Double} with the same values as the specified
         * {@code Vector2D.Double}
         *
         * @param v {@code Vector2D.Double} to copy the values from
         * @since 1.0
         */
        public Double(Vector2D.Double v) {
            dx = v.getX();
            dy = v.getY();
            maxMagnitude = v.getMax();
            updatePolar();
        }

        /**
         * Update this {@code Vector2D.Double} with new {@code X} and {@code Y} offsets
         *
         * @param x New {@code X} offset
         * @param y New {@code Y} offset
         * @since 1.0
         */
        public void updateCartesianCoords(double x, double y) {
            dx = x;
            dy = y;
            updatePolar();
        }

        /**
         * Update this {@code Vector2D.Double} with new {@code angle} and {@code magnitude}
         * values
         *
         * @param angle     New {@code angle} value
         * @param magnitude New {@code length} value
         * @since 1.0
         */
        public void updatePolarCoords(double angle, double magnitude) {
            this.angle = angle;
            magnitude = Math.min(magnitude, maxMagnitude);
            updateCartesian();

        }

        /**
         * @return The current value of the {@code X} component of this {@code Vector2D.Double}
         * @since 1.0
         */
        public double getX() {
            updateCartesian();
            return dx;
        }

        /**
         * @return The current value of the {@code Y} component of this {@code Vector2D.Double}
         * @since 1.0
         */
        public double getY() {
            updateCartesian();
            return dy;
        }

        /**
         * @return The current {@code magnitude} of this {@code Vector2D.Double}
         * @since 1.0
         */
        public double getMagnitude() {
            updatePolar();
            return magnitude;
        }

        /**
         * @return The current {@code angle} of this {@code Vector2D.Double}
         * @since 1.0
         */
        public double getAngle() {
            updatePolar();
            return angle;
        }

        /**
         * @return The {@code maxMagnitude} of this {@code Vector2D.Double}
         * @since 1.0
         */
        public double getMax() {
            return maxMagnitude;
        }

        /**
         * {@inheritDoc}
         */
        void updatePolar() {
            this.angle = Math.atan2(dy, dx);
            if (maxMagnitude != 0) {
                magnitude = Math.min(calcRawMagnitude(dx, dy), maxMagnitude);
            } else {
                magnitude = calcRawMagnitude(dx, dy);
            }
        }

        /**
         * {@inheritDoc}
         *
         * @since 1.3
         */
        void updateCartesian() {
            this.dx = magnitude * Math.cos(angle);
            this.dy = magnitude * Math.sin(angle);
        }
    }

    /**
     * Defines 2D mathematical vectors with float precision
     */
    public static class Float extends Vector2D {
        /**
         * Maximum allowed {@code magnitude} of the {@code Vector2D.Float} object
         *
         * <p>
         * 0 is the default value and does not restrict the {@code magnitude}
         * </p>
         */
        protected float maxMagnitude = 0;

        /**
         * Magnitude of the {@code Vector2D.Float} object
         */
        protected float magnitude = 0;

        /**
         * X component of the {@code Vector2D.Float} object
         */
        protected float dx = 0;

        /**
         * Y component of the {@code Vector2D.Float} object
         */
        protected float dy = 0;

        /**
         * Angle of the {@code Vector2D.Float} object
         */
        protected float angle = 0;

        /**
         * Creates a {@code Vector2D.Float} with all values set to 0
         *
         * @since 1.0
         */
        public Float() {
        }

        /**
         * Create a {@code Vector2D.Float} with specified {@code angle}, {@code magnitude},
         * and {@code maxMagnitude}
         *
         * @param angle     {@code angle} of new {@code Vector2D}
         * @param magnitude {@code magnitude} of new {@code Vector2D}
         * @param max       {@code maxMagnitude} of new {@code Vector2D}, where 0 means
         *                  no maximum
         * @since 1.0
         */
        public Float(float magnitude, float angle, float max) {
            this.magnitude = magnitude;
            this.angle = angle;
            maxMagnitude = max;
            updateCartesian();
        }

        /**
         * Creates a {@code Vector2D.Float} with {@code X}, and {@code Y} offsets
         *
         * @param x {@code X} offset
         * @param y {@code Y} offset
         * @since 1.0
         */
        public Float(float x, float y) {
            dx = x;
            dy = y;
            updatePolar();
        }

        /**
         * Creates a {@code Vector2D.Float} with a specified {@code maxLength} value
         *
         * @param max {@code maxMagnitude} of new {@code Vector2D}, where 0 means no
         *            maximum
         * @since 1.0
         */
        public Float(float max) {
            maxMagnitude = max;
        }

        /**
         * Create a {@code Vector2D.Float} with the same values as the specified
         * {@code Vector2D.Float}
         *
         * @param v {@code Vector2D.Float} to copy the values from
         * @since 1.0
         */
        public Float(Vector2D.Float v) {
            dx = v.dx;
            dy = v.dx;
            maxMagnitude = v.maxMagnitude;
            updatePolar();
        }

        /**
         * Update this {@code Vector2D.Float} with new {@code X} and {@code Y} offsets
         *
         * @param x New {@code X} offset
         * @param y New {@code Y} offset
         * @since 1.0
         */
        public void updateCartesianCoords(float x, float y) {
            dx = x;
            dy = y;
            updatePolar();
        }

        /**
         * Update this {@code Vector2D.Float} with new {@code angle} and {@code magnitude}
         * values
         *
         * @param angle     New {@code angle} value
         * @param magnitude New {@code length} value
         * @since 1.0
         */
        public void updatePolarCoords(float angle, float magnitude) {
            this.angle = angle;
            magnitude = Math.min(magnitude, maxMagnitude);
            updateCartesian();

        }

        /**
         * @return The current value of the {@code X} component of this {@code Vector2D.Float}
         * @since 1.0
         */
        public double getX() {
            updateCartesian();
            return (double) dx;
        }

        /**
         * @return The current value of the {@code Y} component of this {@code Vector2D.Float}
         * @since 1.0
         */
        public double getY() {
            updateCartesian();
            return (double) dy;
        }

        /**
         * @return The current {@code magnitude} of this {@code Vector2D.Float}
         * @since 1.0
         */
        public double getMagnitude() {
            updatePolar();
            return (double) magnitude;
        }

        /**
         * @return The current {@code angle} of this {@code Vector2D.Float}
         * @since 1.0
         */
        public double getAngle() {
            updatePolar();
            return (double) angle;
        }

        /**
         * @return The {@code maxMagnitude} of this {@code Vector2D.Float}
         * @since 1.0
         */
        public double getMax() {
            return (double) maxMagnitude;
        }

        /**
         * {@inheritDoc}
         */
        void updatePolar() {
            this.angle = (float) Math.atan2(dy, dx);
            if (maxMagnitude != 0) {
                magnitude = (float) Math.min(calcRawMagnitude(dx, dy), maxMagnitude);
            } else {
                magnitude = (float) calcRawMagnitude(dx, dy);
            }
        }

        /**
         * {@inheritDoc}
         *
         * @since 1.3
         */
        void updateCartesian() {
            this.dx = (float) (magnitude * Math.cos(angle));
            this.dy = (float) (magnitude * Math.sin(angle));
        }
    }

    private static double calcRawMagnitude(double x, double y) {
        return Math.sqrt((x * x) + (y * y));
    }

    /**
     * @return The current value of the {@code X} component of this {@code Vector2D}
     * @since 1.0
     */
    abstract double getX();

    /**
     * @return The current value of the {@code Y} component of this {@code Vector2D}
     * @since 1.0
     */
    abstract double getY();

    /**
     * @return The current {@code magnitude} of this {@code Vector2D}
     * @since 1.0
     */
    abstract double getMagnitude();

    /**
     * @return The current {@code angle} of this {@code Vector2D}
     * @since 1.0
     */
    abstract double getAngle();

    /**
     * @return The {@code maxMagnitude} of this {@code Vector2D}
     * @since 1.0
     */
    abstract double getMax();

    /**
     * Updates the {@code angle} and {@code magnitude} of this {@code Vector2D}
     *
     * @since 1.0
     */
    abstract void updatePolar();

    /**
     * Updates {@code X} and {@code Y} offsets of {@code Vector2D}
     *
     * @since 1.0
     */
    abstract void updateCartesian();
}
