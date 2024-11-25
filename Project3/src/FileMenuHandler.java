import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileMenuHandler implements ActionListener {
    private ApplianceGUI applianceGUI;

    public FileMenuHandler(ApplianceGUI applianceGUI) {
        this.applianceGUI = applianceGUI;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(applianceGUI);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selecting file: " + selectedFile.getAbsolutePath());
                LinkedList<Appliance> updatedList = fileOpen(selectedFile);
                if (updatedList != null) {
                    applianceGUI.updateApplianceList(updatedList); // Refresh the GUI
                }
            }
        } else if (menuName.equals("Quit")) {
            System.exit(0);
        }
    }

    private LinkedList<Appliance> fileOpen(File file) {
        LinkedList<Appliance> appliances = new LinkedList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String[] parts = nextLine.split(",");

                // Validate and parse the appliance data
                if (parts.length != 3) {
                    System.out.println("Invalid line: " + nextLine);
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
                        boolean undercounter = parts[2].equalsIgnoreCase("Y");
                        appliance = new Dishwasher(serialNumber, price, undercounter);
                    } else if (serialNumber.charAt(0) == 'M') {
                        int watts = Integer.parseInt(parts[2]);
                        appliance = new Microwave(serialNumber, price, watts);
                    } else {
                        System.out.println("Invalid serial number: " + nextLine);
                    }
                    if (appliance != null) {
                        appliances.add(appliance);
                    }
                } catch (IllegalApplianceException | NumberFormatException e) {
                    System.out.println("Invalid serial number: " + nextLine);
                }
            }
            appliances.sort(null); // Ensure the list is sorted
            return appliances;
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(applianceGUI, "File not exists");
            return null;
        }
    }
}