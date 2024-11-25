import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.*;

public class Project3 {

    public static void main(String[] args) {
        LinkedList<Appliance> appliances = new LinkedList<>();
        ApplianceGUI applianceFrame = new ApplianceGUI(appliances); // Create GUI with an empty list
        applianceFrame.setVisible(true);
        // Use JFileChooser to open a file dialog for file selection
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  // Allow only files to be selected
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Process the file if selected
            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNextLine()) {
                    String nextLine = scanner.nextLine();
                    String[] parts = nextLine.split(",");

                    // Validate the line format: serial number, price, and special value
                    if (parts.length != 3) {
                        System.out.println("Invalid line: " + nextLine);
                        continue;
                    }

                    String serialNumber = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    Appliance appliance = null;

                    // Process appliances based on serial number prefix
                    try {
                        if (serialNumber.charAt(0) == 'R') {
                            double cubicFeet = Double.parseDouble(parts[2]);
                            appliance = new Refrigerator(serialNumber, price, cubicFeet);
                        } else if (serialNumber.charAt(0) == 'D') {
                            boolean undercounterInstallation = parts[2].equals("Y");
                            appliance = new Dishwasher(serialNumber, price, undercounterInstallation);
                        } else if (serialNumber.charAt(0) == 'M') {
                            int watts = Integer.parseInt(parts[2]);
                            appliance = new Microwave(serialNumber, price, watts);
                        } else {
                            System.out.println("Invalid serial number: " + serialNumber);
                        }
                        if (appliance != null) {
                            appliances.add(appliance);
                        }
                    } catch (IllegalApplianceException | NumberFormatException e) {
                        System.out.println("Invalid serial number: " + serialNumber);
                    }
                }

                // Sort appliances by serial number
                Collections.sort(appliances);

                // Display sorted list in GUI



            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File not found: " + selectedFile.getName(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("No file selected. Exiting...");
        }
    }
}