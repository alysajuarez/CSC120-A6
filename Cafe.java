/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /**
    * constructs attributes for Library class
    * @param String name 
    *         name of cafe
    * @param String address
    *         address of cafe
    * @param int nFloors
    *         int of number of floors in cafe
    */ 
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 500;
        this.nSugarPackets = 200;
        this.nCreams = 200;
        this.nCups = 30;
        System.out.println("You have built a cafe: "+ this.name);
    }
    

    /** 
    * method to sell coffee
    * @param int size
    *           size of drink being sold
    * @param int nSugarPackets
    *           number of sugar packets in coffee
    * @param int nCreams
    *           number of splashes of cream in coffee
    */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){

        if (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || this.nCups < 1){
            restock(100, 50, 50, 20);
            this.nCoffeeOunces = this.nCoffeeOunces - size;
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
            this.nCreams = this.nCreams - nCreams;
            this.nCups = this.nCups - 1;
        }
        else{
            this.nCoffeeOunces = this.nCoffeeOunces - size;
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
            this.nCreams = this.nCreams - nCreams;
            this.nCups = this.nCups - 1;

        }
        
    }

    /** 
    * method to restock cafe items when needed
    * @param int nCoffeeOunces
    *           ounces of coffee to add to stock
    * @param int nSugarPackets
    *           number of sugar packets in coffee to add to stock
    * @param int nCreams
    *           number of splashes of cream in coffee to add to stock 
    * @param int int nCups
    *           number of cups to restock
    */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
    
    }

    /** 
    * method to return string of class in a clean way 
    * 
    * @return String toString
    *         string description of class
    */  
    public String toString() {
        String description = super.toString();
        description += " There are currently " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " sugar packets, " + this.nCreams + " splashes of cream, and " + this.nCups + " cups in stock";
        return description;
      }


    public static void main(String[] args) {
        Cafe starbucks = new Cafe("Starbucks", "King St", 1);
        System.out.println(starbucks);
        starbucks.sellCoffee(490, 199, 199);
        System.out.println(starbucks);
        starbucks.sellCoffee(15, 3, 3);
        System.out.println(starbucks);

       
    }
    
}
