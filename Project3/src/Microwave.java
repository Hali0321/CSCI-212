//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci
/**
* This class is for microwave, it has its
* serial number, price and watts
*/
public class Microwave extends Appliance {
	
   private int watts;
   
   /**
    * A constructor that takes serial number, price and watts
    * @param serialNumber the Serial number of the Microwave
    * @param price the price of the Microwave
    * @param watts the wattage of the microwave
    */
   public Microwave(String serialNumber, double price, int watts) {
       super(serialNumber, price);
       this.watts = watts;
   }
   
   /**
    * return a string of microwave of serial number, price and watts
    */
   @Override
   public String toString() {
       return "SN: " + getSerialNumber() + ", Price: $" + getPrice() + ", Watts: " + watts + " watts";
   }
}
