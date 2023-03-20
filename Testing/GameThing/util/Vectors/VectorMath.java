package GameThing.util.Vectors;

/**
 * A class that does Vector math for both {@code Vector2D} and {@code Vector3D}
 * 
 * @since 1.0
 * @version 1.2 (3/16/23)
 * @author Septicake
 */
public abstract class VectorMath {

    public abstract class Double extends VectorMath {
        /**
         * The {@code _3D} class allows for Vector math for {@code Vector3D.Double}
         * objects
         * 
         * @since 1.0
         */
        public static class _3D extends VectorMath {

            /**
             * Nope.
             */
            private _3D() {
            }

            /**
             * Returns the result of the addition of two {@code Vector3D.Double} objects
             * 
             * @param v1 First {@code Vector3D}
             * @param v2 Second {@code Vector3D}
             * @return The sum of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector3D.Double add(Vector3D.Double v1, Vector3D.Double v2) {
                return new Vector3D.Double(v1.dx + v2.dx, v1.dy + v2.dy, v1.dz + v2.dz);
            }

            /**
             * Returns the result of the subtraction of two {@code Vector3D.Double} objects
             * 
             * @param v1 The minuend
             * @param v2 The subtrahend
             * @return The difference when {@code v2} is subtracted from {@code v1}
             * 
             * @since 1.0
             */
            public static Vector3D.Double subtract(Vector3D.Double v1, Vector3D.Double v2) {
                return new Vector3D.Double(v1.dx - v2.dx, v1.dy - v2.dy, v1.dz - v2.dz);
            }

            /**
             * Returns the result of the multiplication of two {@code Vector3D.Double}
             * objects
             * 
             * @param v1 First {@code Vector3D.Double}
             * @param v2 Second {@code Vector3D.Double}
             * @return The product of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector3D.Double multiply(Vector3D.Double v1, Vector3D.Double v2) {
                return new Vector3D.Double(v1.dx * v2.dx, v1.dy * v2.dy, v1.dz * v2.dz);
            }

            /**
             * Returns the result of the division of two {@code Vector3D.Double} objects
             * 
             * @param v1 The dividend
             * @param v2 The divisor
             * @return The quotient when {@code v1} is divided by {@code v2}
             * 
             * @since 1.0
             */
            public static Vector3D.Double divide(Vector3D.Double v1, Vector3D.Double v2) {
                return new Vector3D.Double(v1.dx / v2.dx, v1.dy / v2.dy, v1.dz / v2.dz);
            }
        }

        /**
         * The {@code _2D} class allows for Vector math for {@code Vector2D.Double}
         * objects
         * 
         * @since 1.0
         */
        public static class _2D extends VectorMath {

            /**
             * Nope.
             */
            private _2D() {
            }

            /**
             * Returns the result of the addition of two {@code Vector2D.Double} objects
             * 
             * @param v1 First {@code Vector2D.Double}
             * @param v2 Second {@code Vector2D.Double}
             * @return The sum of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector2D.Double add(Vector2D.Double v1, Vector2D.Double v2) {
                return new Vector2D.Double(v1.dx + v2.dx, v1.dy + v2.dy);
            }

            /**
             * Returns the result of the subtraction of two {@code Vector2D.Double} objects
             * 
             * @param v1 The minuend
             * @param v2 The subtrahend
             * @return The difference when {@code v2} is subtracted from {@code v1}
             * 
             * @since 1.0
             */
            public static Vector2D.Double subtract(Vector2D.Double v1, Vector2D.Double v2) {
                return new Vector2D.Double(v1.dx - v2.dx, v1.dy - v2.dy);
            }

            /**
             * Returns the result of the multiplication of two {@code Vector2D.Double}
             * objects
             * 
             * @param v1 First {@code Vector2D.Double}
             * @param v2 Second {@code Vector2D.Double}
             * @return The product of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector2D.Double multiply(Vector2D.Double v1, Vector2D.Double v2) {
                return new Vector2D.Double(v1.dx * v2.dx, v1.dy * v2.dy);
            }

            /**
             * Returns the result of the division of two {@code Vector2D.Double} objects
             * 
             * @param v1 The dividend
             * @param v2 The divisor
             * @return The quotient when {@code v1} is divided by {@code v2}
             * 
             * @since 1.0
             */
            public static Vector2D.Double divide(Vector2D.Double v1, Vector2D.Double v2) {
                return new Vector2D.Double(v1.dx / v2.dx, v1.dy / v2.dy);
            }
        }

