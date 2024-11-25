import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.LinkedList;

public class ApplianceGUI extends JFrame {
    private JTextArea refrigeratorTextArea;
    private JTextArea dishwasherTextArea;
    private JTextArea microwaveTextArea;
    private LinkedList<Appliance> appliances;

    public ApplianceGUI(LinkedList<Appliance> sortedList) {
        this.appliances = sortedList;

        setTitle("Appliance List");
        setLayout(new GridLayout(1, 3));

        refrigeratorTextArea = createTextArea(appliances, 'R');
        dishwasherTextArea = createTextArea(appliances, 'D');
        microwaveTextArea = createTextArea(appliances, 'M');

        add(refrigeratorTextArea);
        add(dishwasherTextArea);
        add(microwaveTextArea);

        setJMenuBar(createMenu());

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // Display GUI
    }

    JTextArea createTextArea(LinkedList<Appliance> sortedList, char applianceType) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBorder(new LineBorder(Color.BLACK));

        // Add appliance type title based on applianceType
        if (applianceType == 'R') {
            textArea.append("Refrigerators\n");
        } else if (applianceType == 'D') {
            textArea.append("Dishwashers\n");
        } else if (applianceType == 'M') {
            textArea.append("Microwaves\n");
        }

        // Iterate over the LinkedList and filter by appliance type
        for (Appliance appliance : sortedList) {
            if (appliance.getSerialNumber().charAt(0) == applianceType) {
                textArea.append(appliance.toString() + "\n");
            }
        }

        return textArea;
    }

    public void updateApplianceList(LinkedList<Appliance> newList) {
        newTextArea(refrigeratorTextArea, newList, 'R');
        newTextArea(dishwasherTextArea, newList, 'D');
        newTextArea(microwaveTextArea, newList, 'M');
        pack();
    }

    private void newTextArea(JTextArea textArea, LinkedList<Appliance> sortedList, char applianceType) {
        textArea.setText(""); // Set everything none
        if (applianceType == 'R') {
            textArea.append("Refrigerators\n");
        } else if (applianceType == 'D') {
            textArea.append("Dishwashers\n");
        } else if (applianceType == 'M') {
            textArea.append("Microwaves\n");
        }

        for (Appliance appliance : sortedList) {
            if (appliance.getSerialNumber().charAt(0) == applianceType) {
                textArea.append(appliance.toString() + "\n");
            }
        }
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem item;
        FileMenuHandler fmh = new FileMenuHandler(this);

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
