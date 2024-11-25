import javax.swing.*;
import java.util.LinkedList;

public class Project3 {

    public static void main(String[] args) {
        // Initialize the appliance list
        LinkedList<Appliance> appliances = new LinkedList<>();
        
        // Create GUI with empty linked list
        ApplianceGUI aFrame = new ApplianceGUI(appliances); 
        aFrame.setVisible(true);  // Display GUI

    }
}