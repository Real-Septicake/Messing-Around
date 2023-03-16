package GameThing.util.Vectors;

public abstract class Scalar {
    public static class Double extends Scalar {
        protected double maxMagnitude = 0;
        protected double magnitude = 0;

        public Double() {
        }

        public Double(double max) {
            maxMagnitude = max;
        }

        public Double(double max, double magnitude) {
            this.magnitude = magnitude;
            maxMagnitude = max;
        }

        public Double(Scalar.Double s) {
            this.magnitude = s.magnitude;
        }

        public double getMagnitude() {
            return magnitude;
        }

        public double getMax() {
            return maxMagnitude;
        }

        public void updateMagnitude(double magnitude) {
            if (maxMagnitude != 0) {
                this.magnitude = Math.min(magnitude, maxMagnitude);
            } else {
                this.magnitude = magnitude;
            }
        }
    }

    public static class Float extends Scalar {
        protected float maxMagnitude = 0;
        protected float magnitude = 0;

        public Float() {
        }

        public Float(float max) {
            maxMagnitude = max;
        }

        public Float(float magnitude, float max) {
            this.magnitude = magnitude;
            maxMagnitude = max;
        }

        public Float(Scalar.Float s) {
            this.magnitude = s.magnitude;
            this.maxMagnitude = s.maxMagnitude;
        }

        public double getMagnitude() {
            return (double) magnitude;
        }

        public double getMax() {
            return (double) maxMagnitude;
        }
    }

    abstract double getMagnitude();

    abstract double getMax();
}