        public static class _1D extends VectorMath {

            /**
             * Don't try it
             */
            private _1D() {
            }

            /**
             * Returns the result of the addition of two {@code Scalar.Double} objects
             * 
             * @param s1 First {@code Scalar.Float}
             * @param s2 Second {@code Scalar.Float}
             * @return The sum of {@code s1} and {@code s2}
             * 
             * @since 1.0
             */
            public static Scalar.Double add(Scalar.Double s1, Scalar.Double s2) {
                return new Scalar.Double(s1.magnitude + s2.magnitude, 0);
            }

            /**
             * Returns the result of the subtraction of two {@code Vector2D.Double} objects
             * 
             * @param s1 The minuend
             * @param s2 The subtrahend
             * @return The difference when {@code s2} is subtracted from {@code s1}
             * 
             * @since 1.0
             */
            public static Scalar.Double subtract(Scalar.Double s1, Scalar.Double s2) {
                return new Scalar.Double(s1.magnitude - s2.magnitude, 0);
            }

            /**
             * Returns the result of the multiplication of two {@code Scalar.Double} objects
             * 
             * @param s1 First {@code Scalar.Double}
             * @param s2 Second {@code Scalar.Double}
             * @return The product of {@code s1} and {@code s2}
             * 
             * @since 1.0
             */
            public static Scalar.Double multiply(Scalar.Double s1, Scalar.Double s2) {
                return new Scalar.Double(s1.magnitude * s2.magnitude, 0);
            }

            /**
             * Returns the result of the division of two {@code Scalar.Double} objects
             * 
             * @param s1 The dividend
             * @param s2 The divisor
             * @return The quotient when {@code s1} is divided by {@code s2}
             * 
             * @since 1.0
             */
            public static Scalar.Double divide(Scalar.Double s1, Scalar.Double s2) {
                return new Scalar.Double(s1.magnitude / s2.magnitude, 0);
            }
        }
    }

    public abstract class Float extends VectorMath {
        /**
         * The {@code _3D} class allows for Vector math for {@code Vector3D.Float}
         * objects
         * 
         * @since 1.0
         */
        public static class _3D extends VectorMath {

            /**
             * Nope.
             */
            private _3D() {
            }

            /**
             * Returns the result of the addition of two {@code Vector3D.Float} objects
             * 
             * @param v1 First {@code Vector3D.Float}
             * @param v2 Second {@code Vector3D.Float}
             * @return The sum of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector3D.Float add(Vector3D.Float v1, Vector3D.Float v2) {
                return new Vector3D.Float(v1.dx + v2.dx, v1.dy + v2.dy, v1.dz + v2.dz);
            }

            /**
             * Returns the result of the subtraction of two {@code Vector3D.Float} objects
             * 
             * @param v1 The minuend
             * @param v2 The subtrahend
             * @return The difference when {@code v2} is subtracted from {@code v1}
             * 
             * @since 1.0
             */
            public static Vector3D.Float subtract(Vector3D.Float v1, Vector3D.Float v2) {
                return new Vector3D.Float(v1.dx - v2.dx, v1.dy - v2.dy, v1.dz - v2.dz);
            }

            /**
             * Returns the result of the multiplication of two {@code Vector3D.Float}
             * objects
             * 
             * @param v1 First {@code Vector3D.Float}
             * @param v2 Second {@code Vector3D.Float}
             * @return The product of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector3D.Float multiply(Vector3D.Float v1, Vector3D.Float v2) {
                return new Vector3D.Float(v1.dx * v2.dx, v1.dy * v2.dy, v1.dz * v2.dz);
            }

            /**
             * Returns the result of the division of two {@code Vector2D.Float} objects
             * 
             * @param v1 The dividend
             * @param v2 The divisor
             * @return The quotient when {@code v1} is divided by {@code v2}
             * 
             * @since 1.0
             */
            public static Vector3D.Float divide(Vector3D.Float v1, Vector3D.Float v2) {
                return new Vector3D.Float(v1.dx / v2.dx, v1.dy / v2.dy, v1.dz / v2.dz);
            }
        }

