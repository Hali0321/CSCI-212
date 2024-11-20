//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci
/**
* A class for refrigerator that takes serial number, price and cubic feet
* initialize them
*/
public class Refrigerator extends Appliance {
   private double cubicFeet; // unique for Refrigerator class, isn't inherited from Appliance
   // super, inherit from parent class, initialize cubicFeet
   public Refrigerator(String serialNumber, double price, double cubicFeet) {
       super(serialNumber, price);
       this.cubicFeet = cubicFeet;
   }
   /**
    * Return the price, size and cubic feet of this refrigerator
    */
   @Override
   public String toString() {
       return "SN: " + getSerialNumber() + ", Price: $" + getPrice() + ", Size: " + cubicFeet + " cubic ft";
   }
}
