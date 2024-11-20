//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 {

    public static void main(String[] args) throws FileNotFoundException {
        SortedApplianceList sortedApplianceList = new SortedApplianceList();

        // Read appliances from the text file and add them to the sorted list
        
        Scanner scanner = new Scanner(new File("Project2.txt"));
        
        // while file next line is not empty
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            
            // check if it's the right format, SN, price, special value
            if (parts.length != 3) {
                System.out.println("Invalid line: " + line);
                continue;
            }
            // start sorting each appliance category 
            else {
                String serialNumber = parts[0];
                double price = Double.parseDouble(parts[1]);
                Appliance appliance = null;
            
                // sort refrigerator
                if (serialNumber.charAt(0) == 'R') {
                	double cubicFeet = Double.parseDouble(parts[2]);
                	appliance = new Refrigerator(serialNumber, price, cubicFeet);
                } 
                // sort dishwasher
                else if (serialNumber.charAt(0) == 'D') {
                	boolean undercounterInstallation = parts[2].equals("Y");
                	appliance = new Dishwasher(serialNumber, price, undercounterInstallation);
                } 
                // sort microwave
                else if (serialNumber.charAt(0) == 'M') {
                	int watts = Integer.parseInt(parts[2]);
                	appliance = new Microwave(serialNumber, price, watts);
                } 
                // add appliance to sorted appliance list if created
                if (appliance != null) {
                	sortedApplianceList.add(appliance);
                }
            }
        }
        scanner.close();  // close scanner

        // Display sorted list in GUI
        ApplianceGUI applianceFrame = new ApplianceGUI(sortedApplianceList);
        applianceFrame.setVisible(true);
    }
}