//Hali Ding   Lab Section: (B) MW 3:40pm-4:30pm  Prof.Nikola Baci
/**
* This abstract class means a appliance class with serial number and price
* It implements comparable to sort appliances by serial number
*/
public abstract class Appliance implements Comparable<Appliance> {
   private String serialNumber;
   protected double price; // protected, only can access from descendant class
  
   /** A constructor that takes a String serial number as a parameter
    *  check if the serialNumber is correct and
    * @param serialNumber SerialNumber of the Appliance
    * @param price Price of the Appliance
    */
   public Appliance(String serialNumber, double price) {
       if (!isValidSerialNumber(serialNumber)) {
           throw new IllegalArgumentException("Invalid SerialNumber.");
       }
       this.serialNumber = serialNumber;
       this.price = price;
   }
   	
  
   /**
    * get the serial number of the Appliance
    * @return appliance serial number of appliance
    */
   public String getSerialNumber() {
       return serialNumber;
   }
  
   /**
    * Get the price of the Appliance
    * @return the price of the appliance
    */
   public double getPrice() {
       return price;
   }
  
  
   /** check the serial number length to be exactly 12 and
    *  the first character starts at 'R' ‘D' or 'M'
    * 	@param the entered serial number to be checked
    */
	private static boolean isValidSerialNumber(String serialNumber) {
		if(serialNumber.length() != 12) {
			return false;
		}
		char firstChar = serialNumber.charAt(0);
       return (firstChar == 'R' || firstChar == 'D' || firstChar == 'M');
   }
	
	
	/**
	 * Compare this appliance with other appliance based on serial numbers
	 * @param other appliance to compare
	 * return -1, 0, 1 if this appliance's serial number is
	 * less than or equal to or greater than
	 * other appliance serial number
	 */
	@Override
	public int compareTo(Appliance other) {
		return this.serialNumber.compareTo(other.getSerialNumber());
	}
	
	/**
	 * Check if this appliance serial number equals
	 * another appliance serial number
	 * @param the other object that is comparing to
	 * return true if same number and same type
	 * return false different number or different type or both
	 */
	public boolean equals(Object other) {
		return(   other != null
			   && getClass() == other.getClass()
			   && serialNumber.equals(((Appliance) other).serialNumber)
				 );
	}
	/**
	 * return a string of appliance, its serial number
	 */
	public String toString() {
		return serialNumber;
	}
}
