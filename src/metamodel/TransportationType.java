package metamodel;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4733 modeling language!*/



// line 43 "model.ump"
// line 120 "model.ump"
public class TransportationType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TransportationType Attributes
  private String name;
  private Symbol symbol;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TransportationType(String aName, Symbol aSymbol)
  {
    name = aName;
    symbol = aSymbol;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setSymbol(Symbol aSymbol)
  {
    boolean wasSet = false;
    symbol = aSymbol;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Symbol getSymbol()
  {
    return symbol;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "symbol" + "=" + (getSymbol() != null ? !getSymbol().equals(this)  ? getSymbol().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}
