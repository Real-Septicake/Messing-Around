package GameThing.Objects;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.awt.geom.Line2D;
import java.awt.Dimension;

import GameThing.util.Vector;

public class Pew {
    private static List<WeakReference<Pew>> instances = new ArrayList<>();
    private Vector vector;
    private Point pos;
    private BufferedImage image;

    private static double speed = 25;

    /**
     * The method that should be used to add new Pews
     * @param angle Angle that the Pew should be at
     * @param pos Position that the Pew should be at
     */
    public static void createPew(double angle, Point pos){
        Pew p = new Pew(new Vector(angle, speed), pos);
        instances.add(new java.lang.ref.WeakReference<Pew>(p));
    }

    public static List<WeakReference<Pew>> getInstances(){
        return instances;
    }

    public void draw(Graphics g, ImageObserver observer){

        Graphics2D rotatedImage = (Graphics2D) g;
        rotatedImage.rotate(Math.toRadians(vector.getAngle()), image.getWidth() / 2, image.getHeight() / 2);
        g.drawImage(image, pos.x, pos.y, observer);
    }

    /**
     * Update position with Vector component values
     */
    public void moveTick(){
        pos.setLocation(pos.getX() + vector.getX(), pos.getY() + vector.getY());
    }

    public Line2D.Double returnCollision(){
        return new Line2D.Double(pos, new Point((int) (pos.getX() + vector.getX()), (int) (pos.getY() + vector.getY())));
    }

    public boolean checkEdge(Dimension dim){
        return (pos.getX() + image.getWidth() / Math.cos(vector.getAngle()) >= dim.getWidth() || pos.getY() + image.getHeight() / Math.sin(vector.getAngle()) >= dim.getHeight());
    }

    /**
     * <b><i>!!! DO NOT USE OUTSIDE CLASS !!!</b></i>
     * @param vector The Vector to be applied to the Pew
     */
    private Pew(Vector vector, Point pos){
        this.pos = pos;
        this.vector = vector;
        loadImage();
    }

    private void loadImage(){
        try {
            image = ImageIO.read(new File("./Testing/GameThing/Images/PewPew.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
