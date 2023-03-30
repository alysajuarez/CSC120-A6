import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;


    /**
    * constructs attributes for Library class
    * @param String name 
    *         name of library
    * @param String address
    *         address of library
    * @param int nFloors
    *         int of number of floors in library
    */ 
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: " + this.name);
      
    }

    /**
    * method to get number of books in library
    * @return this.collection.size()
    */
    public int nBooks() {
      return this.collection.size();
    }
    
    /**
    * method to add a book to library's collection
    * @param String title
    *           title of book to add along with key to indicate true or false to if it's checked out
    */
    public void addTitle(String title){
      this.collection.put(title, true);
    }

    /** 
    * method to add a book to library's collection
    * @param String title
    *           title of book to add 
    */
    public String removeTitle(String title) { 
      if (!this.collection.containsKey(title)){ 
        throw new RuntimeException(title + " is not a part of this library's collection");
      }
        this.collection.remove(title); 
        return title + "has been removed from the library's collection";
        
    }

    /** 
    * method to check out a book from the library if it is in the collection and available and change value to false 
    * @param String title
    *           title of book 
    */
    public void checkOut(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException(title + " is not a part of this library's collection");
      }
      else {
        if (this.collection.get(title) != true){
          throw new RuntimeException(title + " is currently checked out");
        }
        else {
          this.collection.replace(title, true, false);
        }
      }
    }

    /** 
    * method to return book to library
    * @param String title
    *           title of book 
    */
    public void returnBook(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException(title + " is not a part of this library's collection, you cannot return it");
      }
      else {
        if (this.collection.get(title) == true){
          throw new RuntimeException(title + " has not been checked out by you");
        }
        else {
          this.collection.replace(title,false, true);
        }
      }
    }

    /** 
    * method to return book to library
    * @param String title
    *          title of book 
    * @return boolean containsTitle
    *         returns true if the title appears as a key in collection, false otherwise
    */
    public boolean containsTitle(String title){ 
      if (this.collection.containsKey(title)){
        return true;
      }
      else{
        return false;
      }
    }
  

    /** 
    * method to return book to library
    * @param String title
    *          title of book 
    * @return boolean isAvailable
    *         returns true if the title is currently available, false otherwise
    */
    public boolean isAvailable(String title){ 
      if (this.collection.containsKey(title)==true){
        if (this.collection.get(title)==true){
          return true;
        }
        else{
          System.out.println(title + " is currently checked out");
          return false;
    
        }
      }
      else{
        System.out.println(title + " is not a part of this library's collection");
        return false;
      }
    }
      
      

    /** 
    * method to print out the entire collection in an easy-to-read way (including checkout status)
    * 
    */
    public void printCollection(){ // 
      if (this.collection.isEmpty()){
        System.out.println("no books");
      }
      else{
        System.out.println(collection.toString()); 
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
      description += " there are currently " + this.nBooks() + " books in this library's collection";
      return description;
    }




  
    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "Central Campus", 3);
      Library forbes = new Library("Forbes", "20 West St", 2);
      //System.out.println(forbes);
      neilson.addTitle("the shining");
      neilson.addTitle("the hunger games");
      neilson.addTitle("citizen");
      //System.out.println(neilson);
      neilson.printCollection();
      neilson.removeTitle("the hunger games");
      neilson.printCollection();
      // System.out.println(neilson);
      neilson.checkOut("citizen");
      neilson.printCollection();
      //neilson.isAvailable("citizen");
      neilson.returnBook("citizen");
      neilson.isAvailable("citizen");
      //System.out.println(neilson.containsTitle("citizen"));
      // System.out.println(neilson.containsTitle("the hunger games"));

    }
  
  }