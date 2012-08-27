package game;

import core.GameWindowLWJGL;

public class Main {

   /**
    * @param args
    */
   public static void main(String[] args) {

      GameWindowLWJGL render = new GLRenderTest("Render test", 800, 600);
      render.run(1.0 / 30.0);
      System.out.println("Finished");
      System.exit(0);
      /*
            GameWindow game = new AsteroidsInfinity("Asteroids Infinity", 840, 480);
            game.run(1.0 / 30.0);
            System.out.println("Finished");
            System.exit(0);*/

   }

}
