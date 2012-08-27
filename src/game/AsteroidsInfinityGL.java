/**
 * 
 */
package game;

import org.lwjgl.input.Keyboard;

import core.Action;
import core.GameWindowLWJGL;

/**
 * @author adeptues
 * 
 */
public class AsteroidsInfinityGL extends GameWindowLWJGL {
   private Ship ship;

   public AsteroidsInfinityGL(String title, int width, int height) {
      super(title, width, height);
      // TODO Auto-generated constructor stub
   }

   @Override
   public void gameStartup() {
      // TODO Auto-generated method stub

   }

   @Override
   public void gameUpdate(double delta) {
      // THIS is basically polling input maybe better to use que
      if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
         ship.update(delta, Action.UP);

      }
      if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
         ship.update(delta, Action.DOWN);

      }
      if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
         ship.update(delta, Action.LEFT);

      }
      if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
         ship.update(delta, Action.RIGHT);

      }
      /*
      if (Keyboard.isKeyPressed(KeyEvent.VK_E)) {
         ship.update(delta, Action.RRIGHT);

      }*/

   }

   @Override
   public void gameDraw() {
      // TODO Auto-generated method stub

   }

   @Override
   public void gameShutdown() {
      // TODO Auto-generated method stub

   }

}
