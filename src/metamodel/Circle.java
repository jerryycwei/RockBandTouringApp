package metamodel;

import java.awt.Color;
import java.awt.Graphics2D;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 189 "model.ump"
// line 225 "model.ump"
// line 261 "model.ump"
public class Circle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Circle Attributes
  private String name;
  private int positionX;
  private int positionY;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Circle(String aName, int aPositionX, int aPositionY)
  {
    name = aName;
    positionX = aPositionX;
    positionY = aPositionY;
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

  public boolean setPositionX(int aPositionX)
  {
    boolean wasSet = false;
    positionX = aPositionX;
    wasSet = true;
    return wasSet;
  }

  public boolean setPositionY(int aPositionY)
  {
    boolean wasSet = false;
    positionY = aPositionY;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getPositionX()
  {
    return positionX;
  }

  public int getPositionY()
  {
    return positionY;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "positionX" + ":" + getPositionX()+ "," +
            "positionY" + ":" + getPositionY()+ "]"
     + outputString;
  }
  
  //ADDED METHOD
  public void drawCircle(Graphics2D g, boolean isSelected, boolean isStartPoint, boolean isEndPoint) {
		int r = 8;
		int startX = positionX - (r/2);
		int startY = positionY - (r/2);
		if (isSelected) {
			if (isStartPoint) {
				r = 10;
				startX = positionX - (r/2);
				startY = positionY - (r/2);
				g.setColor(Color.GREEN);
			} else if (isEndPoint) {
				r = 10;
				startX = positionX - (r/2);
				startY = positionY - (r/2);
				g.setColor(Color.YELLOW);
			} else {
				g.setColor(Color.blue);
			}
		} else {
			g.setColor(Color.red);
		}
		g.fillOval(startX, startY, r, r);
	}
}