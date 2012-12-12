package collisions;

import java.awt.Point;

import atemis.Line2D;

import maths.Vector2D;

public class LineIntersection {

   /**
    * Routine to calculate where a pair of lines intersect (if they do).
    * 
    * @param (integers) X co-ordinates and Y co-ordinates of both ends of two lines. output: (X,Y) of
    *        intersection, and integer to indicate which type of intersection 3 = true intersection 2 = line
    *        segment 2 only 1 = line segment 1 only 0 = not on either segment -1 = parallel -2 = colinear
    */
   public static int[] lineIntersection(int x1Coord1, int y1Coord1, int x1Coord2, int y1Coord2, int x2Coord1,
         int y2Coord1, int x2Coord2, int y2Coord2) {
      int result[];
      result = new int[3];
      int x = 0;
      int y = 0;
      int intersectionType = 0;// default no collision

      // get coefficients
      int[] firstLine = lineEquation(x1Coord1, y1Coord1, x1Coord2, y1Coord2);
      int[] secondLine = lineEquation(x2Coord1, y2Coord1, x2Coord2, y2Coord2);

      // set coefficients of first line
      int a1 = firstLine[0];
      int b1 = firstLine[1];
      int c1 = firstLine[2];

      // set coefficients of second line
      int a2 = secondLine[0];
      int b2 = secondLine[1];
      int c2 = secondLine[2];

      int xNumerator = ((b1 * c2) - (b2 * c1));

      int xDenominator = ((a1 * b2) - (a2 * b1));
      int yNumerator = ((a2 * c1) - (a1 * c2));// (a2*c1)(a1*c2)

      // test colinear and parallel
      if (xDenominator == 0) {
         if (xNumerator == 0) {
            // colinear
            intersectionType = -2;
            result[0] = x;
            result[1] = y;
            result[2] = intersectionType;
            // da.setColour(Color.RED);
            // da.cross(x, y);
            // da.setColour(Color.BLUE);
            return result;
         }
         // parallel
         intersectionType = -1;
         result[0] = x;
         result[1] = y;
         result[2] = intersectionType;
         // da.setColour(Color.RED);
         // da.cross(x, y);
         // da.setColour(Color.BLUE);
         return result;

      }

      try {
         // calculate new x and y
         y = yNumerator / xDenominator;
         x = xNumerator / xDenominator;
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("failed to calculate x and y");

      }

      // test line intersection points for line 1
      if (((x >= x1Coord1) && (x <= x1Coord2)) || ((x <= x1Coord1) && (x >= x1Coord2))) {
         if (((x >= x2Coord1) && (x <= x2Coord2))// test line 2
               || ((x <= x2Coord1) && (x >= x2Coord2))) {
            // true intersection if line 2 as well
            intersectionType = 3;
            result[0] = x;
            result[1] = y;
            result[2] = intersectionType;
            // da.setColour(Color.RED);
            // da.cross(x, y);
            // da.setColour(Color.BLUE);
            return result;
         } else {
            // line 1
            intersectionType = 1;
            result[0] = x;
            result[1] = y;
            result[2] = intersectionType;
            // da.setColour(Color.RED);
            // da.cross(x, y);
            // da.setColour(Color.BLUE);
            return result;
         }

      } else {// test if on line 2 only
         if (((x > x2Coord1) && (x < x2Coord2)) || ((x < x2Coord1) && (x > x2Coord2))) {
            // line 2
            intersectionType = 2;
            result[0] = x;
            result[1] = y;
            result[2] = intersectionType;
            // da.setColour(Color.RED);
            // da.cross(x, y);
            // da.setColour(Color.BLUE);
            return result;
         }
         // else no intersection
         intersectionType = 0;
         result[0] = x;
         result[1] = y;
         result[2] = intersectionType;
         // da.setColour(Color.RED);
         // da.cross(x, y);
         // da.setColour(Color.BLUE);
         return result;
      }

   } // end lineIntersection()
   
   public static Vector2D lineIntersect(Line2D line1,Line2D line2){
	   int x1 = (int) line1.getP1().getX();
	   int y1 = (int) line1.getP1().getY();
	   int x2 = (int) line1.getP2().getX();
	   int y2 = (int) line1.getP2().getY();
	   int x3 = (int) line2.getP1().getX();
	   int y3 = (int) line2.getP1().getY();
	   int x4 = (int) line2.getP2().getX();
	   int y4 = (int) line2.getP2().getY();
	   Point point = lineIntersectj(x1, y1, x2, y2, x3, y3, x4, y4);
	   if(point != null){
		   Vector2D result = new Vector2D(new Float(point.getX()).floatValue(), new Float(point.getY()).floatValue());
		   return result;
	   }
	   return null;
   }
   
   /**
    * 2d line interection method from http://www.java-gaming.org/topics/utils-essentials/22144/view.html
    * @param x1
    * @param y1
    * @param x2
    * @param y2
    * @param x3
    * @param y3
    * @param x4
    * @param y4
    * @return
    */
   public static Point lineIntersectj(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
	      double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
	      if (denom == 0.0) { // Lines are parallel.
	         return null;
	      }
	      double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
	      double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
	        if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
	            // Get the intersection point.
	            return new Point((int) (x1 + ua*(x2 - x1)), (int) (y1 + ua*(y2 - y1)));
	        }

