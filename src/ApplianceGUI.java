import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.util.LinkedList;

public class ApplianceGUI extends JFrame {

    public ApplianceGUI(LinkedList<Appliance> sortedList) {
        setTitle("Appliance List"); // GUI title
        setLayout(new GridLayout(1, 3)); // 1 row, 3 columns

        // Create TextAreas for each appliance category
        JTextArea refrigeratorTextArea = createTextArea(sortedList, 'R');
        JTextArea dishwasherTextArea = createTextArea(sortedList, 'D');
        JTextArea microwaveTextArea = createTextArea(sortedList, 'M');

        // Add TextAreas to the frame
        add(refrigeratorTextArea);
        add(dishwasherTextArea);
        add(microwaveTextArea);

        // Set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(createMenu()); // Add menu bar to the frame

        // Set frame properties
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Automatically sizes the components
        setVisible(true);
    }

    // Create TextArea for each appliance type
    JTextArea createTextArea(LinkedList<Appliance> sortedList, char applianceType) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBorder(new LineBorder(Color.BLACK));

        // Header for each appliance type
        if (applianceType == 'R') {
            textArea.append("Refrigerators\n");
        } else if (applianceType == 'D') {
            textArea.append("Dishwashers\n");
        } else if (applianceType == 'M') {
            textArea.append("Microwaves\n");
        }

        // Add appliances of the specified type
        for (Appliance appliance : sortedList) {
            if (appliance.getSerialNumber().charAt(0) == applianceType) {
                textArea.append(appliance.toString() + "\n");
            }
        }

        return textArea;
    }

    // Create the menu bar with "File" and "Quit" options
	private JMenuBar createMenu( ) {
    	JMenuBar menuBar  = new JMenuBar();
    	JMenu fileMenu = new JMenu("File");
    	JMenuItem item;
    	FileMenuHandler fmh  = new FileMenuHandler(this);
    	   
    	item = new JMenuItem("Open"); 
    	item.addActionListener(fmh);
    	fileMenu.add(item);
    	   
    	fileMenu.addSeparator(); 
    	   
    	item = new JMenuItem("Quit"); 
    	item.addActionListener(fmh);
    	fileMenu.add(item);
    	   
    	menuBar.add(fileMenu);
    	return menuBar;
	}
    
}