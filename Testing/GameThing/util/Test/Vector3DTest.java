package GameThing.util.Test;

import GameThing.util.Vectors.Vector3D;

public class Vector3DTest {
    //TODO: Spherical to Cartesian is fucked oh god help
    //I DON'T KNOW WHAT I DID WRONG I NEED A NEW GOD TO PRAY TO, open to suggestions

    public static void main(String[] args){
        Vector3D.Double computed = new Vector3D.Double(-14, 12, 1);
        System.out.println("magnitude: " + computed.getMagnitude() + ". Phi: " + Math.toDegrees(computed.getPhi()) + ". Theta: " + Math.toDegrees(computed.getTheta()));

        Vector3D.Double thing = new Vector3D.Double(-14, 12, 1, 0);
        System.out.println("X: " + thing.getX() + ". Y: " + thing.getY() + ". Z: " + thing.getZ());
    }
}
