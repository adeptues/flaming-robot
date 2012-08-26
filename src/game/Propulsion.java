/**
 * 
 */
package game;

import maths.Mat;
import core.Action;
import entities.Component;

/**
 * @author adeptues
 * 
 */
public class Propulsion extends Component {
   private double shipX;
   private double shipY;
   private int x;
   private int y;
   private static double clockwise = 2.0;
   private static double aClockwise = -2.0;

   public Propulsion(int x, int y) {
      shipX = x;
      shipY = y;
   }

   public double getShipX() {
      return shipX;
   }

   public void setShipX(double shipX) {
      this.shipX = shipX;
   }

   public double getShipY() {
      return shipY;
   }

   public void setShipY(double shipY) {
      this.shipY = shipY;
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   @Override
   public void update(double delta, Action action) {
      if (action == Action.UP) {
         shipY -= 100.0 * delta;
      }
      if (action == Action.DOWN) {
         shipY += 100.0 * delta;
      }
      if (action == Action.LEFT) {
         shipX -= 100.0 * delta;
      }
      if (action == Action.RIGHT) {
         shipX += 100.0 * delta;
      }
      if (action == Action.RLEFT) {

      }
      if (action == Action.RRIGHT) {
         // FIXME this does not work

         Double x = new Double(shipX);
         Double y = new Double(shipY);
         Mat m = new Mat();
         double[][] aRotate = m.rotate(90, 0, 0, x.intValue(), y.intValue());
         System.out.println(aRotate[0][0] + ", " + aRotate[0][1]);
         shipX = aRotate[0][0];
         shipY = aRotate[0][1];

         /*
                  Double clock = new Double(clockwise);
                  clock *= delta;
                  Double deltaf = new Double(delta);
                  // TODO maybe use delta for angle
                  float rX = Maths.getRotatedX(x.floatValue(), y.floatValue(), 0, 0, clock.floatValue());
                  float rY = Maths.getRotatedY(x.floatValue(), y.floatValue(), 0, 0, clock.floatValue());
                  shipX = rX;
                  shipY = rY;
                  */
      }

   }

}