        /**
         * The {@code _2D} class allows for Vector math for {@code Vector2D.Float}
         * objects
         * 
         * @since 1.0
         */
        public static class _2D extends VectorMath {

            /**
             * Nope.
             */
            private _2D() {
            }

            /**
             * Returns the result of the addition of two {@code Vector2D.Float} objects
             * 
             * @param v1 First {@code Vector2D.Float}
             * @param v2 Second {@code Vector2D.Float}
             * @return The sum of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector2D.Float add(Vector2D.Float v1, Vector2D.Float v2) {
                return new Vector2D.Float(v1.dx + v2.dx, v1.dy + v2.dy);
            }

            /**
             * Returns the result of the subtraction of two {@code Vector2D.Float} objects
             * 
             * @param v1 The minuend
             * @param v2 The subtrahend
             * @return The difference when {@code v2} is subtracted from {@code v1}
             * 
             * @since 1.0
             */
            public static Vector2D.Float subtract(Vector2D.Float v1, Vector2D.Float v2) {
                return new Vector2D.Float(v1.dx - v2.dx, v1.dy - v2.dy);
            }

            /**
             * Returns the result of the multiplication of two {@code Vector2D.Float}
             * objects
             * 
             * @param v1 First {@code Vector2D.Float}
             * @param v2 Second {@code Vector2D.Float}
             * @return The product of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector2D.Float multiply(Vector2D.Float v1, Vector2D.Float v2) {
                return new Vector2D.Float(v1.dx * v2.dx, v1.dy * v2.dy);
            }

            /**
             * Returns the result of the division of two {@code Vector2D.Float} objects
             * 
             * @param v1 The dividend
             * @param v2 The divisor
             * @return The quotient when {@code v1} is divided by {@code v2}
             * 
             * @since 1.0
             */
            public static Vector2D.Float divide(Vector2D.Float v1, Vector2D.Float v2) {
                return new Vector2D.Float(v1.dx / v2.dx, v1.dy / v2.dy);
            }
        }

        public static class _1D extends VectorMath {

            /**
             * Not a chance
             */
            private _1D() {
            }

            /**
             * Returns the result of the addition of two {@code Scalar.Float} objects
             * 
             * @param s1 First {@code Scalar.Float}
             * @param s2 Second {@code Scalar.Float}
             * @return The sum of {@code s1} and {@code s2}
             * 
             * @since 1.0
             */
            public static Scalar.Float add(Scalar.Float s1, Scalar.Float s2) {
                return new Scalar.Float(s1.magnitude + s2.magnitude, 0);
            }

            /**
             * Returns the result of the subtraction of two {@code Scalar.Float} objects
             * 
             * @param s1 The minuend
             * @param s2 The subtrahend
             * @return The difference when {@code s2} is subtracted from {@code s1}
             * 
             * @since 1.2
             */
            public static Scalar.Float subtract(Scalar.Float s1, Scalar.Float s2) {
                return new Scalar.Float(s1.magnitude - s2.magnitude, 0);
            }

            /**
             * Returns the result of the multiplication of two {@code Scalar.Float} objects
             * 
             * @param s1 First {@code Scalar.Float}
             * @param s2 Second {@code Scalar.Float}
             * @return The product of {@code s1} and {@code s2}
             * 
             * @since 1.2
             */
            public static Scalar.Float multiply(Scalar.Float s1, Scalar.Float s2) {
                return new Scalar.Float(s1.magnitude * s2.magnitude, 0);
            }

            /**
             * Returns the result of the division of two {@code Scalar.Float} objects
             * 
             * @param s1 The dividend
             * @param s2 The divisor
             * @return The quotient when {@code s1} is divided by {@code s2}
             * 
             * @since 1.2
             */
            public static Scalar.Float divide(Scalar.Float s1, Scalar.Float s2) {
                return new Scalar.Float(s1.magnitude / s2.magnitude, 0);
            }
        }
    }
}
