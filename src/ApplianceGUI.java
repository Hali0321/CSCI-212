//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

// GUI class to display the appliances
public class ApplianceGUI extends JFrame {
	
	
    public ApplianceGUI(SortedApplianceList sortedList) {
        setTitle("Appliance List"); // GUI title name
        setLayout(new GridLayout(1, 3)); // 1 row, 3 columns

        // TextArea for each appliance sorting by category
        JTextArea refrigeratorTextArea = createTextArea(sortedList, 'R');
        JTextArea dishwasherTextArea = createTextArea(sortedList, 'D');
        JTextArea microwaveTextArea = createTextArea(sortedList, 'M');

        // add to text area
        add(refrigeratorTextArea);
        add(dishwasherTextArea);
        add(microwaveTextArea);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // appropriate size automatically
        setVisible(true);
    }

    
    // create text area method
    JTextArea createTextArea(SortedApplianceList sortedList, char applianceType) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
		textArea.setBorder(new LineBorder(Color.BLACK));

        // each type following after the type name
        if (applianceType == 'R') {
            textArea.append("Refrigerators\n");
        } else if (applianceType == 'D') {
            textArea.append("Dishwashers\n");
        } else if (applianceType == 'M') {
            textArea.append("Microwaves\n");
        }

        ApplianceNode currentNode = sortedList.head.next;   // skip the dummy head node

        // A while loop on each node
        while (currentNode != null) { 
            if (currentNode.data.getSerialNumber().charAt(0) == applianceType) {
                textArea.append(currentNode.data.toString() + "\n"); // if type matches, append
            }
            currentNode = currentNode.next;  // move to next node
        }

        return textArea;
    }
}