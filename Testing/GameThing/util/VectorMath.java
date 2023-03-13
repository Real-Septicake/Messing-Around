package GameThing.util;

/**
 * A class that does Vector math for both {@code Vector2D} and {@code Vector3D}
 * 
 * @since 1.0
 * @version 1.0 (3/13/23)
 */
public abstract class VectorMath {

    /**
     * The {@code _3D} class allows for Vector math for {@code Vector3D} objects
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
         * Returns the result of the addition of two {@code Vector3D} objects
         * 
         * @param v1 First {@code Vector3D}
         * @param v2 Second {@code Vector3D}
         * @return The sum of {@code v1} and {@code v2}
         * 
         * @since 1.0
         */
        public static Vector3D add(Vector3D v1, Vector3D v2) {
            Vector3D newV = new Vector3D();
            newV.updateCartesianCoords(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.getZ() + v2.getZ());

            return newV;
        }

        /**
         * Returns the result of the subtraction of two {@code Vector3D} objects
         * 
         * @param v1 The minuend
         * @param v2 The subtrahend
         * @return The difference when {@code v2} is subtracted from {@code v1}
         * 
         * @since 1.0
         */
        public static Vector3D subtract(Vector3D v1, Vector3D v2) {
            Vector3D newV = new Vector3D();
            newV.updateCartesianCoords(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
            return newV;
        }

        /**
         * Returns the result of the multiplication of two {@code Vector3D} objects
         * 
         * @param v1 First {@code Vector3D}
         * @param v2 Second {@code Vector3D}
         * @return The product of {@code v1} and {@code v2}
         * 
         * @since 1.0
         */
        public static Vector3D multiply(Vector3D v1, Vector3D v2) {
            Vector3D newV = new Vector3D();
            newV.updateCartesianCoords(v1.getX() * v2.getX(), v1.getY() * v2.getY(), v1.getZ() * v2.getZ());
            return newV;
        }

        /**
         * Returns the result of the division of two {@code Vector2D} objects
         * 
         * @param v1 The dividend
         * @param v2 The divisor
         * @return The quotient when {@code v1} is divided by {@code v2}
         * 
         * @since 1.0
         */
        public static Vector3D divide(Vector3D v1, Vector3D v2) {
            Vector3D newV = new Vector3D();
            newV.updateCartesianCoords(v1.getX() / v2.getX(), v1.getY() / v2.getY(), v1.getZ() / v2.getZ());
            return newV;
        }
    }

    /**
     * The {@code _2D} class allows for Vector math for {@code Vector2D} objects
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
         * Returns the result of the addition of two {@code Vector2D} objects
         * 
         * @param v1 First {@code Vector2D}
         * @param v2 Second {@code Vector2D}
         * @return The sum of {@code v1} and {@code v2}
         * 
         * @since 1.0
         */
        public static Vector2D add(Vector2D v1, Vector2D v2) {
            Vector2D newV = new Vector2D();
            newV.updateCartesianCoords(v1.getX() + v2.getX(), v1.getY() + v2.getY());

            return newV;
        }

        /**
         * Returns the result of the subtraction of two {@code Vector2D} objects
         * 
         * @param v1 The minuend
         * @param v2 The subtrahend
         * @return The difference when {@code v2} is subtracted from {@code v1}
         * 
         * @since 1.0
         */
        public static Vector2D subtract(Vector2D v1, Vector2D v2) {
            Vector2D newV = new Vector2D();
            newV.updateCartesianCoords(v1.getX() - v2.getX(), v1.getY() - v2.getY());
            return newV;
        }

        /**
         * Returns the result of the multiplication of two {@code Vector2D} objects
         * 
         * @param v1 First {@code Vector2D}
         * @param v2 Second {@code Vector2D}
         * @return The product of {@code v1} and {@code v2}
         * 
         * @since 1.0
         */
        public static Vector2D multiply(Vector2D v1, Vector2D v2) {
            Vector2D newV = new Vector2D();
            newV.updateCartesianCoords(v1.getX() * v2.getX(), v1.getY() * v2.getY());
            return newV;
        }

        /**
         * Returns the result of the division of two {@code Vector2D} objects
         * 
         * @param v1 The dividend
         * @param v2 The divisor
         * @return The quotient when {@code v1} is divided by {@code v2}
         * 
         * @since 1.0
         */
        public static Vector2D divide(Vector2D v1, Vector2D v2) {
            Vector2D newV = new Vector2D();
            newV.updateCartesianCoords(v1.getX() / v2.getX(), v1.getY() / v2.getY());
            return newV;
        }
    }
}
