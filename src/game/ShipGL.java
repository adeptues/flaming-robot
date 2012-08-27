package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import entities.Entity;

/**
 * @author adeptues
 * 
 */
public class ShipGL extends Entity {
   private Path2D.Double ssTriangle;

   // TODO rewrite this to use open gl
   public ShipGL(String iD, String humanReadableName) {
      super(iD, humanReadableName);
      // TODO Auto-generated constructor stub
      // construct our ship
      ssTriangle = new Path2D.Double();
      ssTriangle.moveTo(0.0, -30.0);
      ssTriangle.lineTo(20.0, 20.0);
      ssTriangle.lineTo(0.0, 10.0);
      ssTriangle.lineTo(-20.0, 20.0);
      ssTriangle.closePath();
   }

   // not called in this implementation
   @Override
   public void render(Graphics2D g) {
      // get coords to draw at from moveable component
      Propulsion propulsion = (Propulsion) super.getComponentByType(Propulsion.class);
      double x = propulsion.getShipX();
      double y = propulsion.getShipY();
      // offset our drawing to the ships location
      g.translate(x, y);

      // draw the ship (fill then outline)
      g.setColor(Color.gray);
      g.fill(ssTriangle);
      g.setColor(Color.white);
      g.draw(ssTriangle);

   }

   @Override
   public void render() {
      // TODO Auto-generated method stub

   }
}
