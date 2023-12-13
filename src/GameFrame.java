import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
    GamePanel panel;
    GameFrame(){
        panel = new GamePanel();
        // Add the GamePanel to the GameFrame (the JFrame)
        this.add(panel);
        // Set the title of the frame to "Pong Game"
        this.setTitle("Pong Game");
        // Make the frame not resizable by the user
        this.setResizable(false);
        // Set the background color of the frame to black
        this.setBackground(Color.black);
        // Set the default close operation to exit the program when the frame is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Pack the frame, which sizes it based on the preferred sizes of its subcomponents
        this.pack();
        // Set the frame to be visible
        this.setVisible(true);
        // Center the frame on the screen
        this.setLocationRelativeTo(null);
    }
}
