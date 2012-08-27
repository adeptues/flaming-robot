package game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import utils.Log;
import core.GameWindowLWJGL;

public class GLRenderTest extends GameWindowLWJGL {

   public GLRenderTest(String title, int width, int height) {
      super(title, width, height);
      // TODO Auto-generated constructor stub
   }

   @Override
   public void gameStartup() {
      Log.info(getClass().getSimpleName(), "Starting gl test program");
      // componet and entity or world construction would go here and model loading

   }

   @Override
   public void gameUpdate(double delta) {
      // check for updates
      if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
         stop();
      }

   }

   @Override
   public void gameDraw() {
      // set the color of the quad (R,G,B,A)
      GL11.glColor3f(0.5f, 0.5f, 1.0f);

      // draw quad
      GL11.glBegin(GL11.GL_QUADS);
      GL11.glVertex2f(100, 100);
      GL11.glVertex2f(100 + 200, 100);
      GL11.glVertex2f(100 + 200, 100 + 200);
      GL11.glVertex2f(100, 100 + 200);
      GL11.glEnd();

   }

   @Override
   public void gameShutdown() {
      Log.info(getClass().getSimpleName(), "Shutting down");

   }

}
