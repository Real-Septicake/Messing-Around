package GameThing.Objects;

import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;

import java.awt.Rectangle;

import javax.imageio.ImageIO;

import GameThing.util.Vector2D;

public class Player {

    public Vector2D vector;

    private boolean upPressed, downPressed, leftPressed, rightPressed = false;

    public Rectangle r;

    double maxVel = 20;
    double yVel, xVel;
    double xDecel, yDecel;

    private double baseAccel;
    private double pressDecel, releaseDecel;

    // image that represents the player's position on the board
    private BufferedImage image;
    // current position of the player on the board grid
    private Point pos;
    // keep track of the player's score
    private int score;

    private int id;

    /**
     * Allows for creating up to 2 {@code Players}
     * 
     * @param id represents player id, either 0 for player 1, or 1 for player 2
     */
    public Player(int id) {
        // load the assets
        loadImage();

        // initialize the state
        pos = new Point(0, 0);
        score = 0;

        r = new Rectangle(pos, new Dimension(image.getWidth(), image.getHeight()));

        //TODO: Tweak accel and decel values, movement feels jerky
        vector = new Vector2D(maxVel);
        yVel = 0;
        xVel = 0;
        baseAccel = 1.25;

        pressDecel = 0.75;
        releaseDecel = 1.0;
        xDecel = releaseDecel;
        yDecel = releaseDecel;

        this.id = id;
    }

    /**
     * Creates a {@code Player} with the default id of 0
     */
    public Player(){
        // load the assets
        loadImage();

        // initialize the state
        pos = new Point(0, 0);
        score = 0;

        r = new Rectangle(pos, new Dimension(image.getWidth(), image.getHeight()));

        //TODO: Tweak accel and decel values, movement feels jerky
        vector = new Vector2D(maxVel);
        yVel = 0;
        xVel = 0;
        baseAccel = 1.25;
        pressDecel = 0.75;
        releaseDecel = 1.0;

        this.id = 0;
    }

    private void loadImage() {
        try {
            // you can use just the filename if the image file is in your
            // project folder, otherwise you need to provide the file path.
            image = ImageIO.read(new File("./Testing/GameThing/Images/player.png"));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        // with the Point class, note that pos.getX() returns a double, but 
        // pos.x reliably returns an int. https://stackoverflow.com/a/30220114/4655368
        // this is also where we translate board grid position into a canvas pixel
        // position by multiplying by the tile size.
        g.drawImage(
            image, 
            pos.x/*  * Board.TILE_SIZE*/, 
            pos.y/*  * Board.TILE_SIZE*/, 
            observer
        );

        r.setLocation(pos);
    }
    
    public void keyPressed(KeyEvent e) {
        // every keyboard get has a certain code. get the value of that code from the
        // keyboard event so that we can compare it to KeyEvent constants
        int key = e.getKeyCode();
        
        if(id == 0){
            if (key == KeyEvent.VK_UP) {
                upPressed = true;
                yDecel = pressDecel;
            }
            if (key == KeyEvent.VK_RIGHT) {
                rightPressed = true;
                xDecel = pressDecel;
            }
            if (key == KeyEvent.VK_DOWN) {
                downPressed = true;
                yDecel = pressDecel;
            }
            if (key == KeyEvent.VK_LEFT) {
                leftPressed = true;
                xDecel = pressDecel;
            }
            if(key == KeyEvent.VK_SPACE){
                Pew.createPew(Math.toDegrees(vector.getAngle()), getPos());
            }
        }else{
            if (key == KeyEvent.VK_W) {
                upPressed = true;
                yDecel = pressDecel;
            }
            if (key == KeyEvent.VK_D) {
                rightPressed = true;
                xDecel = pressDecel;
            }
            if (key == KeyEvent.VK_S) {
                downPressed = true;
                yDecel = pressDecel;
            }
            if (key == KeyEvent.VK_A) {
                leftPressed = true;
                xDecel = pressDecel;
            }
        }


    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(id == 0){
            if (key == KeyEvent.VK_UP) {
                upPressed = false;
                yDecel = releaseDecel;
            }
            if (key == KeyEvent.VK_RIGHT) {
                rightPressed = false;
                xDecel = releaseDecel;
            }
            if (key == KeyEvent.VK_DOWN) {
                downPressed = false;
                yDecel = releaseDecel;
            }
            if (key == KeyEvent.VK_LEFT) {
                leftPressed = false;
                yDecel = releaseDecel;
            }
        }else{
            if (key == KeyEvent.VK_W) {
                upPressed = false;
                yDecel = releaseDecel;
            }
            if (key == KeyEvent.VK_D) {
                rightPressed = false;
                xDecel = releaseDecel;
            }
            if (key == KeyEvent.VK_S) {
                downPressed = false;
                yDecel = releaseDecel;
            }
            if (key == KeyEvent.VK_A) {
                leftPressed = false;
                yDecel = releaseDecel;
            }
        }
    }

    public void tick(Dimension dim) {
        // this gets called once every tick, before the repainting process happens.
        // so we can do anything needed in here to update the state of the player.

        moveTick();

        // prevent the player from moving off the edge of the board sideways
        if (pos.x < 0) {
            pos.x = 0;
            xVel = 0;
        } else if (pos.x > dim.getWidth() - image.getWidth()) {
            pos.x = (int)dim.getWidth() - image.getWidth();
            xVel = 0;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
            yVel = 0;
        } else if (pos.y > dim.getHeight() - image.getHeight()) {
            pos.y = (int)dim.getHeight() - image.getHeight();
            yVel = 0;
        }
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public void addScore(int amount) {
        score += amount;
    }

    public Point getPos() {
        return pos;
    }

    /**
     * Update position with {@code Vector} component values
     */
    public void moveTick(){
        accelDecelTick();
        vector.updateCoord(xVel, yVel);
        pos.setLocation(pos.getX() + vector.getX(), pos.getY() + vector.getY());
    }

    public void accelDecelTick(){
        if (upPressed) {
            yVel -= baseAccel;
        }
        if (rightPressed) {
            xVel += baseAccel;
        }
        if (downPressed) {
            yVel += baseAccel;
        }
        if (leftPressed) {
            xVel -= baseAccel;
        }

        if(yVel >= 0){
            yVel = Math.max(yVel - yDecel, 0);
        }else{
            yVel = Math.min(yVel + yDecel, 0);
        }

        if(xVel >= 0){
            xVel = Math.max(xVel - xDecel, 0);
        }else{
            xVel = Math.min(xVel + xDecel, 0);
        }
    }
}