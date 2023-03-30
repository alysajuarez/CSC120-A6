public class Building {

    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;


    /**
    * constructs attributes for Building Class
    * @param String name
    *           name of building
    * @param String address
    *           address of bulding
    * @param int nFloors
    *            int of number of floors in building
    */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
    * accessor to get name of building
    * @return this.name
    */
    public String getName() {
        return this.name;
    }

    /**
    * accessor to get address of building
    * @return this.address
    */
    public String getAddress() {
        return this.address;
    }

    /**
    * accessor to get number of floors of building
    * @return this.nFloors
    */
    public int getFloors() {
        return this.nFloors;
    }


    /** 
    * method to return string of class in a clean way 
    * 
    * @return String toString
    *         string description of class
    */  
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}
