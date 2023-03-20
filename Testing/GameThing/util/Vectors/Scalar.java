package GameThing.util.Vectors;

/**
 * A class that allows for the creation and use of mathematical scalars
 *
 * @author Septicake
 * @version 1.0 (3/16/23)
 * @since 1.0
 */
public abstract class Scalar {

    /**
     * Defines mathematical scalars with double precision
     */
    public static class Double extends Scalar {

        /**
         * Maximum allowed {@code magnitude} of the {@code Scalar.Double} object
         *
         * <p>
         * 0 is the default value and does not restrict the {@code magnitude}
         * </p>
         */
        protected double maxMagnitude = 0;

        /**
         * Magnitude of the {@code Scalar.Double} object
         */
        protected double magnitude = 0;

        /**
         * Creates a {@code Scalar.Double} with all values set to 0
         *
         * @since 1.0
         */
        public Double() {
        }

        /**
         * Creates a {@code Scalar.Double} with a specified {@code maxMagnitude} value
         *
         * @param max {@code maxMagnitude} value, where 0 means no maximum
         * @since 1.0
         */
        public Double(double max) {
            maxMagnitude = max;
        }

        /**
         * Creates a {@code Scalar.Double} with specified {@code magnitude} and {@code maxMagnitude} values
         *
         * @param magnitude {@code magnitude} value of the new {@code Scalar.Double}
         * @param max       {@code maxMagnitude} value of the new {@code Scalar.Double}
         * @since 1.0
         */
        public Double(double magnitude, double max) {
            this.magnitude = magnitude;
            maxMagnitude = max;
        }

        /**
         * Create a {@code Scalar.Double} with the same values as the specified
         * {@code Scalar.Double}
         *
         * @param s {@code Scalar.Double} to copy the values from
         * @since 1.0
         */
        public Double(Scalar.Double s) {
            this.magnitude = s.magnitude;
        }

        /**
         * @return The current {@code magnitude} of this {@code Scalar.Double}
         * @since 1.0
         */
        public double getMagnitude() {
            return magnitude;
        }

        /**
         * @return The {@code maxMagnitude} of this {@code Scalar.Double}
         * @since 1.0
         */
        public double getMax() {
            return maxMagnitude;
        }

        /**
         * Update this {@code Scalar.Double} with a new {@code magnitude} value
         *
         * @param magnitude New {@code magnitude} value
         * @since 1.0
         */
        public void updateMagnitude(double magnitude) {
            if (maxMagnitude != 0) {
                this.magnitude = Math.min(magnitude, maxMagnitude);
            } else {
                this.magnitude = magnitude;
            }
        }
    }

    /**
     * Defines mathematical scalars with float precision
     */
    public static class Float extends Scalar {

        /**
         * Maximum allowed {@code magnitude} of the {@code Scalar.Float} object
         *
         * <p>
         * 0 is the default value and does not restrict the {@code magnitude}
         * </p>
         */
        protected float maxMagnitude = 0;

        /**
         * Magnitude of the {@code Scalar.Float} object
         */
        protected float magnitude = 0;

        /**
         * Creates a {@code Scalar.Float} with all values set to 0
         *
         * @since 1.0
         */
        public Float() {
        }

        /**
         * Creates a {@code Scalar.Float} with a specified {@code maxMagnitude} value
         *
         * @param max {@code maxMagnitude} value, where 0 means no maximum
         * @since 1.0
         */
        public Float(float max) {
            maxMagnitude = max;
        }

        /**
         * Creates a {@code Scalar.Float} with specified {@code magnitude} and {@code maxMagnitude} values
         *
         * @param magnitude {@code magnitude} value of the new {@code Scalar.Float}
         * @param max       {@code maxMagnitude} value of the new {@code Scalar.Float}
         * @since 1.0
         */
        public Float(float magnitude, float max) {
            this.magnitude = magnitude;
            maxMagnitude = max;
        }

        /**
         * Create a {@code Scalar.Float} with the same values as the specified
         * {@code Scalar.Float}
         *
         * @param s {@code Scalar.Float} to copy the values from
         * @since 1.0
         */
        public Float(Scalar.Float s) {
            this.magnitude = s.magnitude;
            this.maxMagnitude = s.maxMagnitude;
        }

        /**
         * @return The current {@code magnitude} of this {@code Scalar.Float}
         * @since 1.0
         */
        public double getMagnitude() {
            return (double) magnitude;
        }

        /**
         * @return The {@code maxMagnitude} of this {@code Scalar.Float}
         * @since 1.0
         */
        public double getMax() {
            return (double) maxMagnitude;
        }
    }

    abstract double getMagnitude();

    abstract double getMax();
}
