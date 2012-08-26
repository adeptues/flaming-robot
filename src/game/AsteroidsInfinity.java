/**
 * 
 */
package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import utils.Log;
import core.Action;
import core.GameWindow;
import core.Keyboard;
import entities.Component;

/**
 * This is a simple implementation of the asteroids game in order to demonstrate the engine is at least
 * working
 * 
 * @author adeptues
 * 
 */
public class AsteroidsInfinity extends GameWindow {
   private Ship ship;

   public AsteroidsInfinity(String title, int width, int height) {
      super(title, width, height);
      // TODO Auto-generated constructor stub
   }

   @Override
   public void gameStartup() {
      Log.info(getClass().getSimpleName(), "Starting up game");
      ship = new Ship("1223", "SpaceShip");
      Component prop = new Propulsion(getWidth() / 2, getHeight() / 2);
      ship.addComponent(prop);
      // construct our ship
      // normally we'd build a world object which would track all our entities

   }

   @Override
   public void gameUpdate(double delta) {
      Keyboard keyboard = getKeyboard();
      // input polling
      if (keyboard.isKeyPressed(KeyEvent.VK_UP)) {
         ship.update(delta, Action.UP);

      }
      if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)) {
         ship.update(delta, Action.DOWN);

      }
      if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)) {
         ship.update(delta, Action.LEFT);

      }
      if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)) {
         ship.update(delta, Action.RIGHT);

      }
      if (keyboard.isKeyPressed(KeyEvent.VK_E)) {
         ship.update(delta, Action.RRIGHT);

      }

      // check for escape key
      LinkedList<KeyEvent> keyEvents = keyboard.getEvents();
      for (KeyEvent event : keyEvents) {
         if ((event.getID() == KeyEvent.KEY_PRESSED) && (event.getKeyCode() == KeyEvent.VK_ESCAPE)) {
            stop();
         }
      }

   }

   @Override
   public void gameDraw(Graphics2D g) {
      ship.render(g);

   }

   @Override
   public void gameShutdown() {
      Log.info(getClass().getSimpleName(), "Shutting down game");
      /*
       * boolean fullScreen = isFullScreenRunning(); if (fullScreen) { fullScreen(false); }
       */

   }

}
