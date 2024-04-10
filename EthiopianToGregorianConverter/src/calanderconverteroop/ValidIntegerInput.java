package calanderconverteroop;

import javax.swing.JOptionPane;

public class ValidIntegerInput {
    public static int getValidIntegerInput(String message) {
        int input;
        int maxAllowed = 9999;
        if (message.contains("month")) {
            maxAllowed = 13;
        } else if (message.contains("day")) {
            maxAllowed = 30;
        }
        while (true) {
            String userInput = JOptionPane.showInputDialog(message);
            if (userInput == null) { // Check if cancel button is pressed
                System.exit(0);
            }
            try {
                input = Integer.parseInt(userInput);
                if (input <= 0 || input > maxAllowed) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a positive integer less than or equal to " + maxAllowed + ".");
                } else {
                    break; // Break the loop if input is valid
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }
}