	      return null;
	   }

   /**
    * Routine to find whether a pair of lines intersect if they do and return true or false.<br>
    * 
    * <P>
    * <STRONG>(EXPERIMENTAL)</STRONG>
    * </P>
    * <br>
    * 
    * @param (integers) X co-ordinates and Y co-ordinates of both ends of two lines. output: (X,Y) of
    *        intersection, and integer to indicate which type of intersection 3 = true intersection 2 = line
    *        segment 2 only 1 = line segment 1 only 0 = not on either segment -1 = parallel -2 = colinear
    */
   public static boolean lineIntersect(int x1Coord1, int y1Coord1, int x1Coord2, int y1Coord2, int x2Coord1,
         int y2Coord1, int x2Coord2, int y2Coord2) {
      int result[];
      result = new int[3];
      int x = 0;
      int y = 0;
      int intersectionType = 0;// default no collision

      // get coefficients
      int[] firstLine = lineEquation(x1Coord1, y1Coord1, x1Coord2, y1Coord2);
      int[] secondLine = lineEquation(x2Coord1, y2Coord1, x2Coord2, y2Coord2);

      // set coefficients of first line
      int a1 = firstLine[0];
      int b1 = firstLine[1];
      int c1 = firstLine[2];

      // set coefficients of second line
      int a2 = secondLine[0];
      int b2 = secondLine[1];
      int c2 = secondLine[2];

      int xNumerator = ((b1 * c2) - (b2 * c1));

      int xDenominator = ((a1 * b2) - (a2 * b1));
      int yNumerator = ((a2 * c1) - (a1 * c2));// (a2*c1)(a1*c2)

      // test colinear and parallel
      if (xDenominator == 0) {
         if (xNumerator == 0) {
            // colinear
            intersectionType = -2;
            // result[0] = x;
            // result[1] = y;
            // result[2] = intersectionType;
            // da.setColour(Color.RED);
            // da.cross(x, y);
            // da.setColour(Color.BLUE);
            return false;
         }
         // parallel
         intersectionType = -1;
         result[0] = x;
         result[1] = y;
         result[2] = intersectionType;
         // da.setColour(Color.RED);
         // da.cross(x, y);
         // da.setColour(Color.BLUE);
         return false;

      }

      try {
         // calculate new x and y
         y = yNumerator / xDenominator;
         x = xNumerator / xDenominator;
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("failed to calculate x and y");

      }

      // test line intersection points for line 1
      if (((x >= x1Coord1) && (x <= x1Coord2)) || ((x <= x1Coord1) && (x >= x1Coord2))) {
         if (((x >= x2Coord1) && (x <= x2Coord2))// test line 2
               || ((x <= x2Coord1) && (x >= x2Coord2))) {
            // true intersection if line 2 as well
            intersectionType = 3;
            result[0] = x;
            result[1] = y;
            result[2] = intersectionType;
            // da.setColour(Color.RED);
            // da.cross(x, y);
            // da.setColour(Color.BLUE);
            return true;
         } else {
            // line 1
            intersectionType = 1;
            result[0] = x;
            result[1] = y;
            result[2] = intersectionType;
            // da.setColour(Color.RED);
            // da.cross(x, y);
            // da.setColour(Color.BLUE);
            return true;
         }

      } else {// test if on line 2 only
         if (((x > x2Coord1) && (x < x2Coord2)) || ((x < x2Coord1) && (x > x2Coord2))) {
            // line 2
            intersectionType = 2;
            result[0] = x;
            result[1] = y;
            result[2] = intersectionType;
            // da.setColour(Color.RED);
            // da.cross(x, y);
            // da.setColour(Color.BLUE);
            return true;
         }
         // else no intersection
         intersectionType = 0;
         result[0] = x;
         result[1] = y;
         result[2] = intersectionType;
         // da.setColour(Color.RED);
         // da.cross(x, y);
         // da.setColour(Color.BLUE);
         return false;
      }

   } // end lineIntersection()

   /**
    * lineEquation routine to calculate the equation of a straight line from the co-ordinates of two points on
    * that line. The equation is of the form AX + BY + C = 0
    * 
    * @param X
    *           and Y co-ordinates of two points on line
    * 
    *           output: matrix size 3 to hold coefficients of line equation (A, B, and C)
    * 
    */
   public static int[] lineEquation(int xCoord1, int yCoord1, int xCoord2, int yCoord2) {
      int[] result;
      result = new int[3];

      int coeficientA = yCoord1 - yCoord2;
      int coeficientB = xCoord2 - xCoord1;
      int coeficientC = (xCoord1 * yCoord2) - (xCoord2 * yCoord1);

      result[0] = coeficientA;
      result[1] = coeficientB;
      result[2] = coeficientC;

      return result;
   } // end lineEquation()

}
