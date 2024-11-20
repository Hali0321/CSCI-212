//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci
/**
* A sorted list of appliances. It extends the ApplianceList class.
* add method that takes in new appliance to the list and in a sorted order
*/
public class SortedApplianceList extends ApplianceList {
	
   /**
    * Constructor that is empty
    * Initialize list with a dummy node and set tail = head
    */
   public SortedApplianceList() {
       super(); // run the constructor to initialize in ApplianceList
   }
	/**
	 * Add an appliance to the sorted list and it's also sorted
	 * If list is empty, this appliance will be head and tail
	 * @param appliance
	 */
   public void add(Appliance appliance) {
       ApplianceNode newNode = new ApplianceNode(appliance); // create a new node
       ApplianceNode current = head; // start from head
       //move to nextNode if current's data < appliance that we're adding
       while (current.next != null &&
       	   current.next.data.compareTo(appliance) < 0) { // meaning next data < appliance's
           current = current.next;
       }
       // update references
       newNode.next = current.next;
       current.next = newNode;
      
       // update new tail
       if (newNode.next == null) {
           tail = newNode;
       }
       length++; // length increment
   }
}
