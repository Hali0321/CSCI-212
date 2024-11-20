//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci
/**
* A class for dishwasher
* contains its serial number, price and under counter installation Y/N
*/
public class Dishwasher extends Appliance {
   private boolean undercounterInstallation; // unique for Dishwasher class, isn't inherited from Appliance
   /* constructor that doesn't return anything
    * takes 3 inputs, initialize them, first two by calling super() from parent class
    */
   public Dishwasher(String serialNumber, double price, boolean undercounterInstallation) {
       super(serialNumber, price);
       this.undercounterInstallation = undercounterInstallation;
   }
   /**
    * Return the values of the dishwasher, including price, serial number and installation
    */
   @Override
   public String toString() {
       String undercounter = null; // a String to show Y/N
      
       //check Y/N to set underCounter
       if(undercounterInstallation == true) {
       	undercounter = "Yes";
       }
       else {
       	undercounter = "No";
       }
      
       return "SN: " + getSerialNumber() + ", Price: $" + getPrice()
       	   + ", Undercounter Installation: " + undercounter;
   }
}
