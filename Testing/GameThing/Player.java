package GameThing;

import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Dimension;

import javax.imageio.ImageIO;

public class Player {

    Vector vector;

    boolean upPressed, downPressed, leftPressed, rightPressed = false;

    double yVel, xVel;
    double acceleration;
    double deceleration;

    // image that represents the player's position on the board
    private BufferedImage image;
    // current position of the player on the board grid
    private Point pos;
    // keep track of the player's score
    private int score;

    public Player() {
        // load the assets
        loadImage();

        // initialize the state
        pos = new Point(0, 0);
        score = 0;

        vector = new Vector(5);
        yVel = 0;
        xVel = 0;
        acceleration = 2;
        deceleration = 1;
    }

    private void loadImage() {
        try {
            // you can use just the filename if the image file is in your
            // project folder, otherwise you need to provide the file path.
            image = ImageIO.read(new URL("https://raw.githubusercontent.com/learncodebygaming/java_2d_game/master/images/player.png"));
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
    }
    
    public void keyPressed(KeyEvent e) {
        // every keyboard get has a certain code. get the value of that code from the
        // keyboard event so that we can compare it to KeyEvent constants
        int key = e.getKeyCode();
        
        // depending on which arrow key was pressed, we're going to move the player by
        // one whole tile for this input
        if (key == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
    }

    public void tick(Dimension dim) {
        // this gets called once every tick, before the repainting process happens.
        // so we can do anything needed in here to update the state of the player.

        moveTick();

        // prevent the player from moving off the edge of the board sideways
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= dim.getWidth()) {
            pos.x = (int)dim.getWidth() - 1;
        }
        // prevent the player from moving off the edge of the board vertically
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= dim.getHeight()) {
            pos.y = (int)dim.getHeight() - 1;
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

    public void moveTick(){
        accelDecelTick();
        vector.update(xVel, yVel);
        pos.setLocation(pos.getX() + vector.dx, pos.getY() + vector.dy);
    }

    public void accelDecelTick(){
        if (upPressed) {
            yVel -= acceleration;
        }
        if (rightPressed) {
            xVel += acceleration;
        }
        if (downPressed) {
            yVel += acceleration;
        }
        if (leftPressed) {
            xVel -= acceleration;
        }

        if(yVel >= 0){
            yVel = Math.max(yVel - deceleration, 0);
        }else{
            yVel = Math.min(yVel + deceleration, 0);
        }

        if(xVel >= 0){
            xVel = Math.max(xVel - deceleration, 0);
        }else{
            xVel = Math.min(xVel + deceleration, 0);
        }
    }
}