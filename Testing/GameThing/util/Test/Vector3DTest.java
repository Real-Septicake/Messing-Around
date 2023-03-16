package GameThing.util.Test;

import GameThing.util.Vectors.Vector3D;

public class Vector3DTest {
    //TODO: get this working, I need to know if "my" math is right... or at least if the implementation is
    // @Test
    // public void Vector3DDoubleTest(){
    //     Vector3D.Double computed;
    //     Vector3D.Double expected;

    //     expected = new Vector3D.Double(1.7321, 45, 54.7356, 0);
    //     computed = new Vector3D.Double(1, 1, 1);
    //     assertEquals(expected, computed);
    // }


    public static void main(String[] args){
        Vector3D.Double computed = new Vector3D.Double(1, 1, 1);

        System.out.println("magnitude: " + computed.getMagnitude() + ". Site theta: " + computed.getPhi() + ". Site Phi: " + computed.getTheta());
    }
}
