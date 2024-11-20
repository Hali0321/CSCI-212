//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class Project3 {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Appliance> appliances = new LinkedList<>();

        // Read appliances from the text file and add them to the linked list
        Scanner scanner = new Scanner(new File("p3Input.txt"));
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            
            if (parts.length != 3) {
                System.out.println("Invalid line: " + line);
                continue;
            }

            String serialNumber = parts[0];
            double price = Double.parseDouble(parts[1]);
            Appliance appliance = null;

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
                }
                if (appliance != null && appliance.getSerialNumber() != null) {
                    appliances.add(appliance);
                } // Add appliance only if it is valid
            } catch (IllegalApplianceException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();

        // Sort appliances by serial number
        Collections.sort(appliances);

        // Display sorted list in GUI
        ApplianceGUI applianceFrame = new ApplianceGUI(appliances);
        applianceFrame.setVisible(true);
    }
}