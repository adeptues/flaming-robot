package game;

import core.GameWindow;

public class Main {

   /**
    * @param args
    */
   public static void main(String[] args) {

      GameWindow game = new AsteroidsInfinity("Asteroids Infinity", 840, 480);
      game.run(1.0 / 30.0);
      System.exit(0);

   }

}
