package metamodel;

import java.awt.Color;
import java.awt.Graphics;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/



// line 187 "model.ump"
// line 224 "model.ump"
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

	//Circle Associations
	private Node node;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Circle(String aName, int aPositionX, int aPositionY, Node aNode)
	{
		name = aName;
		positionX = aPositionX;
		positionY = aPositionY;
		if (aNode == null || aNode.getCircle() != null)
		{
			throw new RuntimeException("Unable to create Circle due to aNode");
		}
		node = aNode;
	}

	public Circle(String aName, int aPositionX, int aPositionY, String aNameForNode, MapSystem aMapSystemForNode)
	{
		name = aName;
		positionX = aPositionX;
		positionY = aPositionY;
		node = new Node(aNameForNode, aMapSystemForNode, this);
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

	public Node getNode()
	{
		return node;
	}

	public void delete()
	{
		Node existingNode = node;
		node = null;
		if (existingNode != null)
		{
			existingNode.delete();
		}
	}

	public String toString()
	{
		String outputString = "";
		return super.toString() + "["+
		"name" + ":" + getName()+ "," +
		"positionX" + ":" + getPositionX()+ "," +
		"positionY" + ":" + getPositionY()+ "]" + System.getProperties().getProperty("line.separator") +
		"  " + "node = "+(getNode()!=null?Integer.toHexString(System.identityHashCode(getNode())):"null")
		+ outputString;
	}
	
	public void drawCircle(Graphics g, boolean isSelected) {
		int r = 5;
		int startX = positionX - (r/2);
		int startY = positionY - (r/2);
		if (isSelected) {
			g.setColor(Color.blue);
		} else {
			g.setColor(Color.red);
		}
		g.fillOval(startX, startY, r, r);
	}
}