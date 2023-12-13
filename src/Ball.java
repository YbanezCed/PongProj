import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;

    // Constructor
    Ball(int x, int y, int width, int height){

        super(x, y, width, height);

        // Initialize a Random object to generate random values
        random = new Random();

        // Generate a random value (0 or 1) to determine the initial x-direction
        int randomXDirection = random.nextInt(2);

        // If randomXDirection is 0, make it -1 (left direction), otherwise keep it as 1 (right direction)
        if(randomXDirection == 0)
            randomXDirection--;

        // Set the x-direction of the ball based on the random value and initial speed
        setXDirection(randomXDirection * initialSpeed);

        // Generate a random value (0 or 1) to determine the initial y-direction
        int randomYDirection = random.nextInt(2);

        // If randomYDirection is 0, make it -1 (upward direction), otherwise keep it as 1 (downward direction)
        if(randomYDirection == 0)
            randomYDirection--;

        // Set the y-direction of the ball based on the random value and initial speed
        setYDirection(randomYDirection * initialSpeed);
    }

    // Set the x-direction of the ball
    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    // Set the y-direction of the ball
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    // Move the ball by updating its position based on the current velocities
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    // Draw the ball on a Graphics object with a red color
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, height, width);
    }
}
