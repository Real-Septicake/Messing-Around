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

import GameThing.util.Vectors.Vector2D;

public class Pew {
    private static List<WeakReference<Pew>> instances = new ArrayList<>();
    private Vector2D.Double vector;
    private Point pos;
    private BufferedImage image;

    private static double speed = 25;

    /**
     * The method that should be used to add new {@code Pews}
     * @param angle Angle that the {@code Pew} should be at
     * @param pos Position that the {@code Pew} should be at
     */
    public static void createPew(double angle, Point pos){
        Pew p = new Pew(new Vector2D.Double(speed, angle, 0), pos);
        instances.add(new java.lang.ref.WeakReference<Pew>(p));
    }

    /**
     * @return Every active instance of {@code Pew}
     */
    public static List<WeakReference<Pew>> getInstances(){
        return instances;
    }

    public void draw(Graphics g, ImageObserver observer){
        Graphics2D rotatedImage = image.createGraphics();
        rotatedImage.rotate(vector.getAngle(), image.getWidth(), image.getHeight());
        g.drawImage(image, pos.x, pos.y, observer);
    }

    /**
     * Update position with {@code Vector} component values
     */
    public void moveTick(){
        pos.setLocation(pos.getX() + vector.getX(), pos.getY() + vector.getY());
    }

    public Line2D.Double returnCollision(){
        return new Line2D.Double(pos, new Point((int) (pos.getX() + vector.getX()), (int) (pos.getY() + vector.getY())));
    }

    public boolean checkEdge(Dimension dim){
        return (pos.getX() >= dim.getWidth() || pos.getY() >= dim.getHeight() || pos.getX() <= 0 || pos.getY() <= 0);
    }

    /**
     * <b><i>!!! DO NOT USE OUTSIDE CLASS !!!</b></i>
     * @param v The {@code Vector} to be applied to the Pew
     * @param p The point at which the {@code Pew} should be created
     */
    private Pew(Vector2D.Double v, Point p){
        this.pos = new Point(p);
        this.vector = new Vector2D.Double(v);
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
