package GameThing.util.Test;

import GameThing.util.Vectors.Vector3D;

public class Vector3DTest {

    public static void main(String[] args){
        Vector3D.Double computed = new Vector3D.Double(-14, 12, 1);
        System.out.println("magnitude: " + computed.getMagnitude() + ". Phi: " + Math.toDegrees(computed.getPhi()) + ". Theta: " + Math.toDegrees(computed.getTheta()));

        Vector3D.Double thing = new Vector3D.Double(-14, Math.toRadians(12), Math.toRadians(1), 0);
        System.out.println("X: " + thing.getX() + ". Y: " + thing.getY() + ". Z: " + thing.getZ());
    }
}
