//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci
/**
* A class that sets appliance data and set next appliance node
*/
public class ApplianceNode {
   protected Appliance data; // appliance data
   protected ApplianceNode next; // nextNode reference
   /**
    * A constructor that takes type Appliance data as input
    * @param data Takes appliance's data for parameter
    * set data as this and set next null
    */
   public ApplianceNode(Appliance data) {
       this.data = data;
       this.next = null; //initialize
   }
}
