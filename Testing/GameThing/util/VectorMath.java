package GameThing.util;

/**
 * A class that does Vector math for both {@code Vector2D} and {@code Vector3D}
 * 
 * @since 1.0
 * @version 1.1 (3/14/23)
 * @author Septicake
 */
public abstract class VectorMath {

    public abstract class Double extends VectorMath {
        /**
         * The {@code _3D} class allows for Vector math for {@code Vector3D.Double} objects
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
                return new Vector3D.Double(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.getZ() + v2.getZ());
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
                return new Vector3D.Double(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
            }

            /**
             * Returns the result of the multiplication of two {@code Vector3D.Double} objects
             * 
             * @param v1 First {@code Vector3D.Double}
             * @param v2 Second {@code Vector3D.Double}
             * @return The product of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector3D.Double multiply(Vector3D.Double v1, Vector3D.Double v2) {
                return new Vector3D.Double(v1.getX() * v2.getX(), v1.getY() * v2.getY(), v1.getZ() * v2.getZ());
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
                return new Vector3D.Double(v1.getX() / v2.getX(), v1.getY() / v2.getY(), v1.getZ() / v2.getZ());
            }
        }

        /**
         * The {@code _2D} class allows for Vector math for {@code Vector2D.Double} objects
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
                return new Vector2D.Double(v1.getX() + v2.getX(), v1.getY() + v2.getY());
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
                return new Vector2D.Double(v1.getX() - v2.getX(), v1.getY() - v2.getY());
            }

            /**
             * Returns the result of the multiplication of two {@code Vector2D.Double} objects
             * 
             * @param v1 First {@code Vector2D.Double}
             * @param v2 Second {@code Vector2D.Double}
             * @return The product of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector2D.Double multiply(Vector2D.Double v1, Vector2D.Double v2) {
                return new Vector2D.Double(v1.getX() * v2.getX(), v1.getY() * v2.getY());
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
                return new Vector2D.Double(v1.getX() / v2.getX(), v1.getY() / v2.getY());
            }
        }
    }

    public abstract class Float extends VectorMath {
        /**
         * The {@code _3D} class allows for Vector math for {@code Vector3D.Float} objects
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
                return new Vector3D.Float((float) (v1.getX() + v2.getX()), (float) (v1.getY() + v2.getY()), (float) (v1.getZ() + v2.getZ()));
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
                return new Vector3D.Float((float) (v1.getX() - v2.getX()), (float) (v1.getY() - v2.getY()), (float) (v1.getZ() - v2.getZ()));
            }

            /**
             * Returns the result of the multiplication of two {@code Vector3D.Float} objects
             * 
             * @param v1 First {@code Vector3D.Float}
             * @param v2 Second {@code Vector3D.Float}
             * @return The product of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector3D.Float multiply(Vector3D.Float v1, Vector3D.Float v2) {
                return new Vector3D.Float((float) (v1.getX() * v2.getX()), (float) (v1.getY() * v2.getY()), (float) (v1.getZ() * v2.getZ()));
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
                return new Vector3D.Float((float) (v1.getX() / v2.getX()), (float) (v1.getY() / v2.getY()), (float) (v1.getZ() / v2.getZ()));
            }
        }

        /**
         * The {@code _2D} class allows for Vector math for {@code Vector2D.Float} objects
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
                return new Vector2D.Float((float) (v1.getX() + v2.getX()), (float) (v1.getY() + v2.getY()));
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
                return new Vector2D.Float((float) (v1.getX() - v2.getX()), (float) (v1.getY() - v2.getY()));
            }

            /**
             * Returns the result of the multiplication of two {@code Vector2D.Float} objects
             * 
             * @param v1 First {@code Vector2D.Float}
             * @param v2 Second {@code Vector2D.Float}
             * @return The product of {@code v1} and {@code v2}
             * 
             * @since 1.0
             */
            public static Vector2D.Float multiply(Vector2D.Float v1, Vector2D.Float v2) {
                return new Vector2D.Float((float) (v1.getX() * v2.getX()), (float) (v1.getY() * v2.getY()));
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
                return new Vector2D.Float((float) (v1.getX() / v2.getX()), (float) (v1.getY() / v2.getY()));
            }
        }
    }
}
