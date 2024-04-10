/**
 * JAVA EC to GC calendar converter project *

 Contributors:  1, Abel Abraham             1557/14
                2, Bitaniya Tewodros        4276/14
                3, Dawit Bekele             2155/14
 */


package calanderconverteroop;

import javax.swing.JOptionPane;
import java.time.LocalDate;


import static calanderconverteroop.ValidIntegerInput.getValidIntegerInput;


public class EthiopianToGregorian {

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            try {

                int year = getValidIntegerInput("Enter Ethiopian year:");


                int month = getValidIntegerInput("Enter Ethiopian month:");


                int day = getValidIntegerInput("Enter Ethiopian day:");


                LocalDate gcDate = DateConverter.ToGregorianDate(year, month, day);


                JOptionPane.showMessageDialog(null, "Gregorian Date: " + gcDate);


                int option = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Continue", JOptionPane.YES_NO_OPTION);
                if (option != JOptionPane.YES_OPTION) {
                    exit = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input format. Please enter a valid integer.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        }
    }

}