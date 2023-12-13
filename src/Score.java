import java.awt.*;

public class Score extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    // Define a constant for the goal score (the score needed to win the game)
    static final int GOAL_SCORE = 10; // Set the goal score to 10
    int player1;
    int player2;
    int highScore; // New variable to store the high score

    Score(int GAME_WIDTH, int GAME_HEIGHT) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
        highScore = 0; // Initialize high score to 0
    }
    // Method to draw the scores and high score on the graphics object
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Century Gothic", Font.PLAIN, 40));

        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
        // Draw the scores for player 1 and player 2 on their respective sides
        g.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10), (GAME_WIDTH / 2) - 85, 50);
        g.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10), (GAME_WIDTH / 2) + 20, 50);
        // Set a smaller font size for drawing the high score
        g.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        // Draw the high score at the top left corner of the game area
        g.drawString("High Score: " + highScore, 20, 30); // Display the high score
    }

    // Update the high score if needed
    public void updateHighScore() {
        if (player1 > highScore) {
            highScore = player1;
        } else if (player2 > highScore) {
            highScore = player2;
        }
    }

    // Method to check if the game is over (if either player has reached the goal score)
    public boolean isGameOver() {
        return player1 == GOAL_SCORE || player2 == GOAL_SCORE;
    }
}
