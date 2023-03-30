import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;



  /**
    * constructs attributes for House class
    * @param String name 
    *         name of house
    * @param String address
    *         address of house
    * @param int nFloors
    *         int of number of floors in house
    */ 
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: " + this.name);
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

  
  /** 
  * method to add a resident to the house
  * @param String name
  *          name of resident to add to house
  */
  public void moveIn(String name) {
    // check if this.residents contains name
    if (this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    // if we're good to go, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
  }

  /** 
  * method to remove a resident from the house
  * @param String name
  *          name of resident to remove from house
  */
  public String moveOut(String name){
    if (!this.residents.contains(name)){
      throw new RuntimeException(name + " is not a resident of " + this.name);
    }
    this.residents.remove(name);
    return name + " has moved out of "+ this.name;
  }


  /** 
  * method to check if a person is a resident in this house
  * @param String person
  *          name of person to check 
  */
  public boolean isResident(String person){
    if (this.residents.contains(person)) {
      //   if so: throw and exception
      return true;
    }
    else{
      return false;
    }
  }

   /** 
    * method to return string of class in a clean way 
    * 
    * @return String toString
    *         string description of class
    */  
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false);
    System.out.println(morrow);
    morrow.moveIn("Jordan");
    //morrow.moveIn("Jordan");
    morrow.moveIn("alysa");
    System.out.println(morrow);
    House king = new House("King", "The Quad", 3, true);
    System.out.println(king);
    System.out.println(morrow.nResidents());
    System.out.println(morrow.moveOut("alysa"));
    System.out.println(morrow.nResidents());
    System.out.println(morrow.isResident("alysa"));
    System.out.println(morrow.isResident("Jordan"));
  }

}