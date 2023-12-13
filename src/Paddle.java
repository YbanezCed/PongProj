import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{
    int id;
    int yVelocity;
    int speed = 10;
    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    // Method to handle key presses and set the vertical direction based on the player's input
    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                }
                break;
        }
    }

    // Method to handle key releases and stop the paddle's movement in the vertical direction
    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                }
                break;
        }
    }

    // Method to set the vertical velocity based on the input direction
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    // Method to move the paddle vertically based on its velocity
    public void move() {
        y = y + yVelocity;
    }

    // Method to draw the paddle on the graphics object with a specified color
    public void draw(Graphics g) {
        if(id == 1)
            g.setColor(Color.white);
        else
            g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
}
