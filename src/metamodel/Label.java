package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 207 "model.ump"
// line 275 "model.ump"
// line 333 "model.ump"
public class Label
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Label Attributes
  private String description;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Label(String aDescription)
  {
    description = aDescription;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}