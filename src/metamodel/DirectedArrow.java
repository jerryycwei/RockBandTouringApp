package metamodel;
import java.awt.geom.Point2D;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 182 "model.ump"
// line 220 "model.ump"
// line 253 "model.ump"
public class DirectedArrow
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DirectedArrow Attributes
  private Point2D begin;
  private Point2D end;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DirectedArrow(Point2D aBegin, Point2D aEnd)
  {
    begin = aBegin;
    end = aEnd;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBegin(Point2D aBegin)
  {
    boolean wasSet = false;
    begin = aBegin;
    wasSet = true;
    return wasSet;
  }

  public boolean setEnd(Point2D aEnd)
  {
    boolean wasSet = false;
    end = aEnd;
    wasSet = true;
    return wasSet;
  }

  public Point2D getBegin()
  {
    return begin;
  }

  public Point2D getEnd()
  {
    return end;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "begin" + "=" + (getBegin() != null ? !getBegin().equals(this)  ? getBegin().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "end" + "=" + (getEnd() != null ? !getEnd().equals(this)  ? getEnd().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}