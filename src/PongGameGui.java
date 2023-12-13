import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class PongGameGui extends JFrame {

    private JPanel jPanel1;
    private JButton startButton;
    private JTextField textField1;
    private JTextField textField2;

    public PongGameGui() {
        initComponents(); // Initialize components
    }

    // Method to initialize the components of the GUI
    private void initComponents() {
        // Add a DocumentFilter to the text fields to restrict input
        ((AbstractDocument) textField1.getDocument()).setDocumentFilter(createDocumentFilter());
        ((AbstractDocument) textField2.getDocument()).setDocumentFilter(createDocumentFilter());

        startButton.addActionListener(e -> {
            try {
                // Get player names from text fields
                String player1Name = textField1.getText();
                String player2Name = textField2.getText();

                // Check if names contain only letters
                if (!isValidName(player1Name) || !isValidName(player2Name)) {
                    throw new IllegalArgumentException("Invalid name. Please use only letters.");
                }

                // Display player names in a JOptionPane
                JOptionPane.showMessageDialog(this, "First Player: " + player1Name + "\nSecond Player: " + player2Name,
                        "Entered Names", JOptionPane.INFORMATION_MESSAGE);

                // Close the current window and open a new GameFrame
                this.dispose();
                new GameFrame();
            } catch (IllegalArgumentException ex) {
                // Display an error message if an exception occurs
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Set the content pane of the frame
        setContentPane(jPanel1);
        pack();
        setTitle("Pong Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, GamePanel.GAME_HEIGHT + 150));
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    // Method to check if a name contains only letters
    private boolean isValidName(String name) {
        if (name.matches("[a-zA-Z0-9]+")) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid name. Please use only letters or numbers.");
        }
    }

    // Create a DocumentFilter to restrict input to numbers and letters
    private DocumentFilter createDocumentFilter() {
        return new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
                    throws BadLocationException {
                if (isValidText(text)) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (isValidText(text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isValidText(String text) {
                return text.matches("[a-zA-Z0-9]+");
            }
        };
    }

    // Main method to launch the application
    public static void main(String[] args) {
        // Run the GUI on the event dispatch thread
        SwingUtilities.invokeLater(() -> new PongGameGui());
    }
}
