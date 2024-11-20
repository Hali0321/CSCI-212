//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci
/**
* This abstract class creates a linked list to store appliances
* It can add appliances to the tail and return the list length
* It contains nodes and has an appliance and its reference to next node
*/
public abstract class ApplianceList {
   protected ApplianceNode head; // protected which only grants access in descendant class
   protected ApplianceNode tail;
   protected int length;
   /**
    *  A constructor that constructs an empty list with a dummy head node
    *  that head and point point to dummy node
    */
   public ApplianceList() {
       head = new ApplianceNode(null); // a null head node
       tail = head; // empty list same head & tail
       length = 0; // empty list length is 0
   }
   /**
    * Append appliance to the last of the list
    * A new node with the appliance, tail is the new one and length increment
    * @param appliance To be added to the list
    */
   public void append(Appliance appliance) {
       ApplianceNode nextNode = new ApplianceNode(appliance);
       tail.next = nextNode; // link current tail to next node
       tail = nextNode; // update tail
       length++; // a new node, length +1
   }
   /**
    * return the length of the list
    * @return The number of appliances in the list
    */
   public int getLength() {
       return length;
   }
}
