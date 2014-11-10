package metamodel;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4727 modeling language!*/

// line 182 "model.ump"
// line 220 "model.ump"
// line 253 "model.ump"
public class DirectedArrow {
	
	private static final double ANGLE = 45;
	private static final double LENGTH = 20;

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// DirectedArrow Attributes
	private Point2D begin;
	private Point2D end;
	private Path2D head;
	private Path2D line;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public DirectedArrow(Point2D aBegin, Point2D aEnd) {
		begin = aBegin;
		end = aEnd;

		double angle = getAngle(aBegin, aEnd);
        line = createLine(aBegin, aEnd);
        head = createHead(aEnd, angle, LENGTH, ANGLE);
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public boolean setBegin(Point2D aBegin) {
		boolean wasSet = false;
		begin = aBegin;
		wasSet = true;
		return wasSet;
	}

	public boolean setEnd(Point2D aEnd) {
		boolean wasSet = false;
		end = aEnd;
		wasSet = true;
		return wasSet;
	}

	public Point2D getBegin() {
		return begin;
	}

	public Point2D getEnd() {
		return end;
	}

	public void delete() {
	}

	public String toString() {
		String outputString = "";
		return super.toString()
				+ "["
				+ "]"
				+ System.getProperties().getProperty("line.separator")
				+ "  "
				+ "begin"
				+ "="
				+ (getBegin() != null ? !getBegin().equals(this) ? getBegin()
						.toString().replaceAll("  ", "    ") : "this" : "null")
				+ System.getProperties().getProperty("line.separator")
				+ "  "
				+ "end"
				+ "="
				+ (getEnd() != null ? !getEnd().equals(this) ? getEnd()
						.toString().replaceAll("  ", "    ") : "this" : "null")
				+ outputString;
	}
	
	public static Path2D createLine(double beginX, double beginY, double endX, double endY) {
		Path2D line = new Path2D.Double();
		line.moveTo(beginX, beginY);
		line.lineTo(endX, endY);
		return line;
	}
	
	private static double getAngle(Point2D begin, Point2D end) {
		double width = end.getX() - begin.getX();
		double height = end.getY() - begin.getY();

		if (isFirstQuadrant(width, height) || isFourthQuadrant(width, height)) {
			double atanDegree = Math.toDegrees(Math.atan(height / width));
			return -atanDegree + 180;
		}
		
		if (isSecondQuadrant(width, height)) {
			double atanDegree = Math.toDegrees(Math.atan(width / height));
			return atanDegree - 90;
		}
		
		if (isThirdQuadrant(width, height)) {
			double atanDegree = Math.toDegrees(Math.atan(width / height));
			return atanDegree + 90;
		}
		
		double atanDegree = Math.toDegrees(Math.atan(height / width));
		return -atanDegree + 180;
		
	}
	
	private static boolean isFirstQuadrant(double width, double height) {
		if (width >= 0 && height <= 0) {
			return true;
		}
		return false;
	}
	
	private static boolean isSecondQuadrant(double width, double height) {
		if (width <= 0 && height <= 0) {
			return true;
		}
		return false;
	}
	
	private static boolean isThirdQuadrant(double width, double height) {
		if (width <= 0 && height >= 0) {
			return true;
		}
		return false;
	}
	
	private static boolean isFourthQuadrant(double width, double height) {
		if (width >= 0 && height >= 0) {
			return true;
		}
		return false;
	}

	private static Path2D createHead(Point2D fromPoint, double rotationDeg, double length, double wingsAngleDeg) {
		double ax = fromPoint.getX();
		double ay = fromPoint.getY();

		double radB = Math.toRadians(-rotationDeg + wingsAngleDeg);
		double radC = Math.toRadians(-rotationDeg - wingsAngleDeg);

		Path2D resultPath = new Path2D.Double();
		resultPath.moveTo(length * Math.cos(radB) + ax, length * Math.sin(radB) + ay);
		resultPath.lineTo(ax, ay);
		resultPath.lineTo(length * Math.cos(radC) + ax, length * Math.sin(radC) + ay);
		return resultPath;
	}
	
	private static Path2D createLine(Point2D begin, Point2D end) {
		Path2D line = new Path2D.Double();
		line.moveTo(end.getX(), end.getY());
		line.lineTo(begin.getX(), begin.getY());
		return line;
	}
	
}